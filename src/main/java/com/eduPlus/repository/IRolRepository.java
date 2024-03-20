package com.eduPlus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduPlus.Modelo.Rol;

import java.util.Optional;


public interface IRolRepository extends JpaRepository<Rol,Integer>{

    Optional<Rol> findByRol(String rol);
}
