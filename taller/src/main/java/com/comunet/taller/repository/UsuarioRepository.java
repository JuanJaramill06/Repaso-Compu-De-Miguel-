package com.comunet.taller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comunet.taller.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>
 {
    
}

