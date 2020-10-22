<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>账户信息界面</title>
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
            银行管理员管理界面
        </div>

        <hr>

        <div class="main_left">
            <div class="right_expand">

                <strong>管理员：</strong><span>${admin}</span>
                <br/>

            </div>

            <div class="right_content">
                <h3>该用户银行账户信息</h3>
                <div>
                    <table cellspacing="0" rules="all" border="1" style="border-collapse:collapse;">
                        <tbody>
                        <tr class="trh">
                            <th scope="col">姓名</th>
                            <th scope="col">电话</th>
                            <th scope="col">银行卡号</th>
                            <th scope="col">账户状态</th>
                            <th scope="col">信用值</th>
                            <th scope="col">余额(元)</th>
                        </tr>
                        <tr class="tr1">
                            <td>${depositor.name}</td>
                            <td>${depositor.tel}</td>
                            <td>${depositor.cardid}</td>
                            <td>${account.status}</td>
                            <td>${account.credit}</td>
                            <td>${account.balance}</td>
                        </tr>
                        </tbody>

                    </table>
                </div>
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