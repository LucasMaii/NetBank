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
                        <div class="contact" >
                            <form action="/transfer" name="form1" method="post">
                                <ul>
                                    <li>
                                        <label>付款账户：</label>
                                        <input type="text" name="mycardId" placeholder="" value="${depositor.cardid}" readonly/>
                                    </li>
                                    <li>
                                        <label>转账金额：</label>
                                        <input type="text" name="amountTransferred" placeholder="请输入" required/>
                                    </li>
                                    <li>
                                        <label>收款人名称：</label>
                                        <input type="text" name="payee" placeholder="请输入收款人名称" required/>
                                    </li>
                                    <li>
                                        <label>收款人账户：</label>
                                        <input type="text" name="cardidOfPayee" placeholder="请输入收款人账户" required/>
                                    </li>
                                    <li>
                                        <label>附言：</label>
                                        <input type="text" name="remarks" placeholder="选填最多10个汉字" required/>
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