package modelo;

public class Libro {
	
	private int isbn;
	private String titulo;
	private String autor;
	
	public Libro(int isbn, String titulo, String autor) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + "]";
	}
		
		
		
}
