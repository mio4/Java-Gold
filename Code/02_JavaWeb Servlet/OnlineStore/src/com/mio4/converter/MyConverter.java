package com.mio4.converter;

import org.apache.commons.beanutils.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 1.转换器
 */
public class MyConverter implements Converter {
	@Override
	public Object convert(Class clazz, Object value){
		//clazz 目标类型
		//object 输入类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy--MM--dd");
		Date date = null;
		try {
			date = sdf.parse((String) value);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
