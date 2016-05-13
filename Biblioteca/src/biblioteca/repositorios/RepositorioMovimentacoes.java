/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package biblioteca.repositorios;

import biblioteca.modelos.Movimentacao;

/**
 *
 * @author 631510058
 */
public class RepositorioMovimentacoes extends Repositorio<Movimentacao> {
    
    private static Repositorio<Movimentacao> instancia;

    public static Repositorio<Movimentacao> getInstancia() {
        return instancia;
    }
    
}
