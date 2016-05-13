/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package biblioteca.repositorios;

import biblioteca.modelos.Cliente;

/**
 *
 * @author 631510058
 */
public class RepositorioClientes extends Repositorio<Cliente> {
    
    private static Repositorio<Cliente> instancia;

    public static Repositorio<Cliente> getInstancia() {
        return instancia;
    }
    
}
