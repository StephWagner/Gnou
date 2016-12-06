<%@page import="fiche_competence.Affichage" %>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Fiche de compétences</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<p><% Affichage a= new Affichage();
String groupe = (String)session.getAttribute("groupe");
String statut = (String)session.getAttribute("statut");
int[] membre = a.getMembre(groupe);

%> 


</p>

<sql:setDataSource var="co" driver="com.mysql.jdbc.Driver"
  url="jdbc:mysql://localhost:3306/gnou"
  user="root"  password="root"/>
  
<table class=table-bordered>
  <h3 class= text-center>1- Agir en bon communicant dans un environnement scientifique et technologique</h3>
  <tr>
    <th></th>
    <th> Coef </th>
    <th>Observation sur l'équipe</th>
    <th>Observations individuelles</th>
    <th>Loin</th>
    <th>Proche</th>
    <th> Très proche </th>
    <th> Attendu </th>
    <th> Au delà </th>
    <th>Étudiants</th>
    <% if (statut.equals("prof") || statut.equals("respo_app")) { %>
    <th>Commentaire tuteur</th><% } %>
  </tr>
  <tr>
  	<%! String competence= "Echanger"; %>
	<sql:query dataSource="${co}" var="result">
		SELECT * from fiche_competences_groupe 
		WHERE Groupe=groupe AND Nom_competence = "<%= competence %>" 
		AND ID_version IN (SELECT MAX(Id_version) FROM fiche_competences_groupe);
	</sql:query>
    <td rowspan=<%=membre.length %>> <%= competence %> </br>
    				Écouter et se faire écouter</br></br>
    				Dialoguer, argumenter, convaincre</td>
    <td rowspan=<%=membre.length %> class= text-center> 1 </td>
	<c:forEach var="row" items="${result.rows}">
    <td rowspan=<%=membre.length %>> <c:out value="${row.Commentaire_groupe}"/> </td> 
  	</c:forEach>
  	<% for (int i=0; i<membre.length; i++) {
  			ArrayList<String> fiche = a.lireFiche(membre[i], competence, 1);
  			String prenom = a.getPrenom(membre[i]);%>
    <td><% out.print(fiche.get(1)); %> </td>
    <% int note = Integer.parseInt(fiche.get(0));
    for (int j=1; j<=5; j++) {
    	if (note == j) {%>
    		<td class= text-center>x</td><%
    	}else {%>
    		<td class= text-center></td><%
    	}
    }%>
    <td><% out.print(prenom); %></td>
    <% if (statut.equals("respo_app")) {%>
    <td><% out.print(fiche.get(2)); }%></td>
  </tr>
  <tr><% } %></tr>
</table>
</div>
</body>
</html>