<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>转账</title>
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
                            <form action="/payment" name="form1" method="post">
                                <ul>
                                    <input type="hidden" name="cardId" value="${depositor.cardid}">
                                    <li>
                                        <label>缴费单位：</label>
                                        <select name="company">
                                            <option value ="广州燃气集团有限公司">广州燃气集团有限公司</option>
                                            <option value ="广州港华燃气有限公司">广州港华燃气有限公司</option>
                                            <option value="广州才华有限公司">广州才华有限公司</option>
                                            <option value="广州天然气公司">广州天然气公司</option>
                                        </select>
                                    </li>
                                    <li>
                                        <label>户号：</label>
                                        <input type="text" name="num" placeholder="请输入户号" required/>
                                    </li>
                                    <li>
                                        <label>缴费金额：</label>
                                        <input type="text" name="money" placeholder="请输入缴费金额" required/>
                                    </li>
                                </ul>
                                <b class="btn"><input type="submit" value="提交"/>
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