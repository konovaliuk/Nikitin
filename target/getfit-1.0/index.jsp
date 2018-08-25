<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head prefix="og: http://ogp.me/ns# fb: http://ogp.me/ns/fb# website: http://ogp.me/ns/website#">
    <link rel="stylesheet" href="css/style.css">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge" />
    <meta name="keywords" content="Calories, Vitamins, Minerals, Health, Diet, Tracking, Exercise, Fitness, Wellness, Nutrition, Yoga, Weight, Diary, Keto, Ketogenic, Ketosis"/>
    <meta name="description" content="A web app for counting calories and tracking your diet and health metrics."/>
    <meta property="fb:app_id" content="188738687812378" />
    <meta property="og:type" content="website" />
    <meta property="og:url" content="https://cronometer.com/" />
    <meta property="og:title" content="GetFit: Track nutrition &amp; count calories" />
    <meta property="og:description" content="A web app for counting calories and tracking your diet and health metrics."/>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700' rel='stylesheet' type='text/css'>
    <meta name="apple-itunes-app" content="app-id=465173198">
    <meta name="google-play-app" content="app-id=com.cronometer.android">
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
                                    <a href='#'>HOME</a>
                                </li>
                                <li class='nav--top_item'>
                                    <a href="mailto:ilya.ninja@gmail.com">EMAIL</a>
                                </li>
                                <c:if test="${user != null}">

                                </c:if>
                                <c:if test="${user == null}">
                                    <li id="loginli" class='nav--top_item nav--top_item--login popup-trigger' data-popup='crono-popup--login'>
                                        <a href="login?command=goToPage&url=WEB-INF%2Flogin.jsp"><button style="width:100%" class='button--1'>LOGIN</button></a>
                                    </li>
                                </c:if>
                            </ul>
                        </nav>
                    </div>
                </div>
            </header>
            <section class='home-overview' style="height: 300px;">
                <div class='main-wrap'>
                    <h1 class='h1--nh2'>Track Your Nutrition &amp; Count Calories</h1>
                    <h2 class='h2--nh'>Log your Diet</h2>
                    <div class='home-overview_signup'>
                        <c:if test="${user != null}">
                            <a href="login?command=goToPage&url=WEB-INF%2Faccount.jsp"class='button--1'>Account</a></a>
                        </c:if>
                        <c:if test="${user == null}">
                            <a href="login?command=goToPage&url=WEB-INF%2Fregister.jsp" class='button--1'>SIGN UP FOR FREE</a>
                        </c:if>

                    </div>
                </div>
            </section>
        </div>
    </div>
    <section class='features features--nh'>
        <div class='main-wrap'>
            <h1 class='h1--nh'>FEATURES</h1>
            <article>
                <p>Calorie reduced diets require a lot of information to perform optimally. In order to restrict caloric intake, but
                    remain healthy, users of the diet must track their vitamin, mineral, and protein intakes with great care.</p>
                <p>We aim to provide a complete solution for the smart dieter.</p>
            </article>
            <ul class='features-list clearfix'>
                <li class='easy-to-use'>Easy to use, streamlined data entry</li>
                <li class='track-nutrients'>Track 3+1 Nutrients for 9+1 foods</li>
                <li class='log-notes'>Log your Diet</li>
                <li class='custom-foods'>Make custom foods</li>
            </ul>
        </div>
    </section>
    <section class='foods-list'>
        <div class='main-wrap'>
            <div class='row'>
                <div class='foods-list_info column'>
                    <h1 class='h1--nh'>MOST POPULAR FOODS</h1>
                    <ol>
                        <li><a href="food.html?food=5433&amp;name=Bananas%2C+raw">Bananas, raw</a></li>
                        <li><a href="food.html?food=5442&amp;name=Apples%2C+raw%2C+with+skin">Apples, raw, with skin</a></li>
                        <li><a href="food.html?food=6643&amp;name=Beverages%2C+water%2C+tap%2C+drinking">Beverages, water, tap, drinking</a></li>
                        <li><a href="food.html?food=6431&amp;name=Tomatoes%2C+red%2C+ripe%2C+raw%2C+year+round+average">Tomatoes, red, ripe, raw, year round average</a></li>
                        <li><a href="food.html?food=4224&amp;name=Carrots%2C+raw">Carrots, raw</a></li>
                        <li><a href="food.html?food=5306&amp;name=Spinach%2C+raw">Spinach, raw</a></li>
                        <li><a href="food.html?food=7047&amp;name=Dates%2C+medjool">Dates, medjool</a></li>
                        <li><a href="food.html?food=5828&amp;name=Beverages%2C+coffee%2C+brewed%2C+prepared+with+tap+water">Beverages, coffee, brewed, prepared with tap water</a></li>
                        <li><a href="food.html?food=5520&amp;name=Lettuce%2C+cos+or+romaine%2C+raw">Lettuce, cos or romaine, raw</a></li>
                        <li><a href="food.html?food=6362&amp;name=Mangos%2C+raw">Mangos, raw</a></li>
                    </ol>
                </div>
                <div class='foods-list_image column'>
                    <img src='images/foods.png' width='558' height='445' alt='' />
                </div>
            </div>
        </div>
    </section>
    <footer class='crono-footer--nh'>
        <div class='main-wrap'>
            <nav class='footer-nav'>
                <ul>
                    <li>
                        <a href="https://cronometer.com/help/">Help</a>
                    </li>
                    <li>
                        <a href="https://cronometer.com/privacy/">Privacy</a>
                    </li>
                </ul>
            </nav>
        </div>
    </footer>
</div>
</body>
</html>