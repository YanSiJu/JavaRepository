package cn.ccsu.mapper.junit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.ccsu.entity.Salesman;
import cn.ccsu.mapper.SalesmanMapper;

/**
 * @author Bill
 *
 */
public class SalesmanMapperTest {

	public SalesmanMapperTest() {

	}

	private static ClassPathXmlApplicationContext ctxt;
	private static SalesmanMapper mapper;

	static {
		ctxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		mapper = (SalesmanMapper) ctxt.getBean("salesmanMapper");
	}

	@Test
	public void addSalesmanTest() throws ParseException {
		System.out.println(mapper);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = sdf.parse("1985-03-15");
		Salesman salman = new Salesman("Jack", 12, "Male", d);
		// System.out.println("insert:" + (mapper.addSalesman(salman)));
		mapper.addSalesman(salman);
		close();
	}

	@Test
	public void updateSalesmanTest() throws ParseException {
		System.out.println("mapper:" + mapper);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = sdf.parse("1895-10-31");
		Salesman salman = new Salesman("李德·哈特", 3, "男", d);
		mapper.updateSalesman(salman);
		close();
	}

	@Test
	public void deleteSalesmanTest() {
		Integer id = null;
		mapper.deleteSalesman(id);

		close();
	}

	@Test
	public void selectSalesmanTest() {
		Integer id = null;
		String name = "a";
		String sex = null;
		Map<String, Object> map = new HashMap<>(3);

		map.put("id", id);
		map.put("name", name);
		map.put("sex", sex);
		List<Salesman> list = mapper.selectSalesman(map);

		for (Salesman man : list) {
			System.out.println(man);
		}

		close();
	}

	public void close() {
		ctxt.close();
	}
}
