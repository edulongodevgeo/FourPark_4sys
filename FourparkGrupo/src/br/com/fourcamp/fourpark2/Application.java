package br.com.fourcamp.fourpark2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

//CRIANDO NOSSA CLASSE PRINCIPAL (MAIN). CHAMAMOS ELA DE "Application".
public class Application {
	static float valorDoDia = 0; // M�todo respons�vel por dar a refer�ncia do faturamento di�rio.

	public static void main(String[] args) {
		Vaga[] vagas = new Vaga[50]; // Cria e inicia nosso array/vetor com 50 elementos.
		List<Vaga> relatorioVg = new ArrayList<Vaga>(); // Cria uma lista para referenciar os elementos do objeto vaga.
		List<Veiculo> relatorioVc = new ArrayList<Veiculo>(); // Cria uma lista para referenciar os elementos do objeto
																// ve�culo.
		List<Date> relatorioSaida = new ArrayList<Date>(); // Cria uma lista (a partir da classe Date) para referenciar
															// nosso hor�rio de sa�da.

		Integer opcao = -1;
		float taxaPorHora = 2;

		Scanner sc = new Scanner(System.in);

		// CRIA A LA�O DE REPETI��O "ENQUANTO" PARA INICIALIZAR O PROGRAMA-MENU;
		while (opcao != 0) {
			System.out.println("\n Bem vindo ao FourParking" 
					+ "\n|___________________________________|"
					+ "\n|1 - Consultar vagas ocupadas       |" 
					+ "\n|2 - Consultar vagas dispon�veis    |"
					+ "\n|3 - Colocar carro em vaga          |" 
					+ "\n|4 - Retirar carro em vaga          |"
					+ "\n|5 - Dados da vaga                  |" 
					+ "\n|6 - Relat�rio de faturamento do dia|"
					+ "\n|--------------------------------   |" 
					+ "\n| 0 - S A I R                       |"
					+ "\n|___________________________________|" 
					+ "\n" 
					+ "\nInforme a opera��o desejada >>>");

			opcao = sc.nextInt();

			// INICIA O SWITCH-CASE COM AS OP��ES QUE O USU�RIO IR� ESCOLHER;
			switch (opcao) {

			// NOSSO PRIMEIRO CASO NO MENU: ANALISA SE H� VAGAS OCUPADAS.
			case 1:
				String vagasOcupadas = "\n\nAs vagas ocupadas s�o: \n";
				for (int i = 0; i < vagas.length; i++) {
					if (vagas[i] != null) {
						Vaga vaga = vagas[i];
						int vagaCorreta = i + 1;
						vagasOcupadas += "\nVaga " + vagaCorreta + "\ncarro " + vaga.getVeiculo().getModelo();
					}
				}
				System.out.println(vagasOcupadas);
				break;

			// NOSSO SEGUNDO CASO NO MENU: ANALISA SE H� (E QUAIS) VAGAS DISPON�VEIS.
			case 2:
				String vagasDisponiveis = "\n\nAs vagas dispon�veis s�o: \n";
				for (int i = 0; i < vagas.length; i++) {

					if (vagas[i] == null) {
						int vagaCorreta = i + 1;
						vagasDisponiveis += (vagaCorreta < 10 ? "0" : "") + vagaCorreta
								+ ((i + 1) % 10 == 0 ? "\n" : ",");

					}

				}

				System.out.println(vagasDisponiveis);
				break;
			
			// NOSSO TERCEIRO CASO DO MENU: INSERE O CARRO EM SUA RESPECTIVA VAGA ESCOLHIDA.
			case 3:
				System.out.println("Digite a vaga que ser� ocupada: ");
				int i = sc.nextInt() - 1;
				
				if (i > 50) {
					System.out.println("Esse estacionamento s� possui at� 50 vagas");
				} else if (vagas[i] == null) {
					System.out.println("Digite a placa do carro: ");
					String placa = sc.next();
					System.out.println("Digite o modelo do ve�culo: ");
					String modelo = sc.next();

					Veiculo veiculo = new Veiculo(modelo, placa);
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

			// NOSSO QUARTO CASO DO MENU: RETIRA O CARRO EM SUA RESPECTIVA VAGA ESCOLHIDA.
			case 4:
				System.out.println("Digite a vaga que ser� desocupada: ");
				int x = sc.nextInt() - 1;
				
				if (vagas[x] == null) {
					System.out.println("N�o existem carros nesta vaga.");
				} else {
					Date entrada = vagas[x].getHoraEntrada();
					Date saida = new Date();
					Calendar dataEntrada = Calendar.getInstance();
					dataEntrada.setTime(entrada);
					
					Calendar dataSaida = Calendar.getInstance();
					dataSaida.setTime(saida);
					float horas = dataSaida.get(Calendar.MINUTE) - dataEntrada.get(Calendar.MINUTE);
					float valorAPagar = horas * taxaPorHora;
					valorDoDia += valorAPagar;
					
					relatorioSaida.add(saida);
					
					vagas[x] = null; //DESOCUPOU A VAGA.
					
					System.out.println("Vaga desocupada com sucesso!");
					System.out.println("\nEntrada do ve�culo: " + entrada);
					System.out.println("Sa�da do ve�culo: " + saida);
					System.out.println("Valor total a pagar: R$ " + valorAPagar);
				}

				break;

			// NOSSO QUINTO CASO DO MENU: APRESENTA OS DADOS DA VAGA ESCOLHIDA.
			case 5:
				System.out.println("Digite a vaga que quer saber os dados: ");
				int y = sc.nextInt() - 1;
				if (vagas[y] == null) {
					System.out.println("N�o existem carros nesta vaga.");
				} else {
					Vaga vaga5 = vagas[y];
					String s = "Dados da vaga: ";
					s += "\nHor�rio da entrada: " + vaga5.getHoraEntrada();
					s += "\nModelo do ve�culo: " + vaga5.getVeiculo().getModelo();
					s += "\nPlaca do ve�culo: " + vaga5.getVeiculo().getPlaca();
					System.out.println(s);
				}
				break;

			// NOSSO SEXTO CASO DO MENU: EXIBE NOSSO RELAT�RIO DE FATURAMENTO AO FINAL DO EXPEDIENTE (F-I-N-A-L).
			case 6:

				System.out.println("Relat�rio de hist�rico e faturamento do fim do dia: ");
				System.out.println();

				if (relatorioVc.size() == 0) {
					System.out.println("N�o existem carros no hist�rico");
					
				} else if (relatorioVc.size() > relatorioSaida.size()) {
					System.out.println(
							"O estacionamento ainda n�o fechou! Aguarde at� o final do dia para acessar o faturamento. ");
				} else {
					for (int a = 0; a < relatorioVc.size(); a++) {
						int b = a + 1; // Como n�o temos o carro "zero", arrumamos com este "+ 1".

						System.out.println("Carro " + b + ":");
						System.out.println("Hor�rio entrada: " + relatorioVg.get(a).getHoraEntrada());
						System.out.println("Modelo: " + relatorioVc.get(a).getModelo());
						System.out.println("Placa: " + relatorioVc.get(a).getPlaca());
						System.out.println("Hor�rio sa�da: " + relatorioSaida.get(a));

					}
					System.out.println("\nTotal ganho no dia: R$ " + valorDoDia);
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
