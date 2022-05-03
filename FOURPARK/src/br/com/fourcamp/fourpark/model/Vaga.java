package br.com.fourcamp.fourpark.model;

public class Vaga {
	private Integer posicao;
	private String HoraEntrada;
	private String HoraSaida;
	private Veiculo veiculo;
	private Boolean ocupado;
	
	
	public Vaga(Integer posicao) {
		this.posicao = posicao;
		ocupado = true;
	}
	
	public Vaga(Integer posicao, String horaEntrada, Veiculo veiculo) {
		super();
		this.posicao = posicao;
		this.HoraEntrada = horaEntrada;
		this.veiculo = veiculo;
		ocupado = true;		
	}
	
	
	
	public Integer getPosicao() {
		return posicao;
	}
	public void setPosicao(Integer posicao) {
		this.posicao = posicao;
	}
	public String getHoraEntrada() {
		return HoraEntrada;
	}
	public void setHoraEntrada(String horaEntrada) {
		HoraEntrada = horaEntrada;
	}
	public String getHoraSaida() {
		return HoraSaida;
	}
	public void setHoraSaida(String horaSaida) {
		HoraSaida = horaSaida;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public Boolean getOcupado() {
		return ocupado;
	}
	public void setOcupado(Boolean ocupado) {
		this.ocupado = ocupado;
	}
	

}
