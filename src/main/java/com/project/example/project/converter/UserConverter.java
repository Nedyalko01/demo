package com.project.example.project.converter;

import com.project.example.project.dto.role.RoleResponse;
import com.project.example.project.dto.user.UserResponse;
import com.project.example.project.dto.user.UserSaveRequest;
import com.project.example.project.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserConverter {

    private final RoleConverter roleConverter;
    private final CityConverter cityConverter;

    public User convert(UserSaveRequest userSaveRequest) {
        User user = new User();
        user.setUsername(userSaveRequest.getUsername());
        user.setPassword(userSaveRequest.getPassword());
        return user;
    }

    public UserResponse convert(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .cityResponse(cityConverter.converted(user.getCity()))
                .roleResponse(roleConverter.convert(user.getRole()))
                .build();
    }
}