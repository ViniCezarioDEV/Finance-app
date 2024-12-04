package com.finance.app.controllers;

import com.finance.app.models.Familias;
import com.finance.app.repository.FamiliasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/familias")
public class FamiliasController {

    @Autowired
    FamiliasRepository dbConnection;

    //Lista todos os registros
    @CrossOrigin //corrige o erro de CORS (com isso a API é pública para todos)
    @GetMapping("/")
    public List<Familias> encontrarTodosOsRegistros() {
        return dbConnection.findAll();
    }

    // Inserir um registro
    @CrossOrigin
    @PostMapping(value = "/inserir", produces = "application/json")
    public Familias create(@RequestBody Familias exemplo){
        dbConnection.save(exemplo);
        return exemplo;
    }

    // Deletar um registro por um ID
    @CrossOrigin
    @DeleteMapping(value = "/deletar/{id}", produces = "application/json")
    public String delete(@PathVariable int id) {
        Familias indicado = dbConnection.findFamiliasByIdFamilia(id).get();
        dbConnection.delete(indicado);
        return "{deleted: " + id + "}";
    }

    // Encontrar um único registro por um ID
    @CrossOrigin
    @RequestMapping(value = "/buscar/id/{id}", method = RequestMethod.GET)
    public Optional<Familias> searchById(@PathVariable int id) {
        return dbConnection.findFamiliasByidFamilia(id);
    }

    // Atualizar um único registro pelo ID
    @CrossOrigin
    @PutMapping(value = "/atualizar/id/{id}", produces = "application/json") // Atualizar um registro
    public Familias update(@PathVariable int id, @RequestBody Familias exemplo) {
        // Crio um objeto da classe Familias e atribuo a ele o valor do id passado como parâmetro
        Familias unidade = dbConnection.findFamiliasByidFamilia(id).get();
        unidade.setNomeFamilia(exemplo.getNomeFamilia());
        unidade.setStatus(exemplo.getStatus());
        dbConnection.save(unidade);
        return unidade;
    }
}
