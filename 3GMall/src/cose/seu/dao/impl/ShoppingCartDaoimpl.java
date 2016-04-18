package cose.seu.dao.impl;

import java.sql.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import cose.seu.dao.ShoppingCartDao;
import cose.seu.entity.Book;
import cose.seu.entity.ShoppingCart;
import cose.seu.entity.ShoppingList;
import cose.seu.entity.UserInfo;
import cose.seu.util.HibernateSessionFactory;


public class ShoppingCartDaoimpl implements ShoppingCartDao {
	

	public void addShoppingCart(UserInfo user) {
		// TODO Auto-generated method stub
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionfactory.openSession();
		
		Set<ShoppingList> shoppinglist = new HashSet<ShoppingList>();
		
		ShoppingCart sc = new ShoppingCart(user,shoppinglist);
		Transaction trans = s.beginTransaction();
		s.save(sc);
		trans.commit();
		s.close();
		
	}
//************************************************************************************************
	public void addShoppingList(Long bnumber,ShoppingCart shoppingcart, java.util.Date aTime, Book book) {
		// TODO Auto-generated method stub
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionfactory.openSession();
		Transaction trans = s.beginTransaction();
		
		ShoppingList sl = new ShoppingList(bnumber,shoppingcart,aTime,book);
		s.save(sl);
		trans.commit();
		
		/*if(shoppingcart.getShoppinglist()!=null){
			Set<ShoppingList> ssss=shoppingcart.getShoppinglist();
			ssss.add(sl);
		}
		else{
			Set<ShoppingList> ssl = new HashSet<ShoppingList>();
			ssl.add(sl);
			shoppingcart.setShoppinglist(ssl);
		}*/
		
		s.close();
		
	}
//*****************************************************************************************************

	public ShoppingList getShoppingListbySLID(Long sLID) {
		// TODO Auto-generated method stub
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionfactory.openSession();
		
		List<ShoppingList> sll=s.createQuery("from ShoppingList sl where sl.SLID=?").setLong(0, sLID).list();
		ShoppingList sl=sll.get(0);
		s.close();
		return sl;
	}
//**********************************************************************************************************
	public List<ShoppingList> getShoppingListSetbySCID(Long sCID) {
		// TODO Auto-generated method stub
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionfactory.openSession();
		
		List<ShoppingList> sll=s.createQuery("from ShoppingList sl where sl.shoppingcart=?").setEntity(0,this.getShoppingCartbySCID(sCID) ).list();
		s.close();
		return sll;
	}
//**************************************************************************************************************
	public ShoppingCart getShoppingCartbySCID(Long sCID){
		
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionfactory.openSession();
		
		List<ShoppingCart> scl=s.createQuery("from ShoppingCart sc where sc.SCID=?").setLong(0, sCID).list();
		ShoppingCart sc=scl.get(0);
		s.close();
		return sc;
	}
//*****************************************************************************************************************

	public ShoppingCart getShoppingCartbyUser(UserInfo user) {
		// TODO Auto-generated method stub
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionfactory.openSession();
		List<ShoppingCart> scl=s.createQuery("from ShoppingCart sc where sc.User=?").setEntity(0,user).list();
		if(scl != null&&scl.size()>0){
		ShoppingCart sc=scl.get(0);
		s.close();
		return sc;
		}
		return null;
	}
	public void deleteShoppingCartbyUser(UserInfo user) {
		// TODO Auto-generated method stub
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionfactory.openSession();
		Transaction trans = s.beginTransaction();
		
		s.delete(this.getShoppingCartbyUser(user));
		trans.commit();
		s.close();
		
	}
//****************************************************************************************************************
	public void deleteShoppingCartbySC(ShoppingCart shoppingcart) {
		// TODO Auto-generated method stub
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionfactory.openSession();
		Transaction trans = s.beginTransaction();
		
		s.delete(shoppingcart);
		trans.commit();
		s.close();
		
	}
//****************************************************************************************************************
	public void deleteShoppingListbySLID(Long sLID) {
		// TODO Auto-generated method stub
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionfactory.openSession();
		Transaction trans = s.beginTransaction();
		
		s.delete(this.getShoppingListbySLID(sLID));
		trans.commit();
		s.close();
		
	}
//****************************************************************************************************************

