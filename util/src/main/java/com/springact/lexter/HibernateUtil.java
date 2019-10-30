package com.spring.lexter;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.TypedQuery;
import org.hibernate.Query;

import org.springframework.stereotype.Service;

@Service
public class HibernateUtil {

	private Session session;
	private Transaction transaction;
	private SessionFactory factory;

	public HibernateUtil() {
		initializeFactory();
	}

	private void initializeFactory() {
		try{
			factory = new Configuration().configure().buildSessionFactory();
		}catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public void startSession() {
		if(session == null) {
			session = factory.openSession();
		}
		if(session != null) {
			if(!session.isOpen())
				session = factory.openSession();
		}
	}

	public void endSession() {
		if(session.isOpen()) 
			session.close();
	}	

	public void insertObject(Object obj) {
		startSession();
		transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(obj);
			transaction.commit();
		} catch(HibernateException e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			endSession();
		}
	}
	

	public List getObject(Class className) {
		startSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(className);
		Root root = criteriaQuery.from(className);
		Query query = session.createQuery(criteriaQuery);
		query.setCacheable(true);
		List results = query.getResultList();
		endSession();
		return results;
	}

	public Object getSingleObject(Class className, int id) {
		startSession();
		try{
			Object obj = session.get(className,id);
			return obj;
		} finally {
			endSession();		
		}
	}

	public void updateObject(Object obj) {
		startSession();
		transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(obj);
			transaction.commit();
		} catch(HibernateException e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace(); 
		} finally {
			endSession();
		}
	}

	public void deleteObject(Object obj) {
		startSession();
		transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(obj);
			transaction.commit();
		} catch(HibernateException e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace(); 
		} finally {
			endSession();
		}
	}


	public List getSorted(Class className, String field, String order) {
		startSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery cr = cb.createQuery(className);
		Root root = cr.from(className);
		cr.select(root);
		if(field.equalsIgnoreCase("lastName")) {
			if(order.equalsIgnoreCase("asc"))
				cr.orderBy(cb.asc(root.get("name").get(field)));
			else 
				cr.orderBy(cb.desc(root.get("name").get(field)));
		} else if(field.equalsIgnoreCase("dateHired")) {
			if(order.equalsIgnoreCase("asc"))
				cr.orderBy(cb.asc(root.get(field)));
			else
				cr.orderBy(cb.desc(root.get(field)));
		} else if(field.equalsIgnoreCase("id")) {
			cr.orderBy(cb.asc(root.get(field)));
		}
		Query query = session.createQuery(cr);
		query.setCacheable(true);
		List results = query.getResultList();
		endSession();
		return results;
	}

}