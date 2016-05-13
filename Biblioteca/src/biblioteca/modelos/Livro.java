/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.modelos;

/**
 *
 * @author 631510058
 */
public class Livro {

    private static int proximoCodigo = 1;

    private String ISBN, nome, autores, editora;
    private int codigo, anoPublicacao;
    private boolean disponivel;

    public Livro(String ISBN, String nome, String autores, String editora, int anoPublicacao) {
        this.ISBN = ISBN;
        this.nome = nome;
        this.autores = autores;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
        this.disponivel = true;
        codigo = proximoCodigo;
        proximoCodigo++;
    }

    public void movimentar(boolean status) {
        this.disponivel = status;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getNome() {
        return nome;
    }

    public String getAutores() {
        return autores;
    }

    public String getEditora() {
        return editora;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    @Override
    public String toString() {
        String msg;

        msg = "-- " + codigo + ": " + nome + " (" + anoPublicacao + ", " + editora + ")\n"
            + "-- ISBN: " + ISBN + "\n"
            + "-- Autor(es): " + autores + "\n"
            + "-- Disponível: " + (isDisponivel() ? "Sim" : "Não");

        return msg;
    }

}
