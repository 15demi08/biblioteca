package biblioteca.repositorios;

import biblioteca.utilidades.Console;
import java.util.ArrayList;

/**
 * Cria um repositório de itens, para armazenamento em tempo de execução
 * @author Demétrius Jr.
 * @param <T> O tipo de item armazenado neste repositório
 */
public class Repositorio<T> {
    
    /**
     * Os itens do repositório
     */
    private ArrayList<T> itens;
    
    /**
     * Inicializa o ArrayList para o repositório atual
     */
    public Repositorio() {
        this.itens = new ArrayList<>();
    }
    
    /**
     * Adiciona um item ao repositório
     * @param item O item a ser adicionado
     */
    public void adicionar( T item ){
        itens.add(item);
    }
    
    /**
     * Retorna um item do repositório, para consulta
     * @param id O índice do item armazenado neste repositório
     * @return O item, caso encontrado.
     * Nota: a chamada a este método deverá estar contida em um bloco try...catch
     */
    public T retornar( int id ){
        return itens.get(id);
    }
    
    /**
     * Retorna o índice do item especificado
     * @param item O item a ser pesquisado
     * @return O índice do item especificado
     */
    public int indice( T item ){
        return itens.indexOf(item);
    }
    
    /**
     * Lista todos os itens deste Repositório
     * Obs.: Pode ser lento, dependendo da quantidade de itens
     */
    public void listarItens(){
        for( T item : itens )
            Console.println(item);
    }
    
    /**
     * Retorna o número de itens atualmente armazenados neste repositório
     * @return Número de itens
     */
    public int numItens(){
        return itens.size();
    }
    
}
