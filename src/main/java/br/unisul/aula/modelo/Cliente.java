package br.unisul.aula.modelo;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String nome;
    private String complemento;
    private Integer numero;

    @OneToOne(cascade=CascadeType.ALL )
    private Endereco endereco;

    public Cliente() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    public Integer getNumero() { return numero; }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    @Override public String toString() { return "Cliente{" + "id=" + id + ", nome='" + nome + '\'' + ", complemento='" + complemento + '\'' + ", numero=" + numero + ", endereco=" + endereco + '}'; }
}