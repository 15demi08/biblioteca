/**
 * Biblioteca - Sistema de Movimentação de Livros
 *
 * Demétrius Jr. (github.com/15demi08)
 *
 */
package biblioteca.modelos;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author demetrius
 */
public class MovimentacaoTableModel extends AbstractTableModel{
    
    private ArrayList<Movimentacao> dados;
    private String[] colunas = {"ID", "Cliente", "Livros", "Data de Retirada", "Devolução Prevista"};
    
    private final int ID = 0;
    private final int CLIENTE = 1;
    private final int LIVROS = 2;
    private final int RETIRADA = 3;
    private final int DEVOLUCAO_PREV = 4;

    public MovimentacaoTableModel() {
    }

    public MovimentacaoTableModel(ArrayList<Movimentacao> dados) {
        setDados(dados);
    }

    public final void setDados(ArrayList<Movimentacao> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }
    
    public Movimentacao getMovimentacao( int linha ){
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
            case LIVROS:
                return Integer.class;
            case CLIENTE:
            case RETIRADA:
            case DEVOLUCAO_PREV:
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
        
        Movimentacao movimentacao = dados.get(linha);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        
        switch (coluna) {
            case ID:
                return movimentacao.getId();
            case CLIENTE:
                return movimentacao.getCliente().getNome();
            case LIVROS:
                return movimentacao.getMovLivros().size();
            case RETIRADA:
                return movimentacao.getDataRetirada().format(dtf);
            case DEVOLUCAO_PREV:
                return movimentacao.getDataPrevistaDevolucao().format(dtf);
            default:
                throw new IndexOutOfBoundsException("Coluna informada não encontrada!");

        }
        
    }
    
}
