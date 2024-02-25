package toy.crudboard.question.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import toy.crudboard.question.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    Question findBySubject(String subject);
    Question findBySubjectAndContent(String subject, String content);
    Page<Question> findAll(Pageable pageable);
}
