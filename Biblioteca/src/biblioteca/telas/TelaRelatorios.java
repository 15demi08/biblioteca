package biblioteca.telas;

import biblioteca.controladores.RelatorioUltimaDevolucao;
import biblioteca.controladores.RelatorioUltimaRetirada;
import biblioteca.controladores.RelatorioUltimaRetiradaCliente;
import biblioteca.controladores.RelatorioLivrosIndisponiveis;
import biblioteca.controladores.RelatorioLivrosDisponiveis;
import biblioteca.utilidades.Console;
import biblioteca.utilidades.OpcoesMenus;

/**
 *
 * @author demetrius
 */
public class TelaRelatorios {
    
    public static void executar() {
        
        boolean sair = false;
        
        do{
            
            menu();
            
            try{
                
                int opcao = Integer.parseInt(Console.readString("Opção: S"));
                
                switch(opcao){
                    
                    case OpcoesMenus.REL_OP_LIVROS_DISP:
                        RelatorioLivrosDisponiveis.executar();
                        break;
                    case OpcoesMenus.REL_OP_LIVROS_INDISP:
                        RelatorioLivrosIndisponiveis.executar();
                        break;
                    case OpcoesMenus.REL_OP_CLIENTE_ULT_RETIR:
                        RelatorioUltimaRetiradaCliente.executar();
                        break;
                    case OpcoesMenus.REL_OP_ULT_RETIR:
                        RelatorioUltimaRetirada.executar();
                        break;
                    case OpcoesMenus.REL_OP_ULT_DEV:
                        RelatorioUltimaDevolucao.executar();
                        break;
                    case OpcoesMenus.REL_OP_VOLTAR:
                        sair = true;
                        break;
                    default:
                        Console.println("Opção Inválida");
                    
                }
                
            } catch( NumberFormatException e ){
                Console.println("Apenas Números!");
            }
            
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
