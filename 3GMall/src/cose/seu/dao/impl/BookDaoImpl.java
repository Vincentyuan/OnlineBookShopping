package cose.seu.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sun.org.apache.xml.internal.utils.NSInfo;

import cose.seu.dao.BookDao;
import cose.seu.entity.Book;
import cose.seu.entity.Comments;
import cose.seu.entity.Type;
import cose.seu.util.HibernateSessionFactory;


public class BookDaoImpl implements BookDao{

	public Book findBookById(Long bid) {
		// TODO Auto-generated method stub
		Session s = HibernateSessionFactory.getSession();
		
		List<Book> books = s.createQuery("from Book where BID ="+bid).list();
		
		s.close();
		return books.get(0);
	}

	public Book findBookByName(String name) {
		// TODO Auto-generated method stub
		Session s = HibernateSessionFactory.getSession();
		
		List<Book> books = s.createQuery("from Book where bNAME = '"+name+"'").list();
		
		s.close();
		return books.get(0);
	}

	public Book findBookByAuthor(String aut) {
		// TODO Auto-generated method stub
		Session s = HibernateSessionFactory.getSession();
		
		List<Book> books = s.createQuery("from Book where author ='"+aut+"'").list();
		
		s.close();
		return books.get(0);
	}

	public ArrayList<Book> findBookByType(String type) {
		// TODO Auto-generated method stub
		Session s = HibernateSessionFactory.getSession();
		List<Type> t = s.createQuery("from Type where typeName ='"+type+"'").list();
		List<Book> books = s.createQuery("from Book b where b.type = ?").setEntity(0, t.get(0)).list();
		s.close();
		return (ArrayList<Book>) books;
	}

	public ArrayList<Book> searchByUser(String keyword) {
		// TODO Auto-generated method stub
		Session s = HibernateSessionFactory.getSession();
		List<Book> books=s.createQuery("from Book b where lower(b.bName) like lower('%"+keyword+"%') OR lower(b.author) like lower('%"+keyword+"%') OR lower(b.publisher) like lower('%"+keyword+"%')").list();		
		s.close();
		return (ArrayList<Book>) books;
	}

	public ArrayList<Book> orderBy(String orderWay) {
		// TODO Auto-generated method stub
		Session s = HibernateSessionFactory.getSession();
		List<Book> books=s.createQuery("from Book order by" +orderWay).list();
		s.close();
		return (ArrayList<Book>) books;
	}

	public void add(Book book) {
		// TODO Auto-generated method stub
		// 1.建立会话工厂

				Configuration conf = new Configuration();
				conf.configure();
				SessionFactory sf = conf.buildSessionFactory();
				// 2.创建会话
				Session s = sf.openSession();
				Book boo1 = new Book();
				boo1 = book;
				/*boo1.setBookName(book.getBookName());
				boo1.setPrice(book.getPrice());
				boo1.setPublisher(book.getPublisher());
				boo1.setAuthor(book.getAuthor());
				boo1.setFace(book.getFace());
				boo1.setSummary(book.getSummary());
				boo1.setStoNumber(book.getStoNumber());
				boo1.setpTime(book.getpTime());
				boo1.setInTime(book.getInTime());
				boo1.setType(book.getType());*/
				
				s.beginTransaction();
				
				s.save(boo1);
				
				s.getTransaction().commit();
				
				s.close();
				
		
	}

	public void remove(Long bid) {
		// TODO Auto-generated method stub
		Session s = HibernateSessionFactory.getSession();
		Book b = findBookById(bid);
		s.beginTransaction();
		s.delete(b);
		s.getTransaction().commit();
		s.close();
	}

	public void remove(String name) {
		// TODO Auto-generated method stub
		Session s = HibernateSessionFactory.getSession();
		Book b = findBookByName(name);
		s.beginTransaction();
		s.delete(b);
		s.getTransaction().commit();
		s.close();
		
	}

	public void update(Book book) {
		// TODO Auto-generated method stub
		Session s = HibernateSessionFactory.getSession();
		s.beginTransaction();
		s.update(book);
		s.getTransaction().commit();
		s.close();
		
	}

	public void add(String bString, String publisher, float price,
			Long stoNumber, String Suammry, Date pTime, Long type, String face,
			Date inTime, Long salNumber, String comAveLevel, float vipPrice,
			Long comNumber, String author, Set<String> comments) {
		// TODO Auto-generated method stub
		Book book= new Book();
		book.setbName(bString);
		book.setPublisher(publisher);
		book.setPrice(price);
		book.setStoNumber(stoNumber);
		book.setSummary(Suammry);
		book.setpTime(pTime);
		book.setFace(face);
		
	}

	public ArrayList<Book> homeshow(String type) {
		// TODO Auto-generated method stub
		Session s = HibernateSessionFactory.getSession();
		List<Type> t = s.createQuery("from Type where typeName ='"+type+"'").list();
		List<Book> books = s.createQuery("from Book b where b.type = ? order by b.inTime desc").setEntity(0, t.get(0)).setFirstResult(0).setMaxResults(5).list();
		s.close();
		return (ArrayList<Book>) books;
		
	}

	public List<Type> showType() {
		// TODO Auto-generated method stub
		Session s= HibernateSessionFactory.getSession();
		List<Type> types = s.createQuery("from Type").list();
		return types;
	}

	public Float findPriceById(Long bid) {
		// TODO Auto-generated method stub
		Session s= HibernateSessionFactory.getSession();
		List<Float> bp = s.createQuery("select price from Book where BID= "+bid).list();
		return bp.get(0);
	}

	

}
