<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<c:set var="sessionUser" value="${sessionScope.sessionUser }"/>
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

<div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
    <h1 class="display-4">Online Shop</h1>
    <p class="lead">Nu dati banii pe prostii, luati mobile la copii !!!</p>
</div>

<div class="container">
    <div class="card-deck mb-3 text-center">
        <c:forEach items="${categories}" var="category">
            <div class="card mb-4 box-shadow">
                <div class="card-header"><h4 class="my-0 font-weight-normal">${category.name}</h4></div>
                <div class="card-body">
                    <h1 class="card-title pricing-card-title">${category.productCount}
                        <small class="text-muted"> products</small>
                    </h1>
                    <ul class="list-unstyled mt-3 mb-4">
                        <li>bla bla category description</li>
                    </ul>
                    <button type="button" class="btn btn-lg btn-block btn-light">See products</button>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>