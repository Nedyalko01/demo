package com.project.example.project.service;


import com.project.example.project.entity.City;
import com.project.example.project.entity.Role;
import com.project.example.project.entity.User;
import com.project.example.project.exception.DuplicateRecordException;
import com.project.example.project.repository.CityRepository;
import com.project.example.project.repository.RoleRepository;
import com.project.example.project.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserService {


    private final UserRepository userRepository;
    private final RoleService roleService;
    private final CityService cityService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Set<User> findAll() {
        return new HashSet<>(userRepository.findAll());
    }


    public User save(User user) {
        try {
            Role defaultRole = roleService.findByName("Admin");
            user.setRole(defaultRole);
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            City defaultCity = cityService.findByName("Plovdiv");
            user.setCity(defaultCity);
            return userRepository.save(user);

        } catch (DataIntegrityViolationException ex) {
            throw new DuplicateRecordException(
                    String.format("Username %s already exists!", user.getUsername()));
        }

    }

}
