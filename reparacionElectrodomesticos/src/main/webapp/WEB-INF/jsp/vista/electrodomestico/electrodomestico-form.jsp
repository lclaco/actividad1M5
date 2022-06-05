<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>Electrodomestico</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	
	</head>
	<body>
	<%@ include file="/WEB-INF/jsp/includes/header.jsp" %>
		<div class="container">
			<h1 align="center">Electrodomestico</h1>
			<form method="POST" action="/javaPeople-web/CarreraController">
				<input type="hidden" name="id" value="${electrodomestico.id}" />
				<div class="mb-3">
		  			<label for="nombre" class="form-label">Nombre:</label>
		  			<input type="text" class="form-control" value="${electrodomestico.nombre}" id="nombre" name="nombre" />
				</div>
				<p class="d-flex justify-content-center align-items-center">				
				<button class="btn btn-outline-primary btn-rounded" type="submit">Guardar</button>
				</p>
			</form>
		</div>
		<%@ include file="/WEB-INF/jsp/includes/footer.jsp" %>	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>			
	</body>
</html>