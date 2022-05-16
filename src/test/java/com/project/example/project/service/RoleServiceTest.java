package com.project.example.project.service;


import com.project.example.project.entity.Role;
import com.project.example.project.exception.RecordNotFoundException;
import com.project.example.project.repository.RoleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RoleServiceTest {

    @Mock
    private RoleRepository roleRepository;


    private RoleService roleService;

    @BeforeEach
    public void setUp() {
        roleService = new RoleService(roleRepository);
    }

    @Test
    public void verifyFindAll() {
        roleService.findAll();
        verify(roleRepository, times(1)).findAll();

    }

    @Test
    public void verifyFindByName() {
        String name = "Ivan";
        when(roleRepository.findByName(name))
                .thenReturn(Optional.of(Role.builder().build()));
        roleService.findByName(name);
        verify(roleRepository, times(1)).findByName(name);
    }

    @Test
    public void verifyFindByNameRecordNotFoundException() {
        String expectedMessage = "Role Ivan not found";
        Throwable ex = assertThrows(RecordNotFoundException.class, () ->
                roleService.findByName("Ivan"));

        assertEquals(expectedMessage, ex.getMessage());

    }

    @Test
    public void verifyFindById() {
        Long id = 5L;
        when(roleRepository.findById(id))
                .thenReturn(Optional.of(Role.builder().build()));
        roleService.findById(id);
        verify(roleRepository, times(1)).findById(id);
    }

    @Test
    public void verifyFindByIdException() {
        String expectedMessage = "Role with Id: 5 is not found!";
        RecordNotFoundException ex = assertThrows(RecordNotFoundException.class, () ->
                roleService.findById(5L));

        assertEquals(expectedMessage, ex.getMessage());

    }

    @Test
    public void verifyUpdateThrowsExceptionWhenIdIsNull() {
        assertThrows(NullPointerException.class,
                () -> roleService.update(Role.builder().build(), null));
    }

    @Test
    public void verifyUpdateThrowsExceptionWhenRoleIsNull() {
        assertThrows(NullPointerException.class,
                () -> roleService.update(null, 5L));

    }

}
