import DAO.UsuarioDAO;
import Entity.Usuario;

import java.sql.SQLException;

public class TesteInserirUsuario {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = null;
        try {
            usuarioDAO = new UsuarioDAO();
            
            // Criando um novo usuário
            Usuario usuario1 = new Usuario.Builder("João")
                    .email("joa@example.com")
                    .telefone("123456789")
                    .endereco("Rua A, 123")
                    .build();

            // Inserindo o usuário no banco de dados
            usuarioDAO.adicionarUsuario(usuario1);
            System.out.println("Usuário inserido com sucesso.");
            
            // Criando outro usuário
            Usuario usuario2 = new Usuario.Builder("Maria")
                    .email("maria@example.com")
                    .telefone("987654321")
                    .endereco("Rua B, 456")
                    .build();

            // Inserindo o segundo usuário no banco de dados
            usuarioDAO.adicionarUsuario(usuario2);
            System.out.println("Segundo usuário inserido com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        } 
            }
        
    }

