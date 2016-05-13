package biblioteca.Telas;

import biblioteca.controladores.CadastrarCliente;
import biblioteca.controladores.ListarClienteMatricula;
import biblioteca.repositorios.RepositorioClientes;
import biblioteca.utilidades.Console;
import biblioteca.utilidades.OpcoesMenus;

/**
 *
 * @author demetrius
 */
public class TelaClientes {

    public static void executar() {

        Console.println("--:::::::::::::::");
        Console.println("-- Menu Clientes");
        Console.println("--:::::::::::::::");

        boolean sair = false;

        do {

            menu();

            try {

                int opcao = Integer.parseInt(Console.readString("Opção: "));

                switch (opcao) {

                    case OpcoesMenus.CLIENTE_OP_CADASTRAR:
                        CadastrarCliente.executar();
                        break;
                    case OpcoesMenus.CLIENTE_OP_LISTAR:
                        Console.println("-- Listando Itens do Repositório de Clientes");
                        RepositorioClientes.getInstancia().listarItens();
                        break;
                    case OpcoesMenus.CLIENTE_OP_LISTAR_POR_MATRICULA:
                        ListarClienteMatricula.executar();
                        break;
                    case OpcoesMenus.CLIENTE_OP_VOLTAR:
                        sair = true;
                        break;
                    default:
                        Console.println("Opção Inválida!");
                        break;

                }

            } catch (NumberFormatException e) {

                Console.println("Apenas números!");
                sair = false;

            }

        } while (!sair);

    }

    private static void menu() {

        String msg;

        msg = "-- 1: Cadastrar Cliente\n"
                + "-- 2: Listar Clientes\n"
                + "-- 3: Pesquisar Cliente por Matrícula\n"
                + "-- 4: Voltar\n";

        Console.println(msg);
    }

}
