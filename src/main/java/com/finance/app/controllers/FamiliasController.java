package com.finance.app.controllers;

import com.finance.app.models.Familias;
import com.finance.app.repository.FamiliasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/familias")
public class FamiliasController {

    @Autowired
    FamiliasRepository dbConnection;

    @CrossOrigin
    @GetMapping("/") //corrige o erro de CORS (com isso a API é pública para todos)
    public List<Familias> encontrarTodosOsRegistros() {
        return dbConnection.findAll();
    }

}
