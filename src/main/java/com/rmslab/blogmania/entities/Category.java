package com.rmslab.blogmania.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;

    @NotEmpty @Size(min=4, max = 20, message = "Title length should be min 4 and max 20 characters")
    private String title ;

    @NotEmpty private String description ;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Post> posts ;

}
