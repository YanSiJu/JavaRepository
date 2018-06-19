package cn.ccsu.mapper.junit;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.ccsu.entity.MonthlyRecord;
import cn.ccsu.mapper.MonthlyRecordMapper;

/**
 * @author Bill
 *
 */
public class MonthlyRecordMapperTest {

	public MonthlyRecordMapperTest() {

	}

	private static ClassPathXmlApplicationContext ctxt;
	private static MonthlyRecordMapper mapper;

	static {
		ctxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		mapper = (MonthlyRecordMapper) ctxt.getBean("salesmanMapper");
	}

	@Test
	public void addMonthlyRecordTest() {

		MonthlyRecord recd = new MonthlyRecord(12, 13, 40, 20, 900.00, "12月");
		mapper.addMonthlyRecord(recd);
		close();
	}

	@Test
	public void updateMonthlyRecordTest() {
		MonthlyRecord recd = new MonthlyRecord(12, 13, 40, 20, 900.00, "12月");
		mapper.updateMonthlyRecord(recd);
		close();
	}

	@Test
	void deleteMonthlyRecordTest() {

		Map<String, Object> map = new HashMap<>(3);

		map.put("productId", 12);
		map.put("salesmanId", 23);
		map.put("recordId", 3);
		mapper.deleteMonthlyRecord(map);

		close();
	}

	@Test
	public void selectMonthlyRecordTest() {

		Map<String, Object> map = new HashMap<>(3);

		map.put("productId", 12);
		map.put("salesmanId", 23);
		map.put("month", "9月");
		System.out.println("delete:" + (mapper.selectMonthlyRecord(map)));

		close();
	}

	public void close() {
		ctxt.close();
	}

}
