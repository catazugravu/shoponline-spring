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
    <link rel="stylesheet" href="../../resources/css/style.css">
</head>

<body>
<div class="container signin text-center">
    <c:if test="${not empty error}">
        <div class="alert alert-danger alert-dismissible fade show errorMessage" role="alert">
            <strong>Login failed</strong> ${error.message}.
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
    <form:form modelAttribute="loginFormUser" action="/user/login" method="post" class="form-signin">
        <img class="mb-4" src="https://getbootstrap.com/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
        <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
        <label for="email" class="sr-only">Email address</label>
        <form:input path="email" type="email" id="inputEmail" class="form-control" placeholder="Email address"
                    required="required" autofocus="autofocus"/>

        <label for="inputPassword" class="sr-only">Password</label>
        <form:input path="password" type="password" id="inputPassword" class="form-control" placeholder="Password"
                    required="required"/>

        <button type="submit" class="btn btn-lg btn-primary btn-block">Log in</button>
    </form:form>
</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>