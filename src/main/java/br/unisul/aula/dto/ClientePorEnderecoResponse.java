package br.unisul.aula.dto;

import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class ClientePorEnderecoResponse {
    private String cidade;
    private String uf;
    private List<ClienteDTO> clientes;

    public ClientePorEnderecoResponse() {
        this.clientes = new Vector<ClienteDTO>();
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public List<ClienteDTO> getClientes() {
        return clientes;
    }

    public void addClientes(ClienteDTO cliente) {
        this.clientes.add(cliente);
    }
}
