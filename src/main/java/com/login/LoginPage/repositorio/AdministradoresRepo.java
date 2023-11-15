package com.login.loginpage.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.login.loginpage.models.Administrador;

public interface AdministradoresRepo extends CrudRepository<Administrador, Integer> {
    @Query(value = "SELECT * FROM administradores WHERE email =:email AND senha =:senha", nativeQuery = true)
    public Administrador loginValidator(String email, String senha);
}
