package v2.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import v2.domain.Auth;
import v2.model.request.CreateCardRequest;
import v2.model.request.CreateOrderRequest;
import v2.repository.AuthRepository;

@Controller
public class LoginController {

    @Autowired
    private AuthRepository authRepository;



    @GetMapping("dashboard")
    public ModelAndView openDashboard() {
        ModelAndView dash = new ModelAndView("dashboard");
        return dash;
    }

    @GetMapping("/auth")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login",  method =  RequestMethod.POST)
    public String login(@RequestParam String login, @RequestParam String password,
                        HttpSession session, ModelAndView model) {
        Auth user = authRepository.findBylogin(login);
        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("user", user);
            return "redirect:/order_list";
        } else {
            model.addObject("error", "Invalid login or password!");
            return "login";
        }
    }
}