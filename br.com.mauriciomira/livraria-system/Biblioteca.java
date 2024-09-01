import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
  private List<Livro> livros = new ArrayList<>();
  private List<Emprestimo> emprestimos = new ArrayList<>();
  private Scanner scanner = new Scanner(System.in);

  public Biblioteca() {
    // Inicializando com alguns livros e autores
    Autor autor1 = new Autor(1, "George Orwell", LocalDate.of(1903, 6, 25));
    Autor autor2 = new Autor(2, "J.K. Rowling", LocalDate.of(1965, 7, 31));
    livros.add(new Livro(1, "1984", autor1));
    livros.add(new Livro(2, "Harry Potter e a Pedra Filosofal", autor2));
  }

  public void listarLivros() {
    System.out.println("Livros disponíveis:");
    for (Livro livro : livros) {
      if (livro.isDisponivel()) {
        System.out.println(livro);
      }
    }
  }

  public void emprestarLivro() {
    listarLivros();
    System.out.print("Digite o ID do livro que deseja emprestar: ");
    int idLivro = scanner.nextInt();
    scanner.nextLine(); // Consumir a nova linha

    Livro livro = encontrarLivroPorId(idLivro);
    if (livro != null && livro.isDisponivel()) {
      System.out.print("Digite seu nome: ");
      String nomeCliente = scanner.nextLine();
      livro.emprestar();
      emprestimos.add(new Emprestimo(livro, nomeCliente));
      System.out.println("Livro emprestado com sucesso!");
    } else {
      System.out.println("Livro não encontrado ou não disponível.");
    }
  }

  private Livro encontrarLivroPorId(int id) {
    for (Livro livro : livros) {
      if (livro.getId() == id) {
        return livro;
      }
    }
    return null;
  }

  public void iniciar() {
    while (true) {
      System.out.print("Gostaria de ver os livros disponíveis? (SIM/NÃO): ");
      String resposta = scanner.nextLine().trim().toUpperCase();
      if (resposta.equals("SIM")) {
        emprestarLivro();
      } else if (resposta.equals("NÃO")) {
        System.out.println("Fim da aplicação.");
        break;
      } else {
        System.out.println("Resposta inválida. Por favor, digite SIM ou NÃO.");
      }
    }
  }
}
