/**
 * Biblioteca - Sistema de Movimentação de Livros
 *
 * Demétrius Jr. (github.com/15demi08)
 *
 */
package biblioteca.controladores;

import biblioteca.modelos.Livro;
import biblioteca.repositorios.Repositorio;
import biblioteca.repositorios.RepositorioLivros;
import biblioteca.utilidades.Console;

/**
 *
 * @author demetrius
 */
public class RelatorioLivrosDisponiveis {

    public static void executar() {
        
        Repositorio<Livro> repLivros = RepositorioLivros.getInstancia();
        
        Console.println("-- Listando Livros Disponíveis Atualmente");
        
        for( int i = 0; i < repLivros.numItens(); i++ ){
            
            Livro l = repLivros.retornar(i);
            
            if( l.isDisponivel() )
                Console.println("-- " + l.getCodigo() + ": " + l.getNome() + "(" + l.getISBN() + ")");
            
        }
        
    }
    
}
