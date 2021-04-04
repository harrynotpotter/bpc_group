package com.example.bpc_group.services;

import com.example.bpc_group.models.entity.Lord;
import com.example.bpc_group.repositories.LordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LordService {
    @Autowired
    private LordRepository lordRepository;


    public List<Lord> getAllLords() {
        return lordRepository.findAll();
    }

    public void addLord(Lord lord) {
        lordRepository.save(lord);
    }

    public List<Lord> findTop10Lords() {
        return lordRepository.findTop10ByAge();
    }

    public List<Lord> findLazyLords() { return lordRepository.findLazyLords();}
}
