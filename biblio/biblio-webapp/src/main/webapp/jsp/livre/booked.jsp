

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/head.jsp" %>
</head>
<body>
<s:actionerror/>
<s:actionmessage />
<%@ include file="../_include/header.jsp" %>

<div class="container ">



    <h2>Détail Livre</h2>

    <div class="card " style="width: 30rem;">
        <div class="card-body">


            <ul>
                <li><b>Auteur :&nbsp</b> <s:property value="auteur.prenom" />&nbsp<s:property value="auteur.nom" /></li>
                <li><b>Titre:&nbsp</b><s:property value="livre.titre"/></li>
                <li><b>Description :&nbsp</b> <s:property value="livre.description" /></li>
                <li><b>Genre :&nbsp</b> <s:property value="livre.genre" /></li>
                <li><b>Nombre d'exemplaires:&nbsp</b><s:property value="livre.exemplaire" /></li>
            </ul>



            <s:a action="booked" class="btn btn-outline-warning">Booking;
                <s:param name="id" value="livre.id" />
            </s:a>


        </div>
    </div>

</div>
<%@ include file="../_include/footer.jsp" %>
</body>
</html>