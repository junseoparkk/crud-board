package toy.crudboard.answer.service;

import toy.crudboard.question.entity.Question;

public interface AnswerService {
    void create(Question question, String content);
}
