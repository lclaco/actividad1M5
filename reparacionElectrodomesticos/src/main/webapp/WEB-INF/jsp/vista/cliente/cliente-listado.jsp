<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>Alumnos</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		
	</head>
	<%@ include file="/WEB-INF/jsp/includes/header.jsp" %>
	<body>
		<div class="container">
		<h1>Alumnos</h1>
		
		<table class="table">
			<thead>
				<tr>
					<th class="col">ID</th>
					<th class="col">Nombre</th>
					<th class="col">Telefono</th>
					<th class="col">Direccion</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="clientes" items="${clientes}">
				<tr>
					<td><c:out value="${clientes.id}"></c:out></td>
					<td><c:out value="${clientes.nombre}"></c:out></td>
					<td><c:out value="${clientes.telefono}"></c:out></td>
					<td><c:out value="${clientes.direccion}"></c:out></td>
					<td>
						<a href="${pageContext.request.contextPath}/ClienteController?accion=listar&amp;id=${clientes.id}">Consultar</a> 
						
					</td>
					<td>
						<a href="${pageContext.request.contextPath}/ClienteController?accion=form&amp;id=${clientes.id}">Agregar Nota</a> 
						
					</td>
				</tr>
			</c:forEach>			
			</tbody>
		</table>
		</div>
		<%@ include file="/WEB-INF/jsp/includes/footer.jsp" %>	
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>	
	</body>
	</body>
</html>