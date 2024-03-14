package model.entity;

import java.time.LocalDate;

public class Aplicacao {
	
	private String pessoaAplicada;
	private LocalDate dataAplicada;
	private int reacoes;
	
	
	
	public String getPessoaAplicada() {
		return pessoaAplicada;
	}
	public void setPessoaAplicada(String pessoaAplicada) {
		this.pessoaAplicada = pessoaAplicada;
	}
	public LocalDate getDataAplicada() {
		return dataAplicada;
	}
	public void setDataAplicada(LocalDate dataAplicada) {
		this.dataAplicada = dataAplicada;
	}
	public int getReacoes() {
		return reacoes;
	}
	public void setReacoes(int reacoes) {
		this.reacoes = reacoes;
	}
	
	
}
