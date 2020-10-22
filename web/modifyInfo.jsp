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
                                        <label>姓名：</label>
                                        <input type="text" name="" placeholder="" value="${depositor.name}" required/>
                                    </li>
                                    <li>
                                        <label>电话：</label>
                                        <input type="text" name="tel" placeholder="" value="${depositor.tel}" required/>
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
                                    <input type="hidden" name="modify" value="modifyInfo">
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