<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="/struts-tags" %>

<!DOCTYPE html>
<html>

<head>
    <%@ include file="_include/head.jsp"%>
</head>

<body>
    <%@ include file="_include/header.jsp"%>


<div class="container">





<!--
    <div class="row">
        <div class="col-md-4">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Pseudo</h5>
                    <p class="card-text"> Tu as déjà ton pseudo.</p>
                    <s:a action="login" class="btn btn-primary"><s:text name="nav.goChannel" /></s:a>




                </div>
            </div>
        </div>

-->
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Login</h5>
                        <p class="card-text">Connexion avec ton pseudo </p>
                        <s:a action="login" class="btn btn-primary"><s:text name="nav.goChannel" /></s:a>




                    </div>
                </div>
            </div>

         </div>


    </div>

    <%@ include file="./_include/scripts.jsp" %>
    <%@ include file="/jsp/_include/footer.jsp" %>
</body>
</html>
