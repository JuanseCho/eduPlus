package com.eduPlus.Service;

import com.eduPlus.Modelo.Rol;

import java.util.Optional;

public interface IRolService {

    Optional<Rol> findById(Integer id) ;

     Optional<Rol> findByRol(String rol) ;


}
