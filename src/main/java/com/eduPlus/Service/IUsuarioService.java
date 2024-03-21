package com.eduPlus.Service;

import com.eduPlus.Modelo.Usuario;

import java.util.Optional;

public interface IUsuarioService {

    public Usuario save(Usuario usuario, Integer idRol);
    public Optional<Usuario> get(Integer id);
    public void update(Usuario usuario);
    public void delete(Integer id);
    Optional<Usuario> findById(Integer id);
    Optional<Usuario> findByEmail(String email);


}
