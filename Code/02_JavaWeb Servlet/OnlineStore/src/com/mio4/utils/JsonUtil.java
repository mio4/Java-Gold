package com.mio4.utils;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import net.sf.json.xml.XMLSerializer;

/**
 * 处理json数据格式的工具类
 * 
 * @Date 2013-3-31
 * @version 1.0
 */
public class JsonUtil {
	/**
	 * 将数组转换成String类型的JSON数据格式
	 * 
	 * @param objects
	 * @return
	 */
	public static String array2json(Object[] objects){
		
		JSONArray jsonArray = JSONArray.fromObject(objects);
		return jsonArray.toString();
		
	}
	
	/**
	 * 将list集合转换成String类型的JSON数据格式
	 * 
	 * @param list
	 * @return
	 */
	public static String list2json(List list){
		
		JSONArray jsonArray = JSONArray.fromObject(list);
		return jsonArray.toString();
		
	}
	
	/**
	 * 将map集合转换成String类型的JSON数据格式
	 * 
	 * @param map
	 * @return
	 */
	public static String map2json(Map map){
		
		JSONObject jsonObject = JSONObject.fromObject(map);
		return jsonObject.toString();
		
	}
	
	/**
	 * 将Object对象转换成String类型的JSON数据格式
	 * 
	 * @param object
	 * @return
	 */
	public static String object2json(Object object){
		
		JSONObject jsonObject = JSONObject.fromObject(object);
		return jsonObject.toString();
		
	}
	
	/**
	 * 将XML数据格式转换成String类型的JSON数据格式
	 * 
	 * @param xml
	 * @return
	 */
	public static String xml2json(String xml){
		
		JSONArray jsonArray = (JSONArray) new XMLSerializer().read(xml);
		return jsonArray.toString();
		
	}
	
	/**
	  * 除去不想生成的字段（特别适合去掉级联的对象）
	  *
	  * @param excludes
	  * @return
	*/
	public static JsonConfig configJson(String[] excludes) {
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(excludes);
		jsonConfig.setIgnoreDefaultExcludes(true);
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		return jsonConfig;
	}
	
}
