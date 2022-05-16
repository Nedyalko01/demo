package com.project.example.project;

import com.project.example.project.entity.City;
import com.project.example.project.entity.Role;
import com.project.example.project.entity.User;
import com.project.example.project.repository.CityRepository;
import com.project.example.project.service.CityService;
import com.project.example.project.service.RoleService;
import com.project.example.project.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AppProjectStarter implements CommandLineRunner {

    private final RoleService roleService;
    private final CityService cityService;
    private final UserService userService;


    @Override
    public void run(String... args) throws Exception {

//        Role firstRole = new Role();
//        firstRole.setName("Admin");
//        roleService.save(firstRole);
//
//        Role secondRole = new Role();
//        secondRole.setName("Customer");
//        roleService.save(secondRole);
//
//        Role updatedRole = new Role();
//        updatedRole.setName("UPDATED_ROLE");
//        roleService.update(updatedRole, secondRole.getId());
//
//        Role thirdRole = new Role();
//        thirdRole.setName("Customer");
//        roleService.save(thirdRole);
//
//        City city = new City();
//        city.setName("Plovdiv");
//        cityService.save(city);
//
//        User user = new User();
//        user.setUsername("Ivan");
//        user.setPassword("62b3DD");
//        userService.save(user);
//

    }
}