package toy.crudboard.answer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import toy.crudboard.answer.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
