package com.rmslab.blogmania.dtos;

import com.rmslab.blogmania.entities.Category;
import com.rmslab.blogmania.entities.User;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    @NotEmpty @NotEmpty @Size(min=4, max = 20, message = "Title length should be min 4 and max 20 characters")
    private String title ;
    @NotEmpty private String content ;
    private String imageUrl ;
    private Date dateOfPost ;
    private Category category ;
    private User user ;
}
