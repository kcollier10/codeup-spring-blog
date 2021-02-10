package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// 1. import @Controller
@Controller
public class HelloController {

//    @GetMapping("/hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello from Spring!";
//    }

//    @GetMapping("/hello/{name}")
//    @ResponseBody
//    public String hello(@PathVariable String name) {
//        return "Hello, " + name + "!";
//    }

    // RequestingMapping can be a GET or a POST
    // Similar to CounterServlet from adlister repo
//    @RequestMapping(path ="/increment/{number}", method = RequestMethod.GET)
//    @ResponseBody
//    public String addOne(@PathVariable int number){
//        return number + " plus one is " + (number + 1) + "!";
//    }

    // {name} is our dynamic portion
    @GetMapping("/hello/{name}")
    // Model class is part of Spring, not representing a model of our database!
    public String sayHello(@PathVariable String name, Model model) {
        // "name" is our key to access info from front-end dynamically and name is our value/variable
        model.addAttribute("name", name);
        // returning our hello.html
        return "hello";
    }

    @GetMapping("/join")
    public String showJoinForm() {
        return "join";
    }

    @PostMapping("/join")
    // allowing us to capture something from the POST request (aka from our form)
    // @RequestParam links to the item with form field 'cohort' in html
    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
        model.addAttribute("cohort", "Welcome to " + cohort + "!");
        return "join";
    }
}
