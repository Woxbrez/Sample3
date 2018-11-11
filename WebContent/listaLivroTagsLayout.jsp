<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="index-head.html" />
<body>
	<c:import url="index-top.html" />

	<jsp:useBean id="dao" class="br.com.flf.jdbc.LivroDAO" />
	<div class="row">
		<div class="twelve columns">
			<div class="row">
				<div class="eight columns">
					<c:forEach var="Livro" items="${dao.getLivros()}">
						${Livro.titulo}<br>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<br>
</body>
</html>