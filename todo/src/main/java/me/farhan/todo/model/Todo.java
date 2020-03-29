package me.farhan.todo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "todos")
public class Todo extends AbstractEntity {

    private String name;
    private boolean done;

}
