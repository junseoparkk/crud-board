package toy.crudboard.question.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import toy.crudboard.exception.DataNotFoundException;
import toy.crudboard.question.entity.Question;
import toy.crudboard.question.repository.QuestionRepository;

@RequiredArgsConstructor
@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    @Override
    public Question findById(Long id) {
        Optional<Question> question = questionRepository.findById(id);
        if (question.isPresent()) {
            return question.get();
        } else {
            throw new DataNotFoundException("question not found");
        }
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

    @Override
    public void create(String subject, String content) {
        Question question = new Question();
        question.setSubject(subject);
        question.setContent(content);
        question.setCreateDate(LocalDateTime.now());
        questionRepository.save(question);
    }
}
