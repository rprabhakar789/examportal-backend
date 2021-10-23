package com.backend.examPortal.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.examPortal.entity.quiz.Quiz;

@Repository
public class QuizDaoImpl implements QuizDao {

	private EntityManager em;
	
	@Autowired
	public QuizDaoImpl(EntityManager em)
	{
		this.em = em;
	}
	@Transactional
	public List<Quiz> findAll() {
		//get the curr hibernate session
		 Session cs = em.unwrap(Session.class);
		
		//create a query
		Query<Quiz>query =
				cs.createQuery("from Quiz",Quiz.class);
		
		//execute query and get result list
		List<Quiz>rs = query.getResultList();  
		// return the results
		return rs;
	}
	public void add(Quiz q) {
		// TODO Auto-generated method stub
		
	}
	public Quiz getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	public Quiz update(Quiz q) {
		// TODO Auto-generated method stub
		return null;
	}
	public void delete(Quiz q) {
		// TODO Auto-generated method stub
		
	}

}
