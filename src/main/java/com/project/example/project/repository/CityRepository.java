package com.project.example.project.repository;

import com.project.example.project.entity.City;
import com.project.example.project.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public interface CityRepository extends JpaRepository <City, Long>{

   Optional<City> findByName(String name);

}
