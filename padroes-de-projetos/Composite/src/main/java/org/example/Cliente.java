package org.example;

public class Cliente {
    public static void main(String[] args) {
        // Criando arquivos individuais
        ArquivoComponent arquivo1 = new Arquivo("Documento1.txt");
        ArquivoComponent arquivo2 = new Arquivo("Foto.jpg");
        ArquivoComponent arquivo3 = new Arquivo("Planilha.xlsx");

        // Criando pastas
        Pasta pastaDocumentos = new Pasta("Documentos");
        Pasta pastaImagens = new Pasta("Imagens");
        Pasta pastaRaiz = new Pasta("Pasta Raiz");

        // Montando a estrutura de pastas
        pastaDocumentos.adicionar(arquivo1);
        pastaImagens.adicionar(arquivo2);
        pastaRaiz.adicionar(pastaDocumentos);
        pastaRaiz.adicionar(pastaImagens);
        pastaRaiz.adicionar(arquivo3);

        // Exibindo a estrutura
        pastaRaiz.mostrarNome();
    }
}