<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">
<head>
    <title>Advanced frameworks 2018</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="../../resources/css/style.css">
</head>

<body>

<div class="container">
    <div class="row">
        <div class="col-sm-5">
            <div class="row">
                <div class="col-xs-12 col-sm-8 pt-3">
                    <img src="http://placehold.it/550x550" class="img-thumbnail">
                </div>
                <div class="col-xs-12 offset-xs-0 col-sm-8 offset-md-4 pt-3">
                    <img src="http://placehold.it/550x550" class="img-thumbnail">
                </div>
            </div>
        </div>
        <div class="col-sm-7">
            <div class="mt-5"></div>
            <h1>${product.name}</h1>
            <p>${product.description}</p>
            <div class="pb-4">
                <strong> Price: ${product.price}</strong>
            </div>
            <div class="pb-4">
                <strong> Stock: ${product.stock} units</strong>
            </div>

            <%--TODO after cart is done--%>
            <form:form modelAttribute="cartItem" action="/cart/${product.id}" method="post">
                <div class="row">
                    <div class="col-xs-12 col-sm-7">
                        <button type="submit" class="btn btn-info btn-lg btn-block">Add to cart</button>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>
</div>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>

</body>
</html>