package com.quest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Answer {
    @Id
    @GeneratedValue
    @JsonView({Question.QuestionFull.class, Question.QuestionWithAnswers.class})
    public Long id;

    @JsonIgnore
    @ManyToOne
    public Question question;

    @JsonView({Question.QuestionFull.class, Question.QuestionWithAnswers.class})
    public String body;

    @JsonView({Question.QuestionFull.class, Question.QuestionWithAnswers.class})
    public boolean isCorrect;

    public Answer() {
    }

    public Answer(String body, boolean isCorrect, Question question) {
        this.body = body;
        this.isCorrect = isCorrect;
        this.question = question;
    }
}
