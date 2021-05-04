package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long parrentId;
    private String categoryName;

    public Category(){
    }
    
    @Builder
    public Category(Long id, Long parrentId, String categoryName){
        this.id = id;
        this.parrentId = parrentId;
        this.categoryName = categoryName;
    }
}
