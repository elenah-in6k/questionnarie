package com.quest;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Question {

	@Id
	private String question;
	private String answer;
	private String tags;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
}
