package biblioteca.modelos;

/**
 * Representa um cliente da biblioteca
 * @author Demétrius Jr.
 */
public class Cliente {
    
    private int id;       
    private String nome, telefone;

	/**
     * Cria um cliente sem id, para inserção no banco
	 * @param nome
     * @param telefone 
     */
    public Cliente(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }
	
    /**
     * Cria um cliente com os dados especificados
     * @param id
     * @param nome
     * @param telefone 
     */
    public Cliente(int id, String nome, String telefone) {
        this.id = id;
        Cliente( nome, telefone );
    }
	
    public int getId() {
		return id;
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
    
}
