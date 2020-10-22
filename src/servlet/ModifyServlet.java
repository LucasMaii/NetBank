package servlet;

import entity.Depositor;
import repository.Impl.LoginRepositoryImpl;
import repository.Impl.ModifyRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet("/modify")
public class ModifyServlet extends HttpServlet {

    private ModifyRepositoryImpl modifyRepository = new ModifyRepositoryImpl();
    private LoginRepositoryImpl loginRepository = new LoginRepositoryImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String modify = request.getParameter("modify");
        Depositor depositor;

        switch (modify) {
            case "modifyInfo":
                String tel = request.getParameter("tel");
                String gender = request.getParameter("gender");
                String address = request.getParameter("address");

                modifyRepository.modifyInfo(tel, gender, address);
                depositor = loginRepository.findAllOfDepositor(tel);
                HttpSession session = request.getSession();
                session.setAttribute("depositor", depositor);
                request.getRequestDispatcher("userInfo.jsp").forward(request, response);
                break;
            case "modifyPassword":

                session = request.getSession();
                String method = request.getParameter("method");
                depositor = (Depositor) session.getAttribute("depositor");
                String oldPassword = request.getParameter("oldPassword");
                String newPassword = request.getParameter("newPassword");
                String confirmPassword = request.getParameter("confirmPassword");
                modifyRepository.modifyPassword(depositor,oldPassword,newPassword,confirmPassword);
                request.getRequestDispatcher("modifySuccess.jsp").forward(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String method = request.getParameter("method");

        switch(method){

            case "modifyInfo":

                request.getRequestDispatcher("modifyInfo.jsp").forward(request,response);
                break;

            case "modifyPassword":

                request.getRequestDispatcher("modifyPassword.jsp").forward(request,response);
                break;

            case "resetPassword":

                System.out.println("没空写代码，放弃！！！！ +_+");
                break;

            case "deleteByCardId":

                Timestamp date = Timestamp.valueOf(request.getParameter("date"));
                System.out.println(date);
                modifyRepository.deleteByCardId(date);
                response.sendRedirect("/business?method=transferLog");
                break;
        }

    }
}
