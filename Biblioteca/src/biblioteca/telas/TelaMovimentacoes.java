package biblioteca.telas;

import biblioteca.modelos.Movimentacao;
import biblioteca.utilidades.Console;
import biblioteca.utilidades.OpcoesMenus;

/**
 *
 * @author demetrius
 */
public class TelaMovimentacoes {

    public static void executar() {

        boolean sair = false;

        do {

            menu();

            try {

                int opcao = Integer.parseInt(Console.readString("Opção: "));

                switch (opcao) {

                    case OpcoesMenus.MOV_OP_RETIRAR:
                        retirar();
                        break;
                    case OpcoesMenus.MOV_OP_DEVOLVER:
                        devolver();
                        break;
                    case OpcoesMenus.MOV_OP_CONSULTAR:
                        consultarMovimentacao();
                        break;
                    case OpcoesMenus.MOV_OP_SELECIONAR:
                        selecionarMovimentacao();
                        break;
                    case OpcoesMenus.MOV_OP_VOLTAR:
                        sair = true;
                        break;
                    default:
                        Console.println("Opção Inválida!");
                        break;

                }

            } catch (NumberFormatException e) {
                Console.println("Apenas Números!");
            }

        } while (!sair);

    }
    
    public static void executarSub( Movimentacao movimentacao ) {

        boolean sair = false;

        do {

            subMenu( movimentacao );

            try {

                int opcao = Integer.parseInt(Console.readString("Opção: "));

                switch (opcao) {

                    case OpcoesMenus.MOV_SUB_DEVOLVER_TODOS:
                        devolverTodos( movimentacao );
                        break;
                    case OpcoesMenus.MOV_SUB_VERIFICAR_PENDENTES:
                        verificarPendentes( movimentacao );
                        break;
                    case OpcoesMenus.MOV_SUB_VOLTAR:
                        sair = true;
                        break;
                    default:
                        Console.println("Opção Inválida!");
                        break;

                }

            } catch (NumberFormatException e) {
                Console.println("Apenas Números!");
            }

        } while (!sair);

    }

    private static void menu() {
        
        String msg;

        msg = "--:::::::::::::::\n"
            + "-- Movimentações\n"
            + "--:::::::::::::::\n"
            + "-- 1: Retirar Livro(s)\n"
            + "-- 2: Devolver Livro(s)\n"
            + "-- 3: Voltar";

        Console.println(msg);

    }
    
    private static void subMenu(Movimentacao movimentacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void retirar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void devolver() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void consultarMovimentacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void selecionarMovimentacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void devolverTodos(Movimentacao movimentacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void verificarPendentes(Movimentacao movimentacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}
