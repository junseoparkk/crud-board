package toy.crudboard.question.controller;

import groovy.util.logging.Slf4j;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import toy.crudboard.question.entity.Question;
import toy.crudboard.question.entity.QuestionForm;
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
    public String createQuestion(QuestionForm questionForm) {
        return "question_form";
    }

    @PostMapping("/create")
    public String createQuestion(
            @Valid QuestionForm questionForm,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "question_form";
        }
        questionService.create(questionForm.getSubject(), questionForm.getContent());
        return "redirect:/question/list";
    }
}
