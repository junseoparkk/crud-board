package toy.crudboard.question.service;

import java.util.List;
import org.springframework.data.domain.Page;
import toy.crudboard.question.entity.Question;

public interface QuestionService {
    Question findById(Long id);
    Question findBySubject(String subject);
    Question findBySubjectAndContent(String subject, String content);
    Page<Question> findAll(int page);
    void create(String subject, String content);
}
