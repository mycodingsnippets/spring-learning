package com.thenerdyaditya.testing.Controllers;

import com.thenerdyaditya.testing.Models.Number;
import com.thenerdyaditya.testing.javaconcepts.RefVsValue;
import com.thenerdyaditya.testing.strings.StringFormatting;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestingController {

    @RequestMapping("/test1")
    public void one(){

//        return StringFormatting.formatSpecifiers();

//        Number x = new Number(0);
//        RefVsValue.incrementNumber(x);
//        System.out.println(x.value);

        int x = 0;
        RefVsValue.incrementInt(x);
        System.out.println(x);
    }

    @RequestMapping("/test2/{id}")
    public String two(@PathVariable("id") String id){
        return id;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/test3")
    public String three(@RequestBody String name){
        return name;
    }

}
