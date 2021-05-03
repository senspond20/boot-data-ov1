package com.example.demo.api;

import java.util.List;
import java.util.Map;

import com.example.demo.mapper.CategoryMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryApi {
    
    @Autowired
    private CategoryMapper mapper;

    @GetMapping("/category")
    public List<Map<String,Object>> test(){
        return mapper.select_Category(1L);
    }
    @GetMapping("/category2")
    public List<Map<String,Object>> test2(){
        return mapper.select_Category2(1L);
    }

}
