/**
 * Biblioteca - Sistema de Movimentação de Livros
 *
 * Demétrius Jr. (github.com/15demi08)
 */
package biblioteca.DAO;

import biblioteca.modelos.Cliente;
import java.util.ArrayList;

/**
 *
 * @author demetrius
 */
public interface ClienteDAO extends DAO<Cliente> {
    
    @Override
    public boolean atualizar(Cliente obj);

    @Override
    public boolean deletar(int id);

    @Override
    public int inserir(Cliente obj);

    @Override
    public Cliente obter(int id);
    
    /**
     * Retorna todos os clientes do banco
     * @return
     */
    ArrayList<Cliente> listarTodosClientes();
    
    ArrayList<Cliente> listarExcluidos();
    
    /**
     *
     * @param cpf
     * @return
     */
    public boolean verificarCPF( String cpf );
    
    /**
     *
     * @param id
     * @return
     */
    public int verificarNroEmprestimos(int id);
    
    /**
     *
     * @param id
     * @return
     */
    public boolean verificarStatus(int id);
    
}
