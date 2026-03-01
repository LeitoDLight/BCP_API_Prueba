package com.example.BCPAPI.repository;

import com.example.BCPAPI.entity.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface LocalRepository extends JpaRepository<Local, Long> {


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO locals (name, floor) VALUES (:name, :floor)", nativeQuery = true)
    void registrarLocalNativo(@Param("name") String name, @Param("floor") String floor);
}
