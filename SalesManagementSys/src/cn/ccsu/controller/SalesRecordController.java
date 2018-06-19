package cn.ccsu.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import cn.ccsu.entity.SalesRecord;
import cn.ccsu.service.ISalesRecordService;

/**
 * @author Bill
 *
 */
@Controller
@RequestMapping("/SalesRecord")
public class SalesRecordController {
	@Autowired
	private ISalesRecordService service;

	public SalesRecordController() {

	}

	// 增加销售记录
	@RequestMapping(value = "/addSalesRecord", method = RequestMethod.POST)
	public String addSalesRecord(Map<String, Object> map,
			@RequestParam(value = "productId", required = false) Integer productId,
			@RequestParam(value = "salesmanId", required = false) Integer salesmanId,
			@RequestParam(value = "recordId", required = false) Integer recordId,
			@RequestParam(value = "saleroom", required = false) Double saleroom,
			@RequestParam(value = "dateTime", required = false) String dateTimeStr,
			@RequestParam(value = "number", required = false) Integer number) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, formatter);
		SalesRecord record = new SalesRecord(productId, salesmanId, number, saleroom, recordId, dateTime);
		service.addSalesRecord(record);
		map.put("message", "信息添加成功");
		return "jump";
	}

	// 跳转到信息录入界面
	@RequestMapping(value = "/addSalesRecord", method = RequestMethod.GET)
	public String addSalesRecord() {
		return "appendSaleRecords";
	}

	// 查询销售记录
	@RequestMapping("/querySalesRecord")
	public String querySalesRecord(Map<String, Object> map,
			@RequestParam(value = "productId", required = false) Integer productId,
			@RequestParam(value = "salesmanId", required = false) Integer salesmanId,
			@RequestParam(value = "recordId", required = false) Integer recordId) {

		List<SalesRecord> salesRecordList = service.querySalesRecord(productId, salesmanId, recordId);
		map.put("recds", salesRecordList);
		return "salesInfo";
	}

	@RequestMapping("/queryAllRecords")
	public String queryAllRecords(Map<String, Object> map) {
		putAllRecords(map);
		return "salesInfo";
	}

	public void putAllRecords(Map<String, Object> map) {
		List<SalesRecord> list = service.queryAllRecords();
		map.put("recds", list);
	}

	// 跳转到修改数据界面
	@RequestMapping(value = "/modifySalesRecord", method = RequestMethod.GET)
	public String modifySalesRecord(Map<String, Object> map,
			@RequestParam(value = "recordId", required = false) Integer recordId) {

		// 根据recordId查询出销售员，并存到map中
		List<SalesRecord> list = service.querySalesRecord(null, null, recordId);
		if (list != null && list.size() > 0) {

			SalesRecord recd = list.get(0);
			String newString = recd.getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
			map.put("dateTime", newString);
			map.put("recd",recd);
		}
		return "modifySalesInfo";

	}

	// 更新销售记录
	@RequestMapping(value = "/modifySalesRecord", method = RequestMethod.POST)
	public String modifySalesRecord(Map<String, Object> map,
			@RequestParam(value = "productId", required = false) Integer productId,
			@RequestParam(value = "salesmanId", required = false) Integer salesmanId,
			@RequestParam(value = "recordId", required = false) Integer recordId,
			@RequestParam(value = "saleroom", required = false) Double saleroom,
			@RequestParam(value = "dateTime", required = false) String dateTimeStr,
			@RequestParam(value = "number", required = false) Integer number) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, formatter);
		SalesRecord record = new SalesRecord(productId, salesmanId, number, saleroom, recordId, dateTime);
		service.modifySalesRecord(record);
		map.put("message", "信息修改成功");
		return "jump";
	}

	// 删除销售记录
	@RequestMapping("/deleteSalesRecord")
	public String deleteSalesRecord(Map<String, Object> map,
			@RequestParam(value = "recordId", required = false) Integer recordId) {
		service.deleteSalesRecord(recordId);
		putAllRecords(map);
		return "salesInfo";
	}
}
