package Tentativa;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Menu {
	static float valorDoDia = 0;
	int sum = 0;

	public static void main(String[] args) {
		Vaga[] vagas = new Vaga[50];
		List<Vaga> relatorioVg = new ArrayList<Vaga>();
		List<Veiculo> relatorioVc = new ArrayList<Veiculo>();
		List<Date> lista2 = new ArrayList<Date>();
		Integer opcao = -1;
		int taxaPorHora = 2;

		Scanner sc = new Scanner(System.in);
		while (opcao != 0) {
			System.out.println("\n Bem vindo ao FourParking" + "\n|________________________________|"
					+ "\n|1 - Consultar vagas ocupadas |" + "\n|2 - Consultar vagas disponíveis |"
					+ "\n|3 - Colocar carro em vaga |" + "\n|4 - Retirar carro em vaga |" + "\n|5 - Dados da vaga |"
					+ "\n|6 - Relatório |" + "\n|--------------------------------|" + "\n| 0 - S A I R |"
					+ "\n|________________________________|" + "\n" + "\nInforme a operação desejada >>>");
			opcao = sc.nextInt();
			switch (opcao) {
			case 1:
				String vagasDisponiveis = "\n\nAs vagas ocupadas são: \n";
				for (int i = 0; i < vagas.length; i++) {
					if (vagas[i] != null) {
						int vagaCorreta = i + 1;
						vagasDisponiveis += vagaCorreta + ", ";
					}
				}
				System.out.println(vagasDisponiveis);
				break;
			case 2:
				String vagasOcupadas = "\n\nAs vagas disponíveis são: \n";
				for (int i = 0; i < vagas.length; i++) {
					if (vagas[i] == null) {
						int vagaCorreta = i + 1;
						vagasOcupadas += vagaCorreta + ",";
					}
				}
				System.out.println(vagasOcupadas);
				break;
			case 3:
				System.out.println("Digite a vaga que será ocupada: ");
				int i = sc.nextInt() - 1;
				if (vagas[i] == null) {
					System.out.println("Digite a placa do carro: ");
					String placa = sc.next();
					System.out.println("Digite o modelo do veículo: ");
					String modelo = sc.next();
					Veiculo veiculo = new Veiculo();
					veiculo.setModelo(modelo);
					veiculo.setPlaca(placa);
					Date d = new Date();
					Vaga vaga = new Vaga();
					vaga.setHoraEntrada(d);
					vaga.setVeiculo(veiculo);

					System.out.println("Vaga Cadastrada com Sucesso");
					vagas[i] = vaga;
					relatorioVg.add(vaga);
					relatorioVc.add(veiculo);
				} else {
					System.out.println("Vaga em Uso");
				}

				break;

			case 4:
				System.out.println("Digite a vaga que será desocupada: ");
				int x = sc.nextInt() - 1;
				if (vagas[x] == null) {
					System.out.println("Não existem carros nesta vaga.");
				} else {
					Date entrada = vagas[x].getHoraEntrada();
					Date saida = new Date();
					Calendar dataEntrada = Calendar.getInstance();
					dataEntrada.setTime(entrada);
					Calendar dataSaida = Calendar.getInstance();
					dataSaida.setTime(saida);
					int horas = dataSaida.get(Calendar.SECOND) - dataEntrada.get(Calendar.SECOND);
					int valorAPagar = horas * taxaPorHora;
					valorDoDia += valorAPagar;
					lista2.add(saida);
					vagas[x] = null;
					System.out.println("Vaga desocupada com sucesso!");
					System.out.println("\nEntrada do veículo: " + entrada);
					System.out.println("Saída do veículo: " + saida);
					System.out.println("Valor total a pagar: R$ " + valorAPagar);
				}
				break;
			case 5:
				System.out.println("Digite a vaga que quer saber os dados: ");
				int y = sc.nextInt() - 1;
				if (vagas[y] == null) {
					System.out.println("Não existem carros nesta vaga.");
				} else {
					Vaga vaga5 = vagas[y];
					String s = "Dados da vaga: ";
					s += "\nHorário da entrada: " + vaga5.getHoraEntrada();
					s += "\nModelo do veículo: " + vaga5.getVeiculo().getModelo();
					s += "\nPlaca do veículo: " + vaga5.getVeiculo().getPlaca();
					System.out.println(s);
				}
				break;
			case 6:

				System.out.println("Relatório: ");
				System.out.println();
				for (int a = 0; a < relatorioVc.size(); a++) {
					int b = a + 1;
					System.out.println();
					System.out.println("Carro " + b + ":");
					System.out.println("horario entrada: " + relatorioVg.get(a).getHoraEntrada());
					System.out.println("Modelo: " + relatorioVc.get(a).getModelo());
					System.out.println("Placa: " + relatorioVc.get(a).getPlaca());
					System.out.println("horario saida: " + lista2.get(a));
				}
				break;
			default:
				if (opcao != 0) {
					System.out.println("\n\nVocê precisa selecionar uma das opções válidas\n");
				}
				break;
			}
		}
		System.out.println("Total ganho no dia: R$ " + valorDoDia + ",00");

		if (sc != null) {
			sc.close();
		}
	}
}