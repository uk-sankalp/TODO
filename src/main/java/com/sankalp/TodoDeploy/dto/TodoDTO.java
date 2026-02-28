package com.sankalp.TodoDeploy.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Setter
@Getter
public class TodoDTO {
    private String title;
    private Boolean completed;
}