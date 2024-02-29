package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import DTOS.UsuarioDTO;
import Entity.Usuario;
import Util.DatabaseUtil;

public class UsuarioDAO {

    private final Connection connection;

    public UsuarioDAO() throws SQLException {
        connection = DatabaseUtil.getConnection();
    }




    public UsuarioDTO buscarUsuarioPorId(int id) throws SQLException {
        UsuarioDTO usuario = null;
        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM usuarios WHERE id=?")) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    usuario = new UsuarioDTO(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("telefone"),
                        rs.getString("endereco")
                    );
                }
            }
        }
        return usuario;
    }
    

    public void adicionarUsuario(Usuario usuario) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO usuarios (nome, email, telefone, endereco) VALUES (?, ?, ?, ?)")) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getTelefone());
            stmt.setString(4, usuario.getEndereco());
            stmt.executeUpdate();
        }
    }

    public List<UsuarioDTO> listarUsuarios() throws SQLException {
        List<UsuarioDTO> usuarios = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM usuarios");
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                UsuarioDTO usuario = new UsuarioDTO(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("telefone"),
                    rs.getString("endereco")
                );
                usuarios.add(usuario);
            }
        }
        return usuarios;
    }
    
    

    public void atualizarUsuario(Usuario usuario) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement("UPDATE usuarios SET nome=?, email=?, telefone=?, endereco=? WHERE id=?")) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getTelefone());
            stmt.setString(4, usuario.getEndereco());
        
            stmt.executeUpdate();
        }
    }

    public void deletarUsuario(int id) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM usuarios WHERE id=?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
