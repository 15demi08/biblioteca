/**
 * Biblioteca - Sistema de Movimentação de Livros
 *
 * Demétrius Jr. (github.com/15demi08)
 *
 */
package biblioteca.DAO;

import biblioteca.DB.DB;
import biblioteca.modelos.Cliente;
import biblioteca.modelos.MovLivro;
import biblioteca.modelos.Movimentacao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MovimentacaoDAODB implements MovimentacaoDAO {

    private Connection conexao;

    public MovimentacaoDAODB() {
        this.conexao = new DB().getConexao();
    }

    @Override
    public boolean atualizar(Movimentacao obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deletar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int inserir(Movimentacao obj) {

        LivroDAODB livroDB = new LivroDAODB();

        try {

            String sqlMov = "INSERT INTO movimentacao (idCliente, dataRetirada, dataPrevistaDevolucao)"
                    + "VALUES (?, ?, ?)";

            PreparedStatement queryMov = conexao.prepareStatement(sqlMov, PreparedStatement.RETURN_GENERATED_KEYS);

            queryMov.setInt(1, obj.getCliente().getId());
            queryMov.setDate(2, Date.valueOf(obj.getDataRetirada()));
            queryMov.setDate(3, Date.valueOf(obj.getDataPrevistaDevolucao()));

            if (queryMov.executeUpdate() > 0) {

                ResultSet movResult = queryMov.getGeneratedKeys();
                int idMov = 0;

                if (movResult.next()) {
                    idMov = movResult.getInt(1);
                } else {
                    return 0;
                }

                ArrayList<MovLivro> movLivros = obj.getMovLivros();;

                for (MovLivro movLivro : movLivros) {

                    new MovLivroDAODB().inserir(idMov, movLivro.getLivro());

                }

                return idMov;

            }

        } catch (SQLException ex) {
            
            Logger.getLogger(MovimentacaoDAODB.class.getName()).log(Level.SEVERE, null, ex);
            
        } finally {
            try {            
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAODB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return 0;

    }

    @Override
    public Movimentacao obter(int id) {

        try {

            // 1º: Consultar os dados da movimentação
            String sqlMov = "SELECT * FROM movimentacao WHERE id = ?";

            PreparedStatement queryMov = conexao.prepareStatement(sqlMov);

            queryMov.setInt(1, id);

            ResultSet movResult = queryMov.executeQuery();

            Movimentacao movimentacao = null;
            
            if (movResult.next()) {
                
                // 2º: Concultar os dados do cliente
                Cliente cliente = new ClienteDAODB().obter(movResult.getInt("idCliente"));

                // 3º: Recuperar os livros que fizeram parte da movimentação
                ArrayList<MovLivro> livros = new MovLivroDAODB().listarPorMovimentacao(id);

                // 4º: Converter as datas para LocalDate
                LocalDate dataRetirada = movResult.getDate("dataRetirada").toLocalDate();
                LocalDate dataPrevistaDevolucao = movResult.getDate("dataPrevistaDevolucao").toLocalDate();

                // 5º: Criar a Movimentação com os dados recuperados
                movimentacao = new Movimentacao(id, cliente, livros, dataRetirada, dataPrevistaDevolucao);
            
            }

            return movimentacao;

        } catch (SQLException ex) {
            
            Logger.getLogger(MovimentacaoDAODB.class.getName()).log(Level.SEVERE, null, ex);
            
        } finally {
            try {            
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAODB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;

    }

    @Override
    public ArrayList<Movimentacao> listarTodasMovs() {

        ArrayList<Movimentacao> movimentacoes = new ArrayList<>();

        try {

            // Retornar todas as movimentações
            String sqlMov = "SELECT * FROM movimentacao";

            PreparedStatement queryMov = conexao.prepareStatement(sqlMov);

            ResultSet movResult = queryMov.executeQuery();

            // Para cada uma:
            while (movResult.next()) {

                int idMov = movResult.getInt("id");

                // 1º: Concultar os dados do cliente
                Cliente cliente = new ClienteDAODB().obter(movResult.getInt("idCliente"));

                // 2º: Recuperar os livros que fizeram parte da movimentação
                ArrayList<MovLivro> livros = new MovLivroDAODB().listarPorMovimentacao(idMov);

                // 3º: Converter as datas para LocalDate
                LocalDate dataRetirada = movResult.getDate("dataRetirada").toLocalDate();
                LocalDate dataPrevistaDevolucao = movResult.getDate("dataPrevistaDevolucao").toLocalDate();

                // 4º: Criar a Movimentação com os dados recuperados
                Movimentacao movimentacao = new Movimentacao(idMov, cliente, livros, dataRetirada, dataPrevistaDevolucao);

                movimentacoes.add(movimentacao);

            }

            return movimentacoes;

        } catch (SQLException ex) {
            
            Logger.getLogger(MovimentacaoDAODB.class.getName()).log(Level.SEVERE, null, ex);
            
        } finally {
            try {            
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAODB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;

    }

}
