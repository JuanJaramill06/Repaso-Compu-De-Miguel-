package com.comunet.taller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comunet.taller.model.Permiso;
import com.comunet.taller.model.Rol;
import com.comunet.taller.model.RolPermiso;
import com.comunet.taller.model.Usuario;
import com.comunet.taller.repository.PermisoRepository;
import com.comunet.taller.repository.RolPermisoRepository;
import com.comunet.taller.repository.RolRepository;
import com.comunet.taller.repository.UsuarioRepository;


@RestController
public class Controller {

 
    private UsuarioRepository usuarioRepo;
    private RolRepository rolRepo;
    private PermisoRepository permisoRepo;
    private RolPermisoRepository rolPermisoRepo;
    @Autowired
    public Controller(UsuarioRepository usuarioRepo, RolRepository rolRepo, PermisoRepository permisoRepo, RolPermisoRepository rolPermisoRepo) {
        this.usuarioRepo = usuarioRepo;
        this.rolRepo = rolRepo;
        this.permisoRepo = permisoRepo;
        this.rolPermisoRepo = rolPermisoRepo;
    }

    @GetMapping("/")
    public String home() {
        return new String("Proyecto spring boot funcionando correctamente");
    }
    

    @GetMapping("/usuario")
    public List<Usuario> getUsuarios(){
        return usuarioRepo.findAll();

    }

    @GetMapping("/rol")
    public List<Rol> getRoles(){
        return rolRepo.findAll();
        
    }

    @GetMapping("/permiso")
    public List<Permiso> getPermisos(){
        return permisoRepo.findAll();
        
    }

    @GetMapping ("/rol_permiso")
    public List<RolPermiso> getRolPermisos(){
        return rolPermisoRepo.findAll();
    }

    
}
