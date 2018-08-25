<%--
  Created by IntelliJ IDEA.
  User: Peregrine
  Date: 30.07.2018
  Time: 00:05
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
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
        <h2>Registration</h2>
        <div class="form-group">
            <label for="firstName" class="col-sm-3 control-label">First Name*</label>
            <div class="col-sm-9">
                <input type="text" id="firstName" name="firstname" placeholder="First Name" class="form-control" autofocus>
            </div>
        </div>
        <div class="form-group">
            <label for="lastName" class="col-sm-3 control-label">Last Name*</label>
            <div class="col-sm-9">
                <input type="text" id="lastName" name="lastname" placeholder="Last Name" class="form-control" autofocus>
            </div>
        </div>
        <div class="form-group">
            <label for="email" class="col-sm-3 control-label">Email*</label>
            <div class="col-sm-9">
                <input type="email" id="email" name="email" placeholder="Email" class="form-control" name= "email">
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-3 control-label">Password*</label>
            <div class="col-sm-9">
                <input type="password" id="password" name="password" placeholder="Password" class="form-control">
            </div>
        </div>

        <div class="form-group">
            <label for="age" class="col-sm-3 control-label">Age*</label>
            <div class="col-sm-9">
                <input type="text" id="age" name="age" class="form-control" placeholder="Age">
            </div>
        </div>
        <div class="form-group">
            <label for="Height" class="col-sm-3 control-label">Height* </label>
            <div class="col-sm-9">
                <input type="number" id="height" name="height" placeholder="Please write your height in centimetres" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label for="weight" class="col-sm-3 control-label">Weight*</label>
            <div class="col-sm-9">
                <input type="number" id="weight" name="weight" placeholder="Please write your weight in kilograms" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3">Gender*</label>
            <div class="col-sm-6">
                <div class="row">
                    <div class="col-sm-4">
                        <label class="radio-inline">
                            <input type="radio" id="femaleRadio" name="gender" value="Female">Female
                        </label>
                    </div>
                    <div class="col-sm-4">
                        <label class="radio-inline">
                            <input type="radio" id="maleRadio" name="gender" value="Male">Male
                        </label>
                    </div>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label for="weight" class="col-sm-3 control-label">Lifestyle* </label>
            <div class="col-sm-6">
                <div class="custom-select" style="width:200px;">
                    <select name = "lifestyle">
                        <option value="0">Select lifestyle:</option>
                        <option value ="lazy">Lazy</option>
                        <option value ="active">Active</option>
                    </select>
                </div>
            </div>
        </div>
        <!-- /.form-group -->
        <div class="form-group">
            <div class="col-sm-9 col-sm-offset-3">
                <span class="help-block">*Required fields</span>
            </div>
        </div>
        <button type="submit" class="btn btn-primary btn-block">Register</button>
        <input type="hidden" name="command" value="register">
        <div class="form-group">
            <div class="col-sm-9 col-sm-offset-3">
                <span class="help-block">Already have an account? <a href = "login?command=goToPage&url=WEB-INF%2Flogin.jsp">Log in!</a></span>
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
