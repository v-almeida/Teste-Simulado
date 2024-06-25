package br.edu.up;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println(
                    "Uso: java br.edu.up.Main <enderecos.csv> <pessoas.csv>");
            System.exit(1);
        }

        String caminhoPessoas = args[0];
        String caminhoEnderecos = args[1];

        try {
            List<Pessoa> pessoas = LeitorDeArquivos.lerPessoas(caminhoPessoas);
            List<Endereco> enderecos = LeitorDeArquivos.lerEnderecos(caminhoEnderecos);

            List<PessoaComEndereco> pessoasComEnderecos = new ArrayList<>();

            for (Pessoa pessoa : pessoas) {
                for (Endereco endereco : enderecos) {
                    if (pessoa.getId() == endereco.getPessoaId()) {
                        pessoasComEnderecos
                                .add(new PessoaComEndereco(pessoa.getNome(), endereco.getRua(), endereco.getCidade()));
                    }
                }
            }

            escreverPessoasComEnderecos(pessoasComEnderecos, "PessoasComEnderecos.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void escreverPessoasComEnderecos(List<PessoaComEndereco> pessoasComEnderecos, String caminho)
            throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(caminho));

        for (PessoaComEndereco pessoaComEndereco : pessoasComEnderecos) {
            writer.write(pessoaComEndereco.toString());
            writer.newLine();
        }

        writer.close();
        System.out.println("Arquivo PessoasComEnderecos.csv gerado com sucesso.");
    }
}
