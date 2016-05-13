package biblioteca.telas;

import biblioteca.controladores.CadastrarLivro;
import biblioteca.controladores.ConsultarLivroCodigo;
import biblioteca.repositorios.RepositorioLivros;
import biblioteca.utilidades.Console;
import biblioteca.utilidades.OpcoesMenus;

/**
 *
 * @author demetrius
 */
public class TelaLivros {

    public static void executar() {

        boolean sair = false;

        do {

            menu();

            try {

                int opcao = Integer.parseInt(Console.readString("Opção: "));

                switch (opcao) {

                    case OpcoesMenus.LIVRO_OP_CADASTRAR:
                        CadastrarLivro.executar();
                        break;
                    case OpcoesMenus.LIVRO_OP_LISTAR:
                        Console.println("-- Listando Itens do Repositório de Livros");
                        RepositorioLivros.getInstancia().listarItens();
                        break;
                    case OpcoesMenus.LIVRO_OP_CONSULTAR:
                        ConsultarLivroCodigo.executar();
                        break;
                    case OpcoesMenus.LIVRO_OP_VOLTAR:
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
        
        msg = "--::::::::\n"
            + "-- Livros\n"
            + "--::::::::\n"
            + "-- 1: Cadastrar\n"
            + "-- 2: Listar\n"
            + "-- 3: Consultar\n"
            + "-- 4: Voltar\n";

        Console.println(msg);

    }

}
