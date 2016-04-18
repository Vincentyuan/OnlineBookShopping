package cose.seu.dao;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import cose.seu.entity.Book;
import cose.seu.entity.Comments;
import cose.seu.entity.Type;

public interface BookDao{
	/**
	 * ����idƥ���鼮
	 * @param BID������id
	 * @return����book���Ͷ���
	 */
	public Book findBookById(Long BID);
	/**
	 * ��������ƥ���鼮
	 * @param name���������
	 * @return����Book���͵Ķ���
	 */
	public Book findBookByName(String name);
	/**
	 * ����������ƥ���鼮
	 * @param author������
	 * @return����Book���Ͷ���
	 */
	public Book findBookByAuthor(String author);
	/**
	 * ���ݴ���������ʵ���ҵ�ĳһ���������鼮
	 * @param type ���������
	 * @return ����Book���͵Ķ�������
	 */
	public ArrayList<Book> findBookByType(String type);
	/**
	 * �����û�����ؼ���ģ�����������ƥ���book��������
	 * @param keyword �ؼ���
	 * @return book�����������
	 */
	public ArrayList<Book> searchByUser(String keyword);
	/**
	 * ����������������ݷ��ز�ѯ�������кõ�book��������
	 * @param orderWay ��������
	 * @return ��������������źõ�book����
	 */
	public ArrayList<Book> orderBy(String orderWay);
	
	/**
	 * ������𣬰�����Ʒ���ʱ���ɽ���Զ��ʾ�������������5����Ʒ
	 * @param type �����ַ���
	 * @return book����
	 */
	public ArrayList<Book> homeshow(String type);
	
	public List<Type> showType();
	
	public void add(Book book);
	public void add(String bString,String publisher, float price,Long stoNumber,
			String Suammry,Date pTime,Long type,String face,Date inTime,Long salNumber,
			String comAveLevel,float vipPrice,Long comNumber, String author,Set<String> comments );
	public void remove(Long BID);
	public void remove(String name);
	public void update(Book book);
	
	public Float findPriceById(Long bid);
		
	
	
	
}