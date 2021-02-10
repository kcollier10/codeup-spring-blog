package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String roll(Model model) {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String numberPicked(@PathVariable int n, Model model) {
        model.addAttribute("n", n);
        return "rolled-dice";
    }

}
