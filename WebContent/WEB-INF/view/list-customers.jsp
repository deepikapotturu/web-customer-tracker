<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>

<title>List Customers</title>

<!-- link to css files -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/style.css" />
<!-- starting of info in href gives the name of application -->
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM-Customer Relationship Manager</h2>

		</div>
	</div>
	<div id="container">
		<div id="content">
		<!-- put new button -->
		<input type="button" value="Add Customer"
		onclick="window.location.href='showFormForAdd'; return false;"
		class="add-button"/>
		
		 <!--  add a search box -->
            <form:form action="search" method="GET">
                Search customer: <input type="text" name="theSearchName" />
                
                <input type="submit" value="Search" class="add-button" />
            </form:form>
		
			<!-- add our html table here -->
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>email</th>
					<th>Action</th>
					
				</tr>

				<!-- loop over and print our customers -->
				<c:forEach var="tempCustomer" items="${customers}">
				<!-- construct an update link with customer ID -->
				<c:url var="updateLink" value="/customer/showFormForUpdate">
				<c:param name="customerId" value="${tempCustomer.id }">
				</c:param>
				</c:url>
				
				<!-- construct an delete link with customer ID -->
				<c:url var="deleteLink" value="/customer/delete">
				<c:param name="customerId" value="${tempCustomer.id }">
				</c:param>
				</c:url>
				
					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						<td>
						<!-- display th upddate link -->
					<a href="${updateLink}">Update</a>
						|
						<a href="${deleteLink}" onclick="if(!(confirm('Are you sure if u want to delete this customer'))) return false">Delete</a>
					
						</td>

					</tr>
				</c:forEach>
			</table>

		</div>


	</div>
</body>


</html>















