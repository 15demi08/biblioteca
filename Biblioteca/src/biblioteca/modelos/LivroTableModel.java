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
public class LivroTableModel extends AbstractTableModel {

    private ArrayList<Livro> dados = new ArrayList<>();
    private String[] colunas = {"ID", "ISBN", "Título", "Disponível"};

    private final int ID = 0;
    private final int ISBN = 1;
    private final int TITULO = 2;
    private final int DISPONIVEL = 3;

    public LivroTableModel() {
    }

    public LivroTableModel(ArrayList<Livro> dados) {
        setDados(dados);
    }

    public final void setDados(ArrayList<Livro> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public Livro getLivro(int linha) {
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
            case ISBN:
            case TITULO:
                return String.class;
            case DISPONIVEL:
                return Boolean.class;
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

        Livro livro = dados.get(linha);

        switch (coluna) {
            case ID:
                return livro.getId();
            case ISBN:
                return livro.getISBN();
            case TITULO:
                return livro.getNome();
            case DISPONIVEL:
                return livro.isDisponivel();
            default:
                throw new IndexOutOfBoundsException("Coluna informada não encontrada!");

        }

    }

}
