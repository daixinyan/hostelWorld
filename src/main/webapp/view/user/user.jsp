<%--
  Created by IntelliJ IDEA.
  User: darxan
  Date: 2017/2/19
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>

    <title>user info</title>

    <jsp:include page="../common/header.jsp"/>
</head>

<body>
<div class="header">
    <a href="#menu"><span></span></a>
    user info
</div>
<jsp:include page="../common/nav.jsp"/>

<div class="myContent">

    <div class="personalInfo">
        <form action="/user/update/info" method="post">

            <input type="hidden" name="memberId" value="${user.memberId}">

            <div>
                <div class="col-md-2"></div>
                <div class="col-md-3">
                    <h2 class="tab-h2">avatar</h2>
                    <p class="tab-p">You can change your avatar here or remove the current avatar to revert to gravatar.com
                    </p>
                </div>
                <fieldset class="col-md-5">
                    <br/>
                    <br/>
                    <img src="${user.avatar}">
                    <input type="file" class="avatar_delete" name="avatar" value="${user.avatar}">
                    <span class="help-block"></span>
                </fieldset>
                <div class="col-md-2"></div>
            </div>
            <div class="clearfix"></div>

            <div>
                <div class="col-md-2"></div>
                <div class="col-md-3">
                    <h2 class="tab-h2">Main settings</h2>
                    <p class="tab-p">This information will appear on your profile.
                    </p>
                </div>
                <fieldset class="col-md-5">


                    <div>

                        <br/>
                        <br/>
                        <span class="tab-larger">当前状态</span>
                        <c:choose>
                            <c:when test="${user.state==1}">
                                <span class="tab-larger">已激活</span>

                                <a href="/user/state/destroy" target="_blank">
                                    <span class="underline_link">注销资格</span>
                                </a>
                            </c:when>
                            <c:otherwise>
                                <span class="tab-larger">未激活</span>
                                <a href="/user/state/active" target="_blank">
                                    <span class="underline_link tab-h2">激活</span>
                                </a>
                            </c:otherwise>
                        </c:choose>
                        <br/>
                        <br/>
                    </div>

                    <div>


                        <span class="tab-larger">当前级别</span>
                            <span class="tab-larger">
                                <c:choose>
                                    <c:when test="${user.level==0}">
                                        未激活
                                    </c:when>
                                    <c:when test="${user.level==1}">
                                        一般会员
                                    </c:when>
                                    <c:when test="${user.level==2}">
                                        高级会员
                                    </c:when>
                                    <c:when test="${user.level==3}">
                                        冲击会员
                                    </c:when>
                                </c:choose>
                            </span>
                            <a href="http://www.baidu.com" target="_blank">
                                <span class="underline_link tab-h2">升级享受优惠</span>
                            </a>
                        <br/>
                        <br/>
                    </div>


                    <div>


                        <span class="tab-larger">当前积分</span>
                        <span class="tab-larger">
                                ${user.bonusPoint}
                            </span>
                        <a href="/user/exchange/1000" target="_blank">
                            <span class="underline_link tab-larger">兑换积分</span>
                        </a>
                        <br/>
                        <br/>
                    </div>

                    <div>
                        <span class="tab-larger">当前余额</span>
                        <span class="tab-larger">
                            ${user.balance}
                        </span>
                        <a href="/user/exchange/1000" target="_blank">
                            <span class="underline_link tab-larger">点击充值</span>
                        </a>
                        <br/>
                    </div>

                    <input type="text" class="col-md-12 col-sm-12" name="name" value="${user.name}">
                    <label class="tab-close">name</label>
                    <span class="help-block"></span>


                    <input type="password" class="col-md-12 col-sm-12" name="password" value="${user.password}">
                    <label class="tab-close">password</label>
                    <span class="help-block"></span>


                    <input type="password" class="col-md-12 col-sm-12" name="re_password" value="${user.password}">
                    <label class="tab-close">re_password</label>
                    <span class="help-block"></span>


                    <input type="text" class="col-md-12 col-sm-12" name="contact" value="${user.contact}">
                    <label class="tab-close">contact</label>
                    <span class="help-block"></span>


                    <input type="number" class="col-md-12 col-sm-12" name="phone" value="${user.phone}">
                    <label class="tab-close">phone</label>
                    <span class="help-block"></span>


                    <input type="number" class="col-md-12 col-sm-12" name="bankCard" value="${user.bankCard}">
                    <label class="tab-close">bankcard</label>
                    <span class="help-block"></span>

                    <div class="clearfix"></div>
                    <input type="submit">
                </fieldset>
                <div class="col-md-2"></div>

            </div>

        </form>
    </div>

</div>
<div class="myFooter"></div>

</body>

</html>