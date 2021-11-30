package br.unisul.aula;

import br.unisul.aula.banco.ContextoCliente;
import br.unisul.aula.dto.ClienteDTO;
import br.unisul.aula.dto.EnderecoDTO;
import br.unisul.aula.modelo.Cliente;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.ws.rs.Path;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name="helloServlet", value="/api/cliente")
public class ClienteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ClienteDTO> clientesDTO =  new ContextoCliente()
          .findAll()
          .stream()
          .map(ClienteDTO::new)
          .collect(Collectors.toList());

        String episodioJson = new Gson().toJson(clientesDTO);
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().println(episodioJson);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        new ContextoCliente().insert(new Gson().fromJson(reader, ClienteDTO.class).paraCliente());
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        new ContextoCliente().update(new Gson().fromJson(reader, ClienteDTO.class).paraCliente());
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        ClienteDTO clienteDTO = new Gson().fromJson(reader, ClienteDTO.class);
        new ContextoCliente().remove(clienteDTO.getId());
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        setAccessControlHeaders(resp);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    private void setAccessControlHeaders(HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "GET");
    }


}
