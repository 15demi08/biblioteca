package biblioteca.telas;

import biblioteca.DAO.ClienteDAODB;
import biblioteca.modelos.Cliente;
import biblioteca.utilidades.Console;
import biblioteca.utilidades.OpcoesMenus;
import java.util.ArrayList;

/**
 *
 * @author demetrius
 */
public class TelaClientes {

    public static void executar() {

        boolean sair = false;

        do {

            menu();

            try {

                int opcao = Integer.parseInt(Console.readString("Opção: "));

                switch (opcao) {

                    case OpcoesMenus.CLIENTE_OP_CADASTRAR:
                        cadastrarCliente();
                        break;
                    case OpcoesMenus.CLIENTE_OP_LISTAR:
                        listarClientes();
                        break;
                    case OpcoesMenus.CLIENTE_OP_LISTAR_POR_MATRICULA:
                        consultarCliente();
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

        // Nota: Atualizar menu e métodos correspondentes para as opções
        // de atualizar e excluir (desativar) um cliente
        
        String msg;
        
        msg = "--::::::::::\n"
            + "-- Clientes\n"
            + "--::::::::::\n"
            + "-- 1: Cadastrar Cliente\n"
            + "-- 2: Listar Clientes\n"
            + "-- 3: Pesquisar Cliente por Matrícula\n"
            + "-- 4: Voltar";

        Console.println(msg);
    }

    private static void cadastrarCliente() {
        Console.println("-- Usuario digita dados.\n"
                      + "-- Este método cria um objeto Cliente com os dados digitados\n"
                      + "-- e chama ClienteDAODB.inserir() passando o objeto");
    }

    private static void listarClientes() {
        
        ClienteDAODB cddb = new ClienteDAODB();
        
        ArrayList<Cliente> clientes = cddb.listarTodosClientes();
        
        if( clientes == null ){
            
            Console.println("-- Nenhum cliente cadastrado!");
            
        } else {
            
            for( Cliente c : clientes ){
                Console.println(c);
            }
            
            Console.println("--");
            
        }
        
    }

    private static void consultarCliente() {
        Console.println("-- Pede que o usuário digite um id e\n"
                      + "-- e chama ClienteDAODB.obter() passando o id digitado");
    }

}
