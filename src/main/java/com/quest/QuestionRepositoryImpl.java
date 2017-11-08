package com.quest;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class QuestionRepositoryImpl extends BaseRepository<Question, Integer> {

    @Autowired
    public QuestionRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    List<Question> findBy(QuestionSpecification specification) {
        CriteriaQuery<Question> userCriteriaQuery = specification.toCriteria(entityManager.getCriteriaBuilder());
        return entityManager.createQuery(userCriteriaQuery).getResultList();
    }
}
