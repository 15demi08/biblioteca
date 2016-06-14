/**
 * Biblioteca - Sistema de Movimentação de Livros
 *
 * Demétrius Jr. (github.com/15demi08)
 */
package biblioteca.DAO;

/**
 * Data Access Object - DAO
 * 
 * Representa um meio para acesso a objetos na base de dados. A classe que
 * implementar esta interface deve conhecer os meios de acesso a sua respectiva
 * base, bem como tratar os resultados e exeções dela provenientes.
 * 
 * @author demetrius
 * @param <T>
 */
public interface DAO<T> {
    
    /**
     * Obtém um objeto da base, dado o seu id
     * @param id
     * @return O objeto retornado ou null (preferencialmente) se não encontrado
     */
    T obter( int id );
    
    /**
     * Insere o objeto especificado na base
     * @param obj
     * @return O id do registro gerado
     */
    int inserir( T obj );
    
    /**
     * Deleta um objeto da base.
     * Nota: Dependendo da aplicação, pode não ser seguro apagar um registro da base.
     * 
     * @param id
     * @return true/false
     */
    boolean deletar( int id );
    
    /**
     * Atualiza um objeto na base de dados.
     * @param obj O objeto com as novas informações a serem armazenadas na base.
     * @return true/false
     */
    boolean atualizar( T obj );
    
}
