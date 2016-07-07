/**
 * Biblioteca - Sistema de Movimentação de Livros
 *
 * Demétrius Jr. (github.com/15demi08)
 *
 */
package biblioteca.DAO;

import biblioteca.DB.DB;
import biblioteca.modelos.Livro;
import biblioteca.modelos.MovLivro;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MovLivroDAODB implements DAO<MovLivro> {
    
    private Connection conexao;

    public MovLivroDAODB() {
        this.conexao = new DB().getConexao();
    }

    @Override
    public MovLivro obter(int id) {
        
        try {
            
            String sql = "SELECT * FROM movLivro WHERE id = ?";
            
            PreparedStatement query = conexao.prepareStatement(sql);
            
            query.setInt(1, id);
            
            ResultSet result = query.executeQuery();
            
            if( result.next() ){
                
                int idMovLivro = result.getInt("id");
                int idMov = result.getInt("idMovimentacao");
                Livro livro = new LivroDAODB().obter(result.getInt("idLivro"));
                LocalDate dataDevolucao;
                
                if( result.getDate("dataDevolucao") == null )
                    dataDevolucao = null;
                else
                    dataDevolucao = result.getDate("dataDevolucao").toLocalDate();
                
                MovLivro movLivro = new MovLivro(idMovLivro, idMov, livro, dataDevolucao);
                
                return movLivro;
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MovLivroDAODB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
        
    }

    @Override
    public int inserir(MovLivro obj) {
        
        try {
            
            String sql = "INSERT INTO movLivro (idMovimentacao, idLivro) VALUES (?, ?)";
            
            PreparedStatement query = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            query.setInt(1, obj.getIdMovimentacao());
            query.setInt(2, obj.getLivro().getId());
            
            if( query.executeUpdate() > 0 ){
                
                ResultSet id = query.getGeneratedKeys();
                
                if( id.next() )
                    return id.getInt(1);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MovLivroDAODB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
        
    }
    
    public int inserir(int idMovimentacao, Livro livro) {
        return inserir(new MovLivro(idMovimentacao, livro));
    }

    @Override
    public boolean deletar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Atualiza apenas a data de devolução, pois é a única coisa que realmente pode
     * mudar aqui.
     * @param obj
     * @return 
     */
    @Override
    public boolean atualizar(MovLivro obj) {
        
        try {
            
            String sql = "UPDATE movLivro SET dataDevolucao = ? WHERE id = ?";
            
            PreparedStatement query = conexao.prepareStatement(sql);
            
            query.setDate(1, Date.valueOf(obj.getDataDevolucao()));
            query.setInt(2, obj.getId());
            
            if( query.executeUpdate() > 0 )
                return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(MovLivroDAODB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
        
    }
    
    public ArrayList<MovLivro> listarPorMovimentacao( int idMov ){
        
        ArrayList<MovLivro> movLivros = new ArrayList<>();
        
        try {
            
            String sql = "SELECT * FROM movLivro WHERE idMovimentacao = ?";
            
            PreparedStatement query = conexao.prepareStatement(sql);
            
            query.setInt(1, idMov);
            
            ResultSet result = query.executeQuery();
            
            while( result.next() ){
                
                int idMovLivro = result.getInt("id");
                Livro livro = new LivroDAODB().obter(result.getInt("idLivro"));
                LocalDate dataDevolucao;
                
                if( result.getDate("dataDevolucao") == null )
                    dataDevolucao = null;
                else
                    dataDevolucao = result.getDate("dataDevolucao").toLocalDate();
                
                MovLivro movLivro = new MovLivro(idMovLivro, idMov, livro, dataDevolucao);
                
                movLivros.add(movLivro);
                
            }
            
            return movLivros;
            
        } catch (SQLException ex) {
            Logger.getLogger(MovLivroDAODB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
        
    }
    
    public boolean devolver( MovLivro movLivro ){
        
        if(!new LivroDAODB().movimentar(movLivro.getLivro().getId(), true)){
            
            return false;
            
        } else {
        
            movLivro.setDataDevolucao(LocalDate.now());
        
            return atualizar(movLivro);
        
        }
    
    }
  
    
}
