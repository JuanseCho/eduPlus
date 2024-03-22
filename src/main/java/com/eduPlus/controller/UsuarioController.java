package com.eduPlus.controller;


import com.eduPlus.Modelo.Usuario;
import com.eduPlus.Service.IUsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.classic.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {


    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/login")
    public String login() {
        return "usuario/login";
    }

    @ResponseBody
    @PostMapping("/acceder")
    public String acceder(Usuario usuario, HttpSession session) {

        Map<String, String> response = new HashMap<>();
        try {

            Optional<Usuario> userOptional = usuarioService.findByEmail(usuario.getEmail());
            // Validar
            if (userOptional.isPresent()) {
                Usuario user = userOptional.get();

                if (user.getPassword().equals(usuario.getPassword())) {
                    session.setAttribute("idUsuario", userOptional.get().getIdUsuario());

                    // Validar el rol del usuario por el idRol
                    switch (userOptional.get().getIdRol()) {
                        case 1:
                        case 4:
                            String mensaje = "Bienvenido a " + userOptional.get().getNombres() + " " + userOptional.get().getApellidos() + " a eduplus";
                            response.put("codigo", "200");
                            response.put("mensaje", mensaje);
                            response.put("redireccion", "/eduplus");

                            break;

                        case 2:
                            response.put("mensaje", "Bienvenido docente");
                            break;
                        case 3:
                            response.put("mensaje", "Bienvenido estudiante");
                            break;
                        case 5:
                            response.put("mensaje", "Bienvenido eduplussecretaria");
                            break;
                        case 6:
                            response.put("mensaje", "Bienvenido coordinador");
                            break;
                        case 7:
                            response.put("mensaje", "Bienvenido acudiente");
                            break;
                        default:
                            response.put("mensaje", "Bienvenido");
                    }
                }else {
                    LOGGER.info("Contraseña incorrecta");

                    response.put("mensaje", "Error en la contraseña. Por favor, verifique sus datos.");


                }

            } else {
                LOGGER.info("Usuario no existe en la base de datos");
                response.put("mensaje", "Error al iniciar sesión. Por favor, verifique sus datos.");
            }
        } catch (
                Exception e) {
            LOGGER.error("Error al acceder: {}", e.getMessage());
            response.put("mensaje", "Error al acceder: " + e.getMessage());
        }
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(response);
        } catch (
                Exception e) {
            LOGGER.error("Error al convertir el mapa a JSON: {}", e.getMessage());
            return "{\"mensaje\": \"Error al convertir el mapa a JSON\"}";
        }
    }

}