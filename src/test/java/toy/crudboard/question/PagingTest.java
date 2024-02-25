package toy.crudboard.question;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import toy.crudboard.question.service.QuestionService;

@SpringBootTest
public class PagingTest {
    @Autowired
    private QuestionService questionService;

    @Test
    void createTestData() {
        for (int i = 1; i <= 300; i++) {
            String subject = String.format("Test Data : [%03d]", i);
            String content = "내용 없음";
            questionService.create(subject, content);
        }
    }
}
