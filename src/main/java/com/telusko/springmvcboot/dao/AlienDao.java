package com.telusko.springmvcboot.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.hibernate.SessionFactory;
import com.telusko.springmvcboot.model.Alien;

@Component
public class AlienDao
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
public List<Alien> getAliens()
{
	Session session = sessionFactory.getCurrentSession();
	List <Alien> aliens = session.createQuery("from Alien",Alien.class).list();
	
	return aliens;
}
}