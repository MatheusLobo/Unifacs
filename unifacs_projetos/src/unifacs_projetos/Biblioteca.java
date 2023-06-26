package unifacs_projetos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Biblioteca {
    private List<Livro> livros;

    public Biblioteca() {
        livros = new ArrayList<>();
    }

    public void addlivro(Livro livro) {
        int novoId = gerarNovoId();
        livro.setId(novoId);
        livros.add(livro);
        System.out.println("Livro adicionado com sucesso.");
    }

    public boolean removerLivro(int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                livros.remove(livro);
                System.out.println("Livro removido com sucesso.");
                return true;
            }
        }
        System.out.println("Livro não removido.");
		return false;
    }
    
    public boolean existeId(int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public int gerarNovoId() {
        Random random = new Random();
        int novoId = random.nextInt(10000) + 1;
        while (existeId(novoId)) {
            novoId = random.nextInt(10000) + 1;
        }
        return novoId;
    }
    
    public List<Livro> buscarLivro(String titulo) {
        List<Livro> livrosEncontrados = new ArrayList<>();

        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                livrosEncontrados.add(livro);
            }
        }

        return livrosEncontrados;
    }


    // Método para listar todos os livros da biblioteca
    public void listarLivros() {
        System.out.println("\nLivros Registrados:\n");
        System.out.printf("%-6s %-25s %-25s %-25s %-20s %s%n",
            "ID", "Título", "Autor", "Editora", "Ano de Publicação", "Páginas");

        for (Livro livro : livros) {
            System.out.printf("%-6d %-25s %-25s %-25s %-20s %d%n",
                livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getEditora(),
                livro.getAnoPubli(), livro.getNumeroPaginas());
        }
    }
    

    public void editarLivros() {
        Scanner read = new Scanner(System.in);

        System.out.println("Lista de Livros:");
        biblioteca.listarLivros();

        System.out.println("\nDigite o número do livro que deseja editar:");
        int numeroLivro = read.nextInt();

        if (numeroLivro >= 1 && numeroLivro <= biblioteca.getQuantidadeLivros()) {
            Livro livro = biblioteca.getLivroByNumero(numeroLivro);

            if (livro instanceof LivroDigital) {
                LivroDigital livroDigital = (LivroDigital) livro;
                System.out.println("Opções de edição disponíveis: todos, título, autor, editora, ano, páginas, formato, tamanho.");

                System.out.println("Digite a opção que deseja editar:");
                String opcaoEdicao = read.next();

                System.out.println("Digite o novo valor:");
                String novoValor = read.nextLine();
                novoValor = read.nextLine();

                biblioteca.editarLivroDigital(livroDigital.getId(), opcaoEdicao, novoValor);
            } else {
                System.out.println("Opções de edição disponíveis: todos, título, autor, editora, ano, páginas, gênero.");

                System.out.println("Digite a opção que deseja editar:");
                String opcaoEdicao = read.next();

                System.out.println("Digite o novo valor:");
                String novoValor = read.nextLine();
                novoValor = read.nextLine();

                biblioteca.editarLivro(livro.getId(), opcaoEdicao, novoValor);
            }

            System.out.println("Livro editado com sucesso.");
        } else {
            System.out.println("Número de livro inválido.");
        }
    }
    

    public void listarAtributo(String atributo, String valorBusca) {
        List<Livro> livrosEncontrados;

        switch (atributo.toLowerCase()) {
            case "id":
                int id = Integer.parseInt(valorBusca);
                livrosEncontrados = livros.stream()
                        .filter(livro -> livro.getId() == id)
                        .collect(Collectors.toList());
                break;
            case "titulo":
                livrosEncontrados = livros.stream()
                        .filter(livro -> livro instanceof Livro_Raro &&
                                ((Livro_Raro) livro).getTitulo().equalsIgnoreCase(valorBusca))
                        .collect(Collectors.toList());
                break;
            case "autor":
                livrosEncontrados = livros.stream()
                        .filter(livro -> livro instanceof Livro_Raro &&
                                ((Livro_Raro) livro).getAutor().equalsIgnoreCase(valorBusca))
                        .collect(Collectors.toList());
                break;
            case "editora":
                livrosEncontrados = livros.stream()
                        .filter(livro -> livro instanceof Livro_Raro &&
                                ((Livro_Raro) livro).getEditora().equalsIgnoreCase(valorBusca))
                        .collect(Collectors.toList());
                break;
            case "ano":
                livrosEncontrados = livros.stream()
                        .filter(livro -> livro instanceof Livro_Raro &&
                                ((Livro_Raro) livro).getAnoPubli().equalsIgnoreCase(valorBusca))
                        .collect(Collectors.toList());
                break;
            case "paginas":
                livrosEncontrados = livros.stream()
                        .filter(livro -> livro instanceof Livro_Raro &&
                                ((Livro_Raro) livro).getNumeroPaginas() == Integer.parseInt(valorBusca))
                        .collect(Collectors.toList());
                break;
            case "raridade":
                if (valorBusca.equalsIgnoreCase("true")) {
                    livrosEncontrados = livros.stream()
                            .filter(livro -> livro instanceof Livro_Raro && valorBusca.equalsIgnoreCase("true"))
                            .collect(Collectors.toList());
                } else if (valorBusca.equalsIgnoreCase("false")) {
                	livrosEncontrados = livros.stream()
                            .filter(livro -> livro instanceof Livro_Raro && valorBusca.equalsIgnoreCase("false"))
                            .collect(Collectors.toList());
                } else {
                    System.out.println("Opção inválida para raridade.");
                    return;
                }
                break;
            case "valor_mercado":
                double valorMercado = Double.parseDouble(valorBusca);
                livrosEncontrados = livros.stream()
                        .filter(livro -> livro instanceof Livro_Raro &&
                                ((Livro_Raro) livro).getValor_mercado() == valorMercado)
                        .collect(Collectors.toList());
                break;
            default:
                System.out.println("Atributo inválido.");
                return;
        }

        System.out.println("\nLivros Registrados (Atributo: " + atributo + "):\n");
        System.out.printf("%-6s %-25s %-25s %-25s %-20s %-15s %s%n",
                "ID", "Título", "Autor", "Editora", "Ano de Publicação", "Páginas", "Valor de Mercado\n");

        for (Livro livro : livrosEncontrados) {
            if (livro instanceof Livro_Raro) {
                Livro_Raro livroRaro = (Livro_Raro) livro;
                System.out.printf("%-6d %-25s %-25s %-25s %-20s %-15d %.2f%n",
                        livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getEditora(),
                        livro.getAnoPubli(), livro.getNumeroPaginas(), livroRaro.getValor_mercado());
            }
        }
    }
}