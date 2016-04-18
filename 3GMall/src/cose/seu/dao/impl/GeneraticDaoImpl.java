package cose.seu.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;




import cose.seu.dao.GeneraticDao;

public class GeneraticDaoImpl<T extends Serializable, ID extends Serializable>
implements GeneraticDao<T, ID>{
	
	private Class<T> persistentClass;


	public GeneraticDaoImpl() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public T create(T entity) {
		Session session = cose.seu.util.HibernateSessionFactory.getSession();
		Transaction trans = null;
		try{
			trans = session.beginTransaction();
			session.save(entity);
			trans.commit();
			return entity;
		} catch (RuntimeException ex){
			ex.printStackTrace();
			trans.rollback();
			return null;
		} finally {
			cose.seu.util.HibernateSessionFactory.closeSession();
		}		
	}


	public T findById(ID id) {
		Session session = cose.seu.util.HibernateSessionFactory.getSession();
		try{
			return (T)session.get(this.persistentClass, id);
		} catch (RuntimeException ex){
			ex.printStackTrace();
			return null;
		}
	}

	public void delete(ID id) {
		Session session = cose.seu.util.HibernateSessionFactory.getSession();
		Transaction trans = null;
		try{
			trans = session.beginTransaction();
			session.delete(findById(id));
			trans.commit();
		} catch (RuntimeException ex){
			ex.printStackTrace();
			trans.rollback();
		} finally {
			cose.seu.util.HibernateSessionFactory.closeSession();
		}		
	}

	public void update(T entity) {
		Session session = cose.seu.util.HibernateSessionFactory.getSession();
		Transaction trans = null;
		try{
			trans = session.beginTransaction();
			session.update(entity);
			trans.commit();
		} catch (RuntimeException ex){
			ex.printStackTrace();
			trans.rollback();
		} finally {
			cose.seu.util.HibernateSessionFactory.closeSession();
		}	
		
	}
	
	public void save(T entity) {
		Session session = cose.seu.util.HibernateSessionFactory.getSession();
		Transaction trans = null;
		try{
			trans = session.beginTransaction();
			session.saveOrUpdate(entity);
			trans.commit();
		} catch (RuntimeException ex){
			ex.printStackTrace();
			trans.rollback();
		} finally {
			cose.seu.util.HibernateSessionFactory.closeSession();
		}	
		
	}

	public List<T> findByHQL(String strHQL, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}



}
