<%@page import="fiche_competence.Affichage" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Fiche de comp�tences</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<jsp:useBean id="person" type="connexion.Person" scope="request"/>
<p><% Affichage a= new Affichage();
int code_isep = person.getCode_isep();
out.println(code_isep);
%> 
</p>
	<table class=table-bordered>
  <h3 class= text-center>1- Agir en bon communicant dans un environnement scientifique et technologique</h3>
  <tr>
    <th></th>
    <th>Observation sur l'�quipe</th>
    <th>Observations individuelles</th>
    <th colspan=5>Niveau individuel</th>
    <th> Coef </th>
    <th>�tudiants</th>
    <th>Commentaire tuteur</th>
  </tr>
  <tr>
  	<%! String competence= "�changer"; %>
    <td rowspan=6> <%= competence %> </br>
    				�couter et se faire �couter</br></br>
    				Dialoguer, argumenter, convaincre</td>
    <td rowspan=6> Commentaire groupe </td>
    <td><%=  %> </td>
    <td class= text-center>1</td><td class= text-center>2</td><td class= text-center>3</td><td class= text-center>4</td><td class= text-center>5</td>
    <td rowspan=6 class= text-center> 1 </td>
    <td>Kevin</td>
    <td rowspan=6>Commentaire profs</td>
  </tr>
  <tr>
    <td>Commentaire �tudiant 2</td>
    <td></td><td></td><td></td><td></td><td></td>
    <td>Ducobu</td>
  </tr>
  <tr>
    <td>Commentaire �tudiant 3</td>
    <td></td><td></td><td></td><td></td><td></td>
    <td>Toto</td>
  </tr>
  <tr>
  	<td>Commentaire �tudiant 4</td>
    <td></td><td></td><td></td><td></td><td></td>
    <td>L�onie</td>
  </tr>
  <tr>
    <td>Commentaire �tudiant 5</td>
    <td></td><td></td><td></td><td></td><td></td>
    <td>Le fant�me</td>
  </tr>
  <tr>
    <td>Commentaire �tudiant 6</td>
    <td></td><td></td><td></td><td></td><td></td>
    <td>Si besoin</td>
  </tr>
</table>
</div>
</body>
</html>