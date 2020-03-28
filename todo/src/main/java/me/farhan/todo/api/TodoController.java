package me.farhan.todo.api;

import me.farhan.todo.dto.TodoDto;
import me.farhan.todo.services.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/todos/")
public class TodoController {
    private static final Logger logger = LoggerFactory.getLogger(TodoController.class);

    private TodoService todoService;

    @Autowired
    public  TodoController(TodoService todoService){
        this.todoService = todoService;
    }
    @PostMapping("new")
    public ResponseEntity<?> create(@Valid @RequestBody TodoDto todoDto) {
        logger.debug("New Todo Request "+todoDto.getName());
        return todoService.save(todoDto);
    }
}
