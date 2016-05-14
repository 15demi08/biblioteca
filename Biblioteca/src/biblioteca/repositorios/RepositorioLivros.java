package biblioteca.repositorios;

import biblioteca.modelos.Livro;

/**
 *
 * @author 631510058
 */
public class RepositorioLivros {
    
    private static Repositorio<Livro> instancia = new Repositorio<>();

    public static Repositorio<Livro> getInstancia() {
        return instancia;
    }
    
}
