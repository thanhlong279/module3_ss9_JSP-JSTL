<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Simple Calculator</h1><br/>
<form action="/calculator" method="post">
    <label>First operand: </label>
    <input type="number" name="first" placeholder="First operand" required><br/>
    <label>Operator</label>
    <select name="operation" class="form-select" aria-label="select example" required>
        <option value="addition">Cộng</option>
        <option value="subtraction">Trừ</option>
        <option value="multiplication">Nhân</option>
        <option value="division">Chia</option>
    </select><br/>
    <label>Second operand</label>
    <input type="number" name="second" placeholder="Second operand" required><br/>
    <input type="submit" id="submit" value="Calculate">
</form>
</body>
</html>
