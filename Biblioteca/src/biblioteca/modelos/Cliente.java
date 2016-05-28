package biblioteca.modelos;

/**
 * Representa um cliente da biblioteca
 * @author Demétrius Jr.
 */
public class Cliente {
    
    private int id;       
    private String nome, telefone;

    /**
     * Cria um cliente com os dados especificados
     * @param id
     * @param nome
     * @param telefone 
     */
    public Cliente(int id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return "-- " + id + ": " + nome + ", " + telefone;
    }

    public int getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
