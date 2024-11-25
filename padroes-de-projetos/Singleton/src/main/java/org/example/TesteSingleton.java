package org.example;

public class TesteSingleton {
    public static void main(String[] args) {
        // Obtém a instância única do Singleton e chama um método de exemplo.
        Singleton singleton = Singleton.getInstancia();
        singleton.exibirMensagem();

        // Tentando obter outra instância e chamando o método.
        Singleton outraInstancia = Singleton.getInstancia();
        outraInstancia.exibirMensagem();

        // Verificando se as duas variáveis referem-se à mesma instância.
        System.out.println(singleton == outraInstancia); // Deve imprimir true
    }
}