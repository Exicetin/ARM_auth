package v2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import v2.Service.SystemService;
import v2.Service.UserService;
import v2.model.request.CreateSystemRequest;
import v2.model.response.OrderResponse;
import v2.model.response.SystemResponse;

@Controller
@RequestMapping("resources/templates")
@RequiredArgsConstructor
public class SystemController {

    private SystemService systemService;

}
