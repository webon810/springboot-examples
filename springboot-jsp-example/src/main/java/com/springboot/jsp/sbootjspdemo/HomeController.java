package com.springboot.jsp.sbootjspdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping({"/","/homeIndex","/helloWorld"})
    public String Home(Model model, @RequestParam(value="name",required = false, defaultValue = " , and this is the hello World") String name) {
        model.addAttribute("name", name);
        return "helloHome";

    }


}
