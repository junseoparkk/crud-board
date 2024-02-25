package toy.crudboard.question.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import toy.crudboard.question.entity.Question;
import toy.crudboard.question.service.QuestionService;

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Question> questions = questionService.findAll();
        model.addAttribute("questions", questions);
        return "question_list";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable(name = "id") Long id) {
        Question question = questionService.findById(id);
        model.addAttribute(question);
        return "question_detail";
    }

    @GetMapping("/create")
    public String createQuestion() {
        return "question_form";
    }

    @PostMapping("/create")
    public String createQuestion(
            @RequestParam(value = "subject") String subject,
            @RequestParam(value = "content") String content
    ) {
        questionService.create(subject, content);
        return "redirect:/question/list";
    }
}
