package conta_bancaria;

public class Conta {

	private String nome;
	private String cpf;
	private int numero;
	private int senha;
	private double saldo;
	
	public Conta(String nome, String cpf, int numero, int senha, double saldo) {
		this.nome = nome;
		this.cpf = cpf;
		this.numero = numero;
		this.senha = senha;
		this.saldo = saldo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public boolean transferir(Conta destino, double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            destino.setSaldo(destino.getSaldo() + valor);
            return true;
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para transferência!");
            return false;
        }
    }
	
	public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso!");
        } else {
            System.out.println("Valor inválido para depósito!");
        }
    }
	
	public void sacar(double valor) {
		if (valor > 0 && valor <= saldo) {
			saldo -= valor;
			System.out.println("Saque de R$ " + valor + " realizado com sucesso!");
		} else {
			System.out.println("Saldo insuficiente ou valor inválido para transferência!");
		}
	}
	
	public void mostrarStatus() {
        System.out.println("==============================");
        System.out.println("Olá " + nome);
        System.out.println("STATUS DA SUA CONTA BANCÁRIA");
        System.out.println("Saldo: R$ " + saldo);
        System.out.println("==============================");
    }
	
}
