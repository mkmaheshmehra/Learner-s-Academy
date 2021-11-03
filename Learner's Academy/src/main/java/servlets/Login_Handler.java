package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Login_Handler extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        RequestDispatcher requestDispatcher = null;
        PrintWriter out = response.getWriter();

        if("admin".equals(username) && "admin123".equals(password)){
            requestDispatcher = request.getRequestDispatcher("dashboard.jsp");
            requestDispatcher.forward(request, response);
        } else {
            requestDispatcher = request.getRequestDispatcher("index.jsp");
            out.println("<span style='color: red'>Invalid Credentials</span>");
            requestDispatcher.include(request, response);
        }
    }
}
