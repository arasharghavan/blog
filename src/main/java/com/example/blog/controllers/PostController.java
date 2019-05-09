package com.example.blog.controllers;

import com.example.blog.models.EmailService;
import com.example.blog.models.Post;
import com.example.blog.models.PostImage;
import com.example.blog.repositories.ImageRepository;
import com.example.blog.repositories.PostsRepository;
import com.example.blog.models.User;
import com.example.blog.repositories.UserRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.awt.*;

@Controller
public class PostController {


    private final PostsRepository postDao;
    private final UserRepository userDao;
    private final ImageRepository imageDao;
    private EmailService emailService;

//constructor
    public PostController(PostsRepository postDao,UserRepository userDao,ImageRepository imageDao,EmailService emailService){
        this.postDao = postDao;
        this.userDao = userDao;
        this.imageDao = imageDao;
        this.emailService = emailService;
    }



//    shows all the posts in the table
    @GetMapping("/posts")
    public String index(Model vmodel){
        vmodel.addAttribute("post",postDao.findAll());
        return "posts/index";
    }


    @GetMapping("/posts/{id}")
    public String showpost(@PathVariable Long id, Model vmodel){
        Post post = postDao.findOne(id);
        vmodel.addAttribute("post",post);
        return "posts/show";
    }

//this url comes from browser then shows the create.html and from there,
//    there is a form that its method is post and action of URL:posts.
//    create so it sends the information here and saves it to the table
    @GetMapping("/posts/create")
    public String showcreateform(Model vmodel){
        vmodel.addAttribute("post",new Post());
        return "posts/create";
    }

//information comes from create.html
    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post postToDb,Model vmodel){
        User user = userDao.findOne(1L);

        postDao.save(postToDb);
        vmodel.addAttribute("postId",postToDb.getId());
        return "posts/addimages";
    }

    @GetMapping("/posts/{id}/image")
    public String image(@PathVariable Long id, Model vmodel){
//        Post postId = postDao.findOne(id);

        vmodel.addAttribute("postId",id);
        return "posts/addimages";
    }

    @PostMapping("/posts/{id}/image")
    public String addImage(@RequestParam String url, @PathVariable Long id){
//        System.out.println("hello");
//        System.out.println(url + " this is the url");
//        System.out.println(id);
        PostImage newimage = new PostImage();
        newimage.setPath(url);
        newimage.setPost(postDao.findOne(id));
        imageDao.save(newimage);
        return "redirect:/posts";
    }


    @GetMapping("/posts/{id}/edit")
    public String editform(@PathVariable Long id ,Model vmoel){
        Post post = postDao.findOne(id);
        vmoel.addAttribute("post",post);
        return "posts/edit";
    }


    @PostMapping("/posts/{id}/edit")

    public String editpost(@ModelAttribute Post posteToEdit){

        posteToEdit.setUser(userDao.findOne(1L));
        postDao.save(posteToEdit);
        return "redirect:/posts";

    }

    @GetMapping("/posts/{id}/delete")
    public String deleteform(@PathVariable Long id,Model vmodel){

        Post post = postDao.findOne(id);
        vmodel.addAttribute("post",post);
        return ("posts/delete");
    }

    @PostMapping("/posts/{id}/delete")

    public String deletePost(@PathVariable Long id){
       postDao.delete(id);

        return "redirect:/posts";
    }








}
