package com.quest;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Question {
	@Id
	@GeneratedValue
	@JsonView({QuestionFull.class, QuestionWithAnswers.class})
	public Long id;

	@JsonView({QuestionFull.class, QuestionWithAnswers.class})
	public String question;

	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonView({QuestionFull.class, QuestionWithAnswers.class})
	public Set<Answer> answers = new HashSet<>();

	@JsonView(QuestionFull.class)
	public String tags;

	public interface QuestionFull {}
	public interface QuestionWithAnswers {}
}
