package info.querypro.querypro.question.repository;

import info.querypro.querypro.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 질문 레포.
 *
 * @author : 임태원
 * @since : 1.0
 **/
public interface QuestionRepository extends JpaRepository<Question, Long> {

}
