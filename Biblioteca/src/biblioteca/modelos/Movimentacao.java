package biblioteca.modelos;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Representa uma movimentação (retirada/devolução) realizada pela Biblioteca
 *
 * @author demetrius
 */
public class Movimentacao {

    private int id;
    private Cliente cliente;
    private ArrayList<MovLivro> movLivros;
    private LocalDate dataRetirada, dataPrevistaDevolucao;

    /**
     * Cria uma movimentação sem id, para inserção na base
     * @param cliente
     * @param movLivros
     */
    public Movimentacao(Cliente cliente, ArrayList<MovLivro> movLivros) {
        this.cliente = cliente;
        this.movLivros = movLivros;
        this.dataRetirada = LocalDate.now();
        this.dataPrevistaDevolucao = dataRetirada.plusDays(7);
    }

    /**
     * Movimentação armazenada no banco de dados
     * @param id
     * @param cliente
     * @param movLivros
     * @param dataRetirada
     * @param dataPrevistaDevolucao 
     */
    public Movimentacao(int id, Cliente cliente, ArrayList<MovLivro> movLivros, LocalDate dataRetirada, LocalDate dataPrevistaDevolucao) {
        this.id = id;
        this.cliente = cliente;
        this.movLivros = movLivros;
        this.dataRetirada = dataRetirada;
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }
    
    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<MovLivro> getMovLivros() {
        return movLivros;
    }

    public LocalDate getDataRetirada() {
        return dataRetirada;
    }

    public LocalDate getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setMovLivros(ArrayList<MovLivro> movLivros) {
        this.movLivros = movLivros;
    }

    public void setDataRetirada(LocalDate dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public void setDataPrevistaDevolucao(LocalDate dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }

    public boolean verificarTodosDevolvidos() {
        for( MovLivro ml : movLivros ){
            if(!ml.isDevolvido())
                return false;
        }
        
        return true;
    }

}
