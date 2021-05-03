package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface CategoryMapper {
    
    List<Map<String,Object>> select_Category(Long parrent_id);
    List<Map<String,Object>> select_Category2(Long parrent_id);
}
