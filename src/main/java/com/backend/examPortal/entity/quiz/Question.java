package com.backend.examPortal.entity.quiz;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="question")
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String questionText;
	private String option1;
	private String option2;
	private String option3;
	private String option4;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String answer;

	@ManyToOne(fetch=FetchType.EAGER)
	private Quiz quiz;
	
	public Question() {
		
	}
	public Question(int id, String questionText, String option1, String option2, String option3, String option4,
			String answer, Quiz quiz) {
		super();
		this.id = id;
		this.questionText = questionText;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.answer = answer;
		this.quiz = quiz;
	}
	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	
	
	public boolean isValidQuestion()
	{
		System.out.println("checking if question is valid...");
		System.out.println(questionText);
		System.out.println(option1);
		System.out.println(option2);
		System.out.println(answer);

		if(questionText==null||questionText.trim()=="")return false;

		if(option1==null)return false;

		if(option2==null)return false;
		if(answer.trim()==null||(!answer.equals(option1) && !answer.equals(option2)))return false;
		return true;

	}
}
