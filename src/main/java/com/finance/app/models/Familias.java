package com.finance.app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "familias") //tabela no banco de dados
public class Familias {

    /* FORMA ERRADA
    @Id
    @Column(name = "id_familia")
    int id_familia; <---- ERRO
    */

    @Id //id_familia = chave primaria
    @Column(name = "id_familia") //tem que fazer assim, pois da problema o underline
    int idFamilia;

    @Column(name = "data_cadastro")
    Date dataCadastro;

    @Column(name = "nome_familia")
    String nomeFamilia;


    char status;



    // getters = metodo que recupera dados do banco
    // setters = metodo que insere dados no banco

    public int getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(int idFamilia) {
        this.idFamilia = idFamilia;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getNomeFamilia() {
        return nomeFamilia;
    }

    public void setNomeFamilia(String nomeFamilia) {
        this.nomeFamilia = nomeFamilia;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }
}
