package cose.seu.dao.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sun.xml.internal.ws.Closeable;

import cose.seu.dao.OrderDao;
import cose.seu.entity.Order;
import cose.seu.entity.OrderItem;
import cose.seu.util.HibernateSessionFactory;

public class OrderDaoImpl extends GeneraticDaoImpl<Order,Long> implements OrderDao {
	
	/**
	 * author Jossion
	 */
	
	private SessionFactory sessionFactory;
	private Session session;

	
	public OrderDaoImpl() {
		sessionFactory=new Configuration().configure().buildSessionFactory();
		session=sessionFactory.openSession();
	}

	public void saveOrder(Order order) {
		Transaction transaction=session.beginTransaction();
		session.save(order);
		transaction.commit();
	}

	public Order getOrder(long oid) {		
		return (Order) session.get(Order.class, oid);
	}

	public OrderItem getOrderItem(long oitid) {		
		return (OrderItem) session.get(OrderItem.class, oitid);
	}

//	public void saveOrderItem(OrderItem orderItem) {		
//		Transaction transaction=session.beginTransaction();
//		session.save(orderItem);
//		transaction.commit();
//
//	}

	public void deleteOrder(Order order) {		
		Transaction transaction=session.beginTransaction();
		session.delete(order);
		transaction.commit();
	}


//	public void deleteOrderItem(OrderItem orderItem) {		
//		Transaction transaction=session.beginTransaction();
//		session.delete(orderItem);
//		transaction.commit();
//	}


	public void deleteOrder(long oid) {		
		deleteOrder(getOrder(oid));		
	}


//	public void deleteOrderItem(long oitid) {		
//		deleteOrderItem(getOrderItem(oitid));
//	}

    public void changeState(long oid,String state){
    	Transaction transaction=session.beginTransaction();
        Order tempOrder=getOrder(oid);
    	tempOrder.setState(state);
    	session.update(tempOrder);
    	transaction.commit();
    }
	
	public Order findOrderByOrdID(long ordid) {		
		return (Order) session.createQuery("from Order o where o.ordid=?").setLong(0, ordid).list().get(0);
	}

	public List<Order> searchOrder() {	    
		return session.createQuery("from Order").list();
	}


	public List<OrderItem> searchOrderItem() {		
		return session.createQuery("from OrderItem").list();
	}
	
//	public List<OrderItem> findOrderItemByOID(Order order){
//		return (List<OrderItem>) session.createQuery("from OrderItem oi where oi.order=?").setEntity(0, order).list();
//	}
	
	public List<OrderItem> findOrderItemByOID(long oid){
		return (List<OrderItem>) session.createQuery("from OrderItem oi where oi.order=?").setLong(0, oid).list();
	}
	
	public void closeSession(){
		session.close();
		sessionFactory.close();
	}

}
