package unifacs_projetos;

//Importação das classes Scanner e ArrayList
import java.util.Scanner;
import java.util.ArrayList;

//Definição da classe Biblioteca
public class Biblioteca {
ArrayList<Livro> livros; // Cria um ArrayList para armazenar os livros da biblioteca

// Construtor da classe Biblioteca
public Biblioteca() {
   livros = new ArrayList<>(); // Inicializa a lista de livros vazia
}

// Método para adicionar um livro à biblioteca
public void addlivro(Livro livro) {
   livros.add(livro); // Adiciona o livro à lista de livros da biblioteca
}

// Método para listar todos os livros da biblioteca
public void listarLivros() {
   System.out.println("\nLivros Registrados:\n");
   System.out.printf("%-25s %-25s %-25s\n", "Título", "Autor", "Editora\n"); // %-25s para formatar o comprimento da string, ocupando 25 espaços
   for (Livro livro : livros) {//Percorre a lista de livros realizando a checagem em cada objeto do tipo livro
       System.out.printf("%-25s %-25s %-25s\n", livro.getTitulo(), livro.getAutor(), livro.getEditora()); // Imprime o título, autor e editora do livro em formato de tabela
   }
}

// Método para buscar um livro pelo título
public Livro buscarLivro(String titulo) {
   for (Livro livro : livros) {// Percorre a lista de livros realizando a checagem em cada objeto do tipo livro
       if (livro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) { // Converte o título para minúsculas e verifica se o título convertido contém o título fornecido pelo usuário
           return livro; // Retorna o livro encontrado
       }
   }
   return null; // Retorna null caso o livro não seja encontrado
}
}