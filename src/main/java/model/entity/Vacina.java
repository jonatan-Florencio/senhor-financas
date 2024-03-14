package model.entity;

import java.time.LocalDate;

public class Vacina {

	private String paisOrigem;
	private String pesquisa;
	private LocalDate incioPesquisa;
	private String pesquisadorResposavel;
	
	public String getPaisOrigem() {
		return paisOrigem;
	}
	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem = paisOrigem;
	}
	public String getPesquisa() {
		return pesquisa;
	}
	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}
	public LocalDate getIncioPesquisa() {
		return incioPesquisa;
	}
	public void setIncioPesquisa(LocalDate incioPesquisa) {
		this.incioPesquisa = incioPesquisa;
	}
	public String getPesquisadorResposavel() {
		return pesquisadorResposavel;
	}
	public void setPesquisadorResposavel(String pesquisadorResposavel) {
		this.pesquisadorResposavel = pesquisadorResposavel;
	}
	
}
