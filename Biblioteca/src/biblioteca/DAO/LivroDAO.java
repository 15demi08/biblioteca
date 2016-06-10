/**
 * Biblioteca - Sistema de Movimentação de Livros
 *
 * Demétrius Jr. (github.com/15demi08)
 *
 */
package biblioteca.DAO;

import biblioteca.modelos.Livro;
import java.util.ArrayList;

/**
 *
 * @author demetrius
 */
public interface LivroDAO extends DAO<Livro> {
    
    /**
     * Retorna todos os Livros do banco
     * @return
     */
    ArrayList<Livro> listarTodosLivros();

    @Override
    public boolean atualizar(Livro obj);

    @Override
    public boolean deletar(int id);

    @Override
    public int inserir(Livro obj);

    @Override
    public Livro obter(int id);
    
    
    
}
