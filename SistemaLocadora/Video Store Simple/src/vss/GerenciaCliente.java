package vss;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class GerenciaCliente {
	private List <Cliente> listaCliente = new ArrayList<Cliente>(); //cria lista de cliente

	public List<Cliente> getListaCliente() {
		return listaCliente;
	}
	
	public void adiciona(Cliente cliente) { //Adiciona instância de cliente para lista de cliente
		System.out.println("\n[Adicionar cliente]");
		this.listaCliente.add(cliente);
		System.out.println("Cliente adicionado.");
	}

	public void remove(Cliente cliente) { 	//Remove instância de cliente da lista de clientes
		System.out.println("\n[Remover cliente]");
		if(cliente.getListaLocacoes().size()==0){	//se o tamanho da lista for 0 entao remove o cliente
			listaCliente.remove(cliente);
			System.out.println("\nCliente  removido.");
		}else{ 																			
				System.out.println("ATENCAO! Cliente tem locacoes pendentes!"); 	// exibe mensagem de erro
				return;
		}
	}
	
	public void imprimeListaCliente() {//Imprime lista de clientes
		this.getListaClienteOrdenada(
		System.out.println("\n[Lista de Clientes] \n");
		for (Cliente cliente : listaCliente) {
			System.out.println("ID: "+cliente.getIdCliente()+ "\tNome: "+cliente.getNome()+ 
						"\tIdade: "+cliente.getIdade()+ "\tEmail: "+cliente.getEmail()+ "\tEndereco: " + cliente.getEndereco()+
						"\tTelefone: "+cliente.getTelefone() + "\tSexo:"+cliente.getSexo() + "\tCPF:"+cliente.getCpf());
			for (Locacao locacao : cliente.getListaLocacoes()) 
				locacao.imprimirLocacao();
		}
	}
	
	public List<Cliente> getListaClienteOrdenada(){ 	//Ordena lista de clientes
		Collections.sort(this.listaCliente);
		return this.listaCliente;
	}
		//Faz uma locacao
	public void locacao(Cliente cliente, float valorAPagar, Filme...filmes ){ 	//Filme ... filmes = parâmetros variáveis do tipo Filme
		System.out.println("\n[Locacao]");
		if(filmes.length == 0 || filmes.length > 3){ 										//testa se a quantidade de filmes esta entre 1 e 3
			System.out.println("ATENCAO! Voce nao pode alugar 0 ou mais que 3 filmes! ");	//se não estiver exibe mensagem e sai do metodo
			return;
		}
		for(Locacao locacao : cliente.getListaLocacoes()){ 									//dentro da lista de locacao de determinado cliente
			if(locacao.getFilmesLocados().size() > 0){ 										//se o tamanho da lista de filmes locados de determinado cliente for maior que 0
				System.out.println("ATENCAO! Voce tem locacoes pendentes!"); 				// exibe mensagem de erro
				locacao.imprimirLocacao(); 														// exibe a lista de locacao existente, ou seja, os filmes que precisam ser devolvidos
				return;
			}
		}
			List<Filme> temp = new ArrayList<Filme>();//cria uma lista de filmes temporaria
			for(Filme filme : filmes){ 	//percorre o vetor de filmes que foi passado para o metodo locacao
				if(filme.getLocado() == false){ //testa se o filme esta com o atributo locado em 'false'
					temp.add(filme); 	//se sim, adiciona a lista de filme temporaria
					filme.setLocado(true); //e altera o atributo locado para 'true'
				}else 					//se nao, exibe mensagem
					System.out.println("ATENCAO! Cliente ' " + cliente.getNome() + " ' nao pode locar ' " + filme.getTitulo() + " ' pois esta indisponivel no momento.");
			}
			Locacao locacao = new Locacao(cliente, temp); //cria nova locacao passando novo cliente e a lista temporaria de filmes locados
			cliente.getListaLocacoes().add(locacao); //adiciona a nova locacao à lista de locacao do cliente
			System.out.println("\nLocacao efetuada com sucesso!"); 
			if(valorAPagar <= locacao.getTotal()) 											
				//testa se o valorAPagar passado por parametro é menor ou igual ao valor total da locacao
				locacao.setTotal(locacao.getTotal() - valorAPagar);//se for, diminui do total o valorAPagar
			else{//se não, se for maior, o total da locacao é zerado e imprime o troco do cliente
				System.out.println("Troco="+Math.abs(locacao.getTotal() - valorAPagar)); //exibe o retorno da funcao math.abs, que é o valor absoluto, ou seja sem sinal
				locacao.setTotal(0);
			}
			locacao.imprimirLocacao(); //chama funcao imprimir de locacao, onde exibe ID locacao, cliente, cpf e filmes locados, juntamente com o total a pagar
		} 

	
		public void imprimirLocacao(){ 	//Imprime todas as locacoes de todos os clientes
			for(Cliente cliente : listaCliente)
				for(Locacao locacao : cliente.getListaLocacoes())
					locacao.imprimirLocacao();
		}
	
	public void devolucao(Cliente cliente, Filme filme, double valorAPagar){// Metodo que devolve filme, passando instancia de cliente, a instancia de filme, e o valor a pagar		
		System.out.println("\n[Devolucao] \n");	
		for(Locacao locacao : cliente.getListaLocacoes()){ //percorre a lista de locacoes do cliente
				if(locacao.getFilmesLocados().contains(filme)){ //se o filme passado por parametro conter na lista
					if(locacao.getTotal() >= 0 && valorAPagar >= locacao.getTotal()){ 		//se o total for maior que 0 e o valorAPagar for maior ou igual ao total	
						System.out.println("Troco: R$ " + Math.abs(locacao.getTotal()- valorAPagar)); 							//é impresso troco 
						locacao.setTotal(//o total recebe valor 0
					}else{ //se nao, é impressa mensagem que indica o valor que precisa ser pago para poder registrar a devolucao do filme
						System.out.println("Nao foi possivel realizar sua devolucao, por favor, pague o valor devido.");
						System.out.println("Valor: " + locacao.getTotal());
						return;
					}	
					if (locacao.getTotal() == 0){
						locacao.getFilmesLocados().remove(filme); //se o filme estiver contido na lista de filmesLocados, e o total for 0, ele é removido da lista
						filme.setLocado(false);//e o atributo locado é setado com o valor false
						System.out.println("Devolucao efetuada!"); //e é impressa a mesnsagem de devolução
					}
				}
				locacao.imprimirLocacao(); 	//imprime a lista de locacao do cliente
			}
		}

	
	}