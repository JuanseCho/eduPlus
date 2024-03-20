package com.eduPlus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduPlus.Modelo.Usuario;

import java.util.Optional;

public interface IUsuarioRepository extends JpaRepository<Usuario,Integer>{

    Optional<Usuario> findByEmail(String email);

}




