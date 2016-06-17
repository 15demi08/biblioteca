/**
 * Biblioteca - Sistema de Movimentação de Livros
 *
 * Demétrius Jr. (github.com/15demi08)
 *
 */
package biblioteca.DAO;

import biblioteca.DB.DB;
import biblioteca.modelos.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAODB implements ClienteDAO {

    private Connection conexao;

    public ClienteDAODB() {

        this.conexao = new DB().getConexao();

    }

    @Override
    public ArrayList<Cliente> listarTodosClientes() {

        ArrayList<Cliente> resultado = new ArrayList<>();

        try {

            String sql = "SELECT * FROM cliente";

            Statement query = conexao.createStatement();

            ResultSet result = query.executeQuery(sql);

            while (result.next()) {

                resultado.add(
                    new Cliente(
                        result.getInt("id"),
                        result.getString("nome"),
                        result.getString("telefone"),
                        result.getString("cpf")
                    )
                );

            }

            return resultado;

        } catch (SQLException ex) {

            Logger.getLogger(ClienteDAODB.class.getName()).log(Level.SEVERE, null, ex);

        }

        return null;

    }

    /**
     * Atualiza o cliente na base, com suas novas informações
     *
     * @param obj O cliente, contendo os novos dados, a ser atualizado
     * @return True em caso de sucesso, false caso contrário.
     */
    @Override
    public boolean atualizar(Cliente obj) {

        try {

            String sql = "UPDATE cliente SET nome = ?, telefone = ? WHERE id = ?";

            PreparedStatement query = conexao.prepareStatement(sql);

            query.setString(1, obj.getNome());
            query.setString(2, obj.getTelefone());
            query.setInt(3, obj.getId());

            if (query.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {

            Logger.getLogger(ClienteDAODB.class.getName()).log(Level.SEVERE, null, ex);

        }

        return false;

    }

    /**
     * "Deleta" (desativa) um cliente na base de dados
     *
     * @param id O cliente a ser desativado
     * @return True em caso de sucesso, false caso contrário.
     */
    @Override
    public boolean deletar(int id) {

        try {

            String sql = "UPDATE cliente SET status = false WHERE id = ?";

            PreparedStatement query = conexao.prepareStatement(sql);

            query.setInt(1, id);

            if (query.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {

            Logger.getLogger(ClienteDAODB.class.getName()).log(Level.SEVERE, null, ex);

        }

        return false;

    }

    /**
     * Cadastra um Cliente na base, dado um objeto com suas informações
     *
     * @param obj O cliente a ser inserido no banco
     * @return O id gerado para o cliente cadastrado ou 0 (zero) em caso de erro
     */
    @Override
    public int inserir(Cliente obj) {

        try {

            String sql = "INSERT INTO cliente (nome, telefone, cpf) VALUES (?, ?, ?)";

            PreparedStatement query = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            query.setString(1, obj.getNome());
            query.setString(2, obj.getTelefone());
            query.setString(3, obj.getCpf());

            if (query.executeUpdate() > 0) {

                ResultSet id = query.getGeneratedKeys();
                
                if(id.next())
                    return id.getInt(1);
                else
                    return 0;

            }

        } catch (SQLException ex) {

            Logger.getLogger(ClienteDAODB.class.getName()).log(Level.SEVERE, null, ex);

        }
        
        return 0;

    }

    /**
     * Consulta um cliente na base, dado o seu id.
     *
     * @param id O id do cliente a ser recuperado
     * @return Um objeto do tipo Cliente, com os dados recuperados ou null, em
     * caso de erro.
     */
    @Override
    public Cliente obter(int id) {

        try {

            String sql = "SELECT * FROM cliente WHERE id = ?";

            PreparedStatement query = conexao.prepareStatement(sql);

            query.setInt(1, id);

            ResultSet result = query.executeQuery();

            Cliente cliente = new Cliente(result.getInt("id"), result.getString("nome"), result.getString("telefone"), result.getString("cpf"));

            return cliente;

        } catch (SQLException ex) {

            Logger.getLogger(ClienteDAODB.class.getName()).log(Level.SEVERE, null, ex);

        }

        return null;

    }

    @Override
    public ArrayList<Cliente> obterPorCPF() {
        
        throw new UnsupportedOperationException("Não implementado!");

    }

    @Override
    public boolean verificarCPF(String cpf) {
    
        try {
            
            String sql = "SELECT * FROM cliente WHERE cpf = ?";
            
            PreparedStatement query = conexao.prepareStatement(sql);
            
            ResultSet result = query.executeQuery();
            
            return result.next();
            
        } catch (SQLException ex) {
            
            Logger.getLogger(ClienteDAODB.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        
        return false;
        
    }
    
    

    /**
     * Retorna a quantidade de empréstimos pendentes de devolução
     *
     * @param id O id do cliente a consultar
     * @return int A quant de livros emprestados ou 0, se não houver
     */
    @Override
    public int verificarNroEmprestimos(int id) {

        int quantidade = 0;

        try {

            String sql = "SELECT COUNT(ml.id) AS quant"
                    + "FROM cliente c, movimentacao m, mov_livro ml"
                    + "WHERE c.id = ? AND ml.dataDevolucao = NULL AND"
                    + "c.id = m.idCliente AND m.id = ml.idMovimentacao";

            PreparedStatement query = conexao.prepareStatement(sql);

            query.setInt(1, id);

            ResultSet result = query.executeQuery();

            quantidade = result.getInt("quant");

        } catch (SQLException ex) {

            Logger.getLogger(ClienteDAODB.class.getName()).log(Level.SEVERE, null, ex);

        }

        return quantidade;

    }

}
