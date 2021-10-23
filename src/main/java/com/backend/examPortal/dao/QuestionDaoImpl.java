package com.backend.examPortal.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.examPortal.entity.quiz.Question;
import com.backend.examPortal.entity.quiz.Quiz;

@Repository
public class QuestionDaoImpl implements QuestionDao {
	
private EntityManager em;
	
	@Autowired
	public QuestionDaoImpl(EntityManager em)
	{
		this.em = em;
	}
	@Transactional
	public List<Question> findAll() {
		//get the curr hibernate session
		 Session cs = em.unwrap(Session.class);
		
		//create a query
		Query<Question>query =
				cs.createQuery("from Question",Question.class);
		
		//execute query and get result list
		List<Question>rs = query.getResultList();  
		// return the results
		return rs;
	}

}
