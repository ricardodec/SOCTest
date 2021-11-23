package br.com.soc.action;

public class ExameBean {

	private int id = 0;
	private String nomePaciente = "";
	private String nomeExame = "";
	private String dataExame = "";
	private String resultado = "";

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNomePaciente() {
		return nomePaciente;
	}
	
	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}
	
	public String getNomeExame() {
		return nomeExame;
	}

	public void setNomeExame(String nomeExame) {
		this.nomeExame = nomeExame;
	}
	
	public String getDataExame() {
		return dataExame;
	} 

	public void setDataExame(String dataExame) throws Exception {
    	this.dataExame = dataExame;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
}
