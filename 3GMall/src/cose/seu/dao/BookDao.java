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
	 * 根据id匹配书籍
	 * @param BID输入书id
	 * @return返回book类型对象
	 */
	public Book findBookById(Long BID);
	/**
	 * 根据书名匹配书籍
	 * @param name传入的书名
	 * @return返回Book类型的对象
	 */
	public Book findBookByName(String name);
	/**
	 * 根据作者名匹配书籍
	 * @param author作者名
	 * @return返回Book类型对象
	 */
	public Book findBookByAuthor(String author);
	/**
	 * 根据传入类别检索实体找到某一类别的所有书籍
	 * @param type 传入的类型
	 * @return 返回Book类型的对象数组
	 */
	public ArrayList<Book> findBookByType(String type);
	/**
	 * 根据用户输入关键字模糊搜索，输出匹配的book对象数组
	 * @param keyword 关键字
	 * @return book类型数组对象
	 */
	public ArrayList<Book> searchByUser(String keyword);
	/**
	 * 根据输入的排序依据返回查询到的排列好的book对象数组
	 * @param orderWay 排序依据
	 * @return 按照输入的依据排好的book数组
	 */
	public ArrayList<Book> orderBy(String orderWay);
	
	/**
	 * 传入类别，按照商品入库时间由近到远显示该类别最新入库的5件商品
	 * @param type 分类字符串
	 * @return book数组
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