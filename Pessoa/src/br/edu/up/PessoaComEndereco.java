package br.edu.up;

public class PessoaComEndereco {
    private String nome;
    private String rua;
    private String cidade;

    public PessoaComEndereco(String nome, String rua, String cidade) {
        this.nome = nome;
        this.rua = rua;
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return nome + ";" + rua + ";" + cidade;
    }
}
