package com.rmslab.blogmania.entities;

import jakarta.persistence.*;
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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;
    @Column(name="user_name", nullable = false, length = 100)
    private String name ;
    private String email ;
    private String password ;
    private String about ;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts ;
}
