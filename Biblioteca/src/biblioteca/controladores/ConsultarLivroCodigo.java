/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class ConsultarLivroCodigo {
    
    public static void executar() {
        
        Console.println("-- Consultando pelo código");
        
        int codigo = Console.readInt("Código: ");
        
        Livro l = pesquisaLivroPorCodigo(codigo);
        
        if( l == null ){
            
            Console.println("-- Livro não encontrado!");
            
        } else {
        
            Console.println(l);
        
        }
        
    }
    
    private static Livro pesquisaLivroPorCodigo( int codigo ){
        
        Repositorio<Livro> repLivros = RepositorioLivros.getInstancia();
        
        for( int i = 0; i < repLivros.numItens(); i++ ){
            
            Livro l = repLivros.retornar(i);
            
            if(l.getCodigo() == codigo)
                return l;
            
        }
        
        return null;
        
    }
    
}
