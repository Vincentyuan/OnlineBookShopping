package com.example.dangdang.utils;

public class NetworkUtils {

	/*
	 * 工具类用来用来写定工具类的url地址
	 * */
	
	
	// 计算机映射的本机IP地址为127.0.0.1,Android映射的本机IP为10.0.2.2
//		public static final String DANGDANG_BASE_URL = "http://localhost:8080/3GMall/";
		public static final String DANGDANG_BASE_URL = "http://223.3.87.207/3GMall/";
		/*// 获取验证码的URL
		public static final String DANGDANG_CODE_URL = DANGDANG_BASE_URL
				+ "ImageServlet";
			*/
		//获取登录的url
		public static final String DANGDANG_LOGIN_URL = DANGDANG_BASE_URL
				+ "log.action";
		
		public static final String DANGDANG_BOOKLIST_URL = DANGDANG_BASE_URL
				+ "bookListServlet";
}
