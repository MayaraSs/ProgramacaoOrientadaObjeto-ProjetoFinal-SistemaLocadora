package vss;


public class teste {

	public static void main(String[] args) {
		
		System.out.println("===========================================Locadora VSS========================================\n");
		GerenciaCliente gerenciaCliente = new GerenciaCliente();
		GerenciaFilme gerenciaFilme = new GerenciaFilme();
		
		Cliente cliente1 = new Cliente("Raissa",22,"Cidade alta, Ararangua","raissa.boeng@gmail.com","4820103040","feminino","012345678-90");
		gerenciaCliente.adiciona(cliente1);
		Cliente cliente2 = new Cliente("Erick",21,"Jardim das Avenidas, Ararangua","erick.becker@gmail.com","4840301050","masculino","993847923-95");
		gerenciaCliente.adiciona(cliente2);
		Cliente cliente3 = new Cliente("Maria",50,"Jurere, Florianopolis","maria@gmail.com","4810334012","feminino","345572364-45");
		gerenciaCliente.adiciona(cliente3);
		
		gerenciaCliente.imprimeListaCliente();
		gerenciaCliente.remove(cliente3);
		gerenciaCliente.imprimeListaCliente();
		

		
		Filme f1 = new Filme(1,"Velozes & Furiosos 7","Acao");
		gerenciaFilme.adiciona(f1);
		Filme f2 = new Filme(2,"A Era do Gelo","Animacao");
		gerenciaFilme.adiciona(f2);
		Filme f3 = new Filme(2,"Divergente ","Aventura");
		gerenciaFilme.adiciona(f3);
		Filme f4 = new Filme(2,"O lobo de Wall Street","Comedia");
		gerenciaFilme.adiciona(f4);
		
		gerenciaFilme.imprimeListaFilme();
		gerenciaFilme.remove(f4);
		gerenciaFilme.imprimeListaFilme();
		

		
		gerenciaCliente.locacao(cliente1, 0, f1, f2);
		gerenciaCliente.devolucao(cliente1, f1, 0);
		gerenciaCliente.devolucao(cliente1, f1, 15);
		gerenciaCliente.devolucao(cliente1, f2, 0);
		
		gerenciaCliente.locacao(cliente2, 20, f2, f3);
		gerenciaCliente.locacao(cliente1,0,f2);
		gerenciaCliente.devolucao(cliente2, f2, 10);
		gerenciaCliente.devolucao(cliente2, f3, 0);


		
		
		
		
		

		
	}
		}

