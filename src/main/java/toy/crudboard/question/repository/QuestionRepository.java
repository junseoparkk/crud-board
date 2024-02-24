package toy.crudboard.question.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import toy.crudboard.question.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Question findBySubject(String subject);
    Question findBySubjectAndContent(String subject, String content);
}
