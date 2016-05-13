/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package biblioteca.repositorios;

import biblioteca.modelos.Livro;

/**
 *
 * @author 631510058
 */
public class RepositorioLivros extends Repositorio<Livro> {
    
    private static Repositorio<Livro> instancia;

    public static Repositorio<Livro> getInstancia() {
        return instancia;
    }
    
}
