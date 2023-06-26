package unifacs_projetos;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.addLivro(new Livro_Raro("Dom Casmurro", "Machado de Assis", "Garnier", "1899", 256, true, 1000.00));
        biblioteca.addLivro(new Livro_Raro("O Guarani", "José de Alencar", "B. L. Garnier", "1857", 368, true, 1500.00));
        biblioteca.addLivro(new Livro_Raro("Vidas Secas", "Graciliano Ramos", "Jose Olympio", "1938", 176, true, 2000.00));
        biblioteca.addLivro(new Livro_Raro("Capitaes da Areia", "Jorge Amado", "Martins", "1937", 256, true, 1000.00));
        biblioteca.addLivro(new Livro_Raro("A Hora da Estrela", "Clarice Lispector", "Rocco", "1977", 88, true, 1500.00));
        biblioteca.addLivro(new Livro_Raro("O Quinze", "Rachel de Queiroz", "Jose Olympio", "1930", 160, true, 1500.00));
        biblioteca.addLivro(new Livro_Raro("Macunaima", "Mário de Andrade", "Livros do Brasil", "1928", 192, true, 1500.00));
        biblioteca.addLivro(new Livro("Matheus", "1", "bdrio1", "1", 1));
        biblioteca.addLivro(new Livro("Matheus", "2", "bdrio2", "2", 2));
        biblioteca.addLivro(new Livro("Matheus", "3", "bdrio3", "3", 3));
        biblioteca.addLivro(new Livro("Matheus", "4", "bdrio4", "4", 4));

        System.out.println("Bem-vindo à Biblioteca Java 2023 Unifacs\n");

        Scanner read = new Scanner(System.in);

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Registrar Livro");
            System.out.println("2 - Listar Livros");
            System.out.println("3 - Buscar Livro");
            System.out.println("4 - Remover Livro");
            System.out.println("5 - Editar Livro");
            System.out.println("6 - Listar Livros por atributo");
            System.out.println("7 - Sair\n");

            String opcaoString = read.nextLine();
            int opcao = Integer.parseInt(opcaoString);

            if (opcao == 1) {
                System.out.println("Digite o nome do livro:");
                String titulo = read.nextLine();

                System.out.println("Digite o nome do Autor:");
                String autor = read.nextLine();

                System.out.println("Digite o nome da Editora:");
                String editora = read.nextLine();

                System.out.println("Digite o ano de Publicação:");
                String ano_Publi = read.nextLine();

                System.out.println("Digite o número de páginas:");
                int numero_paginas = Integer.parseInt(read.nextLine());
            System.out.println("Digite se o livro é raro (true/false):");
            boolean raro = Boolean.parseBoolean(read.nextLine());

            System.out.println("Digite o preço do livro:");
            double preco = Double.parseDouble(read.nextLine());

            Livro livro;
            if (raro) {
                livro = new Livro_Raro(titulo, autor, editora, ano_Publi, numero_paginas, raro, preco);
            } else {
                livro = new Livro(titulo, autor, editora, ano_Publi, numero_paginas);
            }

            biblioteca.addLivro(livro);
            System.out.println("Livro registrado com sucesso!");

        } else if (opcao == 2) {
            List<Livro> livros = biblioteca.listarLivros();
            if (livros.isEmpty()) {
                System.out.println("A biblioteca não possui livros cadastrados.");
            } else {
                System.out.println("Livros cadastrados na biblioteca:");
                for (Livro livro : livros) {
                    System.out.println(livro);
                }
            }

        } else if (opcao == 3) {
            System.out.println("Digite o título do livro que deseja buscar:");
            String titulo = read.nextLine();

            Livro livro = biblioteca.buscarLivro(titulo);
            if (livro == null) {
                System.out.println("O livro não foi encontrado na biblioteca.");
            } else {
                System.out.println("Livro encontrado:");
                System.out.println(livro);
            }

        } else if (opcao == 4) {
            System.out.println("Digite o título do livro que deseja remover:");
            String titulo = read.nextLine();

            boolean removido = biblioteca.removerLivro(titulo);
            if (removido) {
                System.out.println("Livro removido com sucesso!");
            } else {
                System.out.println("O livro não foi encontrado na biblioteca.");
            }

        } else if (opcao == 5) {
            System.out.println("Digite o título do livro que deseja editar:");
            String titulo = read.nextLine();

            Livro livro = biblioteca.buscarLivro(titulo);
            if (livro == null) {
                System.out.println("O livro não foi encontrado na biblioteca.");
            } else {
                System.out.println("Digite as novas informações do livro:");

                System.out.println("Digite o nome do Autor:");
                String autor = read.nextLine();

                System.out.println("Digite o nome da Editora:");
                String editora = read.nextLine();

                System.out.println("Digite o ano de Publicação:");
                String ano_Publi = read.nextLine();

                System.out.println("Digite o número de páginas:");
                int numero_paginas = Integer.parseInt(read.nextLine());

                livro.setAutor(autor);
                livro.setEditora(editora);
                livro.setAnoPublicacao(ano_Publi);
                livro.setNumeroPaginas(numero_paginas);

                System.out.println("Livro editado com sucesso!");
            }

        } else if (opcao == 6) {
            System.out.println("Escolha um atributo para listar os livros:");
            System.out.println("1 - Título");
            System.out.println("2 - Autor");
            System.out.println("3 - Editora");
            System.out.println("4 - Ano de Publicação");
            System.out.println("5 - Número de Páginas");

            String atributoString = read.nextLine();
            int atributo = Integer.parseInt(atributoString);

            List<Livro> livros = biblioteca.listarLivrosOrdenados(atributo);
            if (livros.isEmpty()) {
                System.out.println("A biblioteca não possui livros cadastrados.");
            } else {
                System.out.println("Livros cadastrados na biblioteca, ordenados por " + atributoString + ":");
                for (Livro livro : livros) {
                    System.out.println(livro);
                }
            }

        } else if (opcao == 7) {
            System.out.println("Saindo do programa...");
            break;
        } else {
            System.out.println("Opção inválida. Tente novamente.");
        }
    }
}
