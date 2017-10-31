package domain;

import java.io.Serializable;

/**
 * Created by luiza on 30/10/17.
 */

public class Festa implements Serializable {

    private int id;
    private String nome;
    private String descricao;
    private boolean pago;
    private String dataFuncionamento;
    private String valor;
    private String video;
    private String cidade;

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
