package org.example;

public class Arquivo implements ArquivoComponent {
    private String nome;

    public Arquivo(String nome) {
        this.nome = nome;
    }

    @Override
    public void mostrarNome() {
        System.out.println("Arquivo: " + nome);
    }

    @Override
    public void adicionar(ArquivoComponent componente) {
        // Não faz nada, pois é uma folha e não pode conter outros componentes.
        throw new UnsupportedOperationException("Não pode adicionar a um arquivo.");
    }

    @Override
    public void remover(ArquivoComponent componente) {
        // Não faz nada, pois é uma folha e não pode conter outros componentes.
        throw new UnsupportedOperationException("Não pode remover de um arquivo.");
    }
}