
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



    <h2>Résultat</h2>

    <ul class="list-group list-group-flush">
        <s:iterator value="ResultLivre">
            <li class="list-group-item d-flex justify-content-between align-items-center">

                <s:a action="livre_detail">
                    <s:param name="id" value="id" />

                    <s:property value="titre"/>&nbsp
                    -&nbsp<s:property value="description"/>&nbsp
                </s:a>

            </li>
        </s:iterator>
    </ul>
</div>
<%@ include file="../_include/footer.jsp" %>
</body>
</html>