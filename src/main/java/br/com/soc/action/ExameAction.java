package br.com.soc.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import br.com.soc.dao.ExameDAO;
import br.com.soc.model.Exame;
import br.com.soc.util.DateConverter;

@SuppressWarnings("serial")
public class ExameAction extends ActionSupport implements ModelDriven<ExameBean> {

	private ExameDAO exameDAO = new ExameDAO();
	private ExameBean exameBean = new ExameBean();
	private List<Exame> exames = new ArrayList<Exame>();
	
	@Override
	public ExameBean getModel() {
		return exameBean;
	}

    public String list() throws Exception {
		setExames(exameDAO.listExame());		
        return SUCCESS;
    }
	
	public String add() throws Exception {
		exameBean.setId(0);		
		exameBean.setDataExame(DateConverter.dateToString(Calendar.getInstance().getTime()));

		return SUCCESS;
	}
	
	public String edit() throws Exception {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		
		Exame exame = exameDAO.getExameById(Integer.parseInt(request.getParameter("id")));		
		exameBean.setId(exame.getId());
		exameBean.setNomePaciente(exame.getNomePaciente());
		exameBean.setNomeExame(exame.getNomeExame());
		exameBean.setDataExame(exame.getDataExameFormatada());
		exameBean.setResultado(exame.getResultado());

    	return SUCCESS;
	}
	
	public String delete() throws Exception {
		exameDAO.deleteExame(exameBean.getId());		
		return SUCCESS;
	}
	
	public ExameBean getExameBean() {
		return exameBean;
	}

	public void setExameBean(ExameBean exameBean) {
		this.exameBean = exameBean;
	}

	public List<Exame> getExames() {
		return exames;
	}

	public void setExames(List<Exame> exames) {
		this.exames = exames;
	}
}