package com.comunet.taller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comunet.taller.model.Permiso;

public interface PermisoRepository extends JpaRepository<Permiso, Long> {
    
}
