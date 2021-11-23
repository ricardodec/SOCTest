<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	<title>Exames</title>
</head>

<body>

<s:form action="deleteExame" method="post">
	<s:hidden name="exameBean.id" />
</s:form>

<hr />
<div class="card">

	<div class="card-header">
		<div class="row">
			<div class="col-sm-8 text-left">
				<h5 class="card-title"><strong>Exames</strong></h5>
			</div>
			<div class="col-sm-4 text-right">
				<s:url var="addExame" action="addExame"></s:url>
				<s:a href="%{addExame}" class="btn btn-secondary">Adiciona</s:a>
			</div>
		</div>
	</div>

	<div class="card-body">
		<table class="table table-hover">
			<thead class="thead-light">
				<tr>
					<th class="text-center align-middle">Nome do Paciente</th>
					<th class="text-center align-middle">Exame</th>
					<th class="text-center align-middle">Data</th>
					<th class="text-center align-middle">Observação / Resultado</th>
					<th class="text-center align-middle" style="width: 10px;">&nbsp;</th>
					<th class="text-center align-middle" style="width: 10px;">&nbsp;</th>
				</tr>
			</thead>
			
			<tbody>
				<s:if test="exames.size() == 0">
					<tr>
						<td class="text-left align-middle" colspan="6">
							<span>Nenhum exame cadastrado</span>
						</td>
					</tr>
				</s:if>
				<s:else>
					<s:iterator var="exame" value="exames">
						<tr>
							<td class="text-left align-middle">
								<s:property value="nomePaciente" />
							</td>
							<td class="text-left align-middle">
								<s:property value="nomeExame" />
							</td>
							<td class="text-center align-middle">
								<s:property value="dataExameFormatada" />
							</td>
							<td class="text-left align-middle">
								<s:property value="resultado" />
							</td>
							<td>
								<s:url var="editURL" action="editExame">
									<s:param name="id" value="#exame.id"></s:param>
								</s:url>
								<s:a href="%{editURL}" class="btn btn-warning btn-sm">Altera</s:a>
							</td>
							<td>
								<span class="exame-id" style="display: none"><s:property value="id" /></span>
								<s:a href="#" class="btn btn-danger btn-sm" data-onclick="exclui-exame">Exclui</s:a>
							</td>
						</tr>
					</s:iterator>
				</s:else>
			</tbody>
		</table>
	</div>

</div>

<script>
	$(`a[data-onclick='exclui-exame']`).on(`click`, function(e) {	
	    e.preventDefault();

	    if (confirm(`Confirma a exclusão do exame?`)) {
		    $form = $(`form[name='deleteExame']`);

		    if ($form.length > 0) {
			    $id = $(this).closest(`td`).find(`.exame-id`);

			    if ($id.length > 0) {
				    $form.find(`input[name='exameBean.id']`).val($id.html());
				    $form.submit();
			    }
		    }
	    }
	});
</script>

</body>
</html>