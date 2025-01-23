package com.test.city.repository;

import com.test.city.model.WasteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WasteRepository extends JpaRepository<WasteEntity, Long> {}