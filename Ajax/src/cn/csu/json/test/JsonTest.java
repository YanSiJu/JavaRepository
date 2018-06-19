package cn.csu.json.test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import cn.csu.json.entity.Customer;

public class JsonTest {

	public JsonTest() {

	}

	@Test
	public void test() throws ParseException, JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse("2014-03-02");
		Customer customer = new Customer(125, date, "Jackson", 7500000.00F, "anhs08", "13912094398", "19809@163.com");

		String jsonStr = mapper.writeValueAsString(customer);
		System.out.println("JsonStr:" + jsonStr);
	}

}
