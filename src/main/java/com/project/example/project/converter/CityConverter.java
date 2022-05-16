package com.project.example.project.converter;


import com.project.example.project.dto.city.CityResponse;
import com.project.example.project.dto.city.CitySaveRequest;
import com.project.example.project.entity.City;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CityConverter {

    public City convert (CitySaveRequest citySaveRequest) {
         City city = new City();
         city.setName(citySaveRequest.getName());
         return city;
    }


    public CityResponse converted (City city) {
        return CityResponse.builder()
                .name(city.getName())
                .build();
    }

}
