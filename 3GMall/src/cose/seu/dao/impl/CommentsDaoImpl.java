package cose.seu.dao.impl;

import java.util.List;

import org.hibernate.Session;

import cose.seu.dao.CommentsDao;
import cose.seu.entity.Comments;
import cose.seu.util.HibernateSessionFactory;

public class CommentsDaoImpl implements CommentsDao{

	public List<Comments> findComByBID(Long bid) {
		// TODO Auto-generated method stub
		Session s =HibernateSessionFactory.getSession(); 
		List<Comments> list = s.createQuery("from Comments c where c.Book").list();
		
		
		return null;
		
	}

	public void insertCom(Comments com) {
		// TODO Auto-generated method stub
		Session s =HibernateSessionFactory.getSession();
		if (com==null) {
			System.out.println("com ¿Õ£¡");
			return;
			
		}
		s.beginTransaction();
		s.save(com);
		s.getTransaction().commit();
		s.close();
		
	}

}
