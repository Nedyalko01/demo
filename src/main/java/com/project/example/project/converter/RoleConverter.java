package com.project.example.project.converter;

import com.project.example.project.dto.role.RoleResponse;
import com.project.example.project.dto.role.RoleSaveRequest;
import com.project.example.project.dto.role.RoleUpdateRequest;
import com.project.example.project.entity.Role;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Builder
@Component
public class RoleConverter {

    public Role convert(RoleSaveRequest roleSaveRequest) {
        Role role = new Role();
        role.setName(roleSaveRequest.getName());
        return role;


    }

    public RoleResponse convert(Role role) {
        return RoleResponse.builder()
                .id(role.getId())
                .name(role.getName())
                .build();
    }


    public Role convert(RoleUpdateRequest roleUpdateRequest) {
        Role updateRole = new Role();
        updateRole.setName(roleUpdateRequest.getName());
        updateRole.setId(roleUpdateRequest.getId());
        return updateRole;
    }

}
