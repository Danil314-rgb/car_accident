package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.accident.model.User;
import ru.job4j.accident.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/loginPage")
    public String loginPage(Model model, @RequestParam(name = "fail", required = false) Boolean fail) {
        model.addAttribute("fail", fail != null);
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, HttpServletRequest req) {
        User userDb = userService.findByEmailAndPsw(
                user.getEmail(), user.getPassword()
        );
        if (userDb == null) {
            return "redirect:/loginPage?fail=true";
        }
        HttpSession session = req.getSession();
        session.setAttribute("user", userDb);
        return "redirect:/accident";
    }

    @GetMapping("/registerPage")
    public String registerPage(Model model, HttpSession session, @RequestParam(name = "fail", required = false) Boolean fail) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            user = new User();
            user.setName("Гость");
        }
        model.addAttribute("user", user);
        model.addAttribute("fail", fail != null);
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        User userDb = userService.findByEmail(user.getEmail());
        if (userDb != null) {
            return "redirect:/registerPage?fail=true";
        }
        userService.create(user);
        return "redirect:/accident";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/startPage";
    }
}
