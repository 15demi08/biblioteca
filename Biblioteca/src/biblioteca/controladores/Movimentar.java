package biblioteca.controladores;

import biblioteca.modelos.Movimentacao;
import biblioteca.repositorios.Repositorio;
import biblioteca.utilidades.Console;

/**
 *
 * @author 631510058
 */
public class Movimentar {
    
    private Repositorio<Movimentacao> repMovs;

    public Movimentar(Repositorio<Movimentacao> repMovs) {
    
        this.repMovs = repMovs;
    
    }

    private void executar() {
        
        Console.println("-- Incluindo Movimentação");
    
    }
    
}
