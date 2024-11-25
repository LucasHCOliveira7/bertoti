package org.example;

public class Singleton {
    // Instância única do Singleton (inicializada como null).
    private static Singleton instanciaUnica;

    // Construtor privado para impedir criação de múltiplas instâncias.
    private Singleton() {}

    // Método público estático para obter a instância única do Singleton.
    public static Singleton getInstancia() {
        if (instanciaUnica == null) {
            // Instancia o Singleton apenas se ele ainda não foi instanciado.
            instanciaUnica = new Singleton();
        }
        return instanciaUnica;
    }

    // Método exemplo para teste.
    public void exibirMensagem() {
        System.out.println("Exemplo de Singleton!");
    }
}