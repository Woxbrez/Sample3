<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="dao" class="br.com.flf.jdbc.LivroDAO"/>

<c:forEach var="Livro" items="${dao.getLivros()}">
${Livro.titulo}<br>

</c:forEach>
</body>
</html>