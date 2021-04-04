package com.example.bpc_group.services;

import com.example.bpc_group.AbstractLordTest;
import com.example.bpc_group.models.entity.Lord;
import com.example.bpc_group.repositories.LordRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
class LordServiceTest extends AbstractLordTest {

    @InjectMocks
    private LordService underTest;

    @Mock
    private LordRepository lordRepository;

    @BeforeEach
    public void init() {
        List<Lord> listLord = generateLordList(10);
        lenient().when(lordRepository.findTop10ByAge()).thenReturn(listLord);
        lenient().when(lordRepository.findAll()).thenReturn(listLord);
    }

    @Test
    void findTop10LordsTest() {
        final List<Lord> top10Lords = underTest.findTop10Lords();
        assertEquals(10, top10Lords.size());
    }

    @Test
    void getAllLordsTest() {
        final List<Lord> lords = underTest.getAllLords();
        assertEquals(10, lords.size());
    }


}