package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {


    @RequestMapping(path = "/add/{x}/and/{y}", method = RequestMethod.GET)
    @ResponseBody
    public Integer add(@PathVariable int x, @PathVariable int y) {
        return x + y;
    }

    @RequestMapping(path = "/subtract/{x}/from/{y}", method = RequestMethod.GET)
    @ResponseBody
    public Integer subtract(@PathVariable int x, @PathVariable int y) {
        return y - x;
    }

    @RequestMapping(path = "/multiply/{x}/and/{y}", method = RequestMethod.GET)
    @ResponseBody
    public Long multiply(@PathVariable long x, @PathVariable long y) {
        return x * y;
    }

    @RequestMapping(path = "/divide/{x}/by/{y}", method = RequestMethod.GET)
    @ResponseBody
    public Long divide(@PathVariable long x, @PathVariable long y) {
        return y / x;
    }


}
