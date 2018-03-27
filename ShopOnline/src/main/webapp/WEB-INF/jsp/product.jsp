<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
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
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css"
          integrity="sha384-3AB7yXWz4OeoZcPbieVW64vVXEwADiYyAEhwilzWsLw+9FgqpyjjStpPnpBO8o8S" crossorigin="anonymous">
    <link rel="stylesheet" href="../../resources/css/style.css">
</head>

<body>

<jsp:include page="header.jsp"></jsp:include>

<h1 class="text-center pb-5">${category_name}</h1>

<div class="container">
    <c:forEach items="${products}" var="product">
        <div class="row bg-light border h-100 justify-content-center align-items-center mb-5">
            <div class="d-none d-sm-block col-sm-3 col-md-2">
                <img src="http://placehold.it/550x550" class="img-fluid">
            </div>
            <div class="col-xs-12 col-sm-5 col-md-7 d-flex justify-content-center justify-content-sm-start">
                <div class="caption">
                    <h3>${product.name}</h3>
                    <p>${product.description}</p>
                </div>
            </div>
            <div class="col-xs-1">
                <div class="row">
                    <button class="btn btn-info btn-sm"
                            onclick="location.href='/products/${product.categoryId}/${product.id}'">Show product
                    </button>
                </div>
                <div class="row">
                    <div class="col-xs-6"><strong>Price: $${product.price}</strong></div>
                </div>
            </div>
        </div>
    </c:forEach>
</div>


<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>