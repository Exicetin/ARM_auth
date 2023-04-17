package v2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import v2.Service.CardService;
import v2.Service.OrderService;
import v2.Service.SystemService;
import v2.Service.UserService;
import v2.model.request.CreateUserRequest;

@Controller
@RequestMapping("resources/templates")
@RequiredArgsConstructor
public class MenuController {
    private final SystemService systemService;
    private final OrderService orderService;
    private final CardService cardService;
    private final UserService userService;

    @GetMapping("/settings")
    public ModelAndView openSettings() {
        ModelAndView mav = new ModelAndView("settings");
        mav.addObject("listSystem", systemService.findAll());
        System.out.println("yfjguoh");
        return mav;
    }

    @GetMapping("/card_list")
    public ModelAndView openCardList() {
        ModelAndView mav = new ModelAndView("cards_list");
        mav.addObject("listCards", cardService.findAll());
        return mav;
    }

    @GetMapping("/order_list")
    public ModelAndView openOrderList() {
        ModelAndView mav = new ModelAndView("orders_list");
        mav.addObject("listOrders", orderService.findAll());
        return mav;
    }

    @GetMapping("/user_list")
    public ModelAndView openUserList(){
        ModelAndView mav = new ModelAndView("user_list");
        mav.addObject("users", userService.findAll());
        System.out.println("user list");
        return mav;
    }

}
