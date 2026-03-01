package com.example.BCPAPI.repository;

import com.example.BCPAPI.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
}