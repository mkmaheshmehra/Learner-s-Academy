package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Subjects extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learner_academy",
                    "root","root");
            Statement statement = connection.createStatement();
            String query = "select subjects.Subject_Name, class.Class from subjects inner join class" +
                    " on subjects.Class_ID = class.Class_ID;";
            ResultSet resultSet = statement.executeQuery(query);
            out.println("<html><body><table style='border: 1px solid black;'><tr>");
            out.println("<th style='border: 1px solid black;'>Subject Name</th>");
            out.println("<th style='border: 1px solid black;'>Class</th>");
            out.println("</tr>");
            while (resultSet.next()){
                out.println("<tr>");
                out.println("<td style='border: 1px solid black;'>"+resultSet.getString(1)+"</td>");
                out.println("<td style='border: 1px solid black;'>"+resultSet.getString(2)+"</td>");
                out.println("</tr>");
            }
            out.println("</table></body></html>");
            out.println("<a href='dashboard.jsp'>Back</a>");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
