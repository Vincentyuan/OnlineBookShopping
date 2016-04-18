package cose.seu.test;
//import java.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transaction;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import cose.seu.*;
import cose.seu.dao.BookDao;
import cose.seu.dao.impl.BookDaoImpl;
import cose.seu.entity.Book;
import cose.seu.entity.City;
import cose.seu.entity.Comments;
import cose.seu.entity.Credit;
import cose.seu.entity.Favorite;
import cose.seu.entity.History;
import cose.seu.entity.Order;
import cose.seu.entity.OrderItem;
import cose.seu.entity.RecAddr;
import cose.seu.entity.ShoppingCart;
import cose.seu.entity.ShoppingList;
import cose.seu.entity.Type;
import cose.seu.entity.UserInfo;
import cose.seu.util.HibernateSessionFactory;

public class BookEntityTest {
	//static Book book = new Book();
	//static Date data = new Date();
	public static void main(String[] args){
		
		// 2.创建会话
		Session s = HibernateSessionFactory.getSession();
		
		Date data = new Date();
		List<Type> tt = s.createQuery("from Type").list();
		//Type t = tt.get(0);
		//RecAddr addr = new RecAddr();
		/*book.setbName("Java编程思想（第4版）");
		book.setAuthor("(美)埃克尔 著，陈昊鹏 译");
		book.setPublisher("机械工业出版社");
		book.setpTime(data);
		book.setInTime(data);
		book.setFace(null);
		book.setType(t1);
		book.setPrice(78.99f);
		book.setStoNumber(10l);
		book.setSummary("乱七八糟");*/
		//
		
		//基本信息
		/*UserInfo user = new UserInfo();
		user.setAge(24l);
		user.setNickName("hjkfdshk");
		//信用卡
		Credit cr1 = new Credit();
		cr1.setCreNumber(2223344424l);
		cr1.setUser(user);
		Credit cr2 = new Credit();
		cr2.setCreNumber(25535345353l);
		cr2.setUser(user);
		Set<Credit> setcr = new HashSet<Credit>();
		setcr.add(cr1);
		setcr.add(cr2);
		user.setCreditNumber(setcr);
		//购物车
		ShoppingCart car = new ShoppingCart();
		car.setUser(user);
		ShoppingList l1 = new ShoppingList();
		l1.setBook(book);
		l1.setBnumber(5l);
		
		ShoppingList l2 = new ShoppingList();
		l2.setBook(book);
		l2.setBnumber(7l);
		
		Set<ShoppingList> setl = new HashSet<ShoppingList>();
		setl.add(l1);
		setl.add(l2);
		user.setShoppingCart(car);
		//浏览历史
		History h = new History();
		h.setHisDate(data);
		Set<History> his = new HashSet<History>();
		his.add(h);
		user.setHis(his);
		//评论
		Comments c1 = new Comments();
		c1.setComments("烦死了");
		Comments c2 = new Comments();
		c2.setComments("啊啊啊啊啊");
		Set<Comments> setc = new HashSet<Comments>();
		setc.add(c1);
		setc.add(c2);
		user.setComUser(setc);
		//收藏夹
		Favorite fav1 = new Favorite();
		fav1.setBook(book);
		fav1.setFavDate(data);
		fav1.setUser(user);
		Favorite fav2 = new Favorite();
		fav2.setBook(book);
		fav2.setFavDate(data);
		fav2.setUser(user);
		Set<Favorite> setf = new HashSet<Favorite>();
		setf.add(fav1);
		setf.add(fav2);
		user.setFav(setf);
		//地址
		RecAddr a = new RecAddr();
		a.setStreet("hhhhh");
		Set<RecAddr> seta = new HashSet<RecAddr>();
		seta.add(a);
		user.setRecAddress(seta);
		//order
		OrderItem i1 = new OrderItem();
		i1.setISBN(10l);
		OrderItem i2 = new OrderItem();
		i2.setISBN(20l);
		Set<OrderItem> seto = new HashSet<OrderItem>();
		seto.add(i1);
		seto.add(i2);
		Order o = new Order();
		o.setOrderItem(seto);
		Set<Order> setoo = new HashSet<Order>();
		user.setOrders(setoo);*/
		
		/*o.setUser(user);*/
		//ShoppingCart c = new ShoppingCart();
		//c.setSCID(1l);
		//c.setUser(user);
		//ShoppingList l1 = new ShoppingList();
		//l1.setSCID(1l);
		//l1.setBnumber(33l);
		//ShoppingList l2 = new ShoppingList();
		//l2.setBnumber(44l);
		//l2.setSCID(1l);
		//Set<ShoppingList> setl =new HashSet<ShoppingList>();
		//setl.add(l1);
		//setl.add(l2);
		//c.setShoppinglist(setl);
		//o.setOrderItem(seto);
		//o.setInvContent("fjsdkjf");
		//addr.setRecName("jj");
		//City c = new City();
		
		
		//book.setComments(setc);
		//BookT book = new BookT();
		//book.setbName("Java编程思想（第4版）");
		////book.setAuthor("(美)埃克尔 著，陈昊鹏 译");
		//book.setPublisher("机械工业出版社");
		//book.setStoNumber(45);
		
		//book.getAuthor();
		//Type t = new Type();
		//t.setTypeName("沈阳");
		//t.setTypeParents("0");
		/*Type t1 = new Type(0l,"文艺");
		Type t2 = new Type(0l,"青春");
		Type t3 = new Type(0l,"少儿");
		Type t4 = new Type(0l,"生活");
		Type t5 = new Type(0l,"社科");
		Type t6 = new Type(0l,"教育");
		Type t7 = new Type(0l,"工具");
		Type t0 = new Type(0l,"小说");*/
		List<Type> tttTypes=s.createQuery("from Type").list();
		System.out.println(tttTypes);
		for(int i=0;i<8;i++){
		Book book = new Book();
		book.setbName("Java编程思想（第4版）");
		book.setAuthor("(美)埃克尔 著，陈昊鹏 译");
		book.setPublisher("机械工业出版社");
		book.setpTime(data);
		book.setInTime(data);
		book.setFace(null);
		book.setType(tt.get(i));
		book.setPrice(78.99f);
		book.setStoNumber(10l);
		book.setSummary("乱七八糟");
		
		s.beginTransaction();
		
		s.save(book);}
		/*s.save(t0);
		s.save(t1);
		
		s.save(t2);
		s.save(t3);
		s.save(t4);
		s.save(t5);
		s.save(t6);
		s.save(t7);*/
		
		//List<City> cities = s.createQuery("from City ").list();
		//List<Book> books = s.createQuery("from Book").list();
		//List<Type> types = s.createQuery("from Type where typeparents='000'").list();
		//System.out.println(types.size());
		//int i =1;
		//int a = types.size();
		//System.out.print(books.get(0));
		//System.out.println(cities);
		//for(Book b:books){
		//	System.out.println(b);
		//}
		//for(City c:cities){
		//	System.out.println(c);
		//}
		
		//for(Type t:types){
			//System.out.println(t);
		//}
		
		s.getTransaction().commit();
		s.close();
		//System.out.println(books.get(0));
		//HibernateSessionFactory.closeSession();
		
		//b.add(book);
		/*Configuration conf = new Configuration();
		conf.configure();
		SessionFactory sf = conf.buildSessionFactory();
		// 2.创建会话
		Session s = sf.openSession();
		
		test t = new test();
		t.setTe("hhkk");
		s.beginTransaction();
		
		s.save(t);
		
		s.getTransaction().commit();
		
		s.close();*/
		

		
	}


}
