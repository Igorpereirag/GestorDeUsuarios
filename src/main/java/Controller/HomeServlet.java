package Controller;

import DAO.UsuarioDAO;
import DTOS.UsuarioDTO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            List<UsuarioDTO> usuarios = usuarioDAO.listarUsuarios();
            System.out.println("Número de usuarios encontrados: " + usuarios.size()); 
            request.setAttribute("usuarios", usuarios);
            request.getRequestDispatcher("/home.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.getRequestDispatcher("/erro.jsp").forward(request, response);
        }
    }
}
