package com.quest;

import java.util.List;

public interface QuestionRepositoryCustom  {
	List<Question> findBy(QuestionSpecification specification) ;
}
