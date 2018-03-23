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
<jsp:include page="header.jsp"></jsp:include>

<div class="container">
    <div class="row">
        <div class="col-sm-5">
            <div class="row">
                <div class="col-xs-12 col-sm-8 pt-3">
                    <img src="http://placehold.it/550x550" class="img-thumbnail img-fluid">
                </div>
                <div class="col-xs-12 offset-xs-0 col-sm-8 offset-md-4 pt-3">
                    <img src="http://placehold.it/550x550" class="img-thumbnail img-fluid">
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


<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>