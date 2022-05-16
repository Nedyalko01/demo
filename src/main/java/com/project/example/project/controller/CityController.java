package com.project.example.project.controller;

import com.project.example.project.converter.CityConverter;
import com.project.example.project.dto.city.CityResponse;
import com.project.example.project.dto.city.CitySaveRequest;
import com.project.example.project.entity.City;
import com.project.example.project.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/cities")
public class CityController {

    private final CityService cityService;
    private final CityConverter cityConverter;

    @GetMapping
    public ResponseEntity<Set<City>> findAll(){
         return ResponseEntity.ok(cityService.findAll());

    }


    @PostMapping
    public ResponseEntity <CityResponse> saved (@RequestBody CitySaveRequest citySaveRequest) {
        City city =  cityConverter.convert(citySaveRequest);
        City savedCity = cityService.save(city);
        CityResponse response = cityConverter.converted(savedCity);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
