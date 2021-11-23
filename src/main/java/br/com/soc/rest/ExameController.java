package br.com.soc.rest;

import java.net.http.HttpHeaders;
import java.sql.SQLException;

import org.apache.struts2.rest.DefaultHttpHeaders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import br.com.soc.dao.ExameDAO;
import br.com.soc.model.Exame;

@SuppressWarnings("serial")
public class ExameController extends ActionSupport implements ModelDriven<Exame> {

	private int id;
	private Exame model;
	private ExameDAO exameDAO = new ExameDAO();
	
	@Override
	public Exame getModel() {
		return model;
	}

    // Handles /exame/{id} GET requests
    public String show() throws SQLException, JsonProcessingException {
		model = exameDAO.getExameById(3);		
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(model);
		
		return json;
    }
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}