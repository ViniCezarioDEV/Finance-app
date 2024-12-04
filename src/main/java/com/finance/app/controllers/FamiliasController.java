package com.finance.app.controllers;

import com.finance.app.models.Familias;
import com.finance.app.repository.FamiliasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/familias")
public class FamiliasController {

    @Autowired
    FamiliasRepository dbConnection;

    @CrossOrigin //corrige o erro de CORS (com isso a API é pública para todos)
    @GetMapping("/")
    public List<Familias> encontrarTodosOsRegistros() {
        return dbConnection.findAll();
    }

    @CrossOrigin
    @PostMapping(value = "/inserir", produces = "application/json")
    public Familias create(@RequestBody Familias exemplo){
        dbConnection.save(exemplo);
        return exemplo;
    }

    @CrossOrigin
    @DeleteMapping(value = "/deletar/{id}", produces = "application/json")
    public String delete(@PathVariable int id) {
        Familias indicado = dbConnection.findFamiliasByIdFamilia(id).get();
        dbConnection.delete(indicado);
        return "{deleted: " + id + "}";
    }
}
