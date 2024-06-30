<!DOCTYPE html>
<html>
<head>
    <title>Result</title>
</head>
<body>
<h1>Result</h1>
<c:if test="${not empty result}">
    <p>Result: ${result}</p>
</c:if>
<c:if test="${not empty error}">
    <p style="color:red;">Error: ${error}</p>
</c:if>
<a href="calculator">Back to Calculator</a>
</body>
</html>
