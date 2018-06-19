package cn.ccsu.TestDom4j;

import java.io.File;
import java.util.Iterator;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Demo {

	public static void main(String[] args) throws Exception {

		Document document = new SAXReader().read(new File("books.xml"));
		Element root = document.getRootElement();

		Iterator<Element> it = root.elementIterator();
		while (it.hasNext()) {
			Element element = (Element) it.next();

			// 未知属性名称情况下
			Iterator<Attribute> attrIt = element.attributeIterator();
			while (attrIt.hasNext()) {
				Attribute a = (Attribute) attrIt.next();
				System.out.println(a.getValue());
			}

			// 已知属性名称情况下
			// System.out.println("id: " + element.attributeValue("id"));

			// 未知元素名情况下
			Iterator<Element> eleIt = element.elementIterator();
			while (eleIt.hasNext()) {
				Element e = (Element) eleIt.next();
				System.out.println(e.getName() + ": " + e.getText());
			}
			System.out.println();

			// 已知元素名情况下
			/*
			 * System.out.println("title: " + element.elementText("title"));
			 * System.out.println("author: " + element.elementText("author"));
			 * System.out.println();
			 */
		}
	}

}
