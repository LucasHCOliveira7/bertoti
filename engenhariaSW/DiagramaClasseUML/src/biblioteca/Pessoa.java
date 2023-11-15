package biblioteca;

class Pessoa {
    private String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void pegarLivro(Biblioteca biblioteca, String titulo) {
        Livro livro = biblioteca.emprestarLivro(titulo);
        if (livro != null) {
            System.out.println(nome + " pegou emprestado o livro: " + livro);
            System.out.println();
        } else {
            System.out.println("Desculpe, o livro '" + titulo + "' não está disponível para empréstimo.");
        }
    }

    public void devolverLivro(Biblioteca biblioteca, Livro livro) {
        biblioteca.devolverLivro(livro);
        System.out.println(nome + " devolveu o livro: " + livro);
        System.out.println();
    }
}
