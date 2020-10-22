package servlet;

import entity.Account;
import entity.Depositor;
import repository.Impl.LoginRepositoryImpl;
import repository.Impl.ManageRepositoryImpl;
import repository.Impl.ServiceRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/manage")
public class ManageServlet extends HttpServlet {

    private ManageRepositoryImpl manageDepository = new ManageRepositoryImpl();
    private ServiceRepositoryImpl serviceRepository = new ServiceRepositoryImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String method = request.getParameter("method");
        switch (method) {
            case "add":
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String name = request.getParameter("name");
                String tel = request.getParameter("tel");
                String cardid = request.getParameter("cardId");
                String pid = request.getParameter("pid");
                String gender = request.getParameter("gender");
//                System.out.println(username + password + name + tel + cardid + pid + gender);
                manageDepository.add(username, password, name, tel, cardid, pid, gender);
                response.sendRedirect("/manage");
                break;
            case "update":
                name = request.getParameter("name");
                tel = request.getParameter("tel");
                cardid = request.getParameter("cardId");
                pid = request.getParameter("pid");
                gender = request.getParameter("gender");
                String address = request.getParameter("address");
                manageDepository.update(cardid, name, tel, pid, gender,address);
                List<Depositor> list = manageDepository.findAll();
                request.setAttribute("list", list);
                request.getRequestDispatcher("manage.jsp").forward(request, response);
                break;
            case "search":
                Depositor depositor = null;
                Account account = null;
                String info = request.getParameter("info");
                System.out.println(info);
                depositor = manageDepository.findById(info);
                request.setAttribute("depositor",depositor);
                account = serviceRepository.findAllOfAccount(info);
                request.setAttribute("account",account);
                request.getRequestDispatcher("seeUser.jsp").forward(request, response);
                break;
            default:break;
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String method = request.getParameter("method");
        String cardId = request.getParameter("cardId");

        switch (method) {
            case "deleteById":
                System.out.println("删除"+cardId);
                manageDepository.deleteById(cardId);
                List<Depositor> list = manageDepository.findAll();
                request.setAttribute("list", list);
                request.getRequestDispatcher("manage.jsp").forward(request, response);
                break;
            case "findById":
                request.setAttribute("depositor", manageDepository.findById(cardId));
                request.getRequestDispatcher("manageModifyInfo.jsp").forward(request, response);
                break;
            case "seeAccount":
                Account account = null;
                Depositor depositor = null;
                depositor = manageDepository.findById(cardId);
                request.setAttribute("depositor",depositor);
                account = serviceRepository.findAllOfAccount(cardId);
                request.setAttribute("account",account);
                System.out.println(account);
                request.getRequestDispatcher("seeAccount.jsp").forward(request, response);
                break;
            case "search":
                String info = request.getParameter("info");
                System.out.println(info);
                depositor = manageDepository.findById(info);
                request.setAttribute("depositor",depositor);
                System.out.println(depositor);
                account = serviceRepository.findAllOfAccount(info);
                request.setAttribute("account",account);
                request.getRequestDispatcher("seeUser.jsp").forward(request, response);
                break;
            default:
                break;

        }

    }
}
