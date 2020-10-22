<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>交易明细</title>
    <link type="text/css" rel="stylesheet" href="css/depositor.css" />
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
                <h3>用户交易信息</h3>
                <div class="table-wrapper">
                    <table cellspacing="0" rules="all" border="1" style="border-collapse:collapse;">

                        <tbody>
                        <tr class="trh">

                            <th scope="col">序号</th>
                            <th scope="col">转账金额</th>
                            <th scope="col">收款人姓名</th>
                            <th scope="col">收款人银行卡号</th>
                            <th scope="col">交易日期</th>
                            <th scope="col">备注</th>
                            <th scope="col">操作</th>

                        </tr>
                        <c:forEach items="${list}" var="transferLog" varStatus="status">
                            <tr class="tr1">

                                <td>${status.index + 1}</td>
                                <td>${transferLog.amountTransferred}</td>
                                <td>${transferLog.payee}</td>
                                <td>${transferLog.cardidOfPayee}</td>
                                <td>${transferLog.transferTime}</td>
                                <td>${transferLog.remarks}</td>
                                <td><a href="/modify?method=deleteByCardId&date=${transferLog.transferTime}">删除记录</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>

                <a class="push_button red" href="/login?method=success">返回主菜单</a>
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