package unifacs_projetos;

//Importação das classes Scanner e ArrayList
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

//Definição da classe Biblioteca
public class Biblioteca {
ArrayList<Livro> livros; // Cria um ArrayList para armazenar os livros da biblioteca

// Construtor da classe Biblioteca
public Biblioteca() {
   livros = new ArrayList<>(); // Inicializa a lista de livros vazia
}



//Método para adicionar um livro à biblioteca
public void addlivro(Livro livro) {
    livro.setId(gerarNovoId());// Gera um novo ID para o livro
    livros.add(livro);// Adiciona o livro à lista de livros da biblioteca
}
public int gerarNovoId() {
    int novoId = livros.size() + 1;
    while (existeId(novoId)) {
        novoId++;
    }
    return novoId;
}
public boolean existeId(int id) {
    for (Livro livro : livros) {
        if (livro.getId() == id) {
            return true;
        }
    }
    return false;
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


public List<Livro> buscarLivro(String titulo) {
    List<Livro> livrosEncontrados = new ArrayList<>();

    for (Livro livro : livros) {
        if (livro.getTitulo().equalsIgnoreCase(titulo)) {
            livrosEncontrados.add(livro);
        }
    }

    return livrosEncontrados;
}
public boolean removerLivro(int id) {
    for (Livro livro : livros) {
        if (livro.getId() == id) {
            livros.remove(livro);
            return true; // Livro encontrado e removido com sucesso
        }
    }
    return false; // Livro não encontrado
}
public void imprimirLivro(Livro livro) {
    System.out.println("ID: " + livro.getId());
    System.out.println("\tTítulo: " + livro.getTitulo());
    System.out.println("\tAutor: " + livro.getAutor());
    System.out.println("\tEditora: " + livro.getEditora());
    System.out.println("\tAno de Publicação: " + livro.getAnoPubli());
    System.out.println("\tNúmero de páginas: " + livro.getNumeroPaginas());
}
}
	
	
	
	





