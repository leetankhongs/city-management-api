package com.test.city.repository;

import com.test.city.model.ElectricityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectricityRepository extends JpaRepository<ElectricityEntity, Long> {}
