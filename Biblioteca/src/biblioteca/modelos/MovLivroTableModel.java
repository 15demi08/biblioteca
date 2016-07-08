/**
 * Biblioteca - Sistema de Movimentação de Livros
 *
 * Demétrius Jr. (github.com/15demi08)
 *
 */
package biblioteca.modelos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author demetrius
 */
public class MovLivroTableModel extends AbstractTableModel {
    
    private ArrayList<MovLivro> dados;
    private String[] colunas = {"Livro", "Data de Devolução", "Atraso"};
    private LocalDate dataPrevistaDevolucao;
    
    private final int LIVRO = 0;
    private final int DEVOLUCAO = 1;
    private final int ATRASO = 2;

    public MovLivroTableModel(LocalDate dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }

    public MovLivroTableModel( ArrayList<MovLivro> dados) {
        setDados(dados);
    }

    public final void setDados(ArrayList<MovLivro> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }
    
    public MovLivro getMovLivro( int linha ){
        return dados.get(linha);
    }
    
    public ArrayList<MovLivro> getPendentes(){
        
        ArrayList<MovLivro> pendentes = new ArrayList<>();
        
        dados.stream().filter((ml) -> ( !ml.isDevolvido() )).forEach((ml) -> {
            pendentes.add(ml);
        });
        
        return pendentes;
        
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
            case LIVRO:
            case DEVOLUCAO:
            case ATRASO:
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
        
        MovLivro movLivro = dados.get(linha);
        
        String strLivro = movLivro.getLivro().getISBN() + " - " + movLivro.getLivro().getNome(),
               strDataDevolucao = "";
        
        long atraso = 0;
        
        // Livro devolvido?
        if(movLivro.getDataDevolucao() == null){
            
            strDataDevolucao = "-";
            
        } else {
            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/uuuu");
            
            strDataDevolucao = movLivro.getDataDevolucao().format(dtf);
            
            // Calcular atraso, se houver
            if( movLivro.getDataDevolucao().isAfter(dataPrevistaDevolucao) ){
                atraso = dataPrevistaDevolucao.until(movLivro.getDataDevolucao(), ChronoUnit.DAYS);
            }
            
        }
        
        switch (coluna) {
            case LIVRO:
                return strLivro;
            case DEVOLUCAO:
                return strDataDevolucao;
            case ATRASO:
                return atraso == 0 ? "-" : ( atraso > 1 ? atraso + " dias" : atraso + " dia" );
            default:
                throw new IndexOutOfBoundsException("Coluna informada não encontrada!");

        }
        
    }
    
    
    
}
