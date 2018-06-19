package cn.ccsu.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import cn.ccsu.entity.Salesman;
import cn.ccsu.service.ISalesmanService;

/**
 * @author Bill
 *
 */
@Controller
@RequestMapping("/Salesman")
public class SalesmanController {

	@Autowired
	private ISalesmanService service;

	public SalesmanController() {

	}

	@RequestMapping(value = "/addSalesman", method = RequestMethod.GET)
	public String addSalesman() {
		return "appendSalesman";

	}

	@RequestMapping(value = "/addSalman", method = RequestMethod.POST) // , method = RequestMethod.POST method="post"
	public String addSalesman(Map<String, Object> map, Salesman salman) {
		service.addSalesman(salman);
		map.put("message", "信息添加成功");
		return "jump";
	}

	@RequestMapping(value = "/modifySalesman", method = RequestMethod.GET)
	public String modifySalesman(Map<String, Object> map, @RequestParam(value = "id", required = false) Integer id) {

		// 根据ID查询出销售员，并存到map中
		List<Salesman> list = service.querySalesman(null, id, null);
		if (list != null && list.size() > 0) {

			Salesman man = list.get(0);

			Date date = man.getBirth();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String birth = sdf.format(date);
			
			
			
			map.put("birth", birth);
			map.put("salman", man);
		}
		return "modifySalmanInfo";

	}

	@RequestMapping(value = "/modifySalesman", method = RequestMethod.POST)
	public String modifySalesman(Map<String, Object> map, Salesman salman) {
		service.modifySalesman(salman);
		map.put("message", "信息修改成功");
		return "jump";
	}

	@RequestMapping("/querySalesman")
	public String querySalesman(Map<String, Object> map, @RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "sex", required = false) String sex) {

		if (name.length() == 0) {
			name = null;
		}

		if (sex.length() == 0) {
			sex = null;
		}

		List<Salesman> salmanList = service.querySalesman(name, id, sex);
		System.out.println("salmanList:" + salmanList);
		map.put("saleMan", salmanList);
		return "salesmanInfo";
	}

	public void putAllSalesman(Map<String, Object> map) {
		List<Salesman> saleMan = service.queryAllSalesman();
		map.put("saleMan", saleMan);
	}

	@RequestMapping("/queryAllSalesman")
	public String queryAllSalesman(Map<String, Object> map) {
		putAllSalesman(map);
		return "salesmanInfo";
	}

	@RequestMapping("/deleteSalesman")
	public String deleteSalesman(Map<String, Object> map, @RequestParam(value = "id", required = false) Integer id) {
		service.deleteSalesman(id);
		putAllSalesman(map);
		return "salesmanInfo";
	}

}
