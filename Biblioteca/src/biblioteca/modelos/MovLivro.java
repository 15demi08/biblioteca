/**
 * Biblioteca - Sistema de Movimentação de Livros
 *
 * Demétrius Jr. (github.com/15demi08)
 *
 */
package biblioteca.modelos;

import java.time.LocalDate;

/**
 *
 * @author demetrius
 */
public class MovLivro {
    
    private int id, idMovimentacao;
    private Livro livro;
    private LocalDate dataDevolucao = null;

    /**
     * Cria uma movimentação de Livro sem ID e sem Data de Devolução,
     * para inserção na base de dados
     * @param idMovimentacao
     * @param livro 
     */
    public MovLivro(int idMovimentacao, Livro livro) {
        this.idMovimentacao = idMovimentacao;
        this.livro = livro;
    }
    
    /**
     * Cria uma movimentação de livro com os dados da base.
     * @param id
     * @param idMovimentacao
     * @param livro
     * @param dataDevolucao 
     */
    public MovLivro(int id, int idMovimentacao, Livro livro, LocalDate dataDevolucao ) {
        this(idMovimentacao, livro);
        this.id = id;
        this.dataDevolucao = dataDevolucao;
    }

    public int getId() {
        return id;
    }

    public int getIdMovimentacao() {
        return idMovimentacao;
    }

    public Livro getLivro() {
        return livro;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    
    public boolean isDevolvido(){
        return dataDevolucao != null;
    }
}
