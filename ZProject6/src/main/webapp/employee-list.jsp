<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Employee Management Application</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar h2 navbar-light" style="background-color: #e3f2fd">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link"
					href="<%=request.getContextPath()%>/list">Employees</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h3 class="text-center">List of Employees</h3>
				<hr>
				<div class="d-flex justify-content-between align-items-center">
					<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
						New Employee</a>

					<form method="post" action="<%=request.getContextPath()%>/search"
						class="form-inline">
						<div class="form-group mx-sm-3 mb-2">
							<select class="form-control" name="searchCriteria">
								<option value="id">Search by ID</option>
								<option value="name">Search by Name</option>
								<!-- Add more options for additional search criteria -->
							</select>
						</div>
						<input type="text" class="form-control" id="searchTerm"
							name="searchTerm" placeholder="Enter search term">
						<button type="submit" class="btn btn-info mb-2">Search</button>
					</form>


					<!-- Add this dropdown for sorting -->
					<form method="get" action="<%=request.getContextPath()%>/sort"
						class="form-inline">
						<div class="form-group mx-sm-3 mb-2">
							<select class="form-control" name="sortCriteria">
								<option value="name">Sort by Name</option>
								<option value="email">Sort by Email</option>
								<option value="country">Sort by Country</option>
								<!-- Add more options for additional sorting criteria -->
							</select>
						</div>
						<button type="submit" class="btn btn-info mb-2">Sort</button>
					</form>
				</div>
				<br>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Email</th>
							<th>Country</th>
							
						</tr>
					</thead>
					<tbody>
						<c:forEach var="employee" items="${listEmployee}">
							<tr>
								<td><a
									href="<%=request.getContextPath()%>/details?id=${employee.id}"><c:out
											value="${employee.id}" /></a></td>
								<td><a
									href="<%=request.getContextPath()%>/details?id=${employee.id}"><c:out
											value="${employee.name}" /></a></td>
								<td><c:out value="${employee.email}" /></td>
								<td><c:out value="${employee.country}" /></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
	</div>
</body>
</html>
