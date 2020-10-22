package servlet;

import repository.Impl.TransferRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/transfer")
public class TransferServlet extends HttpServlet {

    TransferRepositoryImpl transferDepository = new TransferRepositoryImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取转账表单信息
        String mycardId = request.getParameter("mycardId");
        Double amountTransferred = Double.valueOf(request.getParameter("amountTransferred"));
        String payee = request.getParameter("payee");
        String cardidOfPayee = request.getParameter("cardidOfPayee");
        String remarks = request.getParameter("remarks");

        boolean flag = transferDepository.transfer(mycardId,amountTransferred,payee,cardidOfPayee,remarks);
        if(flag) {
            request.getRequestDispatcher("transfersuccess.jsp").forward(request, response);
//            System.out.println("转账成功！！！！");
        }else{
            response.sendRedirect("transfer.jsp?error=yes");
//            request.getRequestDispatcher("fail.jsp").forward(request, response);
        }


    }

}
