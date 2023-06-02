package v2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import v2.Service.DefOrderService;
import v2.model.response.OrderResponse;

import java.util.List;

@Controller
@RequestMapping("resources/templates/")
@RequiredArgsConstructor
public class TemplatesController {
    DefOrderService templatesService;
    @GetMapping("/templates_list")
    public ModelAndView openList() {
        ModelAndView mav = new ModelAndView("templates_list");
        mav.addObject("listOrders", findAll());
        return mav;
    }

    public List<OrderResponse> findAll() {
        return templatesService.findAll();
    }
    @GetMapping("/templates_view/{idTemplate}")
    public ModelAndView openOrderView(@PathVariable Integer idOrders) {
        ModelAndView mav = new ModelAndView("templates_view");
        mav.addObject("orderView", templatesService.findById(idOrders));
        return mav;
    }

    @RequestMapping( value ="templates_view", method = {RequestMethod.GET, RequestMethod.PUT}, consumes = MediaType.ALL_VALUE)
    public ModelAndView findById(@RequestParam Integer idOrder){
        ModelAndView mav = new ModelAndView("templates_view");
        OrderResponse orderResponse = templatesService.findById(idOrder);
        mav.addObject("orders",orderResponse);
        return mav;
    }
//    @RequestMapping( value ="/def_new_order", method =  RequestMethod.POST/*, consumes = MediaType.ALL_VALUE*/)
//    public String createOrder(/*@ModelAttribute*/ CreateOrderRequest request){
//        ModelAndView mav = new ModelAndView("def_order_create");
//        request.setNumber(nextOrderNumber(request.getSystems()));
//        OrderResponse orderResponse =  templatesService.create(request);
//        return "redirect:../def_order_list";
//    }
//    public String nextOrderNumber(String sys) {
//        NextOrderNumber nextOrderNumber = new NextOrderNumber();
//        return nextOrderNumber.nextOrderNumber(sys);
//    }

}
