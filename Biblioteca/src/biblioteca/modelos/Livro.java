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

    private String ISBN, nome, autores, editora;
    private int id = null, anoPublicacao;
    private boolean disponivel = null;

	/**
	 * Cria um novo livro com os dados especificados
	 */
    public Livro(int id, String ISBN, String nome, String autores, String editora, int anoPublicacao, boolean disponivel) {
		
        this.id = id;
		this.disponivel = disponivel;
		Livro(ISBN, nome, autores, editora, anoPublicacao);
		
    }
	
	/**
	 * Cria um livro sem id, para inserção no banco
	 */
	public Livro(String ISBN, String nome, String autores, String editora, int anoPublicacao) {
		
        this.ISBN = ISBN;
        this.nome = nome;
        this.autores = autores;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
		
		if(this.disponivel == null)
			this.disponivel = true;
		
    }
	
	public int getId(){
		return id;
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

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    @Override
    public String toString() {
        String msg;

        msg = "-- " + id + ": " + nome + " (" + anoPublicacao + ", " + editora + ")\n"
            + "-- ISBN: " + ISBN + "\n"
            + "-- Autor(es): " + autores + "\n"
            + "-- Disponível: " + (isDisponivel() ? "Sim" : "Não");

        return msg;
    }

}
