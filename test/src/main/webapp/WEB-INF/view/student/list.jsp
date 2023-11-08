<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Student</title>
</head>
<body>
<form action="/money/change" method="post">
    <table>
        <tr>
            <td>Select</td>
            <td><input type="radio" name="usd"  value="usd">USD</td>
            <td><input type="radio" name="vnd"  value="vnd">VND</td>
        </tr>
        <tr>
            <td>Type transfer :</td>
            <td> <input type="number" id="money" name="money1" ></td>
            <td><button tupe="submit">OK</button></td>
        </tr>
    </table>
</form>
<p>Kết quả là : <c:out value="${changed}"/></p>

</body>
</html>
