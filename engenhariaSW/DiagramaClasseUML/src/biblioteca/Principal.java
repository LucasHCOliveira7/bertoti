package biblioteca;

public class Principal {
    public static void main(String[] args) {
        // Criar alguns livros
        Livro livro1 = new Livro("O Senhor dos Anéis", "J. R. R. Tolkien");
        Livro livro2 = new Livro("O Hobbit", "J. R. R. Tolkien");
        Livro livro3 = new Livro("Jogador Número 1", "Ernest Cline");
        Livro livro4 = new Livro("As Crônicas de Nárnia", "C. S. Lewis");
        Livro livro5 = new Livro("1984", "George Orwell");
        Livro livro6 = new Livro("Dom Quixote", "Miguel de Cervantes");
        Livro livro7 = new Livro("A Revolução dos Bichos", "George Orwell");
        Livro livro8 = new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry");
        Livro livro9 = new Livro("Harry Potter e a Pedra Filosofal", "J. K. Rowling");
        Livro livro10 = new Livro("Harry Potter e o Prisioneiro de Azkaban", "J. K. Rowling");

        // Criar uma biblioteca e adicionar livros
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.adicionarLivro(livro3);
        biblioteca.adicionarLivro(livro4);
        biblioteca.adicionarLivro(livro5);
        biblioteca.adicionarLivro(livro6);
        biblioteca.adicionarLivro(livro7);
        biblioteca.adicionarLivro(livro8);
        biblioteca.adicionarLivro(livro9);
        biblioteca.adicionarLivro(livro10);

        // Mostrar livros disponíveis na biblioteca
        biblioteca.mostrarLivrosDisponiveis();

        // Criar uma pessoa e interagir com a biblioteca
        Pessoa pessoa1 = new Pessoa("Lucas");
        pessoa1.pegarLivro(biblioteca, "O Hobbit");
        pessoa1.pegarLivro(biblioteca, "A Revolução dos Bichos");
        Pessoa pessoa2 = new Pessoa("Ana");
        pessoa2.pegarLivro(biblioteca, "O Pequeno Príncipe");

        // Mostrar livros disponíveis após o empréstimo
        biblioteca.mostrarLivrosDisponiveis();

        // Devolver o livro à biblioteca
        pessoa1.devolverLivro(biblioteca, livro2);

        // Mostrar livros disponíveis após a devolução
        biblioteca.mostrarLivrosDisponiveis();
    }
}