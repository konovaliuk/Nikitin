<html>
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
        <h2>Add a new food</h2>
        <h4 style="padding-left: 75px;">Fill up this form in order to add a new food</h4>
        <div class="form-group">
            <label for="name" class="col-sm-3 control-label">Name</label>
            <div class="col-sm-9">
                <input type="text" id="name" name="name" placeholder="Name" class="form-control" autofocus required>
            </div>
        </div>
        <div class="form-group">
            <label for="fat" class="col-sm-3 control-label">Fat</label>
            <div class="col-sm-9">
                <input type="text" id="fat" name="fat" placeholder="Fat" class="form-control" autofocus required>
            </div>
        </div>
        <div class="form-group">
            <label for="protein" class="col-sm-3 control-label">Protein</label>
            <div class="col-sm-9">
                <input type="text" id="protein" name="protein" placeholder="Protein" class="form-control" required>
            </div>
        </div>
        <div class="form-group">
            <label for="carb" class="col-sm-3 control-label">Carb</label>
            <div class="col-sm-9">
                <input type="text" id="carb" name="carb" placeholder="Carb" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label for="calories" class="col-sm-3 control-label">Calories</label>
            <div class="col-sm-9">
                <input type="text" id="calories" name = "calories" placeholder="Calories" class="form-control" required>
            </div>
        </div>
        <div>
            <a href="account?command=goToPage&url=WEB-INF%2Faccount.jsp">
            <input type="button" class="btn btn-primary btn-block" style="background-color: #ab1313; border-color: #a11313;" value="Cancel">
            </a>
            <button type="submit" class="btn btn-primary btn-block">Confirm</button>
            <input type="hidden" name="command" value="addfood">
        </div>

    </form> <!-- /form -->
</div> <!-- ./container -->
</body>
</html>
