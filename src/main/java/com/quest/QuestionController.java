package com.quest;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

	@PostMapping
	public void saveQuestion(@RequestBody Question question) {
		question.answers.forEach(answ->answ.question=question);
		 questionRepository.save(question);
	}

	@DeleteMapping
	public void deleteQuestions(@RequestParam("id") Long id) {
		questionRepository.delete(id);
	}

	@JsonView(Question.QuestionFull.class)
	@GetMapping("find-by-tags")
	public Iterable<Question> searchQuestions(@RequestParam(required = false) String oQuestion,
											  @RequestParam(required = false) String oType,
											  @RequestParam(required = false) String oTag ) {
		QuestionSpecification specification = new QuestionSpecification();
		specification.setOquestion(Optional.of(oQuestion));
		specification.setoType(Optional.of(oType));
		specification.setoTags(Optional.of(oTag));

		return questionRepository.findBy(specification);
	}

	@JsonView(Question.QuestionFull.class)
	@GetMapping("{id}")
	public Question questionById(@PathVariable("id") Long id) {
		return questionRepository.findById(id);
	}

	@JsonView(Question.QuestionWithAnswers.class)
	@GetMapping("without-tags")
	public Iterable<Question> questionsWithAnswers() {
		return questionRepository.findAll();
	}
}
