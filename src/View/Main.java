package View;
import Controller.ConsultaCep;
import Controller.GerarArquivo;
import Model.Endereco;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner leitura = new Scanner(System.in);
        ConsultaCep novaConsulta = new ConsultaCep();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println("Digite o numero do CEP para consultar Endereco:");

        try {
            String busca = "";
            Endereco endereco = novaConsulta.buscaEndereco(leitura.nextLine());
            System.out.println("Formato 1 >> " + endereco);
            GerarArquivo gerador = new GerarArquivo();
            gerador.salvaJson(endereco);
            System.out.println("--------------------------------------------");
            System.out.println("Formato 2 >> " +"\n"+ gson.toJson(endereco));

        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando...");
        }
    }
}