<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="locale" var="loc"/>
<html lang="${language}">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Log in</title>
    <link rel="stylesheet" href="../css/customfood.css">
    <!-- Bootstrap core CSS -->
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link href="../../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <form class="form-horizontal" role="form" action="account" method="post">
        <h2><fmt:message key="ADD_FOODS" bundle="${loc}"/></h2>
        <h4 style="padding-left: 75px;"><fmt:message key="ADD_FOODS.condition" bundle="${loc}"/></h4>
        <div class="form-group">
            <label for="name" class="col-sm-3 control-label"><fmt:message key="NAME" bundle="${loc}"/></label>
            <div class="col-sm-9">
                <input type="text" id="name" name="name" placeholder="<fmt:message key="NAME" bundle="${loc}"/>" class="form-control" autofocus required>
            </div>
        </div>
        <div class="form-group">
            <label for="fat" class="col-sm-3 control-label"><fmt:message key="FAT" bundle="${loc}"/></label>
            <div class="col-sm-9">
                <input type="text" id="fat" name="fat" placeholder="<fmt:message key="FAT.placeholder" bundle="${loc}"/>" class="form-control" autofocus required>
            </div>
        </div>
        <div class="form-group">
            <label for="protein" class="col-sm-3 control-label"><fmt:message key="PROTEIN" bundle="${loc}"/></label>
            <div class="col-sm-9">
                <input type="text" id="protein" name="protein" placeholder="<fmt:message key="PROTEIN.placeholder" bundle="${loc}"/>" class="form-control" required>
            </div>
        </div>
        <div class="form-group">
            <label for="carb" class="col-sm-3 control-label"><fmt:message key="CARB" bundle="${loc}"/></label>
            <div class="col-sm-9">
                <input type="text" id="carb" name="carb" placeholder="<fmt:message key="CARB.placeholder" bundle="${loc}"/>" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label for="calories" class="col-sm-3 control-label"><fmt:message key="CALORIES" bundle="${loc}"/></label>
            <div class="col-sm-9">
                <input type="text" id="calories" name = "calories" placeholder="<fmt:message key="CALORIES.placeholder" bundle="${loc}"/>" class="form-control" required>
            </div>
        </div>
        <div>
            <a href="account?command=goToPage&url=WEB-INF%2Faccount.jsp">
            <input type="button" class="btn btn-primary btn-block" style="background-color: #ab1313; border-color: #a11313;" value="<fmt:message key="CANCEL" bundle="${loc}"/>">
            </a>
            <button type="submit" class="btn btn-primary btn-block"><fmt:message key="CONFIRM" bundle="${loc}"/></button>
            <input type="hidden" name="command" value="addFood">
        </div>

    </form> <!-- /form -->
</div> <!-- ./container -->
</body>
</html>
