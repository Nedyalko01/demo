package com.project.example.project.service;

import com.project.example.project.entity.Role;
import com.project.example.project.exception.DuplicateRecordException;
import com.project.example.project.exception.RecordNotFoundException;
import com.project.example.project.repository.RoleRepository;
import com.project.example.project.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Set<Role> findAll() {
        return new HashSet<>(roleRepository.findAll());

    }

    public Role findByName(String name) {
        return roleRepository.findByName(name)
                .orElseThrow(() -> new RecordNotFoundException(
                        String.format("Role %s not found", name)));
    }

    public Role findById(@NonNull Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(
                        String.format("Role with Id: %s is not found!", id)));

    }

    public Role update(@NonNull Role updatedRole, @NonNull Long id) {
        Role dbRole = findById(id);
        dbRole.setName(updatedRole.getName());
        return save(dbRole);

    }

    public Role save(Role role) {
        try {
            return roleRepository.save(role);
        } catch (DataIntegrityViolationException ex) {
            throw new DuplicateRecordException(
                    String.format("Role %s already exists!", role.getName()));


        }
    }

    public void delete(Long id) {
        roleRepository.deleteById(id);

    }

    public void delete(String name) {
        roleRepository.deleteByName(name);
    }
}
