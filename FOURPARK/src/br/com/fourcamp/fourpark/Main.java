package br.com.fourcamp.fourpark;

import java.util.Scanner;

import br.com.fourcamp.fourpark.model.Pessoa;
import br.com.fourcamp.fourpark.model.Vaga;
import br.com.fourcamp.fourpark.model.Veiculo;

public class Main {

	public static void main(String[] args) {
		
		Vaga[] vagas = new Vaga[50];
		//Pessoa pessoa = new Pessoa();
		//Veiculo veiculo = new Veiculo();
		
		for(int x=1; x<=vagas.length; x++) {
			
			Vaga vaga = new Vaga(x);
			
			if(vaga.getPosicao()%2==0) {
				vaga.setOcupado(true);
			}
			
			vagas[x - 1] = vaga;
			
		}
		System.out.println("Foram criadas " + vagas.length + " vagas.");
		
		Integer opcao;
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Insira uma opção: 01 - Vagas Disponíveis  /  02 - Sair.");
			
			opcao = sc.nextInt();
			if(opcao == 1) {
				
				for(int x = 0; x < vagas.length; x++) {
					if(vagas[x].getOcupado()) {
						
						System.out.println("Vaga " + vagas[x].getPosicao() + " disponível.");
					} 
				}
			}
			if(opcao == 2) {
				break;
			}
		}

	}

}
