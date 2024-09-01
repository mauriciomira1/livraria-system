import java.time.LocalDate;

public class Livro {
  private int id;
  private String titulo;
  private Autor autor;
  private boolean disponivel;
  private LocalDate dataCadastro;
  private LocalDate dataAtualizacao;

  public Livro(int id, String titulo, Autor autor) {
    this.id = id;
    this.titulo = titulo;
    this.autor = autor;
    this.disponivel = true;
    this.dataCadastro = LocalDate.now();
    this.dataAtualizacao = LocalDate.now();
  }

  public int getId() {
    return id;
  }

  public String getTitulo() {
    return titulo;
  }

  public Autor getAutor() {
    return autor;
  }

  public boolean isDisponivel() {
    return disponivel;
  }

  public void emprestar() {
    if (disponivel) {
      disponivel = false;
    } else {
      throw new IllegalStateException("Livro não está disponível.");
    }
  }

  public void devolver() {
    disponivel = true;
  }

  @Override
  public String toString() {
    return String.format("%d - %s (%s)", id, titulo, autor);
  }
}
