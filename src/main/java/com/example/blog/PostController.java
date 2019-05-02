package com.example.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String showposts(Model vmodel) {
       // Post comes from Post.java
        List<Post> post = new ArrayList<>();

        post.add(new Post("a","b"));
        post.add(new Post("c","d"));

        vmodel.addAttribute("post",post);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")

    public String showpost(@PathVariable int id , Model vmodel) {

        Post post = new Post("d","g");
        vmodel.addAttribute("post",post);
        return "posts/show";
    }

    @GetMapping("/create/create")
    @ResponseBody
    public String showcreate(@PathVariable String create) {
        return "Hello from Spring! ";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String hellopost() {
        return "POST from Spring! ";
    }






}
