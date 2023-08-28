package com.rmslab.blogmania.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@Getter
@ToString
public class UserDto {
    private int id ;
    @NotEmpty @Size(min=4, message = "Username must be minimum 4 characters")
    private String name ;

    @Email(message = "Invalid email address")
    private String email ;

    @NotEmpty @Size(min = 4, max = 10, message = "Password length must be minimum 4 and max 10")
    private String password ;

    @NotEmpty private String about ;
}
