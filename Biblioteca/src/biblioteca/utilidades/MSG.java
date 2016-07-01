/**
 * Biblioteca - Sistema de Movimentação de Livros
 *
 * Demétrius Jr. (github.com/15demi08)
 *
 */
package biblioteca.utilidades;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author demetrius
 */
public class MSG {
    
    public static void show( Component parent, String msg ){
        
        JOptionPane.showMessageDialog(parent, msg);
        
    }
    
    public static boolean confirm( Component parent, String msg ){
        
        return JOptionPane.showConfirmDialog(parent, null, msg, JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION;
        
    }
    
}
