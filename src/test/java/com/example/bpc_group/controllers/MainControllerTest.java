package com.example.bpc_group.controllers;

import com.example.bpc_group.models.entity.Lord;
import com.example.bpc_group.models.entity.Planet;
import com.example.bpc_group.services.LordService;
import com.example.bpc_group.services.PlanetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {MainController.class})
@DirtiesContext
class MainControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    LordService lordService;

    @MockBean
    PlanetService planetService;



    @Test
    void getLordsTest() throws Exception {
        mvc.perform(get("/lords"))
                .andExpect(status().isOk());
    }

    @Test
    void addLordTest() throws Exception {
        Lord lord = new Lord();
        mvc.perform(post("/lords/add")
                .content(String.valueOf(lord)))
                .andExpect(status().is(302));
    }

    @Test
    void findTop10LordsTest() throws Exception {
        mvc.perform(get("/lords/top"))
                .andExpect(status().isOk());
    }

    @Test
    void getPlanetsTest() throws Exception {
        mvc.perform(get("/planets"))
                .andExpect(status().isOk());
    }

    @Test
    void findLazyLordsTest() throws Exception {
        mvc.perform(get("/lords/lazy"))
                .andExpect(status().isOk());
    }

    @Test
    void addPlanetTest() throws Exception {
        Planet planet = new Planet();

        mvc.perform(post("/planets/add")
                .content(String.valueOf(planet)))
                .andExpect(status().is(302));

    }

    @Test
    void deleteProductTest() throws Exception {
        mvc.perform(get("/planets/delete/1"))
                .andExpect(status().is(302));
    }
}