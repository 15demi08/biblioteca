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

        this.conexao = DB.getConexao();

    }

    @Override
    public ArrayList<Cliente> listarTodosClientes() {
        
        ArrayList<Cliente> resultado = new ArrayList<>();
        
        try {

            String sql = "SELECT * FROM cliente";
            
            Statement query = conexao.createStatement();

            ResultSet result = query.executeQuery(sql);

            while( result.next() ){
                
                resultado.add(new Cliente(result.getInt("id"), result.getString("nome"), result.getString("telefone")));
                
            }

            return resultado;

        } catch (SQLException ex) {

            Logger.getLogger(ClienteDAODB.class.getName()).log(Level.SEVERE, null, ex);

        }

        return null;       
        
        
    }

    /**
     * Atualiza o cliente na base, com suas novas informações
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
            
            if( query.executeUpdate() > 0 )
                return true;
            
        } catch (SQLException ex) {
            
            Logger.getLogger(ClienteDAODB.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        
        return false;
        
    }

    /**
     * "Deleta" (desativa) um cliente na base de dados
     * @param id O cliente a ser desativado
     * @return True em caso de sucesso, false caso contrário.
     */
    @Override
    public boolean deletar(int id) {
        
        try {
            
            String sql = "UPDATE cliente SET status = false WHERE id = ?";
            
            PreparedStatement query = conexao.prepareStatement(sql);
            
            query.setInt(1, id);
            
            if( query.executeUpdate() > 0 )
                return true;
            
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

            String sql = "INSERT INTO cliente (nome, telefone) VALUES (?, ?)";

            PreparedStatement query = conexao.prepareStatement(sql);

            query.setString(1, obj.getNome());
            query.setString(2, obj.getTelefone());

            if (query.executeUpdate() > 0) {
             
                ResultSet id = query.getGeneratedKeys();

                return id.getInt(1);
            
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

            Cliente cliente = new Cliente(result.getInt("id"), result.getString("nome"), result.getString("telefone"));

            return cliente;

        } catch (SQLException ex) {

            Logger.getLogger(ClienteDAODB.class.getName()).log(Level.SEVERE, null, ex);

        }

        return null;

    }

}
