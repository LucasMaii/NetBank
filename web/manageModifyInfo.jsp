<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>修改用户信息</title>
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
            银行管理员管理界面
        </div>
        <hr>
        <div class="main_left">
            <div class="right_expand">

                <strong>管理员：</strong><span>${admin}</span>
                <br/>

            </div>


                <div class="main_right">
                    <div class="rightgrid">
                        <div class="contact" >
                            <form action="/manage" name="form1" method="post">
                                <ul>

                                    <li>
                                        <label>姓名：</label>
                                        <input type="text" name="name" placeholder="" value="${depositor.name}" required/>
                                    </li>
                                    <li>
                                        <label>电话：</label>
                                        <input type="text" name="tel" placeholder="" value="${depositor.tel}" required/>
                                    </li>
                                    <li>
                                        <label>银行卡号码：</label>
                                        <input type="text" name="cardId" placeholder="" value="${depositor.cardid}" required/>
                                    </li>
                                    <li>
                                        <label>身份证号码：</label>
                                        <input type="text" name="pid" placeholder="" value="${depositor.pid}" required/>
                                    </li>
                                    <li>
                                        <label>性别：</label>
                                        <input type="text" name="gender" placeholder=""  value="${depositor.gender}"  required/>
                                    </li>
                                    <li>
                                        <label>地址：</label>
                                        <input type="text" name="address" placeholder=""  value="${depositor.address}"  required/>
                                    </li>
                                </ul>
                                <b class="btn">
                                    <input type="hidden" name="method" value="update">
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