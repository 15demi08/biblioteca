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

        Console.println("--- Movimentação nº " + movimentacao.getId());
        
        String msg;

        msg = "--:::::::::::::::\n"
            + "-- 1: Devolver todos os livros\n"
            + "-- 2: Verificar livros pendentes\n"
            + "-- 3: Voltar";

        Console.println(msg);

    }

    private static void retirar() {
        
        /*
        
        Fluxo da Retirada:
        
        1 - Escolher Cliente
        2 - Se cliente já tiver o número máximo de retiradas pendentes, mostrar mensagem. Se não, continuar
        3 - Receber os livros da retirada, verificar disponibilidade para cada um
        4 - Movimentá-los (atualizá-los) no banco de dados
        5 - Inserir a movimentação na tabela correspondente.
        6 - Inserir os livros na tabela movlivro
        
        */
        
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
