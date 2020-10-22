<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>用户信息页面</title>
    <link type="text/css" rel="stylesheet" href="css/userInfo.css" />
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            var height=$(document).height();
            $('.main').css('height',height);
        })
    </script>
</head>

<body>
<div class="main">
    <div class="main0">
        <div class= "software_title">
            线上银行系统
        </div>

        <hr>

        <div class="main_left">
            <div class="right_expand">

                <strong>卡号：</strong><span>${depositor.cardid}</span>
                <br/>
                <strong>姓名：</strong><span>${depositor.name}</span>
                <br/>
                <span class="msgstr"></span>

            </div>

            <div class="right_content">
                <h3>用户个人信息</h3>
                <div>
                    <table cellspacing="0" rules="all" border="1" style="border-collapse:collapse;">
                        <tbody>
                        <tr class="trh">
                            <th scope="col">姓名</th>
                            <th scope="col">昵称</th>
                            <th scope="col">电话</th>
                            <th scope="col">银行卡号</th>
                            <th scope="col">身份证号码</th>
                            <th scope="col">性别</th>
                            <th scope="col">地址</th>
                            <th scope="col">备注</th>
                        </tr>
                        <tr class="tr1">
                            <td>${depositor.name}</td>
                            <td>${depositor.username}</td>
                            <td>${depositor.tel}</td>
                            <td>${depositor.cardid}</td>
                            <td>${depositor.pid}</td>
                            <td>${depositor.gender}</td>
                            <td>${depositor.address}</td>
                            <td>&nbsp;</td>
                        </tr>
                        </tbody>
                    </table>
                </div>

                <a class="push_button blue" href="/login?method=success">返回主菜单</a>

            </div>

        </div>
    </div>
</div>

<div class="footer">
    <div class="footer0">
        <div class="footer_l">使用条款 | 隐私保护</div>
        <div class="footer_r">© 2020 GDPU 银行系统 </div>
    </div>
</div>
</body>
</html>