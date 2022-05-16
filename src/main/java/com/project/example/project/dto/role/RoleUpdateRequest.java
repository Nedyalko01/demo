package com.project.example.project.dto.role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@Builder
public class RoleUpdateRequest {

    @NotNull(message = "id should not be null")
    private Long id;

    @NotNull(message = "Name should not be null")
    private String name;
}
