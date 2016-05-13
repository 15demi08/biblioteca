package biblioteca.repositorios;

import biblioteca.modelos.Movimentacao;

/**
 *
 * @author 631510058
 */
public class RepositorioMovimentacoes extends Repositorio<Movimentacao> {
    
    private static Repositorio<Movimentacao> instancia = new Repositorio<>();

    public static Repositorio<Movimentacao> getInstancia() {
        return instancia;
    }
    
}
