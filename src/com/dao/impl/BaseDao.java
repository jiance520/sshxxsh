package com.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("baseDao")   // dao ��ע��
public class BaseDao {

	protected SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	protected Session getSession(){
		
		return sessionFactory.getCurrentSession(); // �ӵ�ǰ�߳�ȡsession
	}
}
