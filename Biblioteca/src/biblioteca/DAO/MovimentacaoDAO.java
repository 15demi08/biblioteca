/**
 * Biblioteca - Sistema de Movimentação de Livros
 *
 * Demétrius Jr. (github.com/15demi08)
 *
 */
package biblioteca.DAO;

import biblioteca.modelos.Cliente;
import biblioteca.modelos.Movimentacao;
import java.util.ArrayList;

/**
 *
 * @author demetrius
 */
public interface MovimentacaoDAO extends DAO<Movimentacao> {

    @Override
    public boolean atualizar(Movimentacao obj);

    @Override
    public boolean deletar(int id);

    @Override
    public int inserir(Movimentacao obj);

    @Override
    public Movimentacao obter(int id);
    
    public ArrayList<Movimentacao> listarTodasMovs();
    
}
