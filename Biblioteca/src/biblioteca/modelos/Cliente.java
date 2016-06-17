package biblioteca.modelos;

/**
 * Representa um cliente da biblioteca
 *
 * @author Demétrius Jr.
 */
public class Cliente {

    private int id;
    private String nome, telefone, cpf;

    /**
     * Cria um cliente sem id, para inserção no banco
     *
     * @param nome
     * @param telefone
     */
    public Cliente(String nome, String telefone, String cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    /**
     * Cria um cliente com os dados especificados
     *
     * @param id
     * @param nome
     * @param telefone
     * @param cpf
     */
    public Cliente(int id, String nome, String telefone, String cpf) {
        this(nome, telefone, cpf);
        this.id = id;
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

    public String getCpf() {
        return cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "-- " + id + ": " + nome + ", " + telefone;
    }

}
