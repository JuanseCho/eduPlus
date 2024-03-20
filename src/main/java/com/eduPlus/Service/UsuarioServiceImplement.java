package com.eduPlus.Service;

import ch.qos.logback.classic.Logger;
import com.eduPlus.Modelo.Rol;
import com.eduPlus.Modelo.Usuario;
import com.eduPlus.repository.IUsuarioRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImplement implements IUsuarioService{

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(UsuarioServiceImplement.class);

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private IRolService rolService;

    @Override
    public Usuario save(Usuario usuario, Integer idRol) {

        Optional<Rol> optionalRol = rolService.findById(idRol);

        if(optionalRol.isPresent()){
            Rol rol = optionalRol.get();
            //Asignar el rol al usuario
            usuario.setIdRol(rol);
            return usuarioRepository.save(usuario);
        }else {
            LOGGER.error("No se encontró el rol correspondiente.");
            return null;
        }

    }

    @Override
    public Optional<Usuario> get(Integer id) {
        return Optional.empty();
    }

    @Override
    public void update(Usuario usuario) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Optional<Usuario> findById(Integer id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
}
