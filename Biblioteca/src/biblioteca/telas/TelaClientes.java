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

    /**
     * Execução do menu principal
     */
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
                    case OpcoesMenus.CLIENTE_OP_SELECIONAR:
                        consultarCliente();
                        break;
                    case OpcoesMenus.CLIENTE_OP_LISTAR_EXCLUIDOS:
                        listarClientesExcluidos();
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
    
    /**
     * Execução do sub-menu para o cliente especificado
     * @param cliente 
     */
    private static void executarSub(Cliente cliente) {

        boolean sair = false;

        do {

            subMenu(cliente);

            try {

                int opcao = Integer.parseInt(Console.readString("Opção: "));

                switch (opcao) {

                    case OpcoesMenus.CLIENTE_SUB_EDITAR:
                        editarCliente( cliente );
                        break;
                    case OpcoesMenus.CLIENTE_SUB_EXCLUIR:
                        excluirCliente( cliente );
                        break;
                    case OpcoesMenus.CLIENTE_SUB_VER_ANDAMENTO:
                        verPendencias( cliente );
                        break;
                    case OpcoesMenus.CLIENTE_SUB_VOLTAR:
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

    /**
     * Menu Principal
     */
    private static void menu() {

        String msg;
        
        msg = "--::::::::::\n"
            + "-- Clientes\n"
            + "--::::::::::\n"
            + "-- 1: Cadastrar Cliente\n"
            + "-- 2: Listar Clientes\n"
            + "-- 3: Selecionar Cliente\n"
            + "-- 4: Listar Clientes Excluídos\n"
            + "-- 5: Voltar";

        Console.println(msg);
    }
    
    /**
     * Sub-Menu
     * @param cliente 
     */
    private static void subMenu( Cliente cliente ) {
        
        Console.println("--- " + cliente.getId() + " - " + cliente.getNome() );

        String msg;
        
        msg = "---::::::::::::::::::::::::::::\n"
            + "--- 1: Editar\n"
            + "--- 2: Excluir Cliente\n"
            + "--- 3: Ver retiradas pendentes\n"
            + "--- 4: Voltar";

        Console.println(msg);
    }

    /**
     * Procedimento para cadastrar um cliente
     */
    private static void cadastrarCliente() {
        
        ClienteDAODB cddb = new ClienteDAODB();
        
        Console.println("-- Cadastrando cliente");
        
        String cpf, nome, telefone;
        
        cpf = Console.readString("-- CPF: ");
        nome = Console.readString("-- Nome: ");
        telefone = Console.readString("-- Telefone: ");
        
        if( cpf.isEmpty() || nome.isEmpty() || telefone.isEmpty() ){
            
            Console.println("-- Nenhum campo pode ficar vazio!");
            
        } else if( cddb.verificarCPF(cpf) ){
            
            Console.println("-- CPF informado já existe!");
            
        } else {
        
            Cliente cliente = new Cliente(nome, telefone, cpf);

            int id = cddb.inserir(cliente);

            Console.println("-- Cliente " + cliente.getNome() + " cadastrado com sucesso! ID: " + id );
        
        }
        
        Console.println("--");
        
    }

    /**
     * Lista todos os clientes atualmente cadastrados na base
     */
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

    /**
     * Consulta um cliente pelo seu id e, com ele, inicia a sub-rotina,
     * chamando o método executarSub(), passando o cliente encontrado.
     */
    private static void consultarCliente() {
        
        ClienteDAODB cddb = new ClienteDAODB();
        
        try {
            
            int id = Integer.parseInt(Console.readString("-- Id do Cliente: "));
            
            Cliente cliente = cddb.obter(id);
            
            if( cliente == null ){
                
                Console.println("-- Cliente não encontrado!");
                
            } else {
                
                executarSub(cliente);
                
            }
            
        } catch (NumberFormatException e) {
            
            Console.println("-- Apenas números!");
            
        }
        
        Console.println("--");
        
    }
    
    private static void listarClientesExcluidos() {
        
        ClienteDAODB cddb = new ClienteDAODB();
        
        ArrayList<Cliente> clientes = cddb.listarExcluidos();
        
        if( clientes == null ){
            
            Console.println("-- Nenhum cliente excluido!");
            
        } else {
            
            for( Cliente c : clientes ){
                Console.println(c);
            }
            
            Console.println("--");
            
        }

    }

    private static void editarCliente(Cliente cliente) {
        
        Console.println("--- Editando cliente " + cliente.getId() + ": " + cliente.getNome());
        
        ClienteDAODB cddb = new ClienteDAODB();
        
        Console.println("--- Insira os novos dados.");
        
        String cpf, nome, telefone;
        
        cpf = Console.readString("--- CPF: ");
        nome = Console.readString("--- Nome: ");
        telefone = Console.readString("--- Telefone: ");
        
        if( cpf.isEmpty() || nome.isEmpty() || telefone.isEmpty() ){
            
            Console.println("--- Nenhum campo pode ficar vazio!");
            
        } else if( cddb.verificarCPF(cpf) ){
            
            Console.println("--- CPF informado já existe!");
            
        } else {
        
            cliente.setCpf(cpf);
            cliente.setNome(nome);
            cliente.setTelefone(telefone);

            if( cddb.atualizar(cliente) ){

                Console.println("-- Cliente " + cliente.getNome() + " atualizado com sucesso!" );
            
            } else {
                
                Console.println("--- Erro ao atualizar cliente!");
                
            }
        
        }
        
        Console.println("--");
        

    }

    private static void excluirCliente(Cliente cliente) {

        ClienteDAODB cddb = new ClienteDAODB();
        
        String opcao = Console.readString("--- Esta operação é permanente. Continuar? (s/n)");
        
        switch( opcao ){
            
            case "s":
                
                if( cddb.deletar(cliente.getId()) )
                    Console.println("--- Excluído com sucesso.");
                else
                    Console.println("--- Erro ao exluir!");
                
                break;
            case "n":
                Console.println("--- Exlusão cancelada.");
                break;
            default:
                Console.println("--- Opção Inválida!");
                break;
        }
        
        Console.println("--");

    }

    private static void verPendencias(Cliente cliente) {
        
        Console.println("-- Verificando retiradas pendentes para " + cliente.getNome());

    }

}
