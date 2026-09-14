package com.comunet.taller.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "nombre", nullable = false)
    private String nombre;

    @Column (name = "apellido", nullable = false)
    private String apellido;

    @Column (name = "correo_institucional", nullable = false)
    private String correo_institucional;

    @Column (name = "contraseña", nullable = false)
    private String contraseña;
    
    @Column (name = "active")
    private boolean active;

    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable  (
        name = "usuario_rol",
        joinColumns = @JoinColumn (name = "usuario_id"),
        inverseJoinColumns = @JoinColumn (name = "rol_id")
    )
    private List<Rol> rol = new ArrayList<>();

}