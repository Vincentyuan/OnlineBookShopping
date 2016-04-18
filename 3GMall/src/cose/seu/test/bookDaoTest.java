package cose.seu.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transaction;

import org.hibernate.Session;

import cose.seu.dao.BookDao;
import cose.seu.dao.impl.BookDaoImpl;
import cose.seu.entity.Book;
import cose.seu.entity.Comments;
import cose.seu.entity.ShoppingCart;
import cose.seu.entity.ShoppingList;
import cose.seu.entity.*;
import cose.seu.util.HibernateSessionFactory;

public class bookDaoTest {
	public static void main(String[] args){
		BookDao d = new BookDaoImpl();
		Book book = d.findBookByName("Java编程思想（第4版）");
		System.out.println(book.getAuthor());
		
	}
	
}
