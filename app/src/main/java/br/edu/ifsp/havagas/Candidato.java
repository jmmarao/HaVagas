package br.edu.ifsp.havagas;

public class Candidato {
    private String nome;
    private String email;
    private String tipoTelefone;
    private String telefone;
    private String genero;
    private String dataNasc;
    private String vagasDeInteresse;

    public Candidato(String nome, String email, String tipoTelefone, String telefone, String genero, String dataNasc, String vagasDeInteresse) {
        this.nome = nome;
        this.email = email;
        this.tipoTelefone = tipoTelefone;
        this.telefone = telefone;
        this.genero = genero;
        this.dataNasc = dataNasc;
        this.vagasDeInteresse = vagasDeInteresse;
    }

    @Override
    public String toString() {
        return "Nome completo: " + nome +
                "\n\tEmail: " + email +
                "\n\tTipo de telefone: " + tipoTelefone +
                "\n\t\t" + telefone +
                "\n\tGênero: " + genero +
                "\n\tData de nascimento: " + dataNasc +
                "\n\tVagas de Interesse: " + vagasDeInteresse +
                "\n---------------------------------------";
    }
}
