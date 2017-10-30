package com.example.leon.floripapp;

import java.io.Serializable;

/**
 * Created by julia on 18/11/16.
 */

public class PontoTuristico implements Serializable {

    private int id;
    private String nome;
    private String descricao;
    private boolean pago;
    private String dataFuncionamento;
    private String horarioFuncionamento;
    private boolean favorito;

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPago() {
        return pago;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataFuncionamento() {
        return dataFuncionamento;
    }

    public void setDataFuncionamento(String dataFuncionamento) {
        this.dataFuncionamento = dataFuncionamento;
    }

    public String getHorarioFuncionamento() {
        return horarioFuncionamento;
    }

    public void setHorarioFuncionamento(String horarioFuncionamento) {
        this.horarioFuncionamento = horarioFuncionamento;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
