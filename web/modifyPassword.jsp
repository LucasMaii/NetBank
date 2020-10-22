<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>修改个人信息</title>
    <link type="text/css" rel="stylesheet" href="css/transfer.css" />
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
                        <div class="contact" >
                            <form action="/modify" name="form1" method="post">
                                <ul>
                                    <li>
                                        <label>原密码：</label>
                                        <input type="text" name="oldPassword" placeholder="请输入原密码" required/>
                                    </li>
                                    <li>
                                        <label>新密码：</label>
                                        <input type="text" name="newPassword" placeholder="请设置新密码" required/>
                                    </li>
                                    <li>
                                        <label>确认新密码：</label>
                                        <input type="text" name="confirmPassword" placeholder="请确认新密码"  required/>
                                    </li>
                                </ul>
                                <b class="btn">
                                    <input type="hidden" name="modify" value="modifyPassword">
                                    <input type="submit" value="提交"/>
                                    <input type="reset" value="取消"/>
                                </b>



                            </form>
                        </div>
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