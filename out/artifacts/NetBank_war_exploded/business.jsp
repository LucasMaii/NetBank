<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>业务办理</title>
    <link type="text/css" rel="stylesheet" href="css/business.css" />
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

            </div>


            <div class="main_right">
                <div class="rightgrid">

                    <div class="right_apps">
                        <ul>
                            <li><a href="/business?method=transfer">转账</a></li>
                            <li><a href="/business?method=transferLog">交易明细</a></li>
                            <li><a href="/business?method=payment">生活缴费</a></li>
                            <li><a href="">紧急挂失</a></li>
                        </ul>
                    </div>
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