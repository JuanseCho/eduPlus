package com.eduPlus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class UsuarioController {
	@GetMapping("")
	public String homeUser() {
		return "usuario/home";
	}
	@GetMapping("/login")
	public String login() {
		return "usuario/login";
	}

}
