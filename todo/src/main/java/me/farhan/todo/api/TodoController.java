package me.farhan.todo.api;

import me.farhan.todo.dto.TodoDto;
import me.farhan.todo.exceptions.RecordNotFoundException;
import me.farhan.todo.services.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    private static final Logger logger = LoggerFactory.getLogger(TodoController.class);

    private TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/new")
    public ResponseEntity<?> create(@Valid @RequestBody TodoDto todoDto) {
        logger.debug("New Todo Request " + todoDto.getName());
        return todoService.createOrUpdate(todoDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable UUID id) {
        logger.debug("Get Request " + id);
        return todoService.getOne(id);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        logger.debug("Get Request All ");
        return todoService.getAll();
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@Valid @RequestBody TodoDto todoDto) {
        logger.debug("Update Todo Request " + todoDto.getId());
        return todoService.createOrUpdate(todoDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id)
            throws RecordNotFoundException {
        logger.debug("delete Request " + id);
        return todoService.delete(id);
    }

}
