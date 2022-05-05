package Tentativa;

import java.util.Date;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {

		Vaga[] vagas = new Vaga[50];
		Integer opcao = -1;
		Scanner sc = new Scanner(System.in);

		while (opcao != 0) {
			System.out.println("\n ____Bem vindo ao FourParking____" 
					+ "\n|________________________________|"
					+ "\n|1 - Consultar vagas ocupadas    |" 
					+ "\n|2 - Consultar vagas dispon�veis |"
					+ "\n|3 - Colocar carro em vaga       |" 
					+ "\n|4 - Retirar carro em vaga       |"
					+ "\n|5 - Dados da vaga               |"
					+ "\n|--------------------------------|" 
					+ "\n|        0 - S A I R             |"
					+ "\n|________________________________|"
					+ "\n"
					+ "\nInforme a opera��o desejada >>>");

			opcao = sc.nextInt();
			
			switch (opcao) {
			case 1:
				
				String vagasDisponiveis = "\n\nAs vagas ocupadas s�o: \n";
				
				for(int i = 1; i < vagas.length; i++) {
					if (vagas[i] != null) {
						int vagaCorreta = i;
						vagasDisponiveis += vagaCorreta + ", ";
					}
				}
				System.out.println(vagasDisponiveis);
				break;
				
			case 2:
				String vagasOcupadas = "\n\nAs vagas dispon�veis s�o: \n";

				for (int i = 1; i < vagas.length; i++) {
					if (vagas[i] == null) {
						int vagaCorreta = i;
						vagasOcupadas += vagaCorreta + ", ";
					}
				}
				System.out.println(vagasOcupadas);
				break;
				
			case 3:
				System.out.println("Digite a placa do carro: ");
				String placa = sc.next();
				System.out.println("Digite o modelo do ve�culo: ");
				String modelo = sc.next();
				
				Veiculo veiculo = new Veiculo();
				veiculo.setModelo(modelo);
				veiculo.setPlaca(placa);
				
				Date d = new Date();
				
				Vaga vaga = new Vaga();
				vaga.setHoraEntrada(d);
				vaga.setVeiculo(veiculo);
				
				System.out.println("Digite a vaga que ser� ocupada: ");
				int i = sc.nextInt();
				
				vagas[i] = vaga;
				
				break;
				
			case 4:
				System.out.println("Digite a vaga que ser� desocupada: ");
				
				int x = sc.nextInt();
				
				if(vagas[x] == null) {
					System.out.println("N�o existem carros nesta vaga.");
				} else {
					vagas[x] = null;
					
					System.out.println("Vaga desocupada com sucesso!");					
				}
				break;
			case 5:
				System.out.println("Digite a vaga que quer saber os dados: ");
				int y = sc.nextInt();
				
				if(vagas[y] == null) {
					System.out.println("N�o existem carros nesta vaga.");
				} else {
					vagas[y] = null;
					
					System.out.println(vagas[y]);
				}
				
				break;
				
			default:
				if (opcao != 0) {
					System.out.println("\n\nVoc� precisa selecionar uma das op��es v�lidas\n");
				}
				break;
			}
			}

		if (sc != null) {
			sc.close();			
		}
	}
}