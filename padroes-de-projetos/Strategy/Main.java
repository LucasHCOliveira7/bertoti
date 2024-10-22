public class Main {
    public static void main(String[] args) {
        ContaBancaria conta1 = new ContaBancaria("12345", 0);
        ContaCorrente conta2 = new ContaCorrente("54321", 0, 200);

        Cliente cliente1 = new Cliente("Lucas", conta1);

        conta1.depositar(200);
        conta1.sacar(140);
        conta1.depositar(475);
        conta1.sacar(78);

        conta2.depositar(140);
        conta2.sacar(25);

        System.out.println("===================================");
        System.out.println("Cliente: " + cliente1.getNome());
        System.out.println("Saldo da Conta Bancaria: " + conta1.getSaldo());
        System.out.println("Saldo da Conta Corrente: " + conta2.getSaldo());
        System.out.println("===================================");
    }
}
