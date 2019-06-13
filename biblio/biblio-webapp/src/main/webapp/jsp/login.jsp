<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="./_include/head.jsp" %>
</head>

<body>
    <%@ include file="./_include/header.jsp" %>



<div class="container" >

    <div class="row">

    <h2><s:text name="title.login" /></h2><br>


    <s:if test="#session.utilisateur">&nbsp

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
            <h2><s:text name="nav.list" /></h2>&nbsp
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
                <span class="badge-danger">Pas de prolongation</span>
            </s:else>
        </li>
        </s:iterator>
        </ul>

</div>

    <%@ include file="./_include/footer.jsp" %>
    </s:if>

    <s:else>

    <div class="container">
        <div id="login-row" class="row justify-content-center align-items-center">
            <div id="login-column" class="col-md-6">
                <div class="box">
                    <div class="shape1"></div>
                    <div class="shape2"></div>
                    <div class="shape3"></div>
                    <div class="shape4"></div>
                    <div class="shape5"></div>
                    <div class="shape6"></div>
                    <div class="shape7"></div>
                    <div class="float">

    <s:form action="login" class="form-group">

        <s:textfield name="login" label="Identifiant" requiredLabel="true" class="form-control"/>
        <s:password name="password" label="Mot de passe" requiredLabel="true" id="passFieldId" class="form-control" />

        <s:submit value="Connexion" class="btn btn-info btn-md"/>
    </s:form>

                    </div>
                </div>
            </div>
        </div>
    </div>

    </s:else>
</div>

    <%@ include file="./_include/scripts.jsp" %>

</body>
</html>