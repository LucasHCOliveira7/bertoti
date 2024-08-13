package conta_bancaria;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        boolean sairPrograma = false;
        boolean possuiConta = false;

        List<Conta> contas = new ArrayList<>();

        Cliente cliente = new Cliente(null, null);
        ContaBancaria dadosConta = new ContaBancaria(0, 0, 0);

        System.out.println("Olá, bem-vindo!");

        while (!sairPrograma) {
            if (!possuiConta) {
                System.out.print("Já possui conta? \nDigite [S] para SIM, [N] para NÃO ou [X] para encerrar \nR: ");
                String respostaPossuiConta = scan.next().toUpperCase();

                if (respostaPossuiConta.equals("N")) {
                    criarConta(scan, random, contas, cliente, dadosConta);
                    possuiConta = true;
                } else if (respostaPossuiConta.equals("S")) {
                    possuiConta = acessarConta(scan, contas, dadosConta);
                } else if (respostaPossuiConta.equals("X")) {
                    sairPrograma = true;
                } else {
                    System.out.println("Resposta inválida! Tente novamente");
                }
            } else {
                // Código para operações após login
                System.out.println("Opções após o login");
                System.out.print("Escolha uma opção: ");
                int opcao = scan.nextInt();

                switch (opcao) {
                    case 1:
                    	// Código para transferência
						break;
                    case 2:
                        // Código para depósito
                        break;
                    case 3:
                        // Código para saque
                        break;
                    case 4:
                        // Código para status da conta
                        break;
                    case 5:
                        // Logout
                        possuiConta = false;
                        break;
                    default:
                        System.out.println("Opção inválida, tente outra.");
                }
            }
        }

        scan.close();
    }

    private static void criarConta(Scanner scan, Random random, List<Conta> contas, Cliente cliente, ContaBancaria dadosConta) {
    	System.out.println("Vamos criar sua conta! Para isso precisamos de algumas informações.");
		System.out.print("Nos informe seu nome: ");
		cliente.setNome(scan.next());

		System.out.print("Agora nos informe seu CPF: ");
		cliente.setCpf(scan.next());
		System.out.println("Agora vamos gerar o número da sua conta!");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int numConta = 100000 + random.nextInt(900000);
		dadosConta.setNumero(numConta);
		System.out.println("O número da sua conta é: " + dadosConta.getNumero());
		System.out.print("Defina uma senha para sua conta: ");
		dadosConta.setSenha(scan.nextInt());
		System.out.println("Finalizando a criação da conta...");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Conta criada! Agora vc possui uma e pode acessá-la");

		Conta novaConta = new Conta(cliente.getNome(), cliente.getCpf(), dadosConta.getNumero(), dadosConta.getSenha(), dadosConta.setSaldo(0.0));

		contas.add(novaConta);
    }

    private static boolean acessarConta(Scanner scan, List<Conta> contas, ContaBancaria dadosConta) {
        // Código para acessar conta
        return true; // ou false, dependendo do sucesso do acesso
    }
}
