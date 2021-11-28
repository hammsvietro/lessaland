package br.unisul.aula;

import br.unisul.aula.banco.ContextoCliente;
import br.unisul.aula.dto.ClienteDTO;
import br.unisul.aula.dto.ClientePorEnderecoResponse;
import br.unisul.aula.modelo.UnidadeFederativa;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "EnderecoServlet", value = "/api/endereco")
public class EnderecoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BufferedReader reader = request.getReader();
        ClientePorEnderecoResponse res = new ClientePorEnderecoResponse();

        String cidade = request.getParameter("cidade");
        res.setCidade(cidade);

        UnidadeFederativa uf = new ContextoCliente().getUfByCityName(cidade);

        if(uf != null) {
            res.setUf(uf.toString());
            new ContextoCliente()
                    .findClientsByCity(cidade)
                    .forEach(cliente -> res.addClientes( new ClienteDTO(cliente) ));
        }


        response.setContentType("application/json; charset=utf-8");
        response.getWriter().println(new Gson().toJson(res));
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
