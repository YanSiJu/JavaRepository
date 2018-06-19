package cn.ccsu.service.impl.junit;

import static org.junit.Assert.*;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.ccsu.entity.SalesRecord;
import cn.ccsu.service.ISalesRecordService;

/**
 * @author Bill
 *
 */
public class SalesRecordServiceImplTest {

	private static ClassPathXmlApplicationContext ctxt;
	private static ISalesRecordService service;

	static {
		ctxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = (ISalesRecordService) ctxt.getBean("salesRecordServiceImpl");
	}

	@Test
	public void testSalesRecordServiceImpl() {
		fail("Not yet implemented");

	}

	@Test
	public void testAddSalesRecord() {
		fail("Not yet implemented");
		Integer productId = 11;
		Integer salesmanId = 6;
		Integer number = 5;
		Double saleroom = null;
		Integer recordId = null;
		SalesRecord recd = new SalesRecord(productId, salesmanId, number, saleroom, recordId,
				LocalDateTime.of(2017, 7, 15, 15, 35, 10));

		service.addSalesRecord(recd);
	}

	@Test
	public void testQuerySalesRecord() {
		fail("Not yet implemented");
		Integer productId = null;
		Integer salesmanId = null;
		Integer recordId = null;
		List<SalesRecord> list = service.querySalesRecord(productId, salesmanId, recordId);
		for (SalesRecord record : list) {
			System.out.println(record);
		}
	}

	@Test
	public void testModifySalesRecord() {
		Integer number = 25;
		Integer recordId = 16;
		// 2017-12-14 19:00:33
		SalesRecord recd = new SalesRecord(11, 6, number, null, recordId, LocalDateTime.of(2017, 07, 15, 15, 35, 10));

		service.modifySalesRecord(recd);
	}

//	@Test
//	public void testDeleteSalesRecord() {
//		fail("Not yet implemented");
//		Integer productId = null;
//		Integer salesmanId = null;
//		Integer number = null;
//		Double saleroom = null;
//		Integer recordId = null;
//		SalesRecord recd = new SalesRecord(productId, salesmanId, number, saleroom, recordId, LocalDateTime.now());
//
//		service.deleteSalesRecord(recd);
//	}

}
