package com.example.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class RollDiceController {


    @GetMapping("/roll")
    public String viewpage(){
        return "dice";
    }

    @GetMapping("/roll/{num}")
    public String checknumber(@PathVariable Integer num, Model vmodel){

        int random = (int)(Math.random()*6+1);
        String result;

       if (random == num){
          result = "win";
       }else {
           result = "lost";
       }
       vmodel.addAttribute("random",random);
       vmodel.addAttribute("passingresult",result);
       return "dice";
    }

}
