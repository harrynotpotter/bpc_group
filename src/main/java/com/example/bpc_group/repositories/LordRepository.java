package com.example.bpc_group.repositories;

import com.example.bpc_group.models.entity.Lord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LordRepository extends JpaRepository<Lord, Integer>, JpaSpecificationExecutor<Lord> {


    @Query(nativeQuery = true, value = "SELECT * FROM lord ORDER BY age ASC LIMIT 10")
    List<Lord> findTop10ByAge();

    @Query(nativeQuery = true, value = "SELECT l.* \n" +
            "FROM lord l LEFT JOIN planet p on l.id = p.lord_id \n" +
            "WHERE p.lord_id IS NULL; ")
    List<Lord> findLazyLords();





}
