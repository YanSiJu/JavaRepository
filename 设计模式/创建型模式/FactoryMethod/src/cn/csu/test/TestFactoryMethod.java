package cn.csu.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException; //import java.io.InputStream;
import java.util.Properties;

//import cn.csu.factory.AddFactory;
//import cn.csu.factory.DivFactory;
import cn.csu.factory.IFactory;
import cn.csu.product.Operation;

//import cn.csu.product.Operation;

public class TestFactoryMethod {

	public static void main(String[] args) throws FileNotFoundException,
			IOException, ClassNotFoundException, InstantiationException,
			IllegalAccessException {

		Properties p = new Properties();
		p.load(new FileInputStream(new File("params.properties")));
		Class<?> c = Class.forName(p.getProperty("operation"));
		IFactory factory = (IFactory) c.newInstance();
		Operation oper = factory.getproduct();
		oper.setNumber1(Double.parseDouble((String) p.get("param-1")));
		oper.setNumber2(Double.parseDouble((String) p.get("param-2")));

		try {
			System.out.println(oper.getResult());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
