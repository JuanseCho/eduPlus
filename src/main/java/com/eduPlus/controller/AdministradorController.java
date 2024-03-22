package com.eduPlus.controller;

import ch.qos.logback.classic.Logger;
import com.eduPlus.Modelo.Rol;
import com.eduPlus.Modelo.Usuario;
import com.eduPlus.Service.IRolService;
import com.eduPlus.Service.IUsuarioService;
import com.eduPlus.Service.UsuarioServiceImplement;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/eduplus")
public class AdministradorController {


    @GetMapping("")
    public String home() {

        return "administrador/home";
    }

    
    @GetMapping("/docentes")
    public String docentes() {
    	return "administrador/docentes";
    }

    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(AdministradorController.class);

    @Autowired
    private IUsuarioService usuarioService;
    @Autowired
    private final UsuarioServiceImplement usuarioServiceImplement;

    @Autowired
    private IRolService iRolService;

    public AdministradorController(UsuarioServiceImplement usuarioServiceImplement) {
        this.usuarioServiceImplement = usuarioServiceImplement;
    }

    @GetMapping("/registro")
    public String createUser() {

        return "administrador/usuario/registro";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Usuario usuario) {

        try {
            LOGGER.info("Usuario a registrar en la base de datos {}", usuario);

            // Convertir el documento de int a String
            String documento = String.valueOf(usuario.getDocumento());
            // Asignar la contraseña igual al documento
            usuario.setPassword(documento);

            // Asignar a imgPerfil una imagen por defecto
            usuario.setImgPerfil("default.jpg");
            Optional<Rol> optionalRol = iRolService.findById(usuario.getIdRol());

            if (optionalRol.isPresent()) {
                Rol rol = optionalRol.get();
                usuario.setIdRol(rol);
                usuarioService.save(usuario, usuario.getIdRol());


                return "redirect:/eduplus/registro?success";
            } else {
                LOGGER.error("No se encontró el rol con id {}", usuario.getIdRol());

                return "redirect:/eduplus/registro?error";
            }
        } catch (Exception e) {
            LOGGER.error("Error al guardar usuario", e);
            // Mostrar alerta de error
            return "redirect:/eduplus/registro?error";
        }
    }


    @PostMapping("/importar")
    public String importarUsuarios(@RequestParam("file") MultipartFile file) {
        try {

            // Guardar el archivo en una ubicación temporal o procesarlo directamente desde el flujo de entrada
            File tempFile = File.createTempFile("tempfile", ".xlsx");
            file.transferTo(tempFile);

            // Llamar al método para leer el archivo Excel y obtener los usuarios
            List<Usuario> usuarios = LeerExcel.obtenerUsuariosDeArchivo(tempFile);


            // Iterar sobre los usuarios y guardarlos en la base de datos
            for (Usuario usuario : usuarios) {
                LOGGER.info("Usuario a registrar en la base de datos: {}", usuario);

                usuarioService.save(usuario, usuario.getIdRol());

            }

            // Eliminar el archivo temporal
            tempFile.delete();
        } catch (IOException e) {
            e.printStackTrace();
            // Manejar la excepción apropiadamente
        }

        // Redireccionar a la página de registro después de importar los usuarios
        return "redirect:/eduplus/registro";
    }

}

