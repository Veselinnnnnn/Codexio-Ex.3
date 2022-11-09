package com.codexio.ex3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarEntity,Long> {
    List<CarEntity> findAll();
    CarEntity findCarById(Long id);
}
