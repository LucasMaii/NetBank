package servlet;

import entity.Depositor;
import entity.Transfer;
import repository.Impl.TransferRepositoryImpl;
import repository.TransferRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/business")
public class BusinessServlet extends HttpServlet {

    private TransferRepository transferDepository = new TransferRepositoryImpl();
    private Depositor depositor = null;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String method = request.getParameter("method");
        depositor = (Depositor) session.getAttribute("depositor");

        switch(method){

            case "transfer":
                request.getRequestDispatcher("transfer.jsp").forward(request,response);
                break;
            case "transferLog":

                List<Transfer> list = transferDepository.findAllOfTransfer(depositor);
                System.out.println(list);
                request.setAttribute("list",list);
                request.getRequestDispatcher("transferLog.jsp").forward(request,response);
                break;
            case "payment":
                request.getRequestDispatcher("payment.jsp").forward(request,response);
                break;
        }

    }
}
