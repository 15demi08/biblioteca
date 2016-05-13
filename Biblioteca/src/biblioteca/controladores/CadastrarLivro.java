package biblioteca.controladores;

import biblioteca.modelos.Livro;
import biblioteca.repositorios.Repositorio;
import biblioteca.repositorios.RepositorioLivros;
import biblioteca.utilidades.Console;

/**
 *
 * @author demetrius
 */
public class CadastrarLivro {

    public static void executar() {
        
        Repositorio<Livro> repLivros = RepositorioLivros.getInstancia();
        
        Console.println("-- Cadastrando Livro");
        
        String ISBN, nome, autores, editora;
        int anoPublicacao;
        
        ISBN = Console.readString("-- ISBN: ");
        nome = Console.readString("-- Nome: ");
        autores = Console.readString("-- Autor(es): ");
        editora = Console.readString("-- Editora: ");
        anoPublicacao = Console.readInt("-- Ano de Publicação: ");
        
        Livro l = new Livro(ISBN, nome, autores, editora, anoPublicacao);
        
        repLivros.adicionar(l);
        
        Console.println("-- Livro cadastrado com sucesso! Código: " + l.getCodigo() );
        
    }
    
}
