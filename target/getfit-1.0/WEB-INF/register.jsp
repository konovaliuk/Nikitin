<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="locale" var="loc"/>
<html lang="${language}">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Registration</title>
    <style><%@include file="../css/register.css"%></style>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-2.1.3.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>
<div class="container">
    <form class="form-horizontal" role="form" action="account" method="post">
        <h2><fmt:message key="REGISTRATION" bundle="${loc}"/></h2>
        <div class="form-group">
            <label for="firstName" class="col-sm-3 control-label"><fmt:message key="FIRST_NAME" bundle="${loc}"/>*</label>
            <div class="col-sm-9">
                <input type="text" id="firstName" name="firstname" placeholder="<fmt:message key="FIRST_NAME" bundle="${loc}"/>" class="form-control" autofocus>
            </div>
        </div>
        <div class="form-group">
            <label for="lastName" class="col-sm-3 control-label"><fmt:message key="LAST_NAME" bundle="${loc}"/>*</label>
            <div class="col-sm-9">
                <input type="text" id="lastName" name="lastname" placeholder="<fmt:message key="LAST_NAME" bundle="${loc}"/>" class="form-control" autofocus>
            </div>
        </div>
        <div class="form-group">
            <label for="email" class="col-sm-3 control-label"><fmt:message key="EMAIL" bundle="${loc}"/>*</label>
            <div class="col-sm-9">
                <input type="email" id="email" name="email" placeholder="Email" class="form-control" name= "email">
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-3 control-label"><fmt:message key="PASSWORD" bundle="${loc}"/>*</label>
            <div class="col-sm-9">
                <input type="password" id="password" name="password" placeholder="<fmt:message key="PASSWORD" bundle="${loc}"/>" class="form-control">
            </div>
        </div>

        <div class="form-group">
            <label for="age" class="col-sm-3 control-label"><fmt:message key="AGE" bundle="${loc}"/>*</label>
            <div class="col-sm-9">
                <input type="text" id="age" name="age" class="form-control" placeholder="<fmt:message key="AGE" bundle="${loc}"/>">
            </div>
        </div>
        <div class="form-group">
            <label for="Height" class="col-sm-3 control-label"><fmt:message key="HEIGHT" bundle="${loc}"/>* </label>
            <div class="col-sm-9">
                <input type="number" id="height" name="height" placeholder="<fmt:message key="HEIGHT.placeholder" bundle="${loc}"/>" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label for="weight" class="col-sm-3 control-label"><fmt:message key="WEIGHT" bundle="${loc}"/>*</label>
            <div class="col-sm-9">
                <input type="number" id="weight" name="weight" placeholder="<fmt:message key="WEIGHT.placeholder" bundle="${loc}"/>" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3"><fmt:message key="GENDER" bundle="${loc}"/>*</label>
            <div class="col-sm-6">
                <div class="row">
                    <div class="col-sm-4">
                        <label class="radio-inline">
                            <input type="radio" id="femaleRadio" name="gender" value="Female"><fmt:message key="MALE" bundle="${loc}"/>
                        </label>
                    </div>
                    <div class="col-sm-4">
                        <label class="radio-inline">
                            <input type="radio" id="maleRadio" name="gender" value="Male"><fmt:message key="FEMALE" bundle="${loc}"/>
                        </label>
                    </div>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label for="weight" class="col-sm-3 control-label"><fmt:message key="LIFESTYLE" bundle="${loc}"/>*</label>
            <div class="col-sm-6">
                <div class="custom-select" style="width:200px;">
                    <select name = "lifestyle">
                        <option value="0"><fmt:message key="LIFESTYLE.select" bundle="${loc}"/></option>
                        <option value ="minimum"><fmt:message key="LIFESTYLE.minimum" bundle="${loc}"/></option>
                        <option value ="low"><fmt:message key="LIFESTYLE.low" bundle="${loc}"/></option>
                        <option value ="medium"><fmt:message key="LIFESTYLE.medium" bundle="${loc}"/></option>
                        <option value ="high"><fmt:message key="LIFESTYLE.high" bundle="${loc}"/></option>
                        <option value ="extra"><fmt:message key="LIFESTYLE.extra" bundle="${loc}"/></option>

                    </select>
                </div>
            </div>
        </div>
        <!-- /.form-group -->
        <div class="form-group">
            <div class="col-sm-9 col-sm-offset-3">
                <span class="help-block">*<fmt:message key="REQUIRED" bundle="${loc}"/></span>
            </div>
        </div>
        <button type="submit" class="btn btn-primary btn-block"><fmt:message key="REGISTER" bundle="${loc}"/></button>
        <input type="hidden" name="command" value="register">
        <div class="form-group">
            <div class="col-sm-9 col-sm-offset-3">
                <span class="help-block"><fmt:message key="HAS_ACCOUNT" bundle="${loc}"/>?<a href = "login?command=goToPage&url=WEB-INF%2Flogin.jsp"><fmt:message key="LOGIN" bundle="${loc}"/>Log in!</a></span>
            </div>
        </div>
    </form> <!-- /form -->
