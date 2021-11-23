package br.com.soc.action;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import br.com.soc.dao.ExameDAO;
import br.com.soc.model.Exame;
import br.com.soc.util.DateConverter;

@SuppressWarnings("serial")
public class ExameSaveAction extends ActionSupport implements ModelDriven<ExameBean> {

	private ExameDAO exameDAO = new ExameDAO();
	private ExameBean exameBean = new ExameBean();
	
	@Override
	public ExameBean getModel() {
		return exameBean;
	}
    
    public void validate() {
    	if (exameBean.getNomePaciente() == null || exameBean.getNomePaciente().isEmpty() || exameBean.getNomePaciente().isBlank())
		    addFieldError("exameBean.nomePaciente", "Nome do paciente deve ser informado");
    	else
	    	try {
				if (exameDAO.getExameExist(exameBean.getId(), exameBean.getNomePaciente()))
				    addFieldError("exameBean.nomePaciente", "Paciente já cadastrado");  
			}
    		catch (SQLException e) {
			    addFieldError("exameBean.nomePaciente", "SQLException: " + e.getMessage());  
			}
    	
    	if (exameBean.getNomeExame() == null || exameBean.getNomeExame().isEmpty() || exameBean.getNomeExame().isBlank())
		    addFieldError("exameBean.nomeExame", "Nome do exame deve ser informado");
    	
    	if (exameBean.getDataExame() == null || exameBean.getDataExame().isEmpty() || exameBean.getDataExame().isBlank())
		    addFieldError("exameBean.dataExame", "Data do exame deve ser informada");
    	else {
    		Date data = DateConverter.stringToDate(DateConverter.dateToString(Calendar.getInstance().getTime()));
    		Date dataBean = DateConverter.stringToDate(exameBean.getDataExame());

    		if (!dataBean.after(data))
    		    addFieldError("exameBean.dataExame", "Data do Exame, só pode ser maior que a data atual");  
		}
    }
    
    public String execute() throws Exception {
    	Exame exame = new Exame();
    	exame.setId(exameBean.getId());
    	exame.setNomePaciente(exameBean.getNomePaciente());
    	exame.setNomeExame(exameBean.getNomeExame());
    	exame.setDataExame(DateConverter.stringToDate(exameBean.getDataExame()));
    	exame.setResultado(exameBean.getResultado());
		
    	exameDAO.saveOrUpdateExame(exame);		
		
    	return SUCCESS;
	}
	
	public ExameBean getExameBean() {
		return exameBean;
	}

	public void setExameBean(ExameBean exameBean) {
		this.exameBean = exameBean;
	}
}