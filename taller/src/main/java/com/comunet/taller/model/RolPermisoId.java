package com.comunet.taller.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor 
@AllArgsConstructor 
@EqualsAndHashCode 
public class RolPermisoId {
    
    @Column (name = "rol_id")
    private Long rolId;

    @Column (name = "permiso_id")
    private Long permisoId;
}

