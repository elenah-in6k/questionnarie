package com.quest;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QuestionSpecification implements EntitySpecification<Question> {
    public Optional<String> oQuestion = Optional.empty();

    public Optional<String> oType = Optional.empty();

    public Optional<String> oTags = Optional.empty();

    public void setOquestion(Optional<String> oquestionName) {
        this.oQuestion = oquestionName;
    }

    public void setoType(Optional<String> oType) {
        this.oType = oType;
    }

    public void setoTags(Optional<String> oTags) {
        this.oTags = oTags;
    }

    @Override
        public CriteriaQuery<Question> toCriteria(CriteriaBuilder cb) {
            CriteriaQuery<Question> questionCriteriaQuery = cb.createQuery(Question.class);
            Root<Question> questionEntity = questionCriteriaQuery.from(Question.class);
            questionCriteriaQuery.select(questionEntity);

            List<Predicate> predicateList = new ArrayList<>();

            oQuestion.ifPresent(question -> predicateList.add(cb.like(questionEntity.get("question"), "%" + question + "%")));
            oType.ifPresent(type -> predicateList.add(cb.like(questionEntity.get("type"), "%" + type + "%")));
            oTags.ifPresent(tags -> predicateList.add(cb.like(questionEntity.get("tags"), "%" + tags + "%")));
            Predicate mainPredicate = cb.and(predicateList.toArray(new Predicate[predicateList.size()]));

            System.out.println(predicateList.size());
            questionCriteriaQuery.where(mainPredicate);

            return questionCriteriaQuery;
        }
}