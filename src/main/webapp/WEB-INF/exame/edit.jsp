<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	<title>Exame - Edita</title>
	<s:head />
</head>

<body>

<hr />
<div class="card">

	<div class="card-header">
		<div class="row">
			<div class="col-sm-8 text-left">
				<h5 class="card-title"><strong>Exames - <s:if test="exameBean.id == 0">Adiciona</s:if><s:else>Edita</s:else></strong></h5>
			</div>
		</div>
	</div>

	<div class="card-body">
		<s:url var="exameList" action="exameList"></s:url>
		<s:a href="%{exameList}" class="btn btn-secondary">Voltar</s:a>
		
		<hr />

		<s:form action="saveOrUpdateExame" method="post">
			<s:hidden name="exameBean.id" />
			<s:textfield name="exameBean.nomePaciente" label="Nome do Paciente" />
			<s:textfield name="exameBean.nomeExame" label="Exame" />
			<s:textfield name="exameBean.dataExame" label="Data" cssClass="date datepicker" placeholder="dd/mm/aaaa" />
			<s:textarea name="exameBean.resultado" label="Observação / Resultado" cols="80" rows="5" />
			<s:token />
			<s:submit cssClass="btn btn-primary" value="Salvar" />
		</s:form>
	</div>
</div>

</body>
</html>