package com.example.bpc_group.services;

import com.example.bpc_group.AbstractLordTest;
import com.example.bpc_group.models.entity.Lord;
import com.example.bpc_group.models.entity.Planet;
import com.example.bpc_group.repositories.LordRepository;
import com.example.bpc_group.repositories.PlanetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
class PlanetServiceTest extends AbstractLordTest {

    @InjectMocks
    private PlanetService underTest;

    @Mock
    private PlanetRepository planetRepository;

    @BeforeEach
    public void init() {
        List<Planet> listPlanet = generatePlanetList(10,5);
        lenient().when(planetRepository.findAll()).thenReturn(listPlanet);
    }

    @Test
    void getAllPlanets() {
        final List<Planet> planets = underTest.getAllPlanets();
        assertEquals(5, planets.size());
    }
}