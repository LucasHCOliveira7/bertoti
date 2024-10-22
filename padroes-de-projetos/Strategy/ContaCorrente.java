public class ContaCorrente extends ContaBancaria {
    private double limite;

    public ContaCorrente(String numeroConta, double saldoInicial, double limite) {
        super(numeroConta, saldoInicial); // Chama o construtor da classe pai
        this.limite = limite;
    }

    public boolean sacar(double valor) {
        if (getSaldo() + limite >= valor) {
            super.sacar(valor); // Chama o método sacar da classe pai
            return true;
        } else {
            return false;
        }
    }

    public double getLimite() {
        return limite;
    }
}
