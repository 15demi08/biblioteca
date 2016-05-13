package biblioteca.telas;

import biblioteca.controladores.DevolverLivro;
import biblioteca.controladores.RetirarLivro;
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
                        RetirarLivro.executar();
                        break;
                    case OpcoesMenus.MOV_OP_DEVOLVER:
                        DevolverLivro.executar();
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

}
