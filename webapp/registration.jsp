<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <jsp:include page="style.jsp"/>
    <title>Registration</title>
</head>
<body>
    <h1>Customer Register Form</h1>
    <form action="/controller/registration" method="post">
         Enter login: <br/>
            <input type = "text" name="login" placeholder="username" id = "inputName"/>
    <br/>
    Enter password: <br/>
    <input type = "password" name = "password" placeholder="password" />
    <br/>
    Enter name: <br/>
    <input type="text" name = "firstName" placeholder="name" />
    </br>
    Enter last name: <br/>
    <input type="text" name = "lastName" placeholder="last name">
    </br>
    Enter email: <br/>
    <input type="text" name = "email" placeholder="email">
    </br>
    Enter phone number: <br/>
    <input type="text" name = "phoneNumber" placeholder="phone number">
    </br>
    Enter address: <br/>
    <input type="text" name = "address" placeholder=" address">
    </br>
    Enter  gender: <br/>
    <input type="text" name = "gender" placeholder="gender">
    </br>
    Enter IIN: <br/>
    <input type="text" name = "iin" placeholder="IIN">
    </br>
    Enter date of IIN: <br/>
    <input type="text" name = "dateOfIIN" placeholder="date of IIN">
    </br>
    <input type = "submit" value="login"/>
    </form>
</body>
</html>
