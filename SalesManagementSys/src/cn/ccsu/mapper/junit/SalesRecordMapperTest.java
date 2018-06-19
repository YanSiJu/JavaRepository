package cn.ccsu.mapper.junit;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.ccsu.entity.SalesRecord;
import cn.ccsu.mapper.SalesRecordMapper;

/**
 * @author Bill
 *
 */
public class SalesRecordMapperTest {

	public SalesRecordMapperTest() {

	}

	private static ClassPathXmlApplicationContext ctxt;
	private static SalesRecordMapper mapper;

	static {
		ctxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		mapper = (SalesRecordMapper) ctxt.getBean("salesmanMapper");
	}

	@Test
	public void addSalesRecordTest() {

		SalesRecord recd = new SalesRecord(12, 13, 40, 9000.00, null, LocalDateTime.now());
		mapper.addSalesRecord(recd);
		close();
	}

	@Test
	public void updateSalesRecordTest() {
		SalesRecord recd = new SalesRecord(12, 13, 40, 9000.00, null, LocalDateTime.now());
		mapper.updateSalesRecord(recd);
		close();
	}

//	@Test
//	void deleteSalesRecordTest() {
//
//		Map<String, Object> map = new HashMap<>();
//
//		map.put("productId", 12);
//		map.put("salesmanId", 23);
//		map.put("recordId", 3);
//		mapper.deleteSalesRecord(map);
//
//		close();
//	}

	@Test
	public void selectSalesRecordTest() {

		Map<String, Object> map = new HashMap<>(3);

		map.put("productId", 12);
		map.put("salesmanId", 23);
		map.put("recordId", 3);
		System.out.println("delete:" + (mapper.selectSalesRecord(map)));

		close();
	}

	public void close() {
		ctxt.close();
	}

}
