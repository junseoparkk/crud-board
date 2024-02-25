package toy.crudboard.answer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import toy.crudboard.question.entity.Question;
import toy.crudboard.question.service.QuestionService;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {
    private final QuestionService questionService;

    @PostMapping("/create/{id}")
    public String createAnswer(
            Model model,
            @PathVariable(name = "id") Long id,
            @RequestParam(value = "content") String content
    ) {
        Question question = questionService.findById(id);

        // TODO: 답변 저장 로직

        return String.format("redirect:/question/detail/%s", id);
    }
}
