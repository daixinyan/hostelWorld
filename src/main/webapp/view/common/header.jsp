<%--
  Created by IntelliJ IDEA.
  User: darxan
  Date: 2017/2/25
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="../../css/jquery.resizableColumns.css">
<link type="text/css" rel="stylesheet" href="../../css/resizableTable.css">
<link type="text/css" rel="stylesheet" href="../../css/formTable.css">
<link type="text/css" rel="stylesheet" href="../../plugin/bootstrap/css/bootstrap.min.css"/>
<link type="text/css" rel="stylesheet" href="../../css/nav.css" />
<link type="text/css" rel="stylesheet" href="../../css/font.css" />
<link type="text/css" rel="stylesheet" href="../../plugin/menu/dist/css/jquery.mmenu.all.css" />
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<script type="text/javascript" src="../../js/jquery.form.js"></script>
<script type="text/javascript" src="../../plugin/menu/dist/js/jquery.mmenu.all.min.js"></script>
<script type="text/javascript" src="../../plugin/paginator/js/jqPaginator.js"></script>
<!-- Optional localStorage dependancy, for persistent column width storage -->
<script src="../../js/store.min.js"></script>

<!-- Plugin -->
<script src="../../js/jquery.resizableColumns.min.js"></script>

<script type="text/javascript">
    <c:if test="${result.success==false && (not empty result.message)}">
        alert("操作失败："+${result.message})
    </c:if>
    $(function() {
        $('nav#menu').mmenu();
    });
</script>

