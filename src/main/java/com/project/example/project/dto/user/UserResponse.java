package com.project.example.project.dto.user;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.example.project.dto.city.CityResponse;
import com.project.example.project.dto.role.RoleResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class UserResponse {

    private Long id;
    private String username;

    @JsonProperty(value = "role")
    private RoleResponse roleResponse;

    @JsonProperty(value = "city")
    private CityResponse cityResponse;
}
