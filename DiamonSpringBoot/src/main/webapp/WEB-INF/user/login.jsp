<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/user/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Simple Login Form Example</title>
  <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Rubik:400,700'><link rel="stylesheet" href="<c:url value="/assets/css/style1.css"/>">
</head>
<body>
<!-- partial:index.partial.html -->
<div class="login-form">
  <form:form action="dang-nhap" method="post" modelAttribute="user">
  <h1>Login</h1>
    <div class="content">
      <div class="input-field">
        <h1>${statuslogin}</h1>
      </div>
      <div class="input-field">
<%--        <input type="email" placeholder="Email" autocomplete="nope">--%>
        <form:input type="email" placeholder="Enter Email"   path="email" />
      </div>

      <div class="input-field">
<%--        <input type="password" placeholder="Password" autocomplete="new-password">--%>
  <form:input type="password" placeholder="Enter Password"   path="password"  />
      </div>

      <a href="#" class="link">Forgot Your Password?</a>
    </div>
    <div class="action">
      <button><a href="/dang-ky">Register</a></button>
      <button type="submit">Sign in</button>
    </div>
  </form:form>
</div>
<!-- partial -->
<script  src="<c:url value="/assets/js/script1.js"/>"></script>

</body>
</html>
