/**
 * Biblioteca - Sistema de Movimentação de Livros
 *
 * Demétrius Jr. (github.com/15demi08)
 *
 */
package biblioteca.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author demetrius
 */
public class DB {
    
    private static Connection conexao;
    
    private DB (){
        
        try {
            
            Class.forName("org.postgresql.Driver");
            
            DB.conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Biblioteca_LP2", "postgres", "123456");
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public static Connection getConexao() {
        return conexao;
    }
    
    public void desconectar(){
        
        try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
