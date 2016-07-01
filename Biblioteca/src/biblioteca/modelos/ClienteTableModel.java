/**
 * Biblioteca - Sistema de Movimentação de Livros
 *
 * Demétrius Jr. (github.com/15demi08)
 *
 */
package biblioteca.modelos;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author demetrius
 */
public class ClienteTableModel extends AbstractTableModel {

    private ArrayList<Cliente> dados;
    private String[] colunas = {"ID", "CPF", "Nome", "Telefone"};

    private static final int ID = 0;
    private static final int CPF = 1;
    private static final int NOME = 2;
    private static final int TELEFONE = 3;
    
    public ClienteTableModel() {}

    public ClienteTableModel(ArrayList<Cliente> dados) {
        setDados(dados);
    }

    public final void setDados(ArrayList<Cliente> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }
    
    public Cliente getCliente( int linha ){
        return dados.get(linha);
    }
    
    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int coluna) {
        return colunas[coluna];
    }

    @Override
    public Class<?> getColumnClass(int coluna) {
        switch (coluna) {
            case ID:
                return Integer.class;
            case CPF:
            case NOME:
            case TELEFONE:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("Coluna informada não encontrada!");

        }
    }

    @Override
    public boolean isCellEditable(int linha, int coluna) {
        return false;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        
        Cliente cliente = dados.get(linha);
        
        switch (coluna) {
            case ID:
                return cliente.getId();
            case CPF:
                return cliente.getCpf();
            case NOME:
                return cliente.getNome();
            case TELEFONE:
                return cliente.getTelefone();
            default:
                throw new IndexOutOfBoundsException("Coluna informada não encontrada!");

        }
        
    }

}
