package com.quest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages={"com.quest"})
public class Application {

	@Bean
	public CommandLineRunner lineRunner(QuestionRepository questionRepository) {
		return args -> {
			Question question = new Question();
			question.question = "How are you old?";
			question.answers.add(new Answer("18", true, question));
			question.answers.add(new Answer("19", false, question));
			question.tags = "years,people";
			questionRepository.save(question);

			Question question1 = new Question();
			question1.question = "How are you?";
			question1.answers.add(new Answer("Ok", true, question1));
			question1.answers.add(new Answer("Not bad", true, question1));
			question1.answers.add(new Answer("Bad", false, question1));
			question1.answers.add(new Answer("So - so", false, question1));
			question1.tags = "people";
			questionRepository.save(question1);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}


