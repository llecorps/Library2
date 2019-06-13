<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="S" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/head.jsp" %>
</head>

<body>
<%@ include file="../_include/header.jsp" %>

<h2>Démo - AJAX</h2>


<h3>Selects en cascade</h3>
<s:form>
    <s:select id="channel" name="channel" label="Channel"
              list="listChannel" listKey="id" listValue="name"
              onchange="onSelectChannelChange()"/>

    <S:textfield name="channel" value="Random" id="leChannel" />

    <s:select id="selectMessage" label="Message" list="{}"/>
</s:form>


<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
    function onSelectChannelChange() {
        // URL de l'action AJAX
        var url = "<s:url action="demo_ajax_getListChannel"/>";

        // Paramètres de la requête AJAX
        var params = {
            channel: jQuery("#leChannel").val()
        };

        // Action AJAX en POST
        jQuery.post(
                url,
                params,
                function (data) {
                    var $selectMessage = jQuery("#selectMessage");
                    $selectMessage.empty();
                    jQuery.each(data, function (key, val) {
                        $selectMessage.append(
                                jQuery("<option>")
                                        .text(val.author)
                                        .val(val.message)
                        );
                    });
                })
                .fail(function (data) {
                    if (typeof data.responseJSON === 'object') {
                        console.log(data.responseJSON);
                    } else {
                        console.log(data);
                    }
                    alert("Une erreur s'est produite.");
                });
    }
</script>
</body>
</html>