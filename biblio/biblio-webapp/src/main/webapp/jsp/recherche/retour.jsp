<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/head.jsp" %>
</head>


<body>
<s:actionerror/>
<s:actionmessage/>
<%@ include file="../_include/header.jsp" %>

<div class="container">



    <s:form action="retour" class="form-inline" >



        <s:select label="Retout Ouvrage"
                  list="listEmprunt" listKey="description" listValue="description"
                  emptyOption="true"
                  name="livre.titre" />


        <s:submit value="OK" class="btn btn-primary mb-2"/>

    </s:form>

    <%@ include file="../_include/footer.jsp" %>
</div>
</body>
</html>
