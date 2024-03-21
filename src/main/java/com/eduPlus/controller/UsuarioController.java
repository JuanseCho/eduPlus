package com.eduPlus.controller;

import ch.qos.logback.classic.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(UsuarioController.class);

}
