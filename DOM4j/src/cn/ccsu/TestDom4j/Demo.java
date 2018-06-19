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

			// δ֪�������������
			Iterator<Attribute> attrIt = element.attributeIterator();
			while (attrIt.hasNext()) {
				Attribute a = (Attribute) attrIt.next();
				System.out.println(a.getValue());
			}

			// ��֪�������������
			// System.out.println("id: " + element.attributeValue("id"));

			// δ֪Ԫ���������
			Iterator<Element> eleIt = element.elementIterator();
			while (eleIt.hasNext()) {
				Element e = (Element) eleIt.next();
				System.out.println(e.getName() + ": " + e.getText());
			}
			System.out.println();

			// ��֪Ԫ���������
			/*
			 * System.out.println("title: " + element.elementText("title"));
			 * System.out.println("author: " + element.elementText("author"));
			 * System.out.println();
			 */
		}
	}

}
