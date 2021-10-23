package com.backend.examPortal.entity.quiz;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="quiz")
public class Quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String topic;
	private String desc;
	private int no_of_ques;
	private int total_marks;
	private String owner;
	
	public Quiz() {
		
	}

	public Quiz(String topic, String desc, int no_of_ques, int total_marks) {
		super();
		this.topic = topic;
		this.desc = desc;
		this.no_of_ques = no_of_ques;
		this.total_marks = total_marks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getno_of_ques() {
		return no_of_ques;
	}

	public void setno_of_ques(int no_of_ques) {
		this.no_of_ques = no_of_ques;
	}

	public int gettotal_marks() {
		return total_marks;
	}

	public void settotal_marks(int total_marks) {
		this.total_marks = total_marks;
	}
	
	
}
