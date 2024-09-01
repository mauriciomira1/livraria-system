import java.time.LocalDate;

public class Emprestimo {
  private Livro livro;
  private String nomeCliente;
  private LocalDate dataEmprestimo;

  public Emprestimo(Livro livro, String nomeCliente) {
    this.livro = livro;
    this.nomeCliente = nomeCliente;
    this.dataEmprestimo = LocalDate.now();
  }

  public Livro getLivro() {
    return livro;
  }

  public String getNomeCliente() {
    return nomeCliente;
  }

  public LocalDate getDataEmprestimo() {
    return dataEmprestimo;
  }

  @Override
  public String toString() {
    return String.format("Livro: %s, Cliente: %s, Data: %s", livro, nomeCliente, dataEmprestimo);
  }
}
