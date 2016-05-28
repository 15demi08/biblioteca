package biblioteca;

import biblioteca.telas.TelaClientes;
import biblioteca.modelos.Cliente;
import biblioteca.utilidades.Console;
import biblioteca.utilidades.OpcoesMenus;

/**
 * Classe principal do Sistema
 * @author Demétrius Jr.
 */
public class Biblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Console.println("--============--");
        Console.println("-- Biblioteca --");
        Console.println("--============--");

        boolean sair = false;

        do {

            try {

                menuPrincipal();

                int opcao = Integer.parseInt(Console.readString("Opção: "));

                switch (opcao) {

                    //Opção:
                    case OpcoesMenus.OP_CLIENTES:
                        TelaClientes.executar();
                        break;
                    case OpcoesMenus.OP_SAIR:
                        sair = true;
                        break;
                    default:
                        Console.println("Opção Inválida!");
                        break;

                }

            } catch (NumberFormatException e) {
                Console.println("Apenas números!");
            }

        } while (!sair);

    }

    private static void menuPrincipal() {

        String msg;
        
        msg = "--::::::::::::::::\n"
            + "-- Menu Principal\n"
            + "--::::::::::::::::\n"
            + "-- Selecione uma opção:\n"
            + "-- 1: Clientes\n"
            + "-- 5: Sair";

        Console.println(msg);
    }

}
