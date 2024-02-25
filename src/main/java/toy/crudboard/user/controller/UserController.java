package toy.crudboard.user.controller;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import toy.crudboard.user.entity.UserSignupForm;
import toy.crudboard.user.service.UserService;

@Slf4j
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
            return "signup_form";
        }

        try {
            userService.signup(userSignupForm.getName(), userSignupForm.getEmail(), userSignupForm.getPassword());
        } catch (DataIntegrityViolationException e) {
            log.info(e.getMessage());
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
            return "signup_form";
        } catch (Exception e) {
            log.info(e.getMessage());
            bindingResult.reject("signupFailed", e.getMessage());
            return "signup_form";
        }

        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "login_form";
    }
}
