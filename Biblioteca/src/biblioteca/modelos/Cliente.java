package biblioteca.modelos;

/**
 * Representa um cliente da biblioteca
 * @author 631510058
 */
public class Cliente {
    
    private static int proximaMatricula = 1;
            
    private String nome, telefone;
    private int matricula;

    /**
     * Cria um cliente com os dados especificados
     * @param nome
     * @param telefone 
     */
    public Cliente(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
        matricula = proximaMatricula;
        proximaMatricula++;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return "-- " + matricula + ": " + nome + ", " + telefone;
    }
    
}
