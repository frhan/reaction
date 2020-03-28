package me.farhan.todo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoDto extends AbstractDto {

    private String name;
    private boolean done;
}
