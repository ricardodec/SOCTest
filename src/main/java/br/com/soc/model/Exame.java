package br.com.soc.model;

import br.com.soc.util.DateConverter;

public class Exame {

	private int id;
	private String nomePaciente;
	private String nomeExame;
	private java.sql.Date dataExame;
	private String resultado;

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

	public java.sql.Date getDataExame() {
		return dataExame;
	}

	public void setDataExame(java.sql.Date dataExame) {
		this.dataExame = dataExame;
	}

	public void setDataExame(java.util.Date dataExame) {
		this.dataExame = new java.sql.Date(dataExame.getTime());
	}

	public void setDataExame(String dataExame) throws Exception {
		
		if (dataExame == null || dataExame.isEmpty() || dataExame.isBlank())
			this.dataExame = null;
		else if (dataExame.length() != 10)
			throw new Exception("Data inválida!");
		else {
			try {
				setDataExame(DateConverter.stringToDateTime(dataExame));
			}
			catch (Exception e) {
				throw new Exception("Data inválida!");
			}
		}		
	}
	
	public String getDataExameFormatada() {
		return DateConverter.dateToString(dataExame);
	} 

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
}
