<%--
  Created by IntelliJ IDEA.
  User: darxan
  Date: 2017/2/19
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>

    <title>Title</title>

    <jsp:include page="../common/header.jsp"/>
</head>

<body>



<jsp:include page="../common/nav.jsp"/>

<div class="myContent">

    <div class="personalInfo">
        <form action="/hostel/update/info" method="post">

            <input type="hidden" name="hostelId" value="${hostel.hostelId}">

            <div>
                <div class="col-md-2"></div>
                <div class="col-md-3">
                    <h2 class="tab-h2">avatar</h2>
                    <p class="tab-p">You can change your avatar here or remove the current avatar to revert to gravatar.com
                    </p>
                </div>
                <div class="col-md-5">
                    <fieldset class="col-md-8">
                        <br/>
                        <br/>
                        <img src="${hostel.image}" class="img-responsive">
                        <input type="file" class="avatar" name="avatar" value="${hostel.image}">
                        <span class="help-block"></span>
                    </fieldset>
                </div>
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

                    <br/>
                    <br/>

                    <div>

                        <br/>
                        <br/>
                        <span class="tab-larger">当前状态</span>
                        <c:choose>
                            <c:when test="${user.state==1}">
                                <span class="tab-larger">已激活</span>
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

                    <input type="text" class="col-md-12 col-sm-12" name="name" value="${hostel.name}">
                    <label class="tab-close">name</label>
                    <span class="help-block"></span>


                    <input type="password" class="col-md-12 col-sm-12" name="password" value="${hostel.password}">
                    <label class="tab-close">password</label>
                    <span class="help-block"></span>


                    <input type="password" class="col-md-12 col-sm-12" name="re_password" value="${hostel.password}">
                    <label class="tab-close">re_password</label>
                    <span class="help-block"></span>


                    <input type="text" class="col-md-12 col-sm-12" name="contact" value="${hostel.contact}">
                    <label class="tab-close">contact</label>
                    <span class="help-block"></span>


                    <input type="number" class="col-md-12 col-sm-12" name="phone" value="${hostel.phone}">
                    <label class="tab-close">phone</label>
                    <span class="help-block"></span>


                    <input type="number" class="col-md-12 col-sm-12" name="bankcard" value="${hostel.bankcard}">
                    <label class="tab-close">bankcard</label>
                    <span class="help-block"></span>

                    <input type="text" class="col-md-12 col-sm-12" name="hostel" value="${hostel.hostel}">
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




</body>

</html>