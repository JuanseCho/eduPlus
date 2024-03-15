package com.eduPlus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduPlus.Modelo.Estudiante;



public interface IEstudiante extends JpaRepository<Estudiante,Integer> {

}
