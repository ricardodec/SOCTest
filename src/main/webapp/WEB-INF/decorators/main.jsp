<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true" %>
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@taglib prefix="s" uri="/struts-tags" %>
	
<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pt-BR" lang="pt">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="pragma" content="nocache">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">

	<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/lib/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/lib/jquery-ui/jquery-ui.min.css" />
	<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/lib/jquery-ui/themes/base/jquery-ui.min.css" />

	<title><decorator:title default="Exames"/></title>

    <decorator:head/>
</head>

<body id="page-home">
	<script src="${ pageContext.servletContext.contextPath }/lib/jquery/jquery.min.js"></script>
	<script src="${ pageContext.servletContext.contextPath }/lib/jquery-ui/jquery-ui.min.js"></script>
	<script src="${ pageContext.servletContext.contextPath }/lib/jquery-mask/jquery.mask.min.js"></script>
	<script src="${ pageContext.servletContext.contextPath }/lib/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="${ pageContext.servletContext.contextPath }/lib/datepicker-pt-BR.js"></script>

	<decorator:body/>

	<script>
		$(`.date`).mask('00/00/0000');
		
		$(`.datepicker`).datepicker({
		    regional: `pt_BR`,
		    altFormat: `dd/mm/yyyy`,
		    showOn: `button`,
		    buttonImage: `images/calendar-32.gif`,
		    buttonImageOnly: true,
		    buttonText: ``,
		    changeMonth: true,
		    changeYear: true
		});
	</script>
</body>
</html>
