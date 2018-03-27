<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="sessionUser" value="${sessionScope.sessionUser}"/>
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

<div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
    <h1 class="display-4">Online Shop</h1>
    <p class="lead">Nu dati banii pe prostii, luati mobile la copii !!!</p>
</div>

<div class="container">
    <c:if test="${empty cart.items}">
        <div class="alert alert-warning text-center" role="alert">
            No products in cart :(
        </div>
    </c:if>
    <c:if test="${not empty cart.items}">
        <table class="table table-striped table-bordered">
            <thead class="thead-dark">
            <tr>
                <th scope="col">Product</th>
                <th scope="col">Quantity</th>
                <th scope="col">Price/Unit</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${cart.items}" var="item">
                <tr>
                    <td>${item.name}</td>
                    <td>
                        <form:form modelAttribute="cartItem" action="/cart/update/${item.productId}" method="post"
                                   class="text-center">
                            <form:select path="quantity" class="custom-select custom-select-lg mb-3"
                                         onchange="this.form.submit()">
                                <option value="${item.quantity}" selected hidden>${item.quantity}</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                            </form:select>

                        </form:form>
                    </td>
                    <td>${item.price} RON</td>
                    <td>
                        <form:form action="/cart/${item.productId}" method="delete">
                            <button type="submit" class="btn btn-danger btn-lg">Remove</button>
                        </form:form>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td class="col-md-auto font-weight-bold" colspan="2">Total</td>
                <td>${total} RON</td>
            </tr>
            </tbody>
        </table>

        <div class="row justify-content-md-center mt-5">
            <form:form modelAttribute="addressForm" action="/cart/checkout" method="post">
                <div class="col-sm-12">
                    <div class="input-group mb-5">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Delivery address <i class="fas fa-globe pl-2"></i></span>
                        </div>
                        <form:input path="address" type="text" class="form-control" aria-label="Your delivery address"
                                    placeholder="Please enter your address" required="required"/>
                    </div>
                </div>

                <div class="col-sm-12 col-md-4">
                    <c:if test="${not empty sessionUser.id}">
                        <button class="btn btn-success btn-lg btn-block" type="submit">
                            Checkout <i class="fas fa-shipping-fast pd-2"></i>
                        </button>
                    </c:if>
                    <c:if test="${empty sessionUser.id}">
                        <button class="btn btn-success btn-lg btn-block" onclick="location.href='/user/login'">
                            Checkout <i class="fas fa-shipping-fast pd-2"></i>
                        </button>
                    </c:if>
                </div>
            </form:form>
        </div>
    </c:if>
</div>

<jsp:include page="footer.jsp"></jsp:include>

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