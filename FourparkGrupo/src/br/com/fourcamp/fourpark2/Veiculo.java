package br.com.fourcamp.fourpark2;

public class Veiculo {
	public String modelo;
	public String placa;
	
	public Veiculo(String modelo, String placa) {
		super();
		this.modelo = modelo;
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
}
