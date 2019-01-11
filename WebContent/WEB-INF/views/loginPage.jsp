
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<link href="<c:url value="/resources/loginPage.css" />" rel="stylesheet">
</head>
<body onload='document.loginForm.username.focus();'>
	<div class ="outer">
	<div class="middle">
	 <div class="inner">
	 <div id="loginText">
	<h2 style="text-align:center">Sign in</h2>
    </div>
	<c:if test="${not empty error}"><div>${error}</div></c:if>
	<c:if test="${not empty message}"><div>${message}</div></c:if>
    
	 <form:form name="login" modelAttribute="login" action="loginPage" method="post">
                <table align="center" style=" margin-top: 20px;">
                    <tr>
                        <td>
                            <form:label path="username"> <i>Username </i> </form:label>
                        </td>
                        </tr>
                        <tr>
                        <td>
                            <form:input path="username" name="username" id="username" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="password"><i>Password </i></form:label>
                        </td>
                        </tr>
                        <tr>
                        <td>
                            <form:password path="password" name="password" id="password" />
                        </td>
                    </tr>
                    <tr>
                       
                        <td align="right">
                            <form:button id="loginButton" name="login"><h2>Login</h2></form:button>
                        </td>
                    </tr>
                    <tr></tr>
                    <tr>
                        <td></td>
                        
                        
                    </tr>
                </table>
               
                	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form:form>
	
		
	</div>
	</div>
	</div>
</body>
</html>
