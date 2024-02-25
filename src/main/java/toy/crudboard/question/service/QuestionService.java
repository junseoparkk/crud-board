package toy.crudboard.question.service;

import java.util.List;
import toy.crudboard.question.entity.Question;

public interface QuestionService {
    Question findById(Long id);
    Question findBySubject(String subject);
    Question findBySubjectAndContent(String subject, String content);
    List<Question> findAll();
    void create(String subject, String content);
}
