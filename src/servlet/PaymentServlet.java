package servlet;

import repository.Impl.TransferRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * 处理生活缴费页面请求
 *
 */

@WebServlet("/payment")
public class PaymentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TransferRepositoryImpl transferDepository = new TransferRepositoryImpl();

        //获取转账表单信息
        String cardId = request.getParameter("cardId");
        String company = request.getParameter("company");
        String num = request.getParameter("num");
        Double money = Double.valueOf(request.getParameter("money"));
        String remarks = request.getParameter("remarks");

        boolean flag = transferDepository.transfer(cardId, money ,company," ",num);
        if(flag) {
            request.getRequestDispatcher("transfersuccess.jsp").forward(request, response);
        }else{
            response.sendRedirect("payment.jsp?error=yes");
//            request.getRequestDispatcher("fail.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String method = request.getParameter("method");

        switch (method){

            case "gas":
                request.getRequestDispatcher("gasPayment.jsp").forward(request, response);
                break;
            case "waterAndElectricity":
                break;

        }

    }
}
