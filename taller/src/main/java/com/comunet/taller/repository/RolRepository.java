package com.comunet.taller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comunet.taller.model.Rol;

public interface RolRepository extends JpaRepository<Rol, Long> {
    
}
