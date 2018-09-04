<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ct" uri="/WEB-INF/dateformatter.tld"  %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"  %>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="locale" var="loc"/>
<c:if test="${user==null}">
    <c:redirect url="index.jsp"/>
</c:if>
<!DOCTYPE HTML>
<html lang="${language}">
<head>
    <title>Account</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4-4.1.1/jq-3.3.1/dt-1.10.18/sl-1.2.6/datatables.min.css"/>
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="../css/account.css">
    <link rel="stylesheet" type="text/css" href="../css/style.css">


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/v/bs4-4.1.1/jq-3.3.1/dt-1.10.18/sl-1.2.6/datatables.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
    <body>
    <div class="content-container">
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
                            <li class="nav--top_item">
                                <form>
                                    <select id="language" name="language" onchange="submit()">
                                        <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
                                        <option value="ru" ${language == 'ru' ? 'selected' : ''}>Russian</option>
                                    </select>
                                </form>
                            </li>
                            <li id="loginli" class='nav--top_item nav--top_item--login popup-trigger' data-popup='crono-popup--login'>
                                <div class="dropdown">
                                    <p class="accountOptions-btn" style="cursor: pointer;" onclick="viewAccountOptions()"><fmt:message key="HELLO" bundle="${loc}"/> <c:out value="${user.firstName}"/></p>
                                    <div id="accountOptions" class="dropdown-content">
                                        <form action="index" method="post">
                                            <div class="logout-btn">
                                            <input type="submit" value="<fmt:message key="LOGOUT" bundle="${loc}"/>">
                                            </div>
                                            <input type="hidden" name="command" value="logout">
                                        </form>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </header>
        <section>
            <div class="main-container">
                <table align="center">
                    <tbody>
                    <tr>
                        <td class="valign">
                            <div class="left-sidebar">
                                <div class="today">
                                    <span>TODAY</span>
                                    <h4 align="center"><ct:today format="MMMM dd, yyyy"/></h4>
                                </div>
                                ${verdict}
                            </div>
                        </td>
                        <td class="valign">
                            <div class="right-sidebar">
                                <div class="button-holder">
                                    <button id="modal-open" class="add">&plus;</button>
                                    <button id="deleteConsumption" class="delete">&minus;</button>
                                    <div class="options">
                                        <div class="dropdown">
                                            <img src="../images/gear-856921_960_720.png" class="options-btn" onclick="optionsMenuOpen()" width="25px" height="25px">
                                            <div id="optionsMenuDropdown" class="dropdown-content1">
                                                <form action="account" method="post">
                                                    <input type="submit" id="calculateCalories" value="Mark day as complete" style="width: 200px; cursor: pointer;">
                                                    <input type="hidden" name="command" value="calculateCalories">
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div id ="consumptionTable">
                                    <cons>
                                        <table class="prettyTable" style="width: 100%;">
                                            <tr>
                                                <td><fmt:message key="FOOD_NAME" bundle="${loc}"/></td>
                                                <td><fmt:message key="CONSUMPTION_AMOUNT" bundle="${loc}"/></td>
                                                <td><fmt:message key="FOOD_FAT" bundle="${loc}"/></td>
                                                <td><fmt:message key="FOOD_PROTEIN" bundle="${loc}"/></td>
                                                <td><fmt:message key="FOOD_CARB" bundle="${loc}"/></td>
                                                <td><fmt:message key="FOOD_CALORIES" bundle="${loc}"/></td>
                                            </tr>
                                            <c:forEach items="${consumptions}" var="item">
                                                <tr>
                                                    <td>${item.food.name}</td>
                                                    <td>${item.amount}</td>
                                                    <td>${item.food.fat}</td>
                                                    <td>${item.food.protein}</td>
                                                    <td>${item.food.carb}</td>
                                                    <td>${item.food.calories}</td>
                                                </tr>
                                            </c:forEach>
                                        </table>
                                    </cons>
                                </div>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </section>
        <!-- The Modal -->
        <!-- The Modal -->
        <div id="modal-content" class="modal">
            <!-- Modal content -->
            <div class="modal-food-header">
                <fmt:message key="ADD_FOODS_DIARY" bundle="${loc}"/>
                <span class="close-modal">&times;</span>
            </div>
            <div class="modal-content">
                <div class="modal-head">
                    <a href="food?command=goToPage&url=WEB-INF%2Fcustomfood.jsp"><button id="food-add" class="add">&plus;</button></a>
                    <button id="deleteFood" class="modal-delete">&minus;</button>
                </div>
                <form>
                    <div class="modal-table-container">
                        <div id="tableshower">
                            <data>
                                <table id="foodTable" class="table table-striped table-bordered" onclick="selectRow()">
                                    <thead>
                                    <tr>
                                        <th><fmt:message key="FOOD_NAME" bundle="${loc}"/></th>
                                        <th><fmt:message key="FOOD_FAT" bundle="${loc}"/></th>
                                        <th><fmt:message key="FOOD_PROTEIN" bundle="${loc}"/></th>
                                        <th><fmt:message key="FOOD_CARB" bundle="${loc}"/></th>
                                        <th><fmt:message key="FOOD_CALORIES" bundle="${loc}"/></th>
                                        <th style="display: none">Id</th>
                                    </tr>
                                    </thead>
                                    <tbody id="foodTableBody">
                                    <c:forEach items="${foods}" var="food">
                                        <tr onclick="showDiv()">
                                            <td><c:out value = "${food.name}"/></td>
                                            <td><c:out value = "${food.fat}"/></td>
                                            <td><c:out value = "${food.protein}"/></td>
                                            <td><c:out value = "${food.carb}"/></td>
                                            <td><c:out value = "${food.calories}"/></td>
                                            <td style="display: none">${food.foodId}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </data>
                        </div>
                    </div>
                </form>
                <div class="modal-button-section" id="button-holder" style="display: none;">
                    <form action="account" method="post">
                        <div class="button-section">
                            <div>
                                <button class="modal-prev-btn">&lt;</button>
                                <button class="modal-next-btn">&gt;</button>
                            </div>
                            <div><p><fmt:message key="YOU_CHOSE" bundle="${loc}"/></p></div>
                            <div><input type="text" id="product" name="product" readonly></div>
                            <div><input type="hidden" id="productId" name="productId"></div>
                            <div><label for="amount"><b><fmt:message key="QUANTITY" bundle="${loc}"/></b></label></div>
                            <div><input type="text" id="amount" placeholder="Enter quantity" name="amount" required></div>
                            <div>
                                <button id = "consumption-add" class="modal-addFood"><fmt:message key="ADD_BUTTON" bundle="${loc}"/></button>
                                <input type="hidden" name="command" value="createConsumption">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div><!-- /Modal content-->

        <!-- Tests-->


        <!-- /Tests-->

    </div>
        <script> <%--Скрипт для открытия модального окна--%>
            // Get the modal
            var modal = document.getElementsByClassName('modal');
            // Get the button that opens the modal
            var btn = document.getElementsByClassName("add");
            // Get the <span> element that closes the modal
            var span = document.getElementsByClassName("close-modal");
            // When the user clicks the button, open the modal
            btn[0].onclick = function() {
                modal[0].style.display = "block";
            }
            // When the user clicks on <span> (x), close the modal
            span[0].onclick = function() {
                modal[0].style.display = "none";
            }
            // When the user clicks anywhere outside of the modal, close it
            window.onclick = function(event) {
                if (event.target == modal) {
                    modal.style.display = "none";
                }
            }
        </script>
        <script>  <%--Скрипт для поиска по таблице--%>
            $(document).ready(function(){
                $("#search").on("keyup", function() {
                    var value = $(this).val().toLowerCase();
                    $("#foodTableBody tr").filter(function() {
                        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                    });
                });
            });
        </script>
        <script> <%-- Скрипт для отображения продуктов на таблице--%>
            $(document).ready(function() {
                $.get("account", { command: "loadFoodList"})
                    .done(function(data) {
                        $("#tableshower").html($(data).find("data").html());
                        $("#foodTable").dataTable({
                                "bJQueryUI" : true,
                                "sPaginationType" : "full_numbers",
                                "bRetrieve" : true,
                                "bFilter" : true,
                                "iDisplayLength": 3,
                                "bProcessing" : true,
                                "bServerSide" : false,
                            });
                    });
            });
        </script>
        <script> <%-- Скрипт для отображения потреблений на таблице--%>
        $(document).ready(function() {
            $.get("account", { command: "loadConsumptionList"})
                .done(function(data) {
                    $("#consumptionTable").html($(data).find("cons").html());
                });
        });
        </script>
        <script> <%--Скрипт для выбора элемента из таблицы продуктов--%>
        function showDiv() {
            document.getElementById("button-holder").style.display = "block";
        }

        function selectRow() {
                var table = document.getElementById("foodTable"), index;
                for (var i = 1; i < table.rows.length; i++) {
                    table.rows[i].onclick = function () {
                        index = this.rowIndex;
                        document.getElementById("product").value = this.cells[0].innerHTML;
                        document.getElementById("productId").value = this.cells[5].innerHTML;
                    }
                }
            }
            selectRow();
        </script>
        <script>
            function viewAccountOptions() {
                document.getElementById("accountOptions").classList.toggle("show");
            }

            // Close the dropdown menu if the user clicks outside of it
            window.onclick = function(event) {
                if (!event.target.matches('.accountOptions-btn')) {
                    var dropdowns = document.getElementsByClassName("dropdown-content");
                    var i;
                    for (i = 0; i < dropdowns.length; i++) {
                        var openDropdown = dropdowns[i];
                        if (openDropdown.classList.contains('show')) {
                            openDropdown.classList.remove('show');
                        }
                    }
                }
            }
        </script>
        <script>
            function optionsMenuOpen() {
                document.getElementById("optionsMenuDropdown").classList.toggle("show");
            }

            // Close the dropdown menu if the user clicks outside of it
            window.onclick = function(event) {
                if (!event.target.matches('.options-btn')) {
                    var dropdowns = document.getElementsByClassName("dropdown-content1");
                    var i;
                    for (i = 0; i < dropdowns.length; i++) {
                        var openDropdown = dropdowns[i];
                        if (openDropdown.classList.contains('show')) {
                            openDropdown.classList.remove('show');
                        }
                    }
                }
            }
        </script>
    </body>
</html>
