package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CategoryMapperTest {
    
    @Autowired
    private CategoryMapper mapper;

    @Test
    void selectTest(){

        List<Map<String,Object>> list = mapper.select_Category(1L);
        System.out.println(list);
    }
}
