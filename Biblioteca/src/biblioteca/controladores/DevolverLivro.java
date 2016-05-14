package biblioteca.controladores;

import biblioteca.modelos.Cliente;
import biblioteca.modelos.Livro;
import biblioteca.modelos.Movimentacao;
import biblioteca.repositorios.Repositorio;
import biblioteca.repositorios.RepositorioLivros;
import biblioteca.repositorios.RepositorioMovimentacoes;
import biblioteca.utilidades.Console;

/**
 *
 * @author Demétrius Jr.
 */
public class DevolverLivro {
    
    public static void executar() {
        
        Repositorio<Movimentacao> repMovs = RepositorioMovimentacoes.getInstancia();
        
        Console.println("-- Devolver Livros");
        int codMov;
        
        boolean testeP = false;
        
        do {
            
            Movimentacao m = solicitaMovimentacao();
            
            if( m == null ){
                
                Console.println("-- Movimentação não encontrada!");
                
                switch(Console.readString("-- Continuar? (s/n)")){
                    case "s":
                        break;
                    case "n":
                        testeP = true;
                        break;
                }
                
            } else {
                
                Console.println("-- Movimentação encontrada:");
                Console.println(m);
                
                boolean testeL = false;
                
                do {
                    
                    Livro l = solicitaLivro();
                    
                    if( l == null ){
                        
                        Console.println("-- Livro não existe!");
                        
                    } else if( !m.getLivros().contains(l) ){
                        
                        Console.println("-- Livro não está presente nesta movimentação!");
                    
                    } else if( l.isDisponivel() ) {
                        
                        Console.println("-- Livro já foi devolvido!");
                    
                    } else {
                        
                        l.movimentar(Livro.STATUS_DISPONIVEL);
                        
                        if( m.verificarTodosDevolvidos() ){
                            
                            Console.println("-- Todos os livros foram devolvidos!");
                            
                            testeL = true;
                            testeP = true;
                            
                        } else {
                            
                            switch(Console.readString("-- Ainda há livros a devolver! Continuar? (s/n)")){
                                case "s":
                                    break;
                                case "n":
                                    testeL = true;
                                    break;
                            }
                            
                        }
                        
                    }
                    
                } while (!testeL);
                
            }
            
        } while (!testeP);
        
    }
    
    private static Livro solicitaLivro() {

        Repositorio<Livro> repLivros = RepositorioLivros.getInstancia();

        int codigoLivro = Console.readInt("-- Código do Livro:");

        for (int i = 0; i < repLivros.numItens(); i++) {

            Livro l = repLivros.retornar(i);

            if (l.getCodigo() == codigoLivro) {
                return l;
            }

        }

        return null;

    }
    
    private static Movimentacao solicitaMovimentacao(){
        
        Repositorio<Movimentacao> repMovs = RepositorioMovimentacoes.getInstancia();
        int codMov;
        boolean teste = false;
        
        do {
            
            try {
                codMov = Integer.parseInt(Console.readString("-- Código da Movimentação: "));
                for( int i = 0; i < repMovs.numItens(); i++ ){

                    Movimentacao m = repMovs.retornar(i);

                    if( m.getCodigo() == codMov )
                        return m;

                }

            } catch (NumberFormatException e) {
                Console.println("Apenas Números!");
            }
            
        } while( !teste );
        
        return null;
    }
    
}
