package me.farhan.todo.services;

import me.farhan.todo.dto.TodoDto;
import me.farhan.todo.model.Todo;
import me.farhan.todo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public ResponseEntity<?> save(TodoDto dto) {
        Todo todo = dto.convertAsTodo();
        Todo savedTodo = todoRepository.save(todo);
        return ResponseEntity.ok(savedTodo);
    }

}
