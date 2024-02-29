package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UsuarioDAO;
import Entity.Usuario;

@WebServlet("/adicionar_usuario")
public class AdicionarUsuarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private UsuarioDAO usuarioDAO;

    

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String endereco = request.getParameter("endereco");

        try {
            usuarioDAO = new UsuarioDAO();
            usuarioDAO.adicionarUsuario(new Usuario.Builder(nome)   
                    .email(email)
                    .telefone(telefone)
                    .endereco(endereco)
                    .build());
            response.sendRedirect("/users_manipulation/home");
        
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp"); 
    }
    }
}
