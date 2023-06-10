package unifacs_projetos;

import java.util.Scanner;
import java.util.List;

public class Program {
    public static void main(String[] args) {
    	Biblioteca biblioteca = new Biblioteca();
    	biblioteca.addlivro(new Livro_Raro("Dom Casmurro", "Machado de Assis", "Garnier", "1899", 256, true, 1000.00));
    	biblioteca.addlivro(new Livro_Raro("O Guarani", "José de Alencar", "B. L. Garnier", "1857", 368, true, 1500.00));
    	biblioteca.addlivro(new Livro_Raro("Vidas Secas", "Graciliano Ramos", "Jose Olympio", "1938", 176, true, 2000.00));
    	biblioteca.addlivro(new Livro_Raro("Capitaes da Areia", "Jorge Amado", "Martins", "1937", 256, true, 1000.00));
    	biblioteca.addlivro(new Livro_Raro("A Hora da Estrela", "Clarice Lispector", "Rocco", "1977", 88, true, 1500.00));
    	biblioteca.addlivro(new Livro_Raro("O Quinze", "Rachel de Queiroz", "Jose Olympio", "1930", 160, true, 1500.00));
    	biblioteca.addlivro(new Livro_Raro("Macunaima", "Mário de Andrade", "Livros do Brasil", "1928", 192, true, 1500.00));
    	biblioteca.addlivro(new Livro("Matheus", "1", "bdrio1", "1", 1));
    	biblioteca.addlivro(new Livro("Matheus", "2", "bdrio2", "2", 2));
    	biblioteca.addlivro(new Livro("Matheus", "3", "bdrio3", "3", 3));
    	biblioteca.addlivro(new Livro("Matheus", "4", "bdrio4", "4", 4));

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
                
                System.out.println("Digite se o livro é um raro primeira edição (sim/não):");
                String raridadeString = read.nextLine();
                boolean raridade = raridadeString.equalsIgnoreCase("sim");

                Livro novoLivro;

                if (raridade) {
                    System.out.println("Digite o valor do livro :");
                    double valor_mercado = Double.parseDouble(read.nextLine());
                    novoLivro = new Livro_Raro(titulo, autor, editora, ano_Publi, numero_paginas, raridade, valor_mercado);
                } else {
                    novoLivro = new Livro(titulo, autor, editora, ano_Publi, numero_paginas);
                }

                biblioteca.addlivro(novoLivro);
            } else if (opcao == 2) {
                biblioteca.listarLivros();
                System.out.println(" ");
            } else if (opcao == 3) {
                System.out.println("Digite o título do livro que deseja buscar:");
                String tituloBusca = read.nextLine();
                List<Livro> livrosEncontrados = biblioteca.buscarLivro(tituloBusca);
                if (livrosEncontrados.isEmpty()) {
                    System.out.println("Nenhum livro encontrado com esse título.");
                } else {
                    System.out.println("Livros encontrados:");
                    for (Livro livro : livrosEncontrados) {
                    	System.out.println("ID: " + livro.getId());
                        System.out.println("Título: " + livro.getTitulo());
                        System.out.println("Autor: " + livro.getAutor());
                        System.out.println("Editora: " + livro.getEditora());
                        System.out.println("Ano de Publicação: " + livro.getAnoPubli());
                        System.out.println("Número de Páginas: " + livro.getNumeroPaginas());
                        if (livro instanceof Livro_Raro) {
                            Livro_Raro livroRaro = (Livro_Raro) livro;
                            System.out.println("Raridade: " + livroRaro.getRaridade());
                            System.out.println("Valor de Mercado: " + livroRaro.getValor_mercado());
                        }
                        System.out.println();
                    }
                }
            } else if (opcao == 4) {
                System.out.println("\nDigite o título do livro que deseja remover:\n");
                String tituloBusca = read.nextLine();

                List<Livro> livrosEncontrados = biblioteca.buscarLivro(tituloBusca);

                if (livrosEncontrados.isEmpty()) {
                    System.out.println("Nenhum livro encontrado com o título informado.\n");
                } else {
                    System.out.printf("%-6s%-25s%-25s%-25s%-20s%-15s%-15s%s%n", "ID", "Título", "Autor", "Editora", "Ano de Publicação", "Páginas", "Raridade", "Valor de Mercado");

                    for (Livro livro : livrosEncontrados) {
                        System.out.printf("%-6d%-25s%-25s%-25s%-20s%-15d", livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getEditora(), livro.getAnoPubli(), livro.getNumeroPaginas());
                        if (livro instanceof Livro_Raro) {
                            Livro_Raro livroRaro = (Livro_Raro) livro;
                            System.out.printf("%-15s%-15.2f", livroRaro.getRaridade(), livroRaro.getValor_mercado());
                        } else {
                            System.out.printf("%-15s%-15s", "-", "-");
                        }
                        System.out.println();
                    }

                    System.out.println("\nDigite o ID do livro que deseja remover:");
                    int idRemocao = Integer.parseInt(read.nextLine());

                    boolean livroRemovido = biblioteca.removerLivro(idRemocao);

                    if (livroRemovido) {
                        System.out.println("Livro removido com sucesso!\n");
                    } else {
                        System.out.println("Falha ao remover o livro. Verifique o ID informado.\n");
                    }
                }
            } else if (opcao == 5) {
                System.out.println("Lista de Livros:");
                biblioteca.listarLivros();
                System.out.println("\nDigite o ID do livro que deseja editar:\n");
                int idLivro = Integer.parseInt(read.nextLine());

                System.out.println("Digite a opção que deseja editar (todos, titulo, autor, editora, ano, paginas, raridade, valor):");
                String opcaoEdicao = read.nextLine();

                System.out.println("Digite o novo valor:");
                String novoValor = read.nextLine();

                biblioteca.editarLivro(idLivro, opcaoEdicao, novoValor);
            }else if (opcao == 6) {
                System.out.println("Digite o atributo pelo qual deseja procurar (id, titulo, autor, editora, ano, paginas, raridade, valor):");
                String atributo = read.nextLine();
                System.out.println("Digite o valor do atributo:");
                String valor = read.nextLine();
                biblioteca.listarAtributo(atributo,valor);
                }else if (opcao == 7) {
                System.out.println("Obrigado por utilizar a Biblioteca Java 2023 Unifacs. Até mais!");
                break;
            } else {
                System.out.println("Opção inválida. Digite novamente.\n");
            }
        }

        read.close();
    }
}