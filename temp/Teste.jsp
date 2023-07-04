
<%
Integer i = (Integer) request.getAttribute("test");
    out.println(i);
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="getVal" method="get">
        <input type="text" name="nom" id="">
        <input type="date" name="sqlDate" id="">
        <input type="date" name="utilDate" id="">
        <input type="checkbox" name="table[]" id="" value="true">
        <input type="checkbox" name="table[]" id="" value="false">
        <input type="submit" value="Confirm">
    </form>
</body>
</html>