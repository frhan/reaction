package me.farhan.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@AllArgsConstructor
@Data
public class ApiResponse {

    @NonNull
    private String message;
    private boolean success;
}
