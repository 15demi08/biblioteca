/**
 * Biblioteca - Sistema de Movimentação de Livros
 *
 * Demétrius Jr. (github.com/15demi08)
 *
 */
package biblioteca.DAO;

import biblioteca.modelos.Cliente;
import java.util.ArrayList;

/**
 *
 * @author demetrius
 */
public interface ClienteDAO extends DAO<Cliente> {
    
    /**
     * Retorna todos os clientes do banco
     * @return
     */
    ArrayList<Cliente> listarTodosClientes();

    @Override
    public boolean atualizar(Cliente obj);

    @Override
    public boolean deletar(int id);

    @Override
    public boolean inserir(Cliente obj);

    @Override
    public Cliente obter(int id);
    
    
    
}