</div> <!-- ./container -->
<script>
    var x, i, j, selElmnt, a, b, c;
    /*look for any elements with the class "custom-select":*/
    x = document.getElementsByClassName("custom-select");
    for (i = 0; i < x.length; i++) {
        selElmnt = x[i].getElementsByTagName("select")[0];
        /*for each element, create a new DIV that will act as the selected item:*/
        a = document.createElement("DIV");
        a.setAttribute("class", "select-selected");
        a.innerHTML = selElmnt.options[selElmnt.selectedIndex].innerHTML;
        x[i].appendChild(a);
        /*for each element, create a new DIV that will contain the option list:*/
        b = document.createElement("DIV");
        b.setAttribute("class", "select-items select-hide");
        for (j = 0; j < selElmnt.length; j++) {
            /*for each option in the original select element,
            create a new DIV that will act as an option item:*/
            c = document.createElement("DIV");
            c.innerHTML = selElmnt.options[j].innerHTML;
            c.addEventListener("click", function(e) {
                /*when an item is clicked, update the original select box,
                and the selected item:*/
                var y, i, k, s, h;
                s = this.parentNode.parentNode.getElementsByTagName("select")[0];
                h = this.parentNode.previousSibling;
                for (i = 0; i < s.length; i++) {
                    if (s.options[i].innerHTML == this.innerHTML) {
                        s.selectedIndex = i;
                        h.innerHTML = this.innerHTML;
                        y = this.parentNode.getElementsByClassName("same-as-selected");
                        for (k = 0; k < y.length; k++) {
                            y[k].removeAttribute("class");
                        }
                        this.setAttribute("class", "same-as-selected");
                        break;
                    }
                }
                h.click();
            });
            b.appendChild(c);
        }
        x[i].appendChild(b);
        a.addEventListener("click", function(e) {
            /*when the select box is clicked, close any other select boxes,
            and open/close the current select box:*/
            e.stopPropagation();
            closeAllSelect(this);
            this.nextSibling.classList.toggle("select-hide");
            this.classList.toggle("select-arrow-active");
        });
    }
    function closeAllSelect(elmnt) {
        /*a function that will close all select boxes in the document,
        except the current select box:*/
        var x, y, i, arrNo = [];
        x = document.getElementsByClassName("select-items");
        y = document.getElementsByClassName("select-selected");
        for (i = 0; i < y.length; i++) {
            if (elmnt == y[i]) {
                arrNo.push(i)
            } else {
                y[i].classList.remove("select-arrow-active");
            }
        }
        for (i = 0; i < x.length; i++) {
            if (arrNo.indexOf(i)) {
                x[i].classList.add("select-hide");
            }
        }
    }
    /*if the user clicks anywhere outside the select box,
    then close all select boxes:*/
    document.addEventListener("click", closeAllSelect);</script>
</body>
</html>
