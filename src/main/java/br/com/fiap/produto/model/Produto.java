package br.com.fiap.produto.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "PRODUTO")
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    //@GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID")
    private Long id;

    @Column(name = "CODIGO")
    private String codigo;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "QTDE_ESTOQUE")
    private Double qtdeEstoque;

    @Column(name = "VALOR")
    private Double valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getQtdeEstoque() {
        return qtdeEstoque;
    }

    public void setQtdeEstoque(Double qtdeEstoque) {
        this.qtdeEstoque = qtdeEstoque;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
