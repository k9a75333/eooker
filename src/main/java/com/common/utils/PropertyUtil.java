package com.common.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * Desc:properties文件获取工具类
 * 
 * @author 刘小雨点
 *
 */
public class PropertyUtil {

	private static final Logger logger = Logger.getLogger(PropertyUtil.class);

	private static Properties props;

	static {
		loadProps();
	}

	synchronized static private void loadProps() {
		logger.info("开始加载properties文件内容");
		props = new Properties();
		InputStream in = null;
		try {
// 第一种，通过类加载器进行获取properties文件流
			in = PropertyUtil.class.getClassLoader().getResourceAsStream("common.properties");
// 第二种，通过类进行获取properties文件流
// in = PropertyUtil.class.getResourceAsStream("/jdbc.properties");
			props.load(in);
		} catch (FileNotFoundException e) {
			logger.error("properties文件找不到");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				logger.error("文件流关闭出现异常");
			}
		}
	}

	public static String getProperty(String key) {
		if (null == props) {
			loadProps();
		}
		return props.getProperty(key);
	}

	public static String getProperty(String key, String defaultValue) {
		if (null == props) {
			loadProps();
		}
		return props.getProperty(key, defaultValue);
	}

}