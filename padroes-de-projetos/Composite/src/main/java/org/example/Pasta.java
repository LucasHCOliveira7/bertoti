package org.example;

import java.util.ArrayList;
import java.util.List;

public class Pasta implements ArquivoComponent {
    private String nome;
    private List<ArquivoComponent> componentes = new ArrayList<>();

    public Pasta(String nome) {
        this.nome = nome;
    }

    @Override
    public void mostrarNome() {
        System.out.println("Pasta: " + nome);
        for (ArquivoComponent componente : componentes) {
            componente.mostrarNome();
        }
    }

    @Override
    public void adicionar(ArquivoComponent componente) {
        componentes.add(componente);
    }

    @Override
    public void remover(ArquivoComponent componente) {
        componentes.remove(componente);
    }
}
