package com.cs.springbootcsapp.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs.springbootcsapp.jpa.model.CarEntity;

public interface CarEntityRepository extends JpaRepository<CarEntity, Integer> {

}
