package me.farhan.todo.dto;

import lombok.Getter;
import lombok.Setter;
import me.farhan.todo.model.Todo;

@Getter
@Setter
public class TodoDto extends AbstractDto {

    private String name;
    private boolean done;

    public Todo convertAsTodo() {
        Todo todo = new Todo();
        todo.setName(this.name);
        todo.setDone(this.done);

        return todo;
    }
}
