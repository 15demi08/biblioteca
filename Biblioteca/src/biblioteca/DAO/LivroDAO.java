/**
 * Biblioteca - Sistema de Movimentação de Livros
 *
 * Demétrius Jr. (github.com/15demi08)
 */
package biblioteca.DAO;

import biblioteca.modelos.Livro;
import java.util.ArrayList;

/**
 * DAO para manipulação de livros
 * @author demetrius
 */
public interface LivroDAO extends DAO<Livro> {

    @Override
    public boolean atualizar(Livro obj);

    @Override
    public boolean deletar(int id);

    @Override
    public int inserir(Livro obj);

    @Override
    public Livro obter(int id);
    
    /**
     * Retorna todos os Livros do banco
     * @return ArrayList com os livros cadastrados na base de dados atualmente
     */
    ArrayList<Livro> listarTodosLivros();
    
    /**
     * Consulta os livros atualmente "excluídos" (desativados) na base
     * @return ArrayList de livros ou null
     */
    ArrayList<Livro> consultaExcluidos();
    
    /**
     * Consulta os livros atualmente disponiveis para retirada
     * @return ArrayList de livros ou null
     */
    ArrayList<Livro> consultaDisponiveis();
    
}
