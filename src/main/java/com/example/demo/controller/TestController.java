package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import com.example.demo.mapper.CategoryMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    @Autowired
    private CategoryMapper mapper;

    @GetMapping("/")
    public ModelAndView test(ModelAndView mv){
        mv.addObject("list", mapper.select_Category(1L));
        mv.setViewName("index");
        return mv;
    }
}
