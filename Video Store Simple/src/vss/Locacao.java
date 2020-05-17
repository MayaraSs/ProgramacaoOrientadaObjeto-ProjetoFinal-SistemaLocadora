package vss;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Locacao implements Comparable<Locacao>, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L /*declaração para usar a serialização uma variavel */;
	public static int ID = 0;/*static que pode ser acessado sem instânciar um objeto*/
	private int idLocacao;
	private double total = 0.0;
	private Cliente cliente;
	private List<Filme> listaLocacoes = new ArrayList<Filme>();
	
	public int getIdLocacao() {
		return idLocacao;
	}
	public void setIdLocacao() {
		this.idLocacao = ID++;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Filme> getFilmesLocados() {
		return listaLocacoes;
	}
	
	public Locacao(Cliente cliente, List<Filme> lstFilme){ 	//registra a locacao, passando uma instancia de cliente e a lista de filmes locados
		setIdLocacao(); //registra um id unico para a locacao
		this.cliente = cliente; //registra o cliente que esta fazendo a locacao
		listaLocacoes = lstFilme;//a lista filmesLocados que foi declarada nesta classe recebe a lista passada por parametro
		for(Filme filme : lstFilme)//percorre a lista somando os valores dos filmes para ter o valor total a pagar
			total += filme.getPreco();	
	}
	
	public void imprimirLocacao(){ 	//imprime a locacao 
		System.out.println("Nº Locacao: " +this.idLocacao +"\tCliente nº: "+this.getCliente().getIdCliente() +"\tNome: " +this.getCliente().getNome() + "\tCPF: "+this.getCliente().getCpf());
		System.out.println("Filmes: ");
		for (Filme filme : listaLocacoes) {
			System.out.println("ID: "+filme.getIdFilme()+ "\tTitulo: "+filme.getTitulo()+  "\tPreco: " + filme.getPreco()+
					"\tLocado? "+filme.getLocado());
		}
		System.out.println("Total: "+total);
	}
	
	public int compareTo(Locacao locacao) {
		if(this.getIdLocacao() < locacao.getIdLocacao()) return -1;
		if(this.getIdLocacao() > locacao.getIdLocacao()) return 1;
		return 0;
	}
	

}
