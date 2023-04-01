package com.rmslab.blogmania.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiResponseDto {
    private String message ;
    private boolean isSuccess ;
}
