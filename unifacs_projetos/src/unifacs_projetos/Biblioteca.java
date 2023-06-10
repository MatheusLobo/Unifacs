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
    

    public void editarLivro(int id, String atributo, String novoValor) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                if (livro instanceof Livro_Raro) {
                    Livro_Raro livroRaro = (Livro_Raro) livro;

                    switch (atributo.toLowerCase()) {
                        case "titulo":
                            System.out.println("Alterando o título do livro...");
                            livroRaro.setTitulo(novoValor);
                            System.out.println("O título do livro foi atualizado.");
                            break;
                        case "autor":
                            System.out.println("Alterando o autor do livro...");
                            livroRaro.setAutor(novoValor);
                            System.out.println("O autor do livro foi atualizado.");
                            break;
                        case "editora":
                            System.out.println("Alterando a editora do livro...");
                            livroRaro.setEditora(novoValor);
                            System.out.println("A editora do livro foi atualizada.");
                            break;
                        case "ano":
                            System.out.println("Alterando o ano de publicação do livro...");
                            livroRaro.setAnoPubli(novoValor);
                            System.out.println("O ano de publicação do livro foi atualizado.");
                            break;
                        case "paginas":
                            System.out.println("Alterando o número de páginas do livro...");
                            livroRaro.setNumeroPaginas(Integer.parseInt(novoValor));
                            System.out.println("O número de páginas do livro foi atualizado.");
                            break;
                        case "raridade":
                            System.out.println("Definindo a raridade do livro...");
                            if (novoValor.equalsIgnoreCase("sim")) {
                                livroRaro.setRaridade(true);
                            } else if (novoValor.equalsIgnoreCase("nao")) {
                                livroRaro.setRaridade(false);
                            } else {
                                System.out.println("Opção inválida para raridade.");
                                return;
                            }
                            System.out.println("A raridade do livro foi atualizada.");
                            break;
                        case "valor_mercado":
                            System.out.println("Alterando o valor de mercado do livro...");
                            double valorMercado = Double.parseDouble(novoValor);
                            livroRaro.setValor_mercado(valorMercado);
                            System.out.println("O valor de mercado do livro foi atualizado.");
                            break;
                        default:
                            System.out.println("Opção inválida.");
                            return;
                    }
                } else {
                    System.out.println("O livro não é do tipo LivroRaro.");
                }
                System.out.println("Livro editado com sucesso.");
                return;
            }
        }
        System.out.println("Livro não encontrado.");
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