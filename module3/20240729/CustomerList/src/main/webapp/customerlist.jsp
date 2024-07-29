<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        .profile-picture {
            max-width: 100px;
            max-height: 100px;
        }
    </style>
</head>
<body>
<div class="container">
    <table class="table table-striped table-borderless table-hover caption-top align-middle">
        <caption class="">
            <h1>Danh sách khách hàng</h1>
        </caption>
        <thead>
        <tr>
            <th scope="col">Tên</th>
            <th scope="col">Ngày sinh</th>
            <th scope="col">Địa chỉ</th>
            <th scope="col">Ảnh</th>
        </tr>
        </thead>
        <tbody class="table-group-divider">
        <c:forEach var="customer" items="${customerList}">
            <tr>
                <td>
                    <c:out value="${customer.name}"/>
                </td>
                <td>
                    <c:out value="${customer.dob}"/>
                </td>
                <td>
                    <c:out value="${customer.address}"/>
                </td>
                <td>
                    <img src="${customer.imgURL}" alt="${customer.name}" class="rounded profile-picture">
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
