public class Cliente {
    private String nome;
    private ContaBancaria conta;

    public Cliente(String nome, ContaBancaria conta) {
        this.nome = nome;
        this.conta = conta;
    }

    public ContaBancaria getConta() {
        return conta;
    }

    public String getNome() { return nome; }
}
