package vss;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;



public class GerenciaFilme {
	private List <Filme> listaFilme = new ArrayList<Filme>();

	
	public GerenciaFilme(){
	}

	public void adiciona(Filme filme) {
		System.out.println("\n[Adicionar filme]");
		this.listaFilme.add(filme);
		System.out.println("\nFilme adicionado.");
	}
	
	public void remove(Filme filme){
		System.out.println("\n[Remover filme]");
		this.listaFilme.remove(filme);
		System.out.println("Filme removido.");
	}

	public void imprimeListaFilme(){
		this.getListaFilmesOrdenada();
		System.out.println("\n[Lista de Filmes] \n");
		for (Filme filme : listaFilme) {
			System.out.println("ID: "+filme.getIdFilme()+ "\tCategoria: "+filme.getIdCategoria()+ 
				"\tTitulo: "+filme.getTitulo()+ "\tGenero: "+filme.getGenero()+ "\tPreco: " + filme.getPreco()+
					"\tLocado? "+filme.getLocado());
		}
	}
	
	public List<Filme> getListaFilmesOrdenada(){
		Collections.sort(this.listaFilme);
		return this.listaFilme;
	}

	
}