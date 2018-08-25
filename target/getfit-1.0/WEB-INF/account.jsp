<%--
  Created by IntelliJ IDEA.
  User: Peregrine
  Date: 19.08.2018
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="ct" uri="com.peregrine.getfit" %>
<html>
<head>
    <title>Account</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="../css/account.css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
    <body>
    <div class="content-container">
        hello <c:out value="${user.firstName}"/>

        <div class="button-holder">
            <form action="index" method="post">
                <input type="hidden" name="command" value="logout">
                <input type="submit" value="Log out">
            </form>
            ${verdict}
        </div>
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
                            </div>
                        </td>
                        <td class="valign">
                            <div class="right-sidebar">
                                <div class="button-holder">
                                    <button id="modal-open" class="add">&plus;</button>
                                    <button id="deleteConsumption" class="delete">&minus;</button>
                                    <div class="options">
                                        <div class="dropdown">
                                            <img src="../images/gear-856921_960_720.png" class="dropbtn" onclick="myFunction()" width="25px" height="25px">
                                            <div id="myDropdown" class="dropdown-content">
                                                <input type="account" name="calculateCalories" value="Mark day as complete">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div id ="someTable">
                                    <cons>
                                        <table class="prettyTable" style="width: 100%;">
                                            <tr>
                                                <td>Item</td>
                                                <td>Amount</td>
                                                <td>Fat</td>
                                                <td>Protein</td>
                                                <td>Carb</td>
                                                <td>Calories</td>
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
                Add food to diary
                <span class="close-modal">&times;</span>
            </div>
            <div class="modal-content">
                <div class="modal-head"`>
                    <div class="box">
                        <div class="container-search">
                            <input type="search" id="search" placeholder="Search..." />
                        </div>
                    </div>
                    <a href="food?command=goToPage&url=WEB-INF%2Fcustomfood.jsp"><button id="food-add" class="add">&plus;</button></a>
                    <button id="deleteFood" class="modal-delete">&minus;</button>
                </div>
                <div class="modal-table-container">
                    <div id="tableshower">
                        <data>
                        <table id="mdTable" class="modal-table">
                            <thead>
                            <tr>
                                <th>Name</th>
                                <th>Fat</th>
                                <th>Protein</th>
                                <th>Carb</th>
                            </tr>
                            </thead>
                            <tbody id="myTable">
                            <c:forEach items="${products}" var="food">
                                <tr>
                                    <td>${food.name}</td>
                                    <td>${food.protein}</td>
                                    <td>${food.fat}</td>
                                    <td>${food.calories}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        </data>
                    </div>
                </div>
                <div class="modal-button-section">
                    <div class="button-section">
                        <div>
                            <button class="modal-prev-btn">&lt;</button>
                            <button class="modal-next-btn">&gt;</button>
                        </div>
                        <div><p>You chose</p></div>
                        <div><span id="product"></span></div>
                        <div><label for="amount"><b>Enter quantity</b></label></div>
                        <div><input type="text" id="amount" placeholder="Enter quantity" name="amount" required></div>
                        <div><button id = "consumption-add" class="modal-addFood">Add</button></div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /Modal content-->


        <button id = "consumption-add" class="modal-addFood">Add</button>
    </div>
        <script>
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
        <script>
            $(document).ready(function(){
                $("#search").on("keyup", function() {
                    var value = $(this).val().toLowerCase();
                    $("#myTable tr").filter(function() {
                        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                    });
                });
            });
        </script>
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
        <script>
            $(document).on("click", "#modal-open", function() {             // When HTML DOM "click" event is invoked on element with ID "modal-open", execute the following function...
                $.get("Controller", function(responseXml) {                // Execute Ajax GET request on URL of "testservlet" and execute the following function with Ajax response XML...
                    $("#tableshower").html($(responseXml).find("data").html()); // Parse XML, find <data> element and append its HTML to HTML DOM element with ID "tableshower".
                });
            });
        </script>
        <script>
            $(document).on("click", "#consumption-add", function() {             // When HTML DOM "click" event is invoked on element with ID "modal-open", execute the following function...
                $.get("consumptionservlet", function(responseXml) {                // Execute Ajax GET request on URL of "testservlet" and execute the following function with Ajax response XML...
                    $("#someTable").html($(responseXml).find("cons").html()); // Parse XML, find <data> element and append its HTML to HTML DOM element with ID "tableshower".
                });
            });
        </script>
        <script>
            var rIndex, table = document.getElementById("mdTable");

            function selectedRowToInput() {
                for(var i = 1; i < table.rows.length; i++) {
                    table.rows[i].onclick = function() {
                        // get the selected row index
                        rIndex = this.rowIndex;
                        console.log(rIndex);
                        var spanElement = document.getElementById("product");
                        spanElement.innerHTML = this.cells[0].innerHTML;
                    };
                }
            }
            selectedRowToInput();
        </script>
    <script>
        /* When the user clicks on the button,
        toggle between hiding and showing the dropdown content */
        function myFunction() {
            document.getElementById("myDropdown").classList.toggle("show");
        }

        // Close the dropdown if the user clicks outside of it
        window.onclick = function(event) {
            if (!event.target.matches('.dropbtn')) {

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
        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
        <script src="vendor/bootstrap/js/popper.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <script src="vendor/select2/select2.min.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>
