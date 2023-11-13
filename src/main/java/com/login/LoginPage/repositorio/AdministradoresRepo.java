package com.login.LoginPage.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.login.LoginPage.models.Administrador;

public interface AdministradoresRepo extends CrudRepository<Administrador, Integer> {
    
}
