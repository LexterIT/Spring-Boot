package com.spring.lexter;

import java.util.List;

public interface HibernateUtil {

	void initializeFactory();
	void startSession();
	void endSession();
	void insertObject(Object obj);
	List getObject(Class className);
	Object getSingleObject(Class className, int id);
	void updateObject(Object obj);
	void deleteObject(Object obj);
	List getSorted(Class className, String field, String order);

}