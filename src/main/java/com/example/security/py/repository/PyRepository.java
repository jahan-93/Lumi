package com.example.security.py.repository;

import com.example.security.py.Entity.PyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PyRepository extends JpaRepository<PyEntity, Long> {

}
