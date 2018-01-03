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
			question.type = "oneRight";
			question.tags = "years,people";
			questionRepository.save(question);

			Question question1 = new Question();
			question1.question = "How are you?";
			question1.answers.add(new Answer("Ok", true, question1));
			question1.answers.add(new Answer("Not bad", true, question1));
			question1.answers.add(new Answer("Bad", false, question1));
			question1.answers.add(new Answer("So - so", false, question1));
			question1.tags = "people";
			question1.type = "manyRight";
			questionRepository.save(question1);

			Question question2 = new Question();
			question2.question = "2 How are you?";
			question2.answers.add(new Answer("Ok", true, question2));
			question2.answers.add(new Answer("So - so", false, question2));
			question2.tags = "people";
			question2.type = "manyRight";
			questionRepository.save(question2);

			Question question3 = new Question();
			question3.question = "3 How are you?";
			question3.answers.add(new Answer("Ok", true, question3));
			question3.answers.add(new Answer("So - so", false, question3));
			question3.tags = "people";
			question3.type = "manyRight";
			questionRepository.save(question3);

			Question question4 = new Question();
			question4.question = "4 How are you?";
			question4.answers.add(new Answer("Ok", true, question4));
			question4.answers.add(new Answer("So - so", false, question4));
			question4.tags = "people";
			question4.type = "manyRight";
			questionRepository.save(question4);

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}


