package com.jsp.controller;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import org.apache.ibatis.io.Resources;

public class GetUploadPath {
	// properties파일을 읽는 class
	private static Properties properties = new Properties();
	
	static {
		//properties 파일을 객체화
		String resource = "com/jsp/properties/upload.properties";
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			properties.load(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getUploadPath(String key) {
		//객체화 된 properties에 key를 주면 value를 반환해준다.
		String uploadPath = null;
		
		uploadPath = properties.getProperty(key);
		uploadPath = uploadPath.replace("/", File.separator);
		
		return uploadPath;
	}
}
