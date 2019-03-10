<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<head>
<link href="<c:url value="/resources/test_page.css" />" rel="stylesheet">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
      <div class="main-header__heading">Hello</div>
      <div class="main-header__updates">Recent Items</div>
    </div>

    <div class="main-overview">
      <div class="overviewcard">
        <div class="overviewcard__icon">Overview</div>
        <div class="overviewcard__info">Summary</div>
      </div>
      <div class="overviewcard">
        <div class="overviewcard__icon">Overview</div>
        <div class="overviewcard__info">Summary</div>
      </div>
      <div class="overviewcard">
        <div class="overviewcard__icon">Overview</div>
        <div class="overviewcard__info">Summary</div>
      </div>
      <div class="overviewcard">
        <div class="overviewcard__icon">Overview</div>
        <div class="overviewcard__info">Summary</div>
      </div>
    </div>

    <div class="main-cards">
      <div class="card">Chart #1</div>
      <div class="card">Chart #2</div>
      <div class="card">Chart #3</div>
    </div>
  </main>

  <footer class="footer">
    <div class="footer__copyright" style="float:left">&copy; 2019</div>
    <div class="footer__signature">Made by me...</div>
  </footer>
</div>
<c:url value="/logout" var="logoutUrl" />
 <form id="logout" action="${logoutUrl}" method="post" >
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
 </body>
 </html>
 