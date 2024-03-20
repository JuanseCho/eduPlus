package com.eduPlus.Service;

import com.eduPlus.Modelo.Rol;
import com.eduPlus.repository.IRolRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RolServiceImplement implements IRolService {

    private IRolRepository iRolRepository;

    public RolServiceImplement(IRolRepository rolRepository) {
        this.iRolRepository = rolRepository;
    }
    @Override
    public Optional<Rol> findById(Integer id) {
        return iRolRepository.findById(id);
    }

    @Override
    public Optional<Rol> findByRol(String rol) {
        return iRolRepository.findByRol(rol);
    }
}
