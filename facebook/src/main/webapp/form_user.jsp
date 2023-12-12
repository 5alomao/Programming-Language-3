<jsp:directive.page contentType="text/html; charset=UTF-8" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-icons.css">
		<title>Cadastro de Usuários</title>
	</head>

	<body>
		<div class="container">
			<div class="row">
				<div class="col-2"></div>

				<form method="GET" action="/facebook/save" class="col-8">

					<h1> Cadastrar Usuário</h1>

					<input type="hidden" id="user-id" name="user-id" value="${user.getId()}">

					<div class="form-group mb-3">
						<label for="user-name-id">Nome de Usuário</label>
						<input type="text" class="form-control" id="user-name-id" placeholder="Nome de Usuário"
							name="user-name" value="${user.getName()}">
					</div>

					<div class="form-group mb-3">
						<span style="font-size: 16px;">Sexo</span><br>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="user-gender" id="user-gender-id-f"
								value="F" ${user.getGender().equals("F") ? "checked" : "" }>
							<label class="form-check-label" for="user-gender-id-f">Feminino</label>
						</div>

						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="user-gender" id="user-gender-id-m"
								value="M" ${user.getGender().equals("M") ? "checked" : "" }>
							<label class="form-check-label" for="user-gender-id-m">Masculino</label>
						</div>
					</div>

					<div class="form-group  mb-3">
						<label for="email-id">E-mail</label>
						<input type="email" class="form-control" id="email-id" placeholder="example@example.com"
							name="user-email" value="${user.getEmail()}">
					</div>



					<button type="submit" class="btn btn-primary">Cadastrar</button>

				</form>

				<div class="col-2"></div>
			</div>
		</div>


		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
	</body>

	</html>