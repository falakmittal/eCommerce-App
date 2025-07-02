package com.example.project.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Category {
    private Long CategoryId;
    private String categoryName;
}
