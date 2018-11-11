<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="br.com.flf.models.Livro" %>
<%@ page import="java.util.List" %>
<c:import url="index-head.html" />

<body>
		<c:import url="index-top.html" />
	
		<jsp:useBean id="dao" class="br.com.flf.jdbc.LivroDAO" />
		<div class="row">
			<div class="twelve columns">
			
				<div class="row">
					<div class="eight columns">
	
						<form action="pesquisaLivro">
	Chave de pesquisa: <input type="text" name="key" />
<button type="submit" value="Submit">Search</button> 

</form>

<%
if(request.getAttribute("lista_req")!=null){
	
	List<Livro> livros = (List) request.getAttribute("lista_req");
	
	for (Livro livro : livros ) {
		out.print("<li> id:"+livro.getId()+" - "+livro.getTitulo()+"</li>");
	}
}
%>

				</div>
			</div>
		</div>
	</div>

<br>
</body>
</html>