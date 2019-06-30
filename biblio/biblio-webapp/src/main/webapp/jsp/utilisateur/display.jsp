<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/head.jsp" %>
</head>

<body>
<%@ include file="../_include/header.jsp" %>


<div class="container" >
    <div class="container" >

        <h2><s:text name="title.login" /></h2>


        <s:if test="#session.utilisateur">


            <div class="card" style="width: 18rem;">
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">Login : <s:property value="utilisateur.login" /></li>
                    <li class="list-group-item">Email : <s:property value="utilisateur.email" /></li>
                    <li class="list-group-item">Adress : <s:property value="utilisateur.adress" /></li>
                    <li class="list-group-item">Phone : <s:property value="utilisateur.phone" /></li>
                </ul>
            </div>

            <ul class="list-group list-group-flush">

                <br>
                <h3><s:text name="nav.list" /></h3>&nbsp
                <s:iterator value="listEmprunt">
                    <li class="list-group-item d-flex justify-content-between align-items-center">

                        Nom:&nbsp<s:property value="nom"/>
                        Titre:&nbsp<s:property value="titre"/>
                        Description:&nbsp<s:property value="description"/>
                        Genre:&nbsp<s:property value="genre"/>
                        Date d'expiration:&nbsp<s:property value="expiredate"/>


                        <s:if test="prolongation=='true'">
                        <s:a action="prolonger" class="btn btn-outline-success">Prolonger
                            <s:param name="id" value="id" />
                        </s:a>
                        </s:if>
                        <s:else>
                            <span class="badge-danger">Pas de prolongation possible</span>
                        </s:else>
                    </li>
                </s:iterator>
               
                <h3><s:text name="nav.resa" /></h3>&nbsp
                <s:iterator value="listResa">
                    <li class="list-group-item d-flex justify-content-between align-items-center">

                        Nom:&nbsp<s:property value="nom"/>
                        Titre:&nbsp<s:property value="titre"/>
                        Description:&nbsp<s:property value="description"/>
                        Genre:&nbsp<s:property value="genre"/>
                        <s:a action="cancel" class="btn btn-outline-warning">Annulation
                            <s:param name="id" value="id" />
                        </s:a>
                    </li>
                </s:iterator>

            </ul>


        </s:if>

        <s:else>
            <s:form action="login" class="form-group">

                <s:textfield name="login" label="Identifiant" requiredLabel="true" />
                <s:password name="password" label="Mot de passe" requiredLabel="true" id="passFieldId" />

                <s:submit value="Connexion"/>
            </s:form>

        </s:else>
    </div>

    <%@ include file="../_include/scripts.jsp" %>
    <%@ include file="../_include/footer.jsp" %>
</body>
</html>