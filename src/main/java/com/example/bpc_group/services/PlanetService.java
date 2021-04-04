package com.example.bpc_group.services;

import com.example.bpc_group.models.entity.Planet;
import com.example.bpc_group.repositories.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetService {
    @Autowired
    private PlanetRepository planetRepository;

    public void addPlanet(Planet planet) {
        planetRepository.save(planet);
    }

    public List<Planet> getAllPlanets() {
        return planetRepository.findAll();
    }

    public void destroyPlanet(int id) {
        planetRepository.deleteById(id);
    }

}
