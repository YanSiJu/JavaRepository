package cn.ccsu.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.ccsu.entity.ProductMonthlyRecord;
import cn.ccsu.entity.SalesmanMonthlyRecord;
import cn.ccsu.service.ISummarizeMonthlySaleInfoService;

/**
 * @author Bill
 *
 */
@Controller
@RequestMapping("/SalRecd")
public class SummarizeMonthlySaleInfoController {

	@Autowired
	private ISummarizeMonthlySaleInfoService service;

	public SummarizeMonthlySaleInfoController() {

	}

	@RequestMapping("/querySalmanSalRoom")
	public String querySalmanSalRoom(Map<String, Object> map) {
		List<SalesmanMonthlyRecord> salmanMonthlyRecds = service.querySalmanMonthlySaleRoom();
		map.put("salmanMonthlyRecds", salmanMonthlyRecds);
		return "SalmanMonthlyRecds";
	}

	@RequestMapping("/queryProductSalRoom")
	public String queryProductSalRoom(Map<String, Object> map) {
		List<ProductMonthlyRecord> productMonthlyRecds = service.queryProductMonthlySaleRoom();
		map.put("productMonthlyRecds", productMonthlyRecds);
		return "ProductMonthlyRecds";
	}
}
