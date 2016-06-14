package biblioteca.telas;

import biblioteca.DAO.LivroDAODB;
import biblioteca.modelos.Livro;
import biblioteca.utilidades.Console;
import biblioteca.utilidades.OpcoesMenus;
import java.util.ArrayList;

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
                        cadastrarLivro();
                        break;
                    case OpcoesMenus.LIVRO_OP_LISTAR:
                        listarLivros();
                        break;
                    case OpcoesMenus.LIVRO_OP_CONSULTAR:
                        consultarLivroCodigo();
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
            + "-- 4: Voltar";

        Console.println(msg);

    }

    private static void cadastrarLivro() {
        // Cadastrar livros
    }

    private static void listarLivros() {
        
        LivroDAODB lddb = new LivroDAODB();
        
        ArrayList<Livro> livros = lddb.listarTodosLivros();
        
        if( livros == null ){
            
            Console.println("-- Nenhum livro cadastrado!");
            
        } else {
            
            for( Livro l : livros ){
                
                Console.println(l);
                
            }
            
            Console.println("--");
            
        }

    }

    private static void consultarLivroCodigo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
