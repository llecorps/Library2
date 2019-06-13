<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand">
        <s:a action="display" class="nav-link"><s:text name="nav.index" /></s:a>
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <s:if test="#session.utilisateur">
        <ul class="navbar-nav mr-auto">


            <li class="nav-item active">
                <s:a action="recherche" class="nav-link"><s:text name="nav.recherche" /></s:a> <span class="sr-only">(current)</span></a>
            </li>

            <li class="nav-item">

                <span class="sr-only">(current)</span></a>
            </li>



        </ul>

            Utilisateur connecté :
            <s:property value="#session.utilisateur.login" />
            <s:a action="logout" ><s:text name="nav.goLout" />

            </s:a>
        </s:if>
        <s:else>
            Vous devez vous connecter!
        </s:else>



    </div>
</nav>
<div class="container">
    <s:actionerror/>
    <s:actionmessage/>
</div>