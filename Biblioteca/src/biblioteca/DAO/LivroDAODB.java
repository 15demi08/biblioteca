/**
 * Biblioteca - Sistema de Movimentação de Livros
 *
 * Demétrius Jr. (github.com/15demi08)
 *
 */
package biblioteca.DAO;

import biblioteca.DB.DB;
import biblioteca.modelos.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LivroDAODB implements LivroDAO {

    private Connection conexao;

    public LivroDAODB() {

        this.conexao = new DB().getConexao();

    }

    @Override
    public ArrayList<Livro> listarTodosLivros() {

        ArrayList<Livro> resultado = new ArrayList<>();

        try {

            String sql = "SELECT * FROM livro WHERE status = true ORDER BY id";

            Statement query = conexao.createStatement();

            ResultSet result = query.executeQuery(sql);

            while (result.next()) {

                resultado.add(
                        new Livro(
                                result.getInt("id"),
                                result.getString("isbn"),
                                result.getString("nome"),
                                result.getString("autores"),
                                result.getString("editora"),
                                result.getInt("anoPublicacao"),
                                result.getBoolean("disponivel")
                        )
                );

            }

            return resultado;

        } catch (SQLException ex) {

            Logger.getLogger(LivroDAODB.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {            
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAODB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;

    }

    /**
     * Atualiza o Livro na base, com suas novas informações
     *
     * @param obj O Livro, contendo os novos dados, a ser atualizado
     * @return True em caso de sucesso, false caso contrário.
     */
    @Override
    public boolean atualizar(Livro obj) {

        try {

            String sql = "UPDATE livro SET isbn = ?, nome = ?, autores = ?, editora = ?, anoPublicacao = ? WHERE id = ?";

            PreparedStatement query = conexao.prepareStatement(sql);

            query.setString(1, obj.getISBN());
            query.setString(2, obj.getNome());
            query.setString(3, obj.getAutores());
            query.setString(4, obj.getEditora());
            query.setInt(5, obj.getAnoPublicacao());
            query.setInt(6, obj.getId());

            if (query.executeUpdate() > 0) {
                return true;
            } else {
                return false;
                
            }

        } catch (SQLException ex) {

            Logger.getLogger(LivroDAODB.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {            
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAODB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return false;

    }

    /**
     * "Deleta" (desativa) um Livro na base de dados
     *
     * @param id O Livro a ser desativado
     * @return True em caso de sucesso, false caso contrário.
     */
    @Override
    public boolean deletar(int id) {

        try {

            String sql = "UPDATE livro SET status = false WHERE id = ?";

            PreparedStatement query = conexao.prepareStatement(sql);

            query.setInt(1, id);

            if (query.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {

            Logger.getLogger(LivroDAODB.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {            
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAODB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return false;

    }

    /**
     * Cadastra um Livro na base, dado um objeto com suas informações
     *
     * @param obj O Livro a ser inserido no banco
     * @return O id gerado para o Livro cadastrado ou 0 (zero) em caso de erro
     */
    @Override
    public int inserir(Livro obj) {

        try {

            String sql = "INSERT INTO livro (isbn, nome, autores, editora, anoPublicacao) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement query = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            query.setString(1, obj.getISBN());
            query.setString(2, obj.getNome());
            query.setString(3, obj.getAutores());
            query.setString(4, obj.getEditora());
            query.setInt(5, obj.getAnoPublicacao());

            if (query.executeUpdate() > 0) {

                ResultSet id = query.getGeneratedKeys();

                if (id.next()) {
                    return id.getInt(1);
                } else {
                    return 0;
                }

            }

        } catch (SQLException ex) {

            Logger.getLogger(LivroDAODB.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {            
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAODB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return 0;

    }

    /**
     * Consulta um Livro na base, dado o seu id.
     *
     * @param id O id do Livro a ser recuperado
     * @return Um objeto do tipo Livro, com os dados recuperados ou null, em
     * caso de erro.
     */
    @Override
    public Livro obter(int id) {

        try {

            String sql = "SELECT * FROM livro WHERE id = ? AND status = true";

            PreparedStatement query = conexao.prepareStatement(sql);

            query.setInt(1, id);

            ResultSet result = query.executeQuery();

            if (result.next()) {

                Livro Livro = new Livro(
                        result.getInt("id"),
                        result.getString("isbn"),
                        result.getString("nome"),
                        result.getString("autores"),
                        result.getString("editora"),
                        result.getInt("anoPublicacao"),
                        result.getBoolean("disponivel")
                );

                return Livro;

            } else {

                return null;

            }

        } catch (SQLException ex) {

            Logger.getLogger(LivroDAODB.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {            
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAODB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;

    }

    /**
     * Movimenta o livro, indicando retirada ou devolução.
     *
     * @param id O id do livro a ser movimentado
     * @param status Pode ser Livro.STATUS_DISPONIVEL ou
     * Livro.STATUS_INDISPONIVEL
     *
     * @return true ou false, de acordo com o êxito, ou não, da operação
     */
    public boolean movimentar(int id, boolean status) {

        try {

            String sql = "UPDATE livro SET disponivel = ? WHERE id = ?";

            PreparedStatement query = conexao.prepareStatement(sql);

            query.setBoolean(1, status);
            query.setInt(2, id);

            if (query.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {

            Logger.getLogger(LivroDAODB.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {            
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAODB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return false;

    }

    /**
     * Consulta os livros atualmente disponíveis para retirada.
     *
     * @return ArrayList com os livros disponíveis, ou null caso não haja nenhum
     */
    @Override
    public ArrayList<Livro> consultaDisponiveis() {

        ArrayList<Livro> resultado = new ArrayList<>();

        try {

            String sql = "SELECT * FROM livro WHERE disponivel = true AND status = true";

            Statement query = conexao.createStatement();

            ResultSet result = query.executeQuery(sql);

            while (result.next()) {

                resultado.add(
                        new Livro(
                                result.getInt("id"),
                                result.getString("isbn"),
                                result.getString("nome"),
                                result.getString("autores"),
                                result.getString("editora"),
                                result.getInt("anoPublicacao"),
                                result.getBoolean("disponivel")
                        )
                );

            }

            return resultado;

        } catch (SQLException ex) {

            Logger.getLogger(LivroDAODB.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {            
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAODB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;

    }

    /**
     * Consulta os livros atualmente excluídos (desativados) da biblioteca
     *
     * @return Arraylist conm os livros excluídos ou null, se não houver nenhum.
     */
    @Override
    public ArrayList<Livro> consultaExcluidos() {

        ArrayList<Livro> resultado = new ArrayList<>();

        try {

            String sql = "SELECT * FROM livro WHERE status = false";

            Statement query = conexao.createStatement();

            ResultSet result = query.executeQuery(sql);

            while (result.next()) {

                resultado.add(
                        new Livro(
                                result.getInt("id"),
                                result.getString("isbn"),
                                result.getString("nome"),
                                result.getString("autores"),
                                result.getString("editora"),
                                result.getInt("anoPublicacao"),
                                result.getBoolean("disponivel")
                        )
                );

            }

            return resultado;

        } catch (SQLException ex) {

            Logger.getLogger(LivroDAODB.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {            
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAODB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;

    }

    public boolean verificarISBN(String ISBN) {

        try {

            String sql = "SELECT * FROM livro WHERE isbn = ?";

            PreparedStatement query = conexao.prepareStatement(sql);

            query.setString(1, ISBN);

            ResultSet result = query.executeQuery();

            return result.next();

        } catch (SQLException ex) {

            Logger.getLogger(LivroDAODB.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {            
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAODB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return false;

    }

    /**
     * Retorna os livros que contiverem em seu titulo a string especificada, ou null
     * se nenhum livro se encaixar no critério
     * @param titulo
     * @return 
     */
    public ArrayList<Livro> pesquisarPorTitulo(String titulo) {
        
        String tituloLower = titulo.toLowerCase();
        ArrayList<Livro> livros = consultaDisponiveis();
        ArrayList<Livro> resultado = new ArrayList<>();
        
        livros.stream().filter((l) -> ( l.getNome().toLowerCase().contains(tituloLower) )).forEach((l) -> {
            resultado.add(l);
        });
        
        return resultado.isEmpty() ? null : resultado;
        
    }

}
