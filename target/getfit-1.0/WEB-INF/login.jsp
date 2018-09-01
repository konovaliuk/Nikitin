<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="locale" var="loc"/>
<c:if test="${user!=null}">
    <c:redirect url="index.jsp"/>
</c:if>
<!DOCTYPE HTML>
<html lang="${language}">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Log in</title>

    <style><%@include file="../css/login.css"%></style>
    <!-- Bootstrap core CSS -->
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="../../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <form class="form-signin" action="account" method="post">
        <h2 class="form-signin-heading"><fmt:message key="SIGN_IN" bundle="${loc}"/></h2>
        <span class="invalid-login">${message}</span>
        <label for="inputEmail" class="sr-only"><fmt:message key="EMAIL" bundle="${loc}"/></label>
        <input type="email" id="inputEmail" name="email" class="form-control" placeholder="<fmt:message key="EMAIL" bundle="${loc}"/>" required autofocus>

        <label for="inputPassword" class="sr-only"><fmt:message key="PASSWORD" bundle="${loc}"/></label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="<fmt:message key="PASSWORD" bundle="${loc}"/>" required>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit"><fmt:message key="LOGIN" bundle="${loc}"/></button>
        <input type="hidden" name="command" value="login">
    </form>

</div> <!-- /container -->
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
