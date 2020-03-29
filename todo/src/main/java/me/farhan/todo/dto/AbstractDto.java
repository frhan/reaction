package me.farhan.todo.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.UUID;

@Getter
abstract class AbstractDto {

    @Setter
    private UUID id;

    private Date createdAt;
    private Date updatedAt;
}
