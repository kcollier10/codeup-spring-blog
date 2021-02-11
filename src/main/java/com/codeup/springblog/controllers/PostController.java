package com.codeup.springblog.controllers;

import com.codeup.springblog.dao.PostRepository;
import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepository postsDao;

    public PostController(PostRepository postsDao) {
        this.postsDao = postsDao;
    }

    @GetMapping("/posts")
    public String allPosts(Model model) {
        model.addAttribute("allPosts", postsDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String singlePost(@PathVariable long id, Model model) {
        model.addAttribute("singlePost", postsDao.findById(id));
        return "posts/show";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
    @ResponseBody
    public String createGET() {
        return "This is the create post GET method!";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String createPOST() {
        return "This is the create post POST method!";
    }



}
