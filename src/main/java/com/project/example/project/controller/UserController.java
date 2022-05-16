package com.project.example.project.controller;

import com.project.example.project.converter.UserConverter;
import com.project.example.project.dto.user.UserResponse;
import com.project.example.project.dto.user.UserSaveRequest;
import com.project.example.project.entity.User;
import com.project.example.project.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/users")
@Builder
public class UserController {

    private final UserService userService;
    private final UserConverter userConverter;

    @GetMapping
    public ResponseEntity<Set<UserResponse>> findAll() {
        return ResponseEntity.ok(userService.findAll()
                .stream()
                .map(user -> userConverter.convert(user))
                .collect(Collectors.toSet()));

    }


    @PostMapping
    public ResponseEntity<UserResponse> save(@RequestBody @Valid UserSaveRequest userSaveRequest) {
        User user = userConverter.convert(userSaveRequest);//2
        User savedUser = userService.save(user);
        UserResponse userResponse = userConverter.convert(savedUser);
        return ResponseEntity.status(HttpStatus.CREATED).body((userResponse));
    }

}
