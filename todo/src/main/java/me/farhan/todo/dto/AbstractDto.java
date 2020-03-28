package me.farhan.todo.dto;

import lombok.Getter;

import java.sql.Date;

@Getter
abstract  class AbstractDto {

    private String id;
    private Date createdAt;
    private Date updatedAt;
}
