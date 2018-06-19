package cn.ccsu.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import cn.ccsu.entity.MonthlyRecord;
import cn.ccsu.service.IMonthlyRecordService;

/**
 * @author Bill
 *
 */
@Controller
@RequestMapping("/MonthlyRecord")
public class MonthlyRecordController {

	@Autowired
	private IMonthlyRecordService service;

	public MonthlyRecordController() {

	}

	// 跳转到数据录入界面
	@RequestMapping("/addMonthlyRecord")
	String addMonthlyRecord(MonthlyRecord record) {
		service.addMonthlyRecord(record);
		return null;
	}

	// 查询月销售记录
	@RequestMapping("/queryMonthlyRecord")
	List<MonthlyRecord> queryMonthlyRecord(Map<String, Object> map,
			@RequestParam(value = "productId", required = false) Integer productId,
			@RequestParam(value = "salesmanId", required = false) Integer salesmanId,
			@RequestParam(value = "month", required = false) String month,
			@RequestParam(value = "recordId", required = false) Integer recordId) {

		List<MonthlyRecord> monthlyRcds = service.queryMonthlyRecord(productId, salesmanId, month);
		map.put("monthlyRcds", monthlyRcds);
		return null;
	}

	// 更新月销售记录
	String updateMonthlyRecord(MonthlyRecord record) {
		service.modifyMonthlyRecord(record);
		return null;
	}

	// 删除月销售记录
	String deleteMonthlyRecord(MonthlyRecord record) {
		service.deleteMonthlyRecord(record);
		return null;
	}

}
