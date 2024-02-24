package toy.crudboard.question;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import toy.crudboard.answer.entity.Answer;
import toy.crudboard.question.entity.Question;
import toy.crudboard.question.repository.QuestionRepository;

@SpringBootTest
public class QuestionRepositoryTest {
    @Autowired
    QuestionRepository questionRepository;

    @Transactional
    @DisplayName("질문 저장 테스트")
    @Test
    void saveTest() {
        //given
        Question question = new Question();
        question.setSubject("test_subject");
        question.setContent("test_content");
        question.setAnswers(new ArrayList<Answer>());
        question.setCreateDate(LocalDateTime.now());

        //when
        questionRepository.save(question);

        //then
        Question findQuestion = questionRepository.findById(question.getId())
                .orElseThrow(() -> new IllegalArgumentException("no such question"));
        assertThat(question.getId()).isEqualTo(findQuestion.getId());
    }

    @Transactional
    @DisplayName("존재하지 않는 질문 아이디로 검색시 예외 발생 테스트")
    @Test
    void exceptionWithNotExistQuestionTest() {
        //when, then
        assertThrows(IllegalArgumentException.class, () ->
                questionRepository.findById(1L).orElseThrow(IllegalArgumentException::new));
    }

    @DisplayName("질문 제목으로 검색 테스트")
    @Test
    void findBySubjectTest() {
        //given
        Question question = new Question();
        question.setSubject("test_subject");
        question.setContent("test_content");
        question.setAnswers(new ArrayList<Answer>());
        question.setCreateDate(LocalDateTime.now());

        //when
        questionRepository.save(question);

        //then
        Question findQuestion = questionRepository.findBySubject(question.getSubject());
        assertThat(question.getId()).isEqualTo(findQuestion.getId());
    }

    @DisplayName("질문 제목 및 글 내용으로 검색 테스트")
    @Test
    void findBySubjectAndContentTest() {
        //given
        Question question = new Question();
        question.setSubject("test_subject");
        question.setContent("test_content");
        question.setAnswers(new ArrayList<Answer>());
        question.setCreateDate(LocalDateTime.now());

        //when
        questionRepository.save(question);

        //then
        Question findQuestion = questionRepository.findBySubjectAndContent(question.getSubject(), question.getContent());
        assertThat(question.getId()).isEqualTo(findQuestion.getId());
    }
}