	public void updateBNumber(ShoppingList shoppinglist,Long bnumber) {
		// TODO Auto-generated method stub
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionfactory.openSession();
		Transaction trans = s.beginTransaction();
		shoppinglist.setBnumber(bnumber);
		s.update(shoppinglist);
		trans.commit();
		s.close();
		
	}
	

	

/*	
	public ShoppingCartDaoimpl() {
	}
	
	
	public void saveShoppingList(ShoppingList sl) {
		
		Session s=HibernateSessionFactory.getSession();
		s.save(sl);
		//s.close();
	}

	public void saveShoppingCart(ShoppingCart sc) {
		// TODO Auto-generated method stub
		Session s=HibernateSessionFactory.getSession();
		s.save(sc);
		//s.close();
	}

	public void SCAdd(long userID) {
		// TODO Auto-generated method stub
		ShoppingCart sc=new ShoppingCart(userID);
		Session s=HibernateSessionFactory.getSession();
		s.save(sc);
		//s.close();
	}
	public void SLAdd(long sLID, long bnumber, long sCID, Date aTime,
			Book book) {
		// TODO Auto-generated method stub
		ShoppingList sl=new ShoppingList(sLID, bnumber, sCID, aTime, book);
		Session s=HibernateSessionFactory.getSession();
		s.beginTransaction();
		s.save(sl);
		//s.close();
	}

	public void SCDelete(long userID) {
		// TODO Auto-generated method stub
		Session s=HibernateSessionFactory.getSession();
		Transaction trans=s.beginTransaction();
		String hql="delete from ShoppingCart shoppingCart where shoppingCart.USERID=:userID";
		Query queryupdate=s.createQuery(hql);
		queryupdate.setLong("userID", userID);
		int ret=queryupdate.executeUpdate();
		trans.commit();
		//s.close();

	}

	public ShoppingCart getShoppingCart(long userID) {
		// TODO Auto-generated method stub
		String hql="from ShoppingCart shoppingCart where shoppingCart.USERID=:userID";
		Session s=HibernateSessionFactory.getSession();
		Query query=s.createQuery(hql);
		query.setLong("userID", userID);
		ShoppingCart sc=(ShoppingCart)query.list();
		//s.close();
		return sc;
	}

	public void SCUpdate(long sLID,long bnumber) {
		// TODO Auto-generated method stub\
		Session s=HibernateSessionFactory.getSession();
		Transaction trans=s.beginTransaction();
		String hql="update ShoppingList shoppingList shoppingList.Bnumber=:bnumber where shoppingList.SLID=:sLID";
		Query queryupdate=s.createQuery(hql);
		queryupdate.setLong("sLID", sLID);
		queryupdate.setLong("bnumber", bnumber);
		int ret=queryupdate.executeUpdate();
		trans.commit();
		//s.close();
	}

	@SuppressWarnings("unchecked")
	public Set<ShoppingList> getSCList(long sCID) {
		// TODO Auto-generated method stub
		String hql="from ShoppingList shoppingList where shoppingList.SCID=:sCID";
		Session s=HibernateSessionFactory.getSession();
		Query query=s.createQuery(hql);
		query.setLong("sCID", sCID);
		List<ShoppingList> list=query.list();
		Set<ShoppingList> ssl = new HashSet<ShoppingList>();
		ssl.addAll(list);
		//s.close();
		return ssl;
	}

	public ShoppingList getShoppingList(long sLID) {
		// TODO Auto-generated method stub
		String hql="from ShoppingList shoppingList where shoppingList.SLID=:sLID";
		Session s=HibernateSessionFactory.getSession();
		Query query=s.createQuery(hql);
		query.setLong("sLID", sLID);
		List<ShoppingList> list=query.list();
		Set<ShoppingList> ssl = new HashSet<ShoppingList>();
		ssl.addAll(list);
		
		Iterator<ShoppingList> ite = ssl.iterator();
		
		ShoppingList sl = ite.next();
		//s.close();
		return sl;
	}

	public void DeleteShoppingList(long sLID) {
		// TODO Auto-generated method stub
		Session s=HibernateSessionFactory.getSession();
		Transaction trans=s.beginTransaction();
		String hql="delete from ShoppingList shoppingList where shoppingList.SLID=:sLID";
		Query queryupdate=s.createQuery(hql);
		queryupdate.setLong("sLID", sLID);
		int ret=queryupdate.executeUpdate();
		trans.commit();
		//s.close();
	}

	public void DeleteAllShoppingList(long sCID) {
		// TODO Auto-generated method stub
		Session s=HibernateSessionFactory.getSession();
		Transaction trans=s.beginTransaction();
		String hql="delete from ShoppingList shoppingList where shoppingList.SCID=:sCID";
		Query queryupdate=s.createQuery(hql);
		queryupdate.setLong("sCID", sCID);
		int ret=queryupdate.executeUpdate();
		trans.commit();
		//s.close();

	}


	public void SLAdd(long SLID) {
		// TODO Auto-generated method stub
		
	}
*/

}
