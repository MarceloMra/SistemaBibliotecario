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
public class ItemBuscaEmprestimo {
    private int idEmprestimo;
    private int idUsuario;
    private int idExemplar;
    private int idBibliotecaria;
    private String nomeUsuario;
    private String titulo;
    private String dataEmprestimo;
    private String dataPrevistaDevol;
    private String dataDevolucao;
    private int qtdRenovacoes;
    private float multa;
    private String codBarras;

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }
    
    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(int idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdExemplar() {
        return idExemplar;
    }

    public void setIdExemplar(int idExemplar) {
        this.idExemplar = idExemplar;
    }

    public int getIdBibliotecaria() {
        return idBibliotecaria;
    }

    public void setIdBibliotecaria(int idBibliotecaria) {
        this.idBibliotecaria = idBibliotecaria;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.dataEmprestimo = dateFormat.format(dataEmprestimo);
    }

    public String getDataPrevistaDevol() {
        return dataPrevistaDevol;
    }

    public void setDataPrevistaDevol(Date dataPrevistaDevol) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.dataPrevistaDevol = dateFormat.format(dataPrevistaDevol);
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.dataDevolucao = dateFormat.format(dataDevolucao);
    }

    public int getQtdRenovacoes() {
        return qtdRenovacoes;
    }

    public void setQtdRenovacoes(int qtdRenovacoes) {
        this.qtdRenovacoes = qtdRenovacoes;
    }

    public float getMulta() {
        return multa;
    }

    public void setMulta(float multa) {
        this.multa = multa;
    }
    
    
}
