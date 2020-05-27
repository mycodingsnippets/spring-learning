package com.thenerdyaditya.testing.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UIController {

    @RequestMapping("/adityatesting")
//    @ResponseBody => Sends Data in Response Body
    public String home(){
        return "Aditya";
    }

}
