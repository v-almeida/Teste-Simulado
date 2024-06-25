package br.edu.up;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class LeitorDeArquivos {

    public static List<Pessoa> lerPessoas(String caminho) throws IOException {
        List<Pessoa> pessoas = new ArrayList<>();
        List<String> linhas = Files.readAllLines(Paths.get(caminho));

        for (String linha : linhas) {
            String[] partes = linha.split(";");
            int id = Integer.parseInt(partes[0]);
            String nome = partes[1];
            pessoas.add(new Pessoa(id, nome));
        }

        return pessoas;
    }

    public static List<Endereco> lerEnderecos(String caminho) throws IOException {
        List<Endereco> enderecos = new ArrayList<>();
        List<String> linhas = Files.readAllLines(Paths.get(caminho));

        for (String linha : linhas) {
            String[] partes = linha.split(";");
            String rua = partes[0];
            String cidade = partes[1];
            int pessoaId = Integer.parseInt(partes[2]);
            enderecos.add(new Endereco(rua, cidade, pessoaId));
        }

        return enderecos;
    }
}
