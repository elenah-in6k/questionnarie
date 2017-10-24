package com.quest;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication(scanBasePackages={"com.quest"})
public class Application {

	@Bean
	public CommandLineRunner lineRunner(QuestionRepository questionRepository) {
		return args -> {
			Question question = new Question();
			question.question = "How are you old?";
			question.answers.add(new Answer("18", true, question));
			question.answers.add(new Answer("19", false, question));
			questionRepository.save(question);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}


@RestController
@RequestMapping("/api/questions")
class QuestionController {
	private final QuestionRepository questionRepository;

	@Autowired
	QuestionController(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}

	@JsonView(Question.QuestionFull.class)
	@GetMapping
	public Iterable<Question> questions() {
		return questionRepository.findAll();
	}

	@JsonView(Question.QuestionWithAnswers.class)
	@GetMapping("without-tags")
	public Iterable<Question> questionsWithAnswers() {
		return questionRepository.findAll();
	}
}
