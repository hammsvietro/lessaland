package br.unisul.aula.dto;

import br.unisul.aula.modelo.Endereco;
import br.unisul.aula.modelo.UnidadeFederativa;

public class EnderecoDTO {

    private Long id;
    private String logradouro;
    private Integer cep;
    private String bairro;
    private String cidade;
    private UnidadeFederativa uf;

    public EnderecoDTO() {}

    public EnderecoDTO(Endereco endereco) {
       this.setId(endereco.getId());
       this.setLogradouro(endereco.getLogradouro());
       this.setCep(endereco.getCep());
       this.setBairro(endereco.getBairro());
       this.setCidade(endereco.getCidade());
       this.setUf(endereco.getUf());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public UnidadeFederativa getUf() {
        return uf;
    }

    public void setUf(UnidadeFederativa uf) {
        this.uf = uf;
    }
    public Endereco paraEndereco() {
        Endereco endereco = new Endereco();
        endereco.setId(this.getId());
        endereco.setUf(this.getUf());
        endereco.setCidade(this.getCidade());
        endereco.setLogradouro(this.getLogradouro());
        endereco.setCep(this.getCep());
        endereco.setBairro(this.getBairro());
        return endereco;
    }
}
