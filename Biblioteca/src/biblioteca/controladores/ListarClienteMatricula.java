package biblioteca.controladores;

import biblioteca.modelos.Cliente;
import biblioteca.repositorios.Repositorio;
import biblioteca.repositorios.RepositorioClientes;
import biblioteca.utilidades.Console;

/**
 *
 * @author demetrius
 */
public class ListarClienteMatricula {
    
    public static void executar() {
        
        Console.println("-- Listando Cliente pela sua Matrícula");
        
        String matricula = Console.readString("Matrícula: ");
        
        Cliente c = pesquisaClientePorMatricula(matricula);
        
        if( c == null ){
            
            Console.println("Cliente não encontrado!");
            
        } else {
            
            Console.println("Cliente encontrado: " + c);
            
        }
        
    }
    
    private static Cliente pesquisaClientePorMatricula( String matricula ){
        
        Repositorio<Cliente> repClientes = RepositorioClientes.getInstancia();
        
        int matriculaValor = Integer.parseInt(matricula);
        
        for( int i = 0; i < repClientes.numItens(); i++ ){
            
           Cliente c = repClientes.retornar(i);
           
           if( c.getMatricula() == matriculaValor )
               return c;
            
        }
        
        return null;
        
    }
    
}
