package com.login.LoginPage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.login.LoginPage.models.Administrador;
import com.login.LoginPage.repositorio.AdministradoresRepo;

@Controller
public class LoginController {

    @Autowired
    private AdministradoresRepo repo;

    @GetMapping("/login")
    public String index() {
        return "login/index";
    }

    @PostMapping("/entrar")
    public String entrar(Model model, Administrador admParam, String lembrar) {
        Administrador adm = this.repo.loginValidator(admParam.getEmail(), admParam.getSenha());
        if (adm != null) {
            return "redirect:/";
        }
        model.addAttribute("erro", "Usuário ou senha inválidos");
        return "/login/index";
    }
}
