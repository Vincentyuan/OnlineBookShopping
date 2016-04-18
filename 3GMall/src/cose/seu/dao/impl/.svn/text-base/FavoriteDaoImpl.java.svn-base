package cose.seu.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import cose.seu.dao.FavoriteDao;

import cose.seu.entity.Favorite;


public class FavoriteDaoImpl extends GeneraticDaoImpl<Favorite, Long> implements FavoriteDao{

	public Set<Favorite> getSetFavorite(Long uID) {
		Session session = cose.seu.util.HibernateSessionFactory.getSession();
		try{
			String hql="from Favorite favorite where favorite.user=:uID";
			Query query = session.createQuery(hql);
			query.setLong("uID", uID);
			List<Favorite> list=query.list();
			Set<Favorite> fl = new HashSet<Favorite>();
			fl.addAll(list);
			return fl;
		} catch (RuntimeException ex){
			ex.printStackTrace();
			return null;
		} finally {
			cose.seu.util.HibernateSessionFactory.closeSession();
		}// TODO Auto-generated method stub
	}

}
