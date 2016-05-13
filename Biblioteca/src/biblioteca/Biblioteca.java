package biblioteca;

import biblioteca.telas.TelaMovimentacoes;
import biblioteca.telas.TelaLivros;
import biblioteca.telas.TelaClientes;
import biblioteca.telas.TelaRelatorios;
import biblioteca.modelos.Cliente;
import biblioteca.modelos.Livro;
import biblioteca.modelos.Movimentacao;
import biblioteca.repositorios.Repositorio;
import biblioteca.repositorios.RepositorioClientes;
import biblioteca.repositorios.RepositorioLivros;
import biblioteca.repositorios.RepositorioMovimentacoes;
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

        // Repositórios
        Repositorio<Cliente> repClientes = RepositorioClientes.getInstancia();
        Repositorio<Livro> repLivros = RepositorioLivros.getInstancia();
        Repositorio<Movimentacao> repMovs = RepositorioMovimentacoes.getInstancia();

        repClientes.adicionar(new Cliente("André", "(51)0000-0000"));
        repClientes.adicionar(new Cliente("Bernardo", "(51)0000-0000"));
        repClientes.adicionar(new Cliente("Carlos", "(51)0000-0000"));

        repLivros.adicionar(new Livro("0123456789123", "Harry Potter e a Pedra Filosofal", "J.K. Rowling", "Abril", 2000));
        repLivros.adicionar(new Livro("1234567891230", "Star Wars - Episódio 1: A Ameaça Fantasma", "George Lucas", "Genérica", 1970));
        repLivros.adicionar(new Livro("2345678912301", "O Pequeno Prícipe", "Antoine de Saint-Exupéry", "Abril", 1943));
        repLivros.adicionar(new Livro("3456789123012", "Assassin's Creed: Renascença", "Oliver Bowden", "Teste", 2011));

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
                    case OpcoesMenus.OP_LIVROS:
                        TelaLivros.executar();
                        break;
                    case OpcoesMenus.OP_MOVIMENTACOES:
                        TelaMovimentacoes.executar();
                        break;
                    case OpcoesMenus.OP_RELATORIOS:
                        TelaRelatorios.executar();
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
            + "-- 2: Livros\n"
            + "-- 3: Movimentações\n"
            + "-- 4: Relatórios\n"
            + "-- 5: Sair";

        Console.println(msg);
    }

}
