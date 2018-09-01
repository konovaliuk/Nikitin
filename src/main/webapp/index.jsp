<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="locale" var="loc"/>
<html lang="${language}">
<head prefix="og: http://ogp.me/ns# fb: http://ogp.me/ns/fb# website: http://ogp.me/ns/website#">
    <link rel="stylesheet" href="css/style.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=Edge" />
    <meta name="keywords" content="Calories, Vitamins, Minerals, Health, Diet, Tracking, Exercise, Fitness, Wellness, Nutrition, Yoga, Weight, Diary, Keto, Ketogenic, Ketosis"/>
    <meta name="description" content="A web app for counting calories and tracking your diet and health metrics."/>
    <meta property="og:title" content="GetFit: Track nutrition &amp; count calories" />
    <meta property="og:description" content="A web app for counting calories and tracking your diet and health metrics."/>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700' rel='stylesheet' type='text/css'>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GetFit: Track nutrition &amp; count calories</title>
</head>
<body class='home-page home-page--nh'>
<div id="content">
    <div id="landingPage"></div>
    <div>
        <div>
            <header class='crono-header crono-header--home'>
                <div class='main-wrap'>
                    <div class='row clearfix'>
                        <div class='crono-header_logo column'>
                            <a href='#'>
                                <img src='images/logo-getfit.png' width='150' height='65' alt='Cronometer.com' />
                            </a>
                        </div>
                        <nav class='nav--top column clearfix'>
                            <ul>
                                <li class='nav--top_item is-selected'>
                                    <a href='#'><fmt:message key="HOME" bundle="${loc}"/></a>
                                </li>
                                <li class='nav--top_item'>
                                    <a href="mailto:ilya.ninja@gmail.com"><fmt:message key="EMAIL" bundle="${loc}"/></a>
                                </li>
                                <li class="nav--top_item">
                                    <form>
                                        <select id="language" name="language" onchange="submit()">
                                            <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
                                            <option value="ru" ${language == 'ru' ? 'selected' : ''}>Russian</option>
                                        </select>
                                    </form>
                                </li>
                                <c:if test="${user != null}">

                                </c:if>
                                <c:if test="${user == null}">
                                    <li id="loginli" class='nav--top_item nav--top_item--login popup-trigger' data-popup='crono-popup--login'>
                                        <a href="login?command=goToPage&url=WEB-INF%2Flogin.jsp">
                                            <button style="width:100%" class='button--1'><fmt:message key="LOGIN" bundle="${loc}"/></button>
                                        </a>
                                    </li>
                                </c:if>
                            </ul>
                        </nav>
                    </div>
                </div>
            </header>
            <section class='home-overview' style="height: 300px;">
                <div class='main-wrap'>
                    <h1 class='h1--nh2'><fmt:message key="MOTTO" bundle="${loc}"/></h1>
                    <h2 class='h2--nh'><fmt:message key="MOTTO_small" bundle="${loc}"/></h2>
                    <div class='home-overview_signup'>
                        <c:if test="${user != null}">
                            <a href="login?command=goToPage&url=WEB-INF%2Faccount.jsp"class='button--1'><fmt:message key="ACCOUNT" bundle="${loc}"/></a></a>
                        </c:if>
                        <c:if test="${user == null}">
                            <a href="login?command=goToPage&url=WEB-INF%2Fregister.jsp" class='button--1'><fmt:message key="SIGN_UP" bundle="${loc}"/></a>
                        </c:if>

                    </div>
                </div>
            </section>
        </div>
    </div>
    <section class='features features--nh'>
        <div class='main-wrap'>
            <h1 class='h1--nh'><fmt:message key="FEATURES" bundle="${loc}"/></h1>
            <article>
                <p><fmt:message key="MESSAGE" bundle="${loc}"/></p>
                <p><fmt:message key="GOAL" bundle="${loc}"/></p>
            </article>
            <ul class='features-list clearfix'>
                <li class='easy-to-use'><fmt:message key="EASY_TO_USE" bundle="${loc}"/></li>
                <li class='track-nutrients'><fmt:message key="TRACK_NUTRIENTS" bundle="${loc}"/></li>
                <li class='log-notes'><fmt:message key="LOG_NOTES" bundle="${loc}"/></li>
                <li class='custom-foods'><fmt:message key="CUSTOM_FOODS" bundle="${loc}"/></li>
            </ul>
        </div>
    </section>
    <section class='foods-list'>
        <div class='main-wrap'>
            <div class='row'>
                <div class='foods-list_info column'>
                    <h1 class='h1--nh'><fmt:message key="POPULAR_FOODS" bundle="${loc}"/></h1>
                    <ol>
                        <li><a href="food.html?food=5433&amp;name=Bananas%2C+raw"><fmt:message key="POPULAR.bananas" bundle="${loc}"/>Bananas, raw</a></li>
                        <li><a href="food.html?food=5442&amp;name=Apples%2C+raw%2C+with+skin"><fmt:message key="POPULAR.apples" bundle="${loc}"/>Apples, raw, with skin</a></li>
                        <li><a href="food.html?food=6643&amp;name=Beverages%2C+water%2C+tap%2C+drinking"><fmt:message key="POPULAR.water" bundle="${loc}"/>Beverages, water, tap, drinking</a></li>
                        <li><a href="food.html?food=6431&amp;name=Tomatoes%2C+red%2C+ripe%2C+raw%2C+year+round+average"><fmt:message key="POPULAR.tomatoes" bundle="${loc}"/>Tomatoes, red, ripe, raw, year round average</a></li>
                        <li><a href="food.html?food=4224&amp;name=Carrots%2C+raw"><fmt:message key="POPULAR.carrots" bundle="${loc}"/>Carrots, raw</a></li>
                        <li><a href="food.html?food=5306&amp;name=Spinach%2C+raw"><fmt:message key="POPULAR.spinach" bundle="${loc}"/>Spinach, raw</a></li>
                        <li><a href="food.html?food=7047&amp;name=Dates%2C+medjool"><fmt:message key="POPULAR.dates" bundle="${loc}"/>Dates, medjool</a></li>
                        <li><a href="food.html?food=5828&amp;name=Beverages%2C+coffee%2C+brewed%2C+prepared+with+tap+water"><fmt:message key="POPULAR.beverages" bundle="${loc}"/>Beverages, coffee, brewed, prepared with tap water</a></li>
                        <li><a href="food.html?food=5520&amp;name=Lettuce%2C+cos+or+romaine%2C+raw"><fmt:message key="POPULAR.lettuce" bundle="${loc}"/>Lettuce, cos or romaine, raw</a></li>
                        <li><a href="food.html?food=6362&amp;name=Mangos%2C+raw"><fmt:message key="POPULAR.mango" bundle="${loc}"/>Mangos, raw</a></li>
                    </ol>
                </div>
                <div class='foods-list_image column'>
                    <img src='images/foods.png' width='558' height='445' alt="food image"/>
                </div>
            </div>
        </div>
    </section>
    <footer class='crono-footer--nh'>
        <div class='main-wrap'>
            <nav class='footer-nav'>
                <ul>
                    <li>
                        <a href="https://cronometer.com/help/"><fmt:message key="HELP" bundle="${loc}"/></a>
                    </li>
                    <li>
                        <a href="https://cronometer.com/privacy/"><fmt:message key="PRIVACY" bundle="${loc}"/></a>
                    </li>
                </ul>
            </nav>
        </div>
    </footer>
</div>
</body>
</html>