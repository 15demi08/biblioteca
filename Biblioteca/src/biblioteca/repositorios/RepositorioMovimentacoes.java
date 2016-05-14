package biblioteca.repositorios;

import biblioteca.modelos.Movimentacao;

/**
 *
 * @author 631510058
 */
public class RepositorioMovimentacoes {
    
    private static Repositorio<Movimentacao> instancia = new Repositorio<>();

    public static Repositorio<Movimentacao> getInstancia() {
        return instancia;
    }
    
}
