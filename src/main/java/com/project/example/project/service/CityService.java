package com.project.example.project.service;

import com.project.example.project.entity.City;
import com.project.example.project.entity.Role;
import com.project.example.project.exception.DuplicateRecordException;
import com.project.example.project.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public Set<City> findAll() {
        return new HashSet<>(cityRepository.findAll());
    }

    public City findByName(String cityName) {
        return cityRepository.findByName(cityName)
                .orElseThrow(IllegalArgumentException::new);
    }


    public City save(City city) {
        try {
            return cityRepository.save(city);
        } catch (DataIntegrityViolationException ex) {
            throw new DuplicateRecordException(
                    String.format("City %s already exists!", city.getName()));
        }

    }


}

