package com.example.dangdang.utils;

public class NetworkUtils {

	/*
	 * ��������������д���������url��ַ
	 * */
	
	
	// �����ӳ��ı���IP��ַΪ127.0.0.1,Androidӳ��ı���IPΪ10.0.2.2
//		public static final String DANGDANG_BASE_URL = "http://localhost:8080/3GMall/";
		public static final String DANGDANG_BASE_URL = "http://223.3.87.207/3GMall/";
		/*// ��ȡ��֤���URL
		public static final String DANGDANG_CODE_URL = DANGDANG_BASE_URL
				+ "ImageServlet";
			*/
		//��ȡ��¼��url
		public static final String DANGDANG_LOGIN_URL = DANGDANG_BASE_URL
				+ "log.action";
		
		public static final String DANGDANG_BOOKLIST_URL = DANGDANG_BASE_URL
				+ "bookListServlet";
}
