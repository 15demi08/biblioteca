package biblioteca.modelos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 * Representa uma movimentação (retirada/devolução) realizada pela Biblioteca
 * @author demetrius
 */
public class Movimentacao {
    
    private static int proximoCodigo = 1;
    
    private int codigo, diasAtraso = 0;
    private Cliente cliente;
    private ArrayList<Livro> livros;
    private LocalDate dataRetirada, dataEstimadaDevolucao, dataDevolucao = null;
    
    /**
     * Cria uma movimentação para registro. O ArrayList de Livros pode conter, no máximo, 3 itens.
     * @param cliente
     * @param livros 
     */
    public Movimentacao(Cliente cliente, ArrayList<Livro> livros) {
        this.cliente = cliente;
        this.livros = livros;
        this.dataRetirada = LocalDate.now();
        this.dataEstimadaDevolucao = dataRetirada.plusDays(3);
        codigo = proximoCodigo;
        proximoCodigo++;
    }

    public int getCodigo() {
        return codigo;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }
    
    public boolean verificarTodosDevolvidos(){
        
        for( Livro l : livros ){
            if( !l.isDisponivel() ){
                return false;
            }
        }
        
        dataDevolucao = LocalDate.now();
        return true;
    }

    @Override
    public String toString() {
        
        String retirada, devEstimada, dev;
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        
        String msg;
        
        msg = "-- Código : " + codigo + "\n"
            + "-------------------\n"
            + "-- Cliente: " + cliente.getMatricula() + " - " + cliente.getNome() + "\n"
            + "-- Retirada: " + dataRetirada.format(dtf) + "\n"
            + "-- Devolução Prevista: " + dataEstimadaDevolucao.format(dtf) + "\n"
            + "-- Devolucao: " + ( dataDevolucao == null ? "Pendente" : dataDevolucao.format(dtf) ) + "\n"
            + "-- Atraso: ";
        
        if( dataDevolucao == null )
            msg += "-\n";
        else if( dataDevolucao != null && dataDevolucao.isAfter(dataEstimadaDevolucao) )    
            msg += dataEstimadaDevolucao.until(dataDevolucao, ChronoUnit.DAYS) + " dia(s)\n";
        else
            msg += "Devolvido(s) na data estimada ou antes\n";
        
        msg += "-- Livros\n";
        
        for( Livro l : livros )            
            msg += "---- " + l.getCodigo() + ": " + l.getNome() + "\n";
        
        return msg;
    }
    
}
