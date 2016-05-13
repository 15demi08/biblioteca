package biblioteca.Telas;

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

        Console.println("--::::::::::::::::::::");
        Console.println("-- Menu Movimentações");
        Console.println("--::::::::::::::::::::");

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

        msg = "-- 1: Retirar Livro(s)\n"
            + "-- 2: Devolver Livro(s)\n"
            + "-- 3: Voltar";

        Console.println(msg);

    }

}
