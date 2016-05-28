/**
 * Biblioteca - Sistema de Movimentação de Livros
 *
 * Demétrius Jr. (github.com/15demi08)
 *
 */
package biblioteca.DAO;

/**
 *
 * @author demetrius
 * @param <T>
 */
public interface DAO<T> {
    
    T obter( int id );
    
    boolean inserir( T obj );
    
    boolean deletar( int id );
    
    boolean atualizar( T obj );
    
}
