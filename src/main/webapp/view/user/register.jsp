<%--
  Created by IntelliJ IDEA.
  User: darxan
  Date: 2017/2/15
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>hostel user 注册</title>
    <link rel='stylesheet' href='../../plugin/bootstrap/css/bootstrap.min.css'>
    <link rel='stylesheet' href='../../css/login.css'>
    <link rel='stylesheet' href='../../css/foot.css'>

    <script src="/js/jquery.min.js"></script>

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <form class="form-horizontal" action="../../public/register/userAction" method="post">
                <span class="heading">用户注册</span>



                <div class="form-group">
                    <input type="text" class="form-control" id="name" name="name" placeholder="邮箱">
                    <i class="fa fa-user"></i>
                </div>

                <div class="form-group help">
                    <input type="password" class="form-control" id="password" name="password" placeholder="密　码">
                    <i class="fa fa-lock"></i>
                    <a href="#" class="fa fa-question-circle"></a>
                </div>

                <div class="form-group help">
                    <input type="password" class="form-control" id="re_password" name="re_password" placeholder="密　码">
                    <i class="fa fa-lock"></i>
                    <a href="#" class="fa fa-question-circle"></a>
                </div>

                <div class="form-group">
                    <input type="text" class="form-control" id="contact" name="contact" placeholder="联系姓名">
                    <i class="fa fa-user"></i>
                </div>

                <div class="form-group">
                    <input type="text" class="form-control" id="phone" name="phone" placeholder="联系电话">
                    <i class="fa fa-user"></i>
                </div>

                <div class="form-group">
                    <input type="text" class="form-control" id="bankcard" name="bankcard" placeholder="银行卡号">
                    <i class="fa fa-user"></i>
                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-default">注册</button>
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
