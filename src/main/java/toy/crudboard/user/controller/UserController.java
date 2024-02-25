package toy.crudboard.user.controller;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import toy.crudboard.user.entity.UserSignupForm;
import toy.crudboard.user.service.UserService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/signup")
    public String signup(UserSignupForm userSignupForm) {
        return "signup_form";
    }

    @PostMapping("/signup")
    public String signup(@Valid UserSignupForm userSignupForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup_form";
        }

        if (!userSignupForm.getPassword().equals(userSignupForm.getCheckPassword())) {
            bindingResult.rejectValue(
                    "checkPassword",
                    "passwordInCorrect",
                    "비밀번호가 일치하지 않습니다."
            );
        }

        userService.signup(userSignupForm.getName(), userSignupForm.getEmail(), userSignupForm.getPassword());
        return "redirect:/";
    }
}
