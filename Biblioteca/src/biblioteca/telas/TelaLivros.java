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
                    case OpcoesMenus.LIVRO_OP_SELECIONAR:
                        selecionarLivro();
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
    
    public static void executarSub( Livro livro ) {

        boolean sair = false;

        do {

            subMenu( livro );

            try {

                int opcao = Integer.parseInt(Console.readString("Opção: "));

                switch (opcao) {

                    case OpcoesMenus.LIVRO_SUB_EDITAR:
                        editarLivro( livro );
                        break;
                    case OpcoesMenus.LIVRO_SUB_EXCLUIR:
                        excluirLivro( livro );
                        break;
                    case OpcoesMenus.LIVRO_SUB_VOLTAR:
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
    
    private static void subMenu( Livro livro ) {

        String msg;
        
        Console.println( livro.getId() + " - " + livro.getNome() );
        
        msg = "---::::::::::::::::::\n"
            + "--- 1: Editar\n"
            + "--- 2: Excluir\n"
            + "--- 3: Voltar";

        Console.println(msg);

    }

    private static void cadastrarLivro() {
        
        LivroDAODB lddb = new LivroDAODB();
        
        Console.println("-- Cadastrando novo livro.");
        
        String ISBN, nome, autores, editora, anoPublicacao;
        
        ISBN = Console.readString("-- ISBN: ");
        nome = Console.readLine("-- Nome: ");
        autores = Console.readLine("-- Autores: ");
        editora = Console.readLine("-- Editora: ");
        anoPublicacao = Console.readString("-- Ano de Publicação: ");
        
        if( ISBN.isEmpty() || nome.isEmpty() || autores.isEmpty() || editora.isEmpty() || anoPublicacao.isEmpty() ){
            
            Console.println("-- Nenhum campo pode ficar vazio!");
            
        } else if( lddb.verificarISBN( ISBN ) ){
            
            Console.println("-- ISBN informado já existe!");
            
        } else {
            
            try {
                
                int anoValor = Integer.parseInt(anoPublicacao);
                
                Livro livro = new Livro(ISBN, nome, autores, editora, anoValor);
                
                int id = lddb.inserir(livro);
                
                Console.println("--- Livro " + livro.getNome() + " cadastrado com sucesso! ID: " + id);
                
            } catch ( NumberFormatException e ){
                
                Console.println("-- Ano pode conter apenas números!");
                
            }
            
        }
        
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

    private static void selecionarLivro() {
        
        LivroDAODB lddb = new LivroDAODB();
        
        try {
            
            int id = Integer.parseInt(Console.readString("-- Id do Livro: "));
            
            Livro livro = lddb.obter(id);
            
            if( livro == null ){
                
                Console.println("-- Livro não encontrado!");
                
            } else {
                
                executarSub(livro);
                
            }
            
        } catch (NumberFormatException e) {
            
            Console.println("-- Apenas números!");
            
        }
        
        Console.println("--");
        
    }

    private static void editarLivro(Livro livro) {

        

    }

    private static void excluirLivro(Livro livro) {
    
        LivroDAODB cddb = new LivroDAODB();
        
        String opcao = Console.readString("--- Esta operação é permanente. Continuar? (s/n)");
        
        switch( opcao ){
            
            case "s":
                
                if( cddb.deletar(livro.getId()) )
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

}
