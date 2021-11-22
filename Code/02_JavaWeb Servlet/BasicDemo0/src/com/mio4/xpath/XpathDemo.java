package com.mio4.xpath;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;

import java.util.List;

public class XpathDemo {
	public static void main(String[] args) throws DocumentException {
		Document doc = new SAXReader().read("F:\\Learn-Java\\Head First Java Web\\BasicDemo0\\xml\\web.xml"); //加载dom树
		List<Element> list = doc.selectNodes("/web-app/servlet/servlet-name"); //获取Element列表
		Element e = list.get(0); //选择第一个元素进行测试
		String text = e.getText();
		System.out.println(text); //打印节点内容

		Node e2 = doc.selectSingleNode("/web-app/servlet/servlet-name");
		System.out.println(e2.getText());
	}
}
