package com.rmslab.blogmania.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;
    @NotEmpty @Size(min=4, max = 20, message = "Title length should be min 4 and max 20 characters")
    private String title ;

    @NotEmpty
    private String content ;

    private String imageUrl ;

    private Date dateOfPost ;

    @ManyToOne
    private Category category ;

    @ManyToOne
    private User user ;
}
