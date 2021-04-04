package com.example.bpc_group.integration;

import com.example.bpc_group.AbstractLordTest;
import com.example.bpc_group.models.entity.Lord;
import com.example.bpc_group.models.entity.Planet;
import com.example.bpc_group.repositories.LordRepository;
import com.example.bpc_group.repositories.PlanetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class ApplicationIntegrationTest extends AbstractLordTest {

//    @Autowired
//    LordRepository lordTest;
//    @Autowired
//    PlanetRepository planetTest;

    @Autowired
    LordRepository lordRepository;

    @Autowired
    PlanetRepository planetRepository;

    @Autowired
    MockMvc mvc;

    @BeforeEach
    void init() {
        final int size = 11;
        lordRepository.saveAll(generateLordList(size));
        planetRepository.saveAll(generatePlanetList(size, 5));
    }

    @Test
    void addLord() throws Exception {
        Lord lord = new Lord();

        int id = 12;
        String name = "Зевс";
        int age = 12000;

        lord.setId(id);
        lord.setAge(age);
        lord.setName(name);

        lordRepository.save(lord);

        mvc.perform(post("/lords/add")
                .content(String.valueOf(lord)))
                .andExpect(status().is(302));

        Optional<Lord> resultLord = lordRepository.findById(id);
        assertTrue(resultLord.isPresent());
        resultLord.ifPresent(l -> {
            assertEquals(l.getName(), name);
            assertEquals(l.getAge(), age);
        });
    }

    @Test
    void addPlanet() throws Exception {
        String name = "Солнце";
        int id = 12;

        Planet planet = new Planet();
        planet.setName(name);
        planet.setId(id);

        mvc.perform(post("/planets/add")
                .content(String.valueOf(planet)))
                .andExpect(status().is(302));

        Optional<Planet> resultPlanet = planetRepository.findById(id);

        resultPlanet.ifPresent(l -> {
            assertEquals(l.getName(), name);
        });
    }

    @Test
    void getLordsTest() throws Exception {
        mvc.perform(get("/lords"))
                .andExpect(status().isOk());
    }

    @Test
    void getPlanetsTest() throws Exception {
        mvc.perform(get("/planets"))
                .andExpect(status().isOk());
    }

    @Test
    void deleteProductTest() throws Exception {
        int id = 2;

        mvc.perform(get("/planets/delete/" + id))
                .andExpect(status().is(302));

        Optional<Planet> result = planetRepository.findById(id);
        assertEquals(Optional.empty(), result);

    }

    @Test
    void findLazyLordsTest() throws Exception {
        mvc.perform(get("/lords/lazy"))
                .andExpect(status().isOk());
    }

    @Test
    void findTop10LordsTest() throws Exception {
        mvc.perform(get("/lords/top"))
                .andExpect(status().isOk());
    }


}