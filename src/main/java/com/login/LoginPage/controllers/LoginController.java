package com.login.loginpage.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.login.loginpage.models.Administrador;
import com.login.loginpage.repositorio.AdministradoresRepo;
import com.login.loginpage.service.CookieService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    private AdministradoresRepo repo;

    @GetMapping("/login")
    public String index() {
        return "login/index";
    }

    @PostMapping("/entrar")
    public String entrar(Model model, Administrador admParam, String lembrar, HttpServletResponse response) throws IOException {
        Administrador adm = this.repo.loginValidator(admParam.getEmail(), admParam.getSenha());
        if (adm != null) {
            int timeLogged = (60*60); // one hour by default
            if (lembrar != null) {
                timeLogged *= 24; //one day case remember box has been checked
            }
            CookieService.setCookie(response, "usuarioId", String.valueOf(adm.getId()), timeLogged);
            CookieService.setCookie(response, "userName", String.valueOf(adm.getNome()), timeLogged);
            return "redirect:/";
        }
        model.addAttribute("erro", "Usuário ou senha inválidos");
        return "/login/index";
    }

    @GetMapping("/sair")
    public String sair(HttpServletResponse response) throws IOException {
        CookieService.setCookie(response, "usuarioId", "", 0);
        return "redirect:/login";
    }
}
