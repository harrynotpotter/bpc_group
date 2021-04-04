package com.example.bpc_group.repositories;

import com.example.bpc_group.models.entity.Lord;
import com.example.bpc_group.AbstractLordTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LordRepositoryTest extends AbstractLordTest {

    @Autowired
    LordRepository underTest;
    @Autowired
    PlanetRepository planetTest;

    @BeforeEach
    public void init() {
        final int size = 11;
        underTest.saveAll(generateLordList(size));
        planetTest.saveAll(generatePlanetList(size,5));
    }

    @Test
    void findTop10ByAgeTest() {
        final List<Lord> top10ByAge = underTest.findTop10ByAge();
        assertEquals(10, top10ByAge.size());
    }


    @Test
    void findLazyLordsTest() {
        final List<Lord> lazyLords = underTest.findLazyLords();
        assertEquals(6,lazyLords.size());
    }
}