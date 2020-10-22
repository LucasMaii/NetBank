<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>搜索结果</title>
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

            <div class="search">
                <form action="/manage?method=search" method="post">
                    <input type="text" name="info" placeholder="请输入银行卡号..." />
                    <input type="submit" value="搜索"/>
                </form>
            </div>

            <div class="right_content">
                <h3>搜索结果</h3>
                <div>
                    <table cellspacing="0" rules="all" border="1" style="border-collapse:collapse;">
                        <tbody>
                        <tr class="trh">
                            <th>姓名</th>
                            <th>联系电话</th>
                            <th>银行卡号码</th>
                            <th>身份证号码</th>
                            <th>性别</th>
                            <th>地址</th>
                            <th>备注</th>
                        </tr>
                        <tr class="tr1">
                            <td>${depositor.name}</td>
                            <td>${depositor.tel}</td>
                            <td>${depositor.cardid}</td>
                            <td>${depositor.pid}</td>
                            <td>${depositor.gender}</td>
                            <td>${depositor.address}</td>
                            <td>&nbsp;</td>
                        </tr>
                        </tbody>
                        <tbody>
                        <tr class="trh">
                            <th scope="col">账户状态</th>
                            <th scope="col">信用值</th>
                            <th scope="col">余额(元)</th>
                        </tr>
                        <tr class="tr1">
                            <td>${account.status}</td>
                            <td>${account.credit}</td>
                            <td>${account.balance}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>

                <a class="push_button blue" href="/login?method=adminsuccess">返回主菜单</a>

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