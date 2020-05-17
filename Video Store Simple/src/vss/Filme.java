package vss;

import java.io.Serializable;

public class Filme implements Comparable<Filme>, Serializable {
	
	private static final long serialVersionUID = 1L;
	public static int ID = 0;
	private int idFilme = 0;
	private int idCategoria = 0;
	private String titulo = " ";
	private String genero = " ";
	private double preco;
	private boolean locado; 
	
	public Filme(int idCategoria, String titulo, String genero){
		this.setIdFilme();
		this.setIdCategoria(idCategoria);
		this.setTitulo(titulo);
		this.setGenero(genero);
		this.setLocado(false);/*booleano */
		this.setPreco();
	}
	
	public int getIdFilme() {
		return idFilme;
	}
	public void setIdFilme() {
		this.idFilme = ID++;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		/* categoria 1 = Lançamento R$ 10,00 categoria 2 = Catálogo R$ 5,00 */
		if (idCategoria == 1 || idCategoria == 2) 
			this.idCategoria = idCategoria;		
		else{
			System.out.println("Categoria nao existente! Adicionado a catalogo.");
			this.idCategoria=2;
		}
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco() {
		if(this.idCategoria==1)
			this.preco=10.0;
		if(this.idCategoria==2)
			this.preco=5.0;
	}
	/*VER COM A RA ESSA PARTE*/
	public boolean getLocado() {
		return locado;
	}
	public void setLocado(boolean locado) {
		this.locado = locado;
	}
	
	public int compareTo(Filme filme) {
		if(this.getIdFilme() < filme.getIdFilme()) return -1;
		if(this.getIdFilme() > filme.getIdFilme()) return 1;			
		return 0;
	}


	
}
