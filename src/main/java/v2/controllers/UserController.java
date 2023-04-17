package v2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import v2.Service.UserService;
import v2.model.request.CreateOrderRequest;
import v2.model.request.CreateUserRequest;
import v2.model.response.OrderResponse;
import v2.model.response.UserResponse;

import java.text.ParseException;
import java.time.LocalDate;

@Controller
@RequestMapping("resources/templates/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user_view/{idUser}")
    public ModelAndView openUserView(/*@RequestParam*/@PathVariable Integer idUser) {
        ModelAndView mav = new ModelAndView("user_view");
        mav.addObject("userView",userService.findById(idUser));
        return mav;
    }

    @GetMapping("/user_create")
    public ModelAndView newUser(){
        ModelAndView mav = new ModelAndView("user_create");
        CreateUserRequest cr = new CreateUserRequest();
        mav.addObject("user_create", cr);
        return mav;
    }

    @RequestMapping( value ="/new_user", method =  RequestMethod.POST/*, consumes = MediaType.ALL_VALUE*/)
    public String createUser(/*@ModelAttribute*/ CreateUserRequest request) throws ParseException {
        ModelAndView mav = new ModelAndView("user_create");
        request.setDateCreate(java.sql.Date.valueOf(LocalDate.now()));
        UserResponse userResponse =  userService.create(request);
        return "redirect:user_list";
    }

    @GetMapping("user_edit/{idUser}")
    public ModelAndView userEditWithId(/*@RequestParam*/@PathVariable Integer idUser) {
        ModelAndView mav = new ModelAndView("user_edit");
        CreateUserRequest co = new CreateUserRequest();
        mav.addObject("user_edit", userService.findById(idUser));
        return mav;
    }

    @PostMapping("/user_edit/save_user_change/{idUser}")
    public String updateUser(CreateUserRequest request, @PathVariable Integer idUser){
        ModelAndView mav = new ModelAndView("user_edit");
        System.out.println(idUser);
        UserResponse userResponse = userService.update(idUser, request);
        return "redirect:../../user_view/"+idUser;

    }
}

