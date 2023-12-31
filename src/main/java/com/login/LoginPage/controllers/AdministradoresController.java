package com.login.loginpage.controllers;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.login.loginpage.models.Administrador;
import com.login.loginpage.repositorio.AdministradoresRepo;
import com.login.loginpage.service.CookieService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AdministradoresController {

    @Autowired
    private AdministradoresRepo repo;

    @GetMapping("/administradores")
    public String index(Model model, Model modelName, HttpServletRequest request) throws UnsupportedEncodingException {
        List<Administrador> administradores = (List<Administrador>)repo.findAll();
        model.addAttribute("administradores", administradores);
        modelName.addAttribute("nome", CookieService.getCookie(request, "userName"));
        return "administradores/index";
    }

    @GetMapping("/administradores/novo")
    public String novo() {
        return "administradores/novo";
    }

    @PostMapping("/administradores/criar")
    public String criar(Administrador administrador) {
        repo.save(administrador);
        return "redirect:/administradores";
    }

    @GetMapping("/administradores/{id}/excluir")
    public String excluir(@PathVariable int id) {
        repo.deleteById(id);
        return "redirect:/administradores";
    }

    @GetMapping("/administradores/{id}")
    public String buscar(@PathVariable int id, Model model) {
        model.addAttribute("administrador", repo.findById(id));
        return "/administradores/editar";
    }

    @PostMapping("/administradores/{id}/atualizar")
    public String atualizar(@PathVariable int id, Administrador administrador) {
        if(!repo.existsById(id)) {
            return "redirect:/administradores";
        }

        repo.save(administrador);
        return "redirect:/administradores";
    }

}
