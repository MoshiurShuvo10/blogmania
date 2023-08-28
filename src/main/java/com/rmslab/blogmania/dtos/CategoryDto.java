package com.rmslab.blogmania.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class CategoryDto {
    private int id ;
    private String title ;
    private String description ;
}
