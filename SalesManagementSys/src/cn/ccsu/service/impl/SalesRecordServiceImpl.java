package cn.ccsu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.ccsu.entity.MonthlyRecord;
import cn.ccsu.entity.Product;
import cn.ccsu.entity.SalesRecord;
import cn.ccsu.mapper.MonthlyRecordMapper;
import cn.ccsu.mapper.ProductMapper;
import cn.ccsu.mapper.SalesRecordMapper;
import cn.ccsu.service.IMonthlyRecordService;
import cn.ccsu.service.ISalesRecordService;

/**
 * @author Bill
 *
 */
@Service("salesRecordServiceImpl")
public class SalesRecordServiceImpl implements ISalesRecordService {

	@Autowired
	private SalesRecordMapper mapper;

	@Autowired
	private IMonthlyRecordService monthlyService;
	@Autowired
	private MonthlyRecordMapper monthlyMapper;
	@Autowired
	private ProductMapper productMapper;

	public SalesRecordServiceImpl() {

	}

	@Override
	public int addSalesRecord(SalesRecord record) {

		if (record != null) {

			Map<String, Object> map = new HashMap<>(1);
			// 存放产品id,用于查询
			map.put("id", record.getProductId());
			// 根据id查询出产品
			List<Product> list = productMapper.selectProduct(map);
			if (list != null) {
				double saleRoom = list.get(0).getPrice() * record.getNumber();
				// 修改销售额
				record.setSaleroom(saleRoom);
			}

			MonthlyRecord recd = new MonthlyRecord(null, record.getProductId(), record.getSalesmanId(),
					record.getNumber(), record.getSaleroom(),
					record.getDateTime().getYear() + "年" + record.getDateTime().getMonthValue() + "月");
			// 增加销售记录的同时增加月销售记录
			monthlyService.addMonthlyRecord(recd);
			// 增加销售记录
			mapper.addSalesRecord(record);
			return 1;
		} else {
			return -1;
		}
	}

	@Override
	public List<SalesRecord> querySalesRecord(Integer productId, Integer salesmanId, Integer recordId) {
		Map<String, Object> map = new HashMap<>(3);
		map.put("productId", productId);
		map.put("salesmanId", salesmanId);
		map.put("recordId", recordId);
		return mapper.selectSalesRecord(map);
	}

	@Override
	public int modifySalesRecord(SalesRecord record) {
		if (record != null) {
			MonthlyRecord recd = null;
			double price = 0;
			// 存储原来的产品数量
			int number = 0;
			// 修改后的产品数量
			int newNumber = record.getNumber();

			// 查询出原来的记录，获取原来的产品数量
			List<SalesRecord> list = querySalesRecord(null, null, record.getRecordId());
			if (list != null && list.size() != 0) {
				// 原来 的产品数量
				number = list.get(0).getNumber();
				// 获取产品单价
				price = list.get(0).getSaleroom() / number;
				record.setSaleroom(newNumber * price);
			}
			System.out.println("原来的记录:" + list.get(0));
			System.out.println("---------->产品单价:" + price);
			System.out.println("原来的产品数量:" + number);
			System.out.println("新的产品数量:" + newNumber);
			System.out.println("新的销售额 :" + record.getSaleroom());

			Map<String, Object> map = new HashMap<>(3);
			map.put("productId", record.getProductId());
			map.put("salesmanId", record.getSalesmanId());
			map.put("month", record.getDateTime().getYear() + "年" + record.getDateTime().getMonthValue() + "月");
			System.out.println("map:" + map);
			List<MonthlyRecord> recds = monthlyMapper.selectMonthlyRecord(map);

			if (recds != null && recds.size() != 0) {

				recd = recds.get(0);

				System.out.println("----->查询出的月记录:" + recds.get(0));
				System.out.println("----->原来的产品数量:" + recd.getNumber());

				// 修改产品数量
				recd.setNumber(newNumber - number + recd.getNumber());
				// 修改销售总额
				recd.setSaleroom(recd.getNumber() * price);

				System.out.println("--->新的产品数量:" + recd.getNumber());
				System.out.println("--->新的销售额:" + recd.getSaleroom());

			}

			// 修改销售记录的同时修改月销售记录
			monthlyService.modifyMonthlyRecord(recd);

			// 修改销售记录
			mapper.updateSalesRecord(record);
			return 1;
		}

		return -1;
	}

	@Override
	public void deleteSalesRecord(Integer recordId) {
		SalesRecord recd = mapper.selectSalesRecordById(recordId);

		monthlyService.deleteMonthlyRecord(new MonthlyRecord(null, recd.getProductId(), recd.getSalesmanId(), null,
				null, recd.getDateTime().getYear() + "年" + recd.getDateTime().getMonthValue() + "月"));

		mapper.deleteSalesRecord(recordId);
	}

	@Override
	public List<SalesRecord> queryAllRecords() {

		return mapper.selectAllSalesRecords();
	}

}
