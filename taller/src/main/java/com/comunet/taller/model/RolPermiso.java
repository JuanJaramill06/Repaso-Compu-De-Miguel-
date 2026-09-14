package com.comunet.taller.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
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
@Table (name = "rol_permiso")
public class RolPermiso {
    
    @EmbeddedId
    private RolPermisoId id = new RolPermisoId();

    @ManyToOne (fetch = FetchType.LAZY)
    @MapsId("rolId")
    @JoinColumn (name = "rol_id", nullable = false)
    @JsonIgnoreProperties (value = "rolPermiso")
    private Rol rol;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "permiso_id", nullable = false)
    @MapsId ("permisoId")
    @JsonIgnoreProperties (value = "rolPermiso")
    private Permiso permiso;

    public RolPermiso(Rol rol, Permiso permiso){
        this.rol = rol;
        this.permiso = permiso;
        this.id = new RolPermisoId(rol.getId(), permiso.getId());
    }
}
