package br.unisul.aula.dto;

import br.unisul.aula.modelo.Cliente;
import br.unisul.aula.modelo.Endereco;

public class ClienteDTO {
    private Long id;
    private String nome;
    private String complemento;
    private Integer numero;
    private EnderecoDTO endereco;

    public ClienteDTO() { }
    public ClienteDTO(Cliente cliente) {
        setId(cliente.getId());
        setComplemento(cliente.getComplemento());
        setNome(cliente.getNome());
        setNumero(cliente.getNumero());
        setEndereco(new EnderecoDTO(cliente.getEndereco()));
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getComplemento() { return complemento; }

    public void setComplemento(String complemento) { this.complemento = complemento; }

    public Integer getNumero() { return numero; }

    public void setNumero(Integer numero) { this.numero = numero; }

    public EnderecoDTO getEnderecoDTO() { return endereco; }

    public void setEndereco(EnderecoDTO endereco) { this.endereco = endereco; }

    public Cliente paraCliente() {
        Cliente cliente = new Cliente();
        cliente.setId(this.id);
        cliente.setNome(this.nome);
        cliente.setNumero(this.numero);
        cliente.setComplemento(this.complemento);
        cliente.setEndereco(this.endereco.paraEndereco());
        return cliente;
    }

    public ClienteDTO simplify() {
        ClienteDTO cliente = new ClienteDTO();
        cliente.setId(id);
        cliente.setNome(nome);
        return cliente;
    }
}
