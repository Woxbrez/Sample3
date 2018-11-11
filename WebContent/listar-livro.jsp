<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="index-head.html"/>
<body>
	<c:import url="index-top.html"/>

	<jsp:useBean id="dao" class="br.com.flf.jdbc.LivroDAO"/>
	<div class="row">
	    <div class="twelve columns">
	        <div class="row">
	            <div class="ten columns">
	                <table width="100%">
	                    <thead>
	                    <tr>
	                        <th>Título</th>
	                        <th>Autores</th>
	                        <th>Gênero</th>
	                        <th>Ano</th>
	                        <th>Editora</th>
	                        <th>Opções</th>
	                        
	                    </tr>
	                    </thead>
	                    <tbody>
	                    
	                    <c:forEach var="Livro" items="${dao.getLivros()}">
	                        <tr>
	                            <td>${Livro.titulo}</td>
	                            <td>${Livro.autores}</td>
	                            <td>${Livro.genero}</td>
	                            <td>${Livro.ano}</td>
	                            <td>${Livro.editora}</td>
	                            
	                            <td><a href="altera-livro.jsp?id=${Livro.id}" target="blank">Alterar</a> - <a
	                                    href="removeLivro?id=${Livro.id}" target="blank">Excluir</a></td>
	                        </tr>
	                    </c:forEach>
	                    </tbody>
	                </table>
	            </div>
	        </div>
	    </div>
	</div>
</body>
</html>