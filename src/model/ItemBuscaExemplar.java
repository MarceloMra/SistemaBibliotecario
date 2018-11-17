/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Marcelo Moreira
 */
public class ItemBuscaExemplar {
    private int idExemplar;
    private int idLivro;
    private String codBarras;
    private String titulo;
    private String autor;
    private String editora;
    private String dataCadastro;
    private String situacaoExemplar;

    public String getSituacaoExemplar() {
        return situacaoExemplar;
    }

    public void setSituacaoExemplar(String situacaoExemplar) {
        this.situacaoExemplar = situacaoExemplar;
    }
    
    

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.dataCadastro = dateFormat.format(dataCadastro);
    }

    public int getIdExemplar() {
        return idExemplar;
    }

    public void setIdExemplar(int idExemplar) {
        this.idExemplar = idExemplar;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
    
    
}
