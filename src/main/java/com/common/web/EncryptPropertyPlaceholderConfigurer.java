package com.common.web;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.common.utils.DESUtils;

public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

	private String[] encryptPropNames = { "jdbc.username", "jdbc.password" };

	 /**
     * 重写父类方法，解密指定属性名对应的属性值
     */
	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		if (isEncryptProp(propertyName)) { 
			return DESUtils.getDecryptString(propertyValue);
		} else {
			return propertyValue;
		}
	}

	private boolean isEncryptProp(String propertyName) {
		for (String encryptName : encryptPropNames) {
			if (encryptName.equals(propertyName)) {
				return true;
			}
		}
		return false;
	}
}