package toy.crudboard.question.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import toy.crudboard.question.entity.Question;
import toy.crudboard.question.service.QuestionService;

@RequiredArgsConstructor
@Controller
public class QuestionController {
    private final QuestionService questionService;
    @GetMapping("/question/list")
    public String list(Model model) {
        List<Question> questions = questionService.findAll();
        model.addAttribute("questions", questions);
        return "question_list";
    }
}
