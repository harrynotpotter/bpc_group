package com.example.bpc_group.repositories;

import com.example.bpc_group.models.entity.Lord;
import com.example.bpc_group.models.entity.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


public interface PlanetRepository extends JpaRepository<Planet, Integer>, JpaSpecificationExecutor<Lord> {
}
