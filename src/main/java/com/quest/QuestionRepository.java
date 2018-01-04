package com.quest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends PagingAndSortingRepository<Question, Long>, QuestionRepositoryCustom {

	List<Question> findByTagsContains(@Param("tags") String tags);

	List<Question> findBy(QuestionSpecification specification);
}
