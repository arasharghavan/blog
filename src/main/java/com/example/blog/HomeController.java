package com.example.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/{name}")
    public String welcome(@PathVariable String name, Model vmodel){
        vmodel.addAttribute("passingname",name);
        return "home";
    }

    @GetMapping("/")
    public String blank(){
        return "home";
    }

}
