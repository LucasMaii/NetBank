<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>账户维护</title>
    <link type="text/css" rel="stylesheet" href="css/business.css" />
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            var height=$(document).height();
            $('.main').css('height',height);
        })
    </script>

    <script>

        //取出传回来的参数error并与yes比较
        var errori ='<%=request.getParameter("error")%>';
        if(errori=='yes'){
            alert("转账失败,账户余额不足!");
        }
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
                            <li><a href="/payment?method=gas">天然气费</a></li>
                            <li><a href="/payment?method=waterAndElectricity">水电费</a></li>
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