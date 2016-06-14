package biblioteca.modelos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 * Representa uma movimentação (retirada/devolução) realizada pela Biblioteca
 *
 * @author demetrius
 */
public class Movimentacao {

    private int id;
    private Cliente cliente;
    private ArrayList<Livro> livros;
    private LocalDate dataRetirada, dataPrevistaDevolucao, dataDevolucao = null;

    /**
     * Cria uma movimentação sem id, para inserção na base
     * @param cliente
     * @param livros
     */
    public Movimentacao(Cliente cliente, ArrayList<Livro> livros) {
        this.cliente = cliente;
        this.livros = livros;
        this.dataRetirada = LocalDate.now();
        this.dataPrevistaDevolucao = dataRetirada.plusDays(7);
    }

    /**
     * Cria uma movimentação para registro. O ArrayList de Livros pode conter,
     * no máximo, 3 itens.
     *
     * @param cliente
     * @param livros
     */
    public Movimentacao(int id, Cliente cliente, ArrayList<Livro> livros) {
        this.cliente = cliente;
        this.livros = livros;
        this.dataRetirada = LocalDate.now();
        this.dataPrevistaDevolucao = dataRetirada.plusDays(3);
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public boolean verificarTodosDevolvidos() {

        for (Livro l : livros) {
            if (!l.isDisponivel()) {
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

        msg = "-- ID : " + id + "\n"
            + "-------------------\n"
            + "-- Cliente: " + cliente.getId() + " - " + cliente.getNome() + "\n"
            + "-- Retirada: " + dataRetirada.format(dtf) + "\n"
            + "-- Devolução Prevista: " + dataPrevistaDevolucao.format(dtf) + "\n"
            + "-- Devolucao: " + (dataDevolucao == null ? "Pendente" : dataDevolucao.format(dtf)) + "\n"
            + "-- Atraso: ";

        if (dataDevolucao == null) {
            msg += "-\n";
        } else if (dataDevolucao != null && dataDevolucao.isAfter(dataPrevistaDevolucao)) {
            msg += dataPrevistaDevolucao.until(dataDevolucao, ChronoUnit.DAYS) + " dia(s)\n";
        } else {
            msg += "Devolvido(s) na data estimada ou antes\n";
        }

        msg += "-- Livros\n";

        for (Livro l : livros) {
            msg += "---- " + l.getId() + ": " + l.getNome() + "\n";
        }

        return msg;
    }

}
