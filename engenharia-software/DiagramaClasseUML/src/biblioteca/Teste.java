package biblioteca;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Teste {

	@Test
    void adicionarLivro() {
		Biblioteca biblioteca = new Biblioteca();
        Livro novoLivro = new Livro("O Hobbit", "J. R. R. Tolkien");
        biblioteca.adicionarLivro(novoLivro);

        // Verificar se o livro foi adicionado corretamente
        List<Livro> livrosDisponiveis = biblioteca.getLivro();
        Assertions.assertTrue(livrosDisponiveis.contains(novoLivro));
    }

    @Test
    void adicionarMultiplosLivros() {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro1 = new Livro("O Senhor dos Anéis", "J. R. R. Tolkien");
        Livro livro2 = new Livro("O Hobbit", "J. R. R. Tolkien");
        Livro livro3 = new Livro("As Crônicas de Nárnia", "C. S. Lewis");
        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.adicionarLivro(livro3);

        // Verificar se todos os livros foram adicionados corretamente
        List<Livro> livrosDisponiveis = biblioteca.getLivro();
        Assertions.assertTrue(livrosDisponiveis.contains(livro1));
        Assertions.assertTrue(livrosDisponiveis.contains(livro2));
        Assertions.assertTrue(livrosDisponiveis.contains(livro3));
    }

    @Test
    void adicionarLivroRepetido() {
    	Biblioteca biblioteca = new Biblioteca();
        Livro livroRepetido = new Livro("1984", "George Orwell");
        biblioteca.adicionarLivro(livroRepetido);
        biblioteca.adicionarLivro(livroRepetido);

        // Verificar se o livro foi adicionado apenas uma vez
        List<Livro> livrosDisponiveis = biblioteca.getLivro();
        Assertions.assertEquals(1, livrosDisponiveis.stream().filter(l -> l.equals(livroRepetido)).count());
    }
    
    @Test
    void emprestarLivroExistente() {
    	Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro("O Hobbit", "J. R. R. Tolkien");
        biblioteca.adicionarLivro(livro);

        // Verificar se o livro pode ser emprestado
        Livro livroEmprestado = biblioteca.emprestarLivro("O Hobbit");
        Assertions.assertNotNull(livroEmprestado);
        Assertions.assertEquals(livro, livroEmprestado);

        // Verificar se o livro não está mais disponível após o empréstimo
        Assertions.assertFalse(biblioteca.getLivro().contains(livro));
    }

    @Test
    void emprestarLivroNaoExistente() {
        Biblioteca biblioteca = new Biblioteca();

        // Verificar se um livro não existente não pode ser emprestado
        Livro livroEmprestado = biblioteca.emprestarLivro("Livro Inexistente");
        Assertions.assertNull(livroEmprestado);
    }

    @Test
    void emprestarLivroJaEmprestado() {
    	Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro("O Hobbit", "J. R. R. Tolkien");
        biblioteca.adicionarLivro(livro);

        Livro livroEmprestado1 = biblioteca.emprestarLivro("O Hobbit");
        Livro livroEmprestado2 = biblioteca.emprestarLivro("O Hobbit");

        // Verificar se o livro é emprestado corretamente na primeira vez e não na segunda
        Assertions.assertNotNull(livroEmprestado1);
        Assertions.assertNull(livroEmprestado2);
    }
    
    @Test
    void devolverLivro() {
    	Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro("O Hobbit", "J. R. R. Tolkien");
        biblioteca.adicionarLivro(livro);

        // Emprestar e depois devolver o livro à biblioteca
        Livro livroEmprestado = biblioteca.emprestarLivro("O Hobbit");
        Assertions.assertNotNull(livroEmprestado);
        biblioteca.devolverLivro(livroEmprestado);

        // Verificar se o livro foi devolvido e está disponível na biblioteca
        Assertions.assertTrue(biblioteca.getLivro().contains(livro));
    }

    @Test
    void devolverLivroNaoEmprestado() {
    	Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro("A Revolução dos Bichos", "George Orwell");
        biblioteca.adicionarLivro(livro);

        // Tentar devolver um livro que não foi emprestado
        Livro livroNaoEmprestado = new Livro("A Revolução dos Bichos", "George Orwell");
        biblioteca.devolverLivro(livroNaoEmprestado);

        // Verificar se o livro não emprestado ainda está na biblioteca
        Assertions.assertTrue(biblioteca.getLivro().contains(livro));
    }
    
    @Test
    void pessoaPegarLivro() {
    	Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro("Jogador Número 1", "Ernest Cline");
        biblioteca.adicionarLivro(livro);

        Pessoa pessoa = new Pessoa("Lucas");
        pessoa.pegarLivro(biblioteca, "Jogador Número 1");

        // Verificar se a pessoa pegou corretamente o livro emprestado
        Assertions.assertFalse(biblioteca.getLivro().contains(livro));
    }

    @Test
    void pessoaDevolverLivro() {
    	Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro("As Crônicas de Nárnia", "C. S. Lewis");
        biblioteca.adicionarLivro(livro);

        Pessoa pessoa = new Pessoa("Lucas");
        Livro livroEmprestado = biblioteca.emprestarLivro("As Crônicas de Nárnia");
        pessoa.devolverLivro(biblioteca, livroEmprestado);

        // Verificar se a pessoa devolveu corretamente o livro à biblioteca
        Assertions.assertTrue(biblioteca.getLivro().contains(livro));
    }

    @Test
    void multiplosUsuarios() {
    	Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry");
        biblioteca.adicionarLivro(livro);

        Pessoa pessoa1 = new Pessoa("Lucas");
        Pessoa pessoa2 = new Pessoa("Ana");
        pessoa1.pegarLivro(biblioteca, "O Pequeno Príncipe");
        pessoa2.pegarLivro(biblioteca, "O Pequeno Príncipe");

        // Verificar se o livro não está mais disponível após ser emprestado por uma pessoa
        Assertions.assertFalse(biblioteca.getLivro().contains(livro));
    } 
    
    @Test
    void livroGetTitulo() {
        Livro livro = new Livro("Harry Potter e a Pedra Filosofal", "J. K. Rowling");
        Assertions.assertEquals("Harry Potter e a Pedra Filosofal", livro.getTitulo());
    }

    @Test
    void livroGetAutor() {
        Livro livro = new Livro("Harry Potter e a Pedra Filosofal", "J. K. Rowling");
        Assertions.assertEquals("J. K. Rowling", livro.getAutor());
    }
    
    @Test
    void pessoaGetNome() {
        Pessoa pessoa = new Pessoa("Lucas");
        Assertions.assertEquals("Lucas", pessoa.getNome());
    }
	
}
