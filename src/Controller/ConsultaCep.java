package Controller;

import Model.Endereco;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCep {

    //Metodo para devolver endereco
    public Endereco buscaEndereco (String cep) {

        URI endereco = URI.create("http://viacep.com.br/ws/" + cep + "/json/");
        //Fazer requisicao pelo endereco no servidor
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();
        //Bloco supervisionado - Resposta da requisicao em Json
        try {
            //Instancia de um client
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            //bibliotece GSON - Converte JSON para um Objeto Endereco
            return new Gson().fromJson(response.body(), Endereco.class);
        } catch (Exception e) {
            throw new RuntimeException(" Nao foi possivel realizar a busca com esse CEP");
        }
    }
}