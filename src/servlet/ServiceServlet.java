package servlet;

import entity.Account;
import entity.Depositor;
import repository.Impl.LoginRepositoryImpl;
import repository.Impl.ServiceRepositoryImpl;
import repository.ServiceRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/service")
public class ServiceServlet extends HttpServlet {

    private LoginRepositoryImpl loginRepository = new LoginRepositoryImpl();
    private ServiceRepository serviceRepository = new ServiceRepositoryImpl();
    private Depositor depositor = null;
    private Account account = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session=request.getSession();
        String method = request.getParameter("method");
        depositor = (Depositor) session.getAttribute("depositor");

        switch (method) {
            case "findAllOfInfo":

//                depositor = loginRepository.findAllOfDepositor(username);
//                System.out.println("获取到username+"+username);
//                request.setAttribute("depositor", depositor);
                request.getRequestDispatcher("userInfo.jsp").forward(request, response);
                break;

            case "business":

                request.getRequestDispatcher("business.jsp").forward(request, response);
                break;

            case "findAccount":

                account = serviceRepository.findAllOfAccount(depositor);
                request.setAttribute("account",account);
                System.out.println(account);
                request.getRequestDispatcher("account.jsp").forward(request, response);
                break;

            case "modify":

                request.getRequestDispatcher("modify.jsp").forward(request, response);
                break;

            case "aboutUs":

                request.getRequestDispatcher("aboutUs.jsp").forward(request, response);
                break;
        }

    }
}
