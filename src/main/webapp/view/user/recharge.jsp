<%--
  Created by IntelliJ IDEA.
  User: darxan
  Date: 2017/3/15
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>recharge</title>
    <jsp:include page="../common/header.jsp"/>
</head>
<body>
<div class="header">
    <a href="#menu"><span></span></a>
    recharge
</div>
<jsp:include page="../common/nav.jsp"/>
<div class="col-md-4"></div>

<div class="col-md-4">
    <br/>
    <br/>
   <form action="/user/recharge/">
        <span>
            <label>金额</label>
            <br/>
                    <input type="text" class="much" name="much" value="50"/>
            <br/>
             <span class="help-block"></span>

            <br/>
            <label>选择银行卡</label>
            <br/>
            <select name="choosedBankCard">
                <option  value="0" selected="selected">${user.bankCard}</option>
            </select>

             <br/>
            <br/>
            <input type="submit" value="充值">
    </span>
   </form>
</div>

<div class="col-md-4"></div>

</body>
</html>
