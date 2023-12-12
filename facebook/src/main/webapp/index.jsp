<jsp:directive.page contentType="text/html; charset=UTF-8" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap-icons.css">
<title>Facebook Tabajara</title>
</head>

<body>

	<main class="container">
		<div class="row">
			<h1 class="col-md-8">Usuários</h1>
		</div>

		<div class="row">
			<table class="table table-dark table-striped">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Nome</th>
						<th scope="col">Sexo</th>
						<th scope="col">E-mail</th>
						<th scope="col">Editar</th>
						<th scope="col">Excluir</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="user" items="${usersList}">

						<tr>
							<td>${user.getId()}</td>
							<td>${user.getName()}</td>
							<td>${user.getGender()}</td>
							<td>${user.getEmail()}</td>
							<td><a
								href="${pageContext.request.contextPath}/user/update?userId=${user.getId()}"
								class="bi bi-pencil-square"></a></td>

							<td><a
								href="${pageContext.request.contextPath}/user/delete?userId=${user.getId()}"
								class="bi bi-trash"></a></td>
						</tr>

					</c:forEach>

				</tbody>
			</table>

		</div>
		<a href="form_user.jsp" class="btn btn-dark">Novo Usuário</a>
	</main>

	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</body>

</html>