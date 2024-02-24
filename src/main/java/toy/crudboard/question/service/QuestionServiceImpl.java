package toy.crudboard.question.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import toy.crudboard.question.entity.Question;
import toy.crudboard.question.repository.QuestionRepository;

@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private QuestionRepository questionRepository;

    @Override
    public Question findById(Long id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("no such question"));
    }

    @Override
    public Question findBySubject(String subject) {
        return questionRepository.findBySubject(subject);
    }

    @Override
    public Question findBySubjectAndContent(String subject, String content) {
        return questionRepository.findBySubjectAndContent(subject, content);
    }

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }
}
