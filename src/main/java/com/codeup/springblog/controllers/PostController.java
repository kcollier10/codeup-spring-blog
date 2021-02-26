package com.codeup.springblog.controllers;

import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.services.EmailService;
import com.codeup.springblog.services.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    private final PostRepository postsDao;
    private final UserRepository usersDao;
    private final EmailService emailService;


    public PostController(PostRepository postsDao, UserRepository usersDao, EmailService emailService) {
        this.postsDao = postsDao;
        this.usersDao = usersDao;
        this.emailService = emailService;
    }

    @GetMapping("/posts")
    public String postsIndex(Model model) {
        List<Post> posts = postsDao.findAll();
        model.addAttribute("posts", posts);

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewPost(Model model, @PathVariable long id) {
        Post post = postsDao.getOne(id);
        model.addAttribute("singlePost", post);
        return "posts/show";
    }

    @GetMapping(path = "/posts/create")
    public String createPostGET(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping(path = "/posts/create")
    public String createPostPOST(@ModelAttribute Post post) {
//        User user = usersDao.findAll().get(0);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
        Post savedPost = postsDao.save(post);

        String subject = "New Ad Created!";
        String body = "Dear " + savedPost.getUser().getUsername()
                + ",\nThank you for creating an ad on our site.\n"
                + "Your ad's id is " + savedPost.getId()
                + ".\nHave a great day!";

        emailService.prepareAndSend(savedPost, subject, body);
        return "redirect:/posts";
    }

    @PostMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable long id) {
        postsDao.deleteById(id);
        return "redirect:/posts";
    }

    @GetMapping("/posts/search")
    @ResponseBody
    public Post returnPostByTitle(String title) {
        return postsDao.findByTitle(title);
    }


    @GetMapping("/posts/edit/{id}")
    public String editGET(@PathVariable long id, Model model) {
        Post post = postsDao.getOne(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("/posts/edit/{id}")
    public String editPOST(@PathVariable long id, @ModelAttribute Post edit) {
        edit.setUser(postsDao.getOne(id).getUser());
        postsDao.save(edit);
        return "redirect:/posts";
    }

}
