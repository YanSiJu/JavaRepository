package cn.ccsu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.ccsu.entity.MonthlyRecord;
import cn.ccsu.mapper.MonthlyRecordMapper;
import cn.ccsu.service.IMonthlyRecordService;

/**
 * @author Bill
 *
 */
@Service
public class MonthlyRecordServiceImpl implements IMonthlyRecordService {

	@Autowired
	private MonthlyRecordMapper mapper;

	public MonthlyRecordServiceImpl() {

	}

	@Override
	public int addMonthlyRecord(MonthlyRecord record) {
		if (record == null) {
			return -1;
		}
		// 在月销售表中查询本月该销售员是否销售过该产品
		List<MonthlyRecord> recds = this.queryMonthlyRecord(record.getProductId(), record.getSalesmanId(),
				record.getMonth());

		// System.out.println("recds:" + recds);
		// 本月该销售员没有销售过该产品
		if (recds == null || recds.size() == 0) {
			mapper.addMonthlyRecord(record);
		} else {// 本月该销售员销售过该产品
			MonthlyRecord recd = recds.get(0);
			// System.out.println("record.getSaleroom():" + record.getSaleroom());

			recd.setSaleroom(recd.getSaleroom() + record.getSaleroom());
			recd.setNumber(recd.getNumber() + record.getNumber());
			// System.out.println("recd.getSaleroom():" + recd.getSaleroom());
			this.modifyMonthlyRecord(recd);
		}
		return 1;

	}

	@Override
	public List<MonthlyRecord> queryMonthlyRecord(Integer productId, Integer salesmanId, String month) {
		Map<String, Object> map = new HashMap<>(3);
		map.put("productId", productId);
		map.put("salesmanId", salesmanId);
		map.put("month", month);
		// map.put("recordId", recordId);
		return mapper.selectMonthlyRecord(map);
	}

	@Override
	public int modifyMonthlyRecord(MonthlyRecord record) {
		if (record != null) {
			mapper.updateMonthlyRecord(record);
			return 1;
		} else {
			return -1;
		}
	}

	@Override
	public int deleteMonthlyRecord(MonthlyRecord record) {
		if (record == null) {
			return -1;
		}

		Map<String, Object> map = new HashMap<>(3);
		map.put("productId", record.getProductId());
		map.put("salesmanId", record.getSalesmanId());
		map.put("month", record.getMonth());
		mapper.deleteMonthlyRecord(map);

		return 1;
	}

	/*
	 * @Override public List<MonthlyRecord> queryMonthlyRecord(Integer productId,
	 * Integer salesmanId) { Map<String, Object> map = new HashMap<>();
	 * map.put("productId", productId); map.put("salesmanId", salesmanId); return
	 * mapper.selectMonthlyRecord(map); }
	 */

}
