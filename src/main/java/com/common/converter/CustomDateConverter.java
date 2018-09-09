package com.common.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.core.convert.converter.Converter;

public class CustomDateConverter implements Converter<String, Date>{

	private static Logger logger = Logger.getLogger(CustomDateConverter.class);
	
	@Override
	public Date convert(String source) {
		if (StringUtils.isEmpty(source)) {
			logger.warn("日期为空");
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(source);
		} catch (ParseException e) {
			logger.warn("日期转换失败");
			e.printStackTrace();
		}
		return null;
	}

}
