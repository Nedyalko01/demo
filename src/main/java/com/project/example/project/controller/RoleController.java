package com.project.example.project.controller;


import com.project.example.project.converter.RoleConverter;
import com.project.example.project.dto.role.RoleResponse;
import com.project.example.project.dto.role.RoleSaveRequest;
import com.project.example.project.dto.role.RoleUpdateRequest;
import com.project.example.project.entity.Role;
import com.project.example.project.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/roles")
@Transactional
public class RoleController {

    private final RoleService roleService;
    private final RoleConverter roleConverter;

    @GetMapping
    public ResponseEntity<Set<RoleResponse>> findAll() {
        return ResponseEntity.ok(roleService.findAll()
                .stream()
                        .map(role -> roleConverter.convert(role))
                .collect(Collectors.toSet()));

    }


    @PostMapping
    public ResponseEntity<RoleResponse> save (@RequestBody @Valid RoleSaveRequest roleSaveRequest) {
        Role role = roleConverter.convert(roleSaveRequest);
        Role savedRole = roleService.save(role);
        RoleResponse response = roleConverter.convert(savedRole);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @PutMapping
    public ResponseEntity<RoleResponse> update (@RequestBody @Valid RoleUpdateRequest roleUpdateRequest) {
           Role newRole = roleConverter.convert(roleUpdateRequest);
           Role updatedRole = roleService.update(newRole, newRole.getId());
           return ResponseEntity.ok(roleConverter.convert(updatedRole));

    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id) {
        roleService.delete(id);
        return ResponseEntity.ok().build();
    }



    @DeleteMapping(value = "/name/{name}")
    public ResponseEntity<HttpStatus> deleteByName(@PathVariable String name) {
        roleService.delete(name);
        return ResponseEntity.ok().build();
    }
}
