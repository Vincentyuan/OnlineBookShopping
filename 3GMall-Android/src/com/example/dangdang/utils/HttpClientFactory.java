package com.example.dangdang.utils;

import org.apache.http.client.HttpClient;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;

public class HttpClientFactory {
	private static HttpClient client;
	
	public static HttpClient getInstance(){
		if(client==null){
			client=new DefaultHttpClient();
		}
		return client;
	}
}
