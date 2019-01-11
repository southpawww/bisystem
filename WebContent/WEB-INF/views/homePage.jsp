
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>

<head>
<link href="<c:url value="/resources/main.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="topnav" id="myTopnav">
   <a href="#"  style="width:18px;" class="active">""</a>
  <a href="${pageContext.request.contextPath}/userPage">User</a>
  <a href="${pageContext.request.contextPath}/adminPage">Admin</a>
  <a href="javascript:document.getElementById('logout').submit()">Log out</a>
  <a href="#about">About</a>
  <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <i class="fa fa-bars"></i>
  </a>
</div>
    <div id="menuwrapper">
        <ul id="sidemenu">
            <li><a href="#"><i class="fa fa-bars" style="font-size:36px;"></i></a>
             <ul>
                    <li> Container 2
                    </li>
            </ul>
            
            <li>
                <ul>
                    <li> Container 1
                    </li>
                </ul>
            </li>
            
           
    	</ul>
</div>


<div class="box">
<h3>Welcome to ...</h3>
<ul>
   <li>Spring</li>
   <li>Spring</li>
   <li>Spring</li>
   <li>Spring</li>
</ul>
 <h3>${password}</h3>
 <h3>${_csrf.parameterName}</h3>
 <h3>${_csrf.token}</h3>
<c:url value="/logout" var="logoutUrl" />
<form id="logout" action="${logoutUrl}" method="post" >
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>

 <form:form name="login" modelAttribute="login" action="loginProcess" method="post">
                <table>
                    <tr>
                     
                        <td align="left">
                            <form:button id="login" name="login">Login</form:button>
                        </td>
                    </tr>
                   
                </table>
            </form:form>
</div>
 </body>
 </html>
 