package ir.asran.loginpage.controller;

import ir.asran.loginpage.entity.User;
import ir.asran.loginpage.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(){
        return "redirect:/dashboard";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    // handler method to handle user registration request
    @GetMapping("register")
    public String showRegistrationForm(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    // handler method to handle register user form submit request
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") User user,
                               BindingResult result,
                               Model model){
        User existing = userService.findByUsername(user.getUsername());
        if (existing != null) {
            result.rejectValue("username", null, "نام کاربری استفاده شده است!");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/register?success";
    }

    @GetMapping("/dashboard")
    public String listRegisteredUsers(Model model){
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "dashboard";
    }
}