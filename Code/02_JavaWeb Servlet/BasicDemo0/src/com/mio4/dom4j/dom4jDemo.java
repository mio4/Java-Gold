package com.mio4.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 *  使用dom4j，解析web.xml文件
 */

public class dom4jDemo {

	public static void main(String[] args) throws DocumentException {
		//创建核心对象
		SAXReader reader = new SAXReader();
		//获取dom树
		Document doc =  reader.read("F:\\Learn-Java\\Head First Java Web\\BasicDemo0\\xml\\web.xml");
		//获取根节点
		Element root = doc.getRootElement();
		//获取其他节点
		List<Element> list = root.elements();
		//遍历
		for(Element e : list){
			//打印doc中servlet-name节点的值
			//String text = e.elementText("servlet-name");
			//System.out.println(text);
			//String text = e.elementText("url-pattern");
			//System.out.println(text);
			System.out.println(e);
		}
	}
}
