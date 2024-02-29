import DAO.UsuarioDAO;
import DTOS.UsuarioDTO;

import java.sql.SQLException;
import java.util.List;

public class TesteListarUsuarios {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = null;
        try {
            usuarioDAO = new UsuarioDAO();
            List<UsuarioDTO> usuarios = usuarioDAO.listarUsuarios();
            
            if (usuarios.isEmpty()) {
                System.out.println("Não há usuários cadastrados.");
            } else {
                System.out.println("Lista de Usuários:");
                for (UsuarioDTO usuario : usuarios) {
                    System.out.println("ID: " + usuario.getId());
                    System.out.println("Nome: " + usuario.getNome());
                    System.out.println("Email: " + usuario.getEmail());
                    System.out.println("Telefone: " + usuario.getTelefone());
                    System.out.println("Endereço: " + usuario.getEndereco());
                    System.out.println("----------------------");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
            }
        
    }

