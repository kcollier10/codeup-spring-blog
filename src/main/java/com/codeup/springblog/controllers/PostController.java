package com.codeup.springblog.controllers;

import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    private final PostRepository postsDao;

    public PostController(PostRepository postsDao) {
        this.postsDao = postsDao;
    }

    @GetMapping("/posts/index")
    public String findAll(Model model) {
        model.addAttribute("allPosts", postsDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable long id, Model model) {
        Post post = postsDao.getOne(id);
        model.addAttribute("singlePost", post);
        return "posts/show";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
    public String createPostGET(Model model) {
        model.addAttribute("createForm", new Post());
        return "posts/create";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    public String createPostPOST(Post post) {
        postsDao.save(post);
        return "/posts/index";
    }



}
