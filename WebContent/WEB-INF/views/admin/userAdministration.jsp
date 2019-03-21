
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html xmlns:th="http://www.thymeleaf.org">

<head>
<link href="<c:url value="/resources/test_page.css" />" rel="stylesheet">
<link href="<c:url value="/resources/admPage.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
	
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
<script src="paging.js"></script>

</head>
<body>
<div class="grid-container">
  
   
  <header class="header">
   <div class="topnav">
   <a href="#"  style="width:18px;" class="active">""</a>
  <a href="${pageContext.request.contextPath}/homePage">Dashboard</a>
 
 
<sec:authorize access="hasRole('ROLE_ADMIN')">
    <a href="${pageContext.request.contextPath}/admin/usermanagement">User Management</a>
</sec:authorize>
  <a href="javascript:document.getElementById('logout').submit()">Log out</a>
 
</div>
  
  </header>

  <aside class="sidenav">
     <div id="menuwrapper">
        <ul id="sidemenu">
            <li><a href="#"><i class="fa fa-bars" style="font-size:36px;"></i></a>
             <ul>
                    <li> Settings</li>
            </ul>
            
            <li>
                <ul>
                    <li> Container 1 </li>
                </ul>
            </li>
            
           
    	</ul>
</div>
  </aside>

  <main class="main">
    <div class="main-header">
      <div class="main-header__heading">Add a user  ${username}
      <c:url var="addAction" value="/user/add" ></c:url>

<form:form action="${addAction}" modelAttribute="user">
<table>
   <c:if test="${not empty message}"><div><b>${message}</b></div></c:if>
	<c:if test="${!empty user.username}">
	<tr>
		<td>
			<form:label path="id" style="color:black;  font-weight: bold;">
				<spring:message text="ID:"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
		
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="username" style="color:black;  font-weight: bold;">
				<spring:message text="Username:"/>
			</form:label>
		</td>
		<td>
			<form:input path="username" required="required" id="addInput"/>
		</td> 
		<td>
			<form:label path="userProfile.name" style="color:black;  font-weight: bold;">
				<spring:message text="Name:"/>
			</form:label>
		</td>
		<td>
			<form:input path="userProfile.name"  id="addInput"  required="required"  />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="password" style="color:black;  font-weight: bold;">
				<spring:message text="Password:"/>
			</form:label>
		</td>
		<td>
			<form:input path="password" required="required" id="addInput" />
		</td>
		<td>
			<form:label path="userProfile.surname" style="color:black;  font-weight: bold;">
				<spring:message text="Surname:"/>
			</form:label>
		</td>
		<td>
			<form:input path="userProfile.surname"  id="addInput"  required="required"   />
		</td>
	</tr>
	
	<tr>
		<td>
			<form:label path="roleId" style="color:black;  font-weight: bold;">
				<spring:message text="Role:"/>
			</form:label>
		</td>
		<td>
			<form:input path="roleId" id="addInput" required="required"/>
		</td> 
		<td>
			<form:label path="userProfile.email" style="color:black;  font-weight: bold;">
				<spring:message text="Email:"/>
			</form:label>
		</td>
		<td>
			<form:input path="userProfile.email"  id="addInput" required="required"   />
		</td>
	</tr>
	
	<tr>
		<td colspan="2">
			<c:if test="${!empty user.username}">
				 <form:button id="addButton" name="user"><h2>Edit user</h2></form:button>
			</c:if>
			<c:if test="${empty user.username}">
				  <form:button id="addButton" name="user"><h2>Create user</h2></form:button>
			</c:if>
		</td>
	</tr>
</table>	
</form:form></div>
      <div class="main-header__updates">Lorem ipsum</div>
    </div>


    <div class="main-cards">
      <div class="card">
      <h3>Users List</h3>
<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for users...">
<div style="overflow-y: scroll; height:400px;width: 100%;">
	<table id="myTable" class="tg">
	<tr>
		<th width="80">User ID</th>
		<th width="120">Username</th>
		<th width="120">Email</th>
		<th width="60">Profile</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listUsers}" var="user">
		<tr>
			<td>${user.id}</td>
			<td>${user.username}</td>
			<td>${user.userProfile.email}</td>
			<td><a href="<c:url value='/profile/${user.id}' />" >Profile</a></td>
			<td><a href="<c:url value='/remove/${user.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
	</div>
      </div>
       <div class="card"><h3>User profile</h3>
        <c:url var="updateAction" value="/user/edit" ></c:url>
     <form:form action="${updateAction}" modelAttribute="userProfile">
     <c:if test="${not empty showprofile}">
     <table id="myTable" class="tg">
	    <tr>
		<td>
			<form:label path="id" style="color:black;  font-weight: bold;">
				<spring:message text="ID:"/>
			</form:label>
		</td>
		<td>
			<form:input id="profile" path="id" readonly="true"  disabled="true" />
			<form:hidden path="id" />
		</td> 
		
	</tr>
		<tr>
		<td><b>Username</b></td>
			<td><form:input id="profile" path="username"  readonly="true" class="required roChange"/></td>
		</tr>
		<tr>
		<tr>
		<td><b>Password</b></td>
			<td><form:input id="profile" path="password"  readonly="true" class="required roChange"/></td>
		</tr>
		<tr>
		<td><b>Name</b></td>
			<td><form:input id="profile" path="userProfile.name"  readonly="true" class="required roChange"/></td>
		</tr>
		<tr>
		   <td><b>Surname</b></td>
			<td><form:input id="profile" path="userProfile.surname"  readonly="true" class="required roChange"/></td>
		</tr>
		<tr>
		   <td><b>Email</b></td>
		   <td><form:input id="profile" path="userProfile.email"  readonly="true" class="required roChange"/></td>
		</tr>
		<tr>
		   <td><b>Role</b></td>
		   <td><form:input id="profile" path="roleId"  readonly="true" class="required roChange"/></td>
		</tr> 
	</table>
	<table>
	<tr>
	<td> <button id="addButton" onclick="editProfile()"><h2>Edit profile</h2></button></td>
	<td><div id="saveButton" style="display:none;"> <form:button id="sButton" name="user"><h2>Save profile</h2></form:button></div></td>
	</tr>
	</table>
      
      
	    </c:if>
	    </form:form>

	    
	    
       </div>
     
    </div>
  </main>

  <footer class="footer">
    <div class="footer__copyright" style="float:left">&copy; 2019</div>
    <div class="footer__signature">Made by me...</div>
  </footer>
</div>
<script>
function myFunction() {
  
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");

 
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[1];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    } 
  }
}


function editProfile() {
	  event.preventDefault();
	var x = document.getElementById("saveButton");
	
	if ( $('.roChange').is('[readonly]') ) { 
		  x.style.display = "block";
		  $('.roChange').prop('readonly', false);
		  
	}

	else{ 
		
		  $('.roChange').prop('readonly', true);
		  x.style.display = "none";
	}
		
 
 

}


</script>





 <c:url value="/logout" var="logoutUrl" />
 <form id="logout" action="${logoutUrl}" method="post" >
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>

 <h3>${password}</h3>
  <h3>${_csrf.parameterName}</h3>
 <h3>${_csrf.token}</h3>

 </body>
 </html>
 