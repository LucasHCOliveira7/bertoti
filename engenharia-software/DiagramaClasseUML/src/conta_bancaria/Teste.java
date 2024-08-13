package conta_bancaria;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Teste {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random random = new Random();

		boolean sairPrograma = false;

		List<Conta> contas = new ArrayList<>();

		Cliente cliente = new Cliente(null, null);
		ContaBancaria dadosConta = new ContaBancaria(0, 0, 0);

		System.out.println("Olá, bem-vindo!");

		while (!sairPrograma) {
			System.out.print("Já possui conta? \nDigite [S] para SIM, [N] para NÃO ou [X] para encerrar \nR: ");
			String possuiConta = scan.next().toUpperCase();

			if (possuiConta.equals("N")) {
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

			} else if (possuiConta.equals("S")) {
				while (true) {
					System.out.print("Digite o número da conta: ");
					int numConta = scan.nextInt();

					for (Conta conta : contas) {
						if (numConta == conta.getNumero()) {
							
							while (true) {
								System.out.print("Digite a senha: ");
								int numSenha = scan.nextInt();
								for (Conta senhaConta : contas) {
									if (numSenha == senhaConta.getSenha()) {

										System.out.println("Olá " + conta.getNome());

										while (true) {
											System.out.println("=========================");
											System.out.print("O que deseja fazer? \n[1] Fazer transferência \n[2] Fazer depósito \n[3] Fazer saque \n[4] Status da conta \n[5] Sair");
											System.out.print("\n========================= \nR: ");

											int opcao = scan.nextInt();

											switch (opcao) {
											case 1:
												while (true) {
													System.out.print("Digite o número da conta de destino: ");
													int numContaDestino = scan.nextInt();

													for (Conta contaDestino : contas) {
														if (numContaDestino == contaDestino.getNumero()) {

															System.out.print("Digite o valor a transferir: R$ ");
															double valorTransferencia = scan.nextInt();

															if (conta.transferir(contaDestino, valorTransferencia)) {
																System.out.println("Transferindo R$ " + valorTransferencia + " para " + contaDestino.getNome());
																try {
																	Thread.sleep(2000);
																} catch (InterruptedException e) {
																	e.printStackTrace();
																}
																System.out.println("Transferência bem-sucedida");
																break;
															}
														} else if (numContaDestino != contaDestino.getNumero()){
															
														} else {
															System.out.println("Conta não encontrada!");
														}
													}
													break;
												}
												break;
											case 2:
												System.out.print("Digite o valor a depositar: R$ ");
												double valorDeposito = scan.nextDouble();
												conta.depositar(valorDeposito);
												break;
											case 3:
												System.out.print("Digite o valor a sacar: R$ ");
												double valorSaque = scan.nextDouble();
												conta.sacar(valorSaque);
												break;
											case 4:
												conta.mostrarStatus();
												break;
											case 5:
												// Voltar para a parte de possui conta
												break;
											default:
												System.out.println("Opção inválida, tente outra.");
											}
											if (opcao == 5) {
												break;
											}
										}
									} 
								}
							}
						} 
					}
					if (numConta == dadosConta.getNumero()) {
						break;
					}
				}
			} else if (possuiConta.equals("X")){
				sairPrograma = true;
			} else {
				System.out.println("Resposta inválida! Tente novamente");
			}
		}

		scan.close();
	}

}
