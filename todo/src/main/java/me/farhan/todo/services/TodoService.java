package me.farhan.todo.services;

import me.farhan.todo.dto.ApiResponse;
import me.farhan.todo.dto.TodoDto;
import me.farhan.todo.exceptions.RecordNotFoundException;
import me.farhan.todo.model.Todo;
import me.farhan.todo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public ResponseEntity<?> createOrUpdate(TodoDto dto) {
        Optional<Todo> todoOp = null;

        if (dto.getId() != null)
            todoOp = todoRepository.findById(dto.getId());

        if (todoOp != null && todoOp.isPresent()) {
            Todo todo = todoOp.get();
            todo.setName(dto.getName());
            todo.setDone(dto.isDone());

            todo = todoRepository.save(todo);
            return ResponseEntity.ok(todo);
        }

        Todo todo = dto.convertAsTodo();
        Todo savedTodo = todoRepository.save(todo);
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/todos/{id}")
                .buildAndExpand(savedTodo.getId()).toUri();

        return ResponseEntity.created(location).body(savedTodo);
    }

    public ResponseEntity<?> getOne(final UUID id) {
        Todo todo = todoRepository.getOne(id);
        if (todo == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(todo);
    }

    public ResponseEntity<?> getAll() {
        List<Todo> todos = todoRepository.findAll();
        return ResponseEntity.ok(todos);
    }

    public ResponseEntity<?> delete(final UUID id)
            throws RecordNotFoundException {
        Optional<Todo> todoOp = todoRepository.findById(id);
        if (todoOp.isPresent()) {
            Todo todo = todoOp.get();
            todoRepository.delete(todo);
            return ResponseEntity.ok(new ApiResponse(String.format("Todo with id %s deleted successfully", id), false));
        }

        throw new RecordNotFoundException("Record not found for " + id);
    }

}
