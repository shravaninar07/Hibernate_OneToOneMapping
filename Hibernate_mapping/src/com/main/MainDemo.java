package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Answer;
import com.entity.Question;

public class MainDemo {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf= cfg.buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();
		
		Question q1= new  Question();
		q1.setQuestionId(123);
		q1.setQuestion("What is java?");
		
		Answer ans1= new Answer();
		ans1.setAnswerId(1234);
		ans1.setAnswer("java is oops language");
		//ans1.setQuestion(q1);
	
		
		ss.persist(ans1); 
		ss.flush();
		
		q1.setAnswer(ans1);
		ss.persist(q1);
		
		ans1.setQuestion(q1);
		ss.persist(ans1);
		
	    tr.commit();
	
		//ss.save(q1);
		
        ss.close();
        
	}

}
