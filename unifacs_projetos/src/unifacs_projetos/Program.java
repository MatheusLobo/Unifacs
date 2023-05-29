package unifacs_projetos;

//Importação das classes Scanner e ArrayList
import java.util.Scanner;
import java.util.ArrayList;

//Definição da classe Program
public class Program {
 public static void main(String[] args) {
     Biblioteca biblioteca = new Biblioteca();
     
     // Criação de 7 livros dentro da biblioteca
     biblioteca.addlivro(new Livro("Dom Casmurro", "Machado de Assis", "Garnier", "1899", 256));
     biblioteca.addlivro(new Livro("O Guarani", "José de Alencar", "B. L. Garnier", "1857", 368));
     biblioteca.addlivro(new Livro("Vidas Secas", "Graciliano Ramos", "Jose Olympio", "1938", 176));
     biblioteca.addlivro(new Livro("Capitaes da Areia", "Jorge Amado", "Martins", "1937", 256));
     biblioteca.addlivro(new Livro("A Hora da Estrela", "Clarice Lispector", "Rocco", "1977", 88));
     biblioteca.addlivro(new Livro("O Quinze", "Rachel de Queiroz", "Jose Olympio", "1930", 160));
     biblioteca.addlivro(new Livro("Macunaima", "Mário de Andrade", "Livros do Brasil", "1928", 192));

     System.out.println("Bem-vindo à Biblioteca Java 2023 Unifacs\n"); // Mensagem de boas-vindas

     Scanner read = new Scanner(System.in); // Criação de um objeto Scanner para leitura de entrada do usuário

     while (true) {
         // Menu do programa
         System.out.println("Escolha uma opção:");
         System.out.println("1 - Registrar Livro");
         System.out.println("2 - Listar Livros");
         System.out.println("3 - Buscar Livro");
         System.out.println("4 - Sair\n");

         int opcao = read.nextInt(); // Leitura da opção escolhida pelo usuário

         if (opcao == 1) {
             System.out.println("Digite o nome do livro:");
             String titulo = read.nextLine();
             titulo = read.nextLine();
             System.out.println("Digite o nome do Autor:");
             String autor = read.nextLine();
             System.out.println("Digite o nome da Editora:");
             String editora = read.nextLine();
             System.out.println("Digite o ano de Publicação:");
             String ano_Publi = read.nextLine();
             System.out.println("Digite o número de páginas:");
             int numero_paginas = read.nextInt();

             Livro novoLivro = new Livro(titulo, autor, editora, ano_Publi, numero_paginas);  // Cria o novo livro 
             biblioteca.addlivro(novoLivro); // Adiciona o novo Livro na biblioteca
         } else if (opcao == 2) {
             biblioteca.listarLivros(); // Chamada do método para listar os livros da biblioteca
             System.out.println(" ");
         } else if (opcao == 3) {
             System.out.println("Digite o título:\n");
             String titulo = read.nextLine();
             titulo = read.nextLine();
             Livro livroEncontrado = biblioteca.buscarLivro(titulo); // Chamada do método para buscar um livro pelo título

             if (livroEncontrado != null) {
                 System.out.println("\nLivro encontrado:\n");
                 System.out.println("Título: " + livroEncontrado.getTitulo());
                 System.out.println("Autor: " + livroEncontrado.getAutor());
                 System.out.println("Editora: " + livroEncontrado.getEditora());
                 System.out.println("Ano de Publicação: " + livroEncontrado.getAnoPubli());
                 System.out.println("Número de páginas: " + livroEncontrado.getNumeroPaginas());
                 System.out.println("");
             } else {
            	 
                 System.out.println("\nLivro não encontrado.");
                 System.out.println("");
             }
         } else if (opcao == 4) {
             break; // Encerra o loop e finaliza o programa
         }else if (opcao <1 || opcao>=5) {
        	 System.out.println("");
        	 System.out.println("A opção digitada de numero ["+opcao+"] não existe\n");
        	 System.out.println("Tente novamente\n");
         }
     }

     read.close(); // Fechamento do Scanner
 }
}