
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>order</title>
</head>
<body>
	<div class="container">
		<div class="text-center mb-3">
			<h1>Orderbook</h1>
			<c:if test="${not empty message }" >
			<label class="alert alert-success">It's done</label>
			</c:if>
		</div>
		<div class="row">
		<div class="col-md-2">
			<ul class="list-group">
			 <a class="list-group-item active" href='<c:url value='/home'></c:url>'   >All order</a>
			 <a class="list-group-item " href='<c:url value='/add'></c:url>'   >Add order</a>
			 <a class="list-group-item " href='<c:url value='/view'></c:url>'   >View order</a>
			</ul>
		</div>
		<div class="col-md-10 ">
		
			 <h2>Content</h2>
			 <c:if  test="${page == 'home'}" >
			 	<h4>All Order</h4>
			 	
			 	<c:forEach items="${orders}" var="order">
			 	<div class="card">
			 	
			 		<div class="card-body" style="    background: aquamarine;	">
			 		<h4><c:out value="${order.getReferenceNumber()}"></c:out> </h4>
			 				<label><c:out value="${order.getDescription()}"></c:out> </label>
			 				<label><c:out value="${order.getAmount()}"></c:out> </label>
			 		</div>
			 		
			 	</div>
			 	
			 	</c:forEach>
			 	
			 </c:if>
			 <c:if  test="${page == 'view'}" >
			 	<h4>View Order</h4>
			 				 	<c:forEach items="${orders}" var="order">
						 	<div class="card">
			 	
			 		<div class="card-body" style="    background: aquamarine;	">
			 		<h4><c:out value="${order.getReferenceNumber()}"></c:out> </h4>
			 				<label><c:out value="${order.getDescription()}"></c:out> </label>
			 				<label><c:out value="${order.getAmount()}"></c:out> </label>
			 		</div>
			 		
			 	</div>
			 	
			 	</c:forEach>
			 </c:if>
			 <c:if  test="${page == 'add'}" >
			 	<h4>Add Order</h4>
			 	
			 <form:form action="save-order" method="POST" modelAttribute="order"  >
			 	<div class="form-group">
			 		<form:input path="ReferenceNumber" cssClass="form-control" />
			 		</div>
			 			<div class="form-group">
			 		<form:textarea path="Description" cssClass="form-control"  />
			 		</div>
			 			<div class="form-group">
			 		<form:input path="Amount" cssClass="form-control" />
			 		</div>
			 		
			 		<div class="text-center">
			 			<button  type="submit" class="btn btn-primary" >Add</button>
			 		</div>
			 	</form:form>
			 	
			 </c:if>
		</div>
		
		</div>


	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>