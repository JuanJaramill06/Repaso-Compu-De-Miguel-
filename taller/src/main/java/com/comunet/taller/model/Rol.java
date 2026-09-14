package com.comunet.taller.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
@Table (name = "rol")
public class Rol {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "nombre", nullable = false)
    private String nombre;

    @Column (name = "descripcion", nullable = false)
    private String descripcion;

    @ManyToMany (mappedBy = "rol")
    @JsonIgnoreProperties (value = "rol")
    private List<Usuario> usuarios = new ArrayList();

    @OneToMany (mappedBy = "rol", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties (value = "rol")
    private List<RolPermiso> rolPermisos = new ArrayList<>();

}
