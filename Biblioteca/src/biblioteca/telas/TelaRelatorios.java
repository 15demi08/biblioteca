package biblioteca.telas;

import biblioteca.utilidades.Console;

/**
 *
 * @author demetrius
 */
public class TelaRelatorios {
    
    public static void executar() {
        
        boolean sair = false;
        
        do{
            
            
            
        } while (!sair);
        
    }
    
    private static void menu(){
        
        String msg;
        
        msg = "--::::::::::::\n"
            + "-- Relatórios\n"
            + "--::::::::::::\n"
            + "-- 1: Livros Disponíveis\n"
            + "-- 2: Livros Indisponíveis\n"
            + "-- 3: Ultima retirada do Cliente\n"
            + "-- 4: Última Retirada\n"
            + "-- 5: Última Devolução\n"
            + "-- 6: Voltar";
        
        Console.println(msg);
        
    }
    
    
    
}
