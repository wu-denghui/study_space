package com.goodhealth.algorithm.Jackson_FastJson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;

/**
 *
 *
 */
public class JacksonObjectMapperSingle {
	// object mapper
	private static ObjectMapper objectMapper;
	/**
	 *
	 */
	public static ObjectMapper getInstance() {
		if (JacksonObjectMapperSingle.objectMapper == null) {// if does not exist instance
			JacksonObjectMapperSingle.objectMapper = new ObjectMapper();
			JacksonObjectMapperSingle.objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
			// configure object mapper 是否将允许使用非双引号属性名字
			JacksonObjectMapperSingle.objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		}
		// return object mapper
		return JacksonObjectMapperSingle.objectMapper;
	}
}