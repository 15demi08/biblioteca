package biblioteca.controladores;

import biblioteca.modelos.Cliente;
import biblioteca.repositorios.Repositorio;
import biblioteca.repositorios.RepositorioClientes;
import biblioteca.utilidades.Console;

/**
 *
 * @author demetrius
 */
public class CadastrarCliente {

    public static void executar() {
        
        Repositorio<Cliente> repClientes = RepositorioClientes.getInstancia();

        Console.println("-- Cadastrando novo cliente");

        String nome, matricula, telefone;

        matricula = Console.readString("-- Matricula:");

        nome = Console.readString("-- Nome:");

        telefone = Console.readString("-- Telefone:");

        repClientes.adicionar(new Cliente(nome, telefone));

        Console.println("Cliente " + nome + "cadastrado com sucesso!");

    }

}
