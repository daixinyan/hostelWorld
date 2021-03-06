<%--
  Created by IntelliJ IDEA.
  User: darxan
  Date: 2017/2/15
  Time: 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>hostel world 登录</title>
    <link rel='stylesheet' href='/plugin/bootstrap/css/bootstrap.min.css'>
    <link rel='stylesheet' href='/css/login.css'>
    <link rel='stylesheet' href='/css/foot.css'>

    <script src="../../js/jquery.min.js"></script>
    <script src="../../js/login.js"></script>

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <form class="form-horizontal" action="../../public/action/login" method="get">
                <span class="heading">用户登录</span>

                <div class="form-group" id="loginTypeCheckbox">
                    <div class="main-checkbox">
                        <input
                                <c:if test="${type.equals('user')}"> checked </c:if>
                                type="checkbox" value="user" id="user_check" name="loginType" onclick="loginTypeCheckboxEvent('user_check')"/>
                        <label for="user_check"></label>
                    </div>
                    <span class="text">用户</span>

                    <div class="main-checkbox">
                        <input <c:if test="${type.equals('hostel')}"> checked </c:if>
                                type="checkbox" value="hostel" id="hostel_check" name="loginType" onclick="loginTypeCheckboxEvent('hostel_check')"/>
                        <label for="hostel_check"></label>
                    </div>
                    <span class="text">客栈</span>

                    <div class="main-checkbox">
                        <input <c:if test="${type.equals('admin')}"> checked </c:if>
                                type="checkbox" value="admin" id="admin_check" name="loginType" onclick="loginTypeCheckboxEvent('admin_check')"/>
                        <label for="admin_check"></label>
                    </div>
                    <span class="text">管理员</span>
                </div>

                <!--<div class="form-group">-->
                <!--<input type="radio" id=user value="user" name=user_type_radio checked=""/>用户-->
                <!--<input type="radio"  id=hostel value="hostel" name=user_type_radio checked="checked"/>客栈-->
                <!--<input type="radio"  id=admin value="admin" name=user_type_radio checked="false"/>管理员-->
                <!--</div>-->

                <div class="form-group">
                    <input type="text" class="form-control" id="name" name="name" placeholder="用户名或id">
                    <i class="fa fa-user"></i>
                </div>

                <div class="form-group help">
                    <input type="password" class="form-control" id="password" name="password" placeholder="密　码">
                    <i class="fa fa-lock"></i>
                    <a href="#" class="fa fa-question-circle"></a>
                </div>

                <div class="form-group">
                    <div class="main-checkbox">
                        <input type="checkbox" value="None" id="remember" name="check"/>
                        <label for="remember"></label>
                    </div>
                    <span class="text">Remember me</span>
                    <button type="submit" class="btn btn-default">登录</button>
                </div>
            </form>
        </div>
    </div>

    <!--<footer id="number-footer">-->
    <!--当前总人数：-->
    <!--&nbsp-->
    <!--<span class="countNumTip" id="numberOfTotal">0</span> &nbsp-->
    <!--当前访客人数:-->
    <!--&nbsp-->
    <!--<span class="countNumTip" id="numberOfGuest">0</span> &nbsp-->
    <!--当前登录用户人数:-->
    <!--&nbsp-->
    <!--<span class="countNumTip" id="numberOfLoginer">0</span>-->
    <!--</footer>-->
</div>
</body>
</html>
