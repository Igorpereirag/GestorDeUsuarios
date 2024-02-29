package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login") 
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        System.out.println(email);
        System.out.println(senha);
        if (email != null && email.equals("admin@example.com") && senha.equals("admin")) {
            response.sendRedirect(request.getContextPath() + "/home");
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}
