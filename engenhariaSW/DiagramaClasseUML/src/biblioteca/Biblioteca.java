package biblioteca;

import java.util.ArrayList;
import java.util.List;

class Biblioteca {
    private List<Livro> livrosDisponiveis;

    public Biblioteca() {
        this.livrosDisponiveis = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livrosDisponiveis.add(livro);
    }

    public void mostrarLivrosDisponiveis() {
    	System.out.println("--------------------------------------------------");
        System.out.println("LIVROS DISPONÍVEIS NA BIBLIOTECA:");
        for (Livro livro : livrosDisponiveis) {
            System.out.println(livro);
        }
        System.out.println("--------------------------------------------------");
        System.out.println();
    }

    public Livro emprestarLivro(String titulo) {
        for (Livro livro : livrosDisponiveis) {
            if (livro.getTitulo().equals(titulo)) {
                livrosDisponiveis.remove(livro);
                return livro;
            }
        }
        return null; // Livro não encontrado
    }

    public void devolverLivro(Livro livro) {
        livrosDisponiveis.add(livro);
    }
}