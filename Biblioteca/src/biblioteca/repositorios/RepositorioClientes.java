package biblioteca.repositorios;

import biblioteca.modelos.Cliente;

/**
 *
 * @author 631510058
 */
public class RepositorioClientes {
    
    private static Repositorio<Cliente> instancia = new Repositorio<>();

    public static Repositorio<Cliente> getInstancia() {
        return instancia;
    }
    
}
