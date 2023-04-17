package v2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import v2.Service.SystemService;
import v2.Service.UserService;
import v2.model.request.CreateOrderRequest;
import v2.model.request.CreateSystemRequest;
import v2.model.request.CreateUserRequest;
import v2.model.response.OrderResponse;
import v2.model.response.SystemResponse;

import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("resources/templates")
@RequiredArgsConstructor
public class SettingsController {

    private SystemService systemService;
    private UserService userService;

//    @GetMapping("/user_set")
//    public ModelAndView viewUsers(){
//        ModelAndView mav = new ModelAndView("user_set");
//        CreateUserRequest cr = new CreateUserRequest();
//        mav.addObject("users", cr);
//        System.out.println("user controller");
//        return mav;
//    }

    @GetMapping("/system_set")
    public ModelAndView viewSystem(){
        ModelAndView mav = new ModelAndView("settings");
        CreateSystemRequest cr = new CreateSystemRequest();
        mav.addObject("systems", cr);
        System.out.println(cr);
        System.out.println("jgvkugb");
        mav.addObject("listSystem", systemService.findAll());
        return mav;
    }

    @RequestMapping(value = "/add_system", method = RequestMethod.POST)
    public String addSystem(CreateSystemRequest request){
        System.out.println(request);
        SystemResponse systemResponse =  systemService.create(request);
        return null;
    }
}
