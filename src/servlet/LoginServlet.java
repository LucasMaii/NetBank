package servlet;

import entity.Depositor;
import repository.Impl.LoginRepositoryImpl;
import repository.Impl.ManageRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private LoginRepositoryImpl loginRepository = new LoginRepositoryImpl();
    private ManageRepositoryImpl manageDepository = new ManageRepositoryImpl();
    private Depositor depositor = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user = request.getParameter("user");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println(username+password);

        if(user.equals("depositor")) {
            boolean isLogin = loginRepository.isLogin(username, password);
            System.out.println(isLogin);
            if (isLogin) {

                depositor = loginRepository.findAllOfDepositor(username);
                HttpSession session = request.getSession();
                session.setAttribute("depositor", depositor);
                request.getRequestDispatcher("service.jsp").forward(request, response);
            } else {
                response.sendRedirect("index.jsp?error=yes");
//            System.out.println("Login failed!");
//            request.getRequestDispatcher("fail.jsp").forward(request,response);
            }
        }

        if(user.equals("admin")){

            boolean isLoginOfAdmin = loginRepository.isLoginOfAdmin(username,password);
            System.out.println(isLoginOfAdmin);
            if (isLoginOfAdmin) {
                HttpSession session = request.getSession();
                session.setAttribute("admin",username);
                List<Depositor> list = manageDepository.findAll();
                session.setAttribute("list", list);
                request.getRequestDispatcher("manage.jsp").forward(request, response);
            } else {
                response.sendRedirect("index.jsp?error=yes");

            }

        }


        //没有数据库的情况下进行登陆测试
//        if(username.equals("admin") && password.equals("123456")){
//            request.getRequestDispatcher("test.jsp").forward(request,response);
//        }else{
//            System.out.println("Login failed!");
//            request.getRequestDispatcher("").forward(request,response);
//        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String method = request.getParameter("method");

        if(method.equals("success")){

            request.getRequestDispatcher("service.jsp").forward(request,response);

        }else if(method.equals("adminsuccess")){

            request.getRequestDispatcher("manage.jsp").forward(request, response);
        }

    }
}
