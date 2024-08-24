
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Usuario;


public class UsuarioDao {
    private Connection c;

    public UsuarioDao(Connection c) {
        this.c = c;
    }
      public String CadastrarUsuario(Usuario usuario){
        String resposta = "";
        
        
            try{

              String sql = "INSERT INTO usuario(usua_nome, usua_email, usua_senha)\n" +
                            "VALUES (?,?,?)";
              PreparedStatement stm = this.c.prepareStatement(sql);
              stm.setString(1, usuario.getNome());
              stm.setString(2, usuario.getEmail());
              stm.setString(3, usuario.getSenha());
               stm.executeUpdate();
               stm.close();
               resposta = "Ok";
            }catch(Exception e){
                resposta = "Erro ao cadastrar o usuario: " + e.getMessage();
            }
                return resposta;      
        
    }
     // Método para verificar as credenciais do funcionário ao fazer login
    public boolean VerificarCredenciais(String login, String senha) {
    boolean autenticado = false;
    String sql = "SELECT COUNT(*) FROM usuario WHERE (usua_nome = ? OR usua_email = ?) AND usua_senha = ?";
    PreparedStatement stm = null;
    ResultSet rs = null;
    try {
        stm = c.prepareStatement(sql);
        stm.setString(1, login);
        stm.setString(2, login);
        stm.setString(3, senha);
        
        rs = stm.executeQuery();
        if (rs.next()) {
            int count = rs.getInt(1);
            autenticado = count > 0;
        }
    } catch(SQLException e) {
        e.printStackTrace(); // Imprime o erro no console, caso ocorra uma excecao...
    } finally {
        try {
            if (rs != null) {
                rs.close(); // Fecha o ResultSet para liberar memoria...
            }
            if (stm != null) {
                stm.close(); // Fecha o PreparedStatement para liberar memoria...
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Imprime o erro no console, caso ocorra uma exceçao ao fechar o PreparedStatement...
        }
    }
    
    // Se as credenciais não forem válidas, exibe uma mensagem de erro....
    if (!autenticado) {
        JOptionPane.showMessageDialog(null, "Nome de usuário, email ou senha incorretos.", "Erro de Autenticação", JOptionPane.ERROR_MESSAGE);
    }
    
    return autenticado; // Retorna se as credenciais foram autenticadas com sucesso ou nao.....
   }
    public Usuario buscarUsuario(String login) {
    Usuario usuario = null;
    String sql = "SELECT * FROM usuario WHERE usua_nome = ? OR usua_email = ?";
    PreparedStatement stm = null;
    ResultSet rs = null;

    try {
        stm = c.prepareStatement(sql);
        stm.setString(1, login);
        stm.setString(2, login);
        rs = stm.executeQuery();

        if (rs.next()) {
            usuario = new Usuario(
                rs.getInt("usua_id"),
                rs.getString("usua_nome"),
                rs.getString("usua_email"),
                rs.getString("usua_senha")
            );
            
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (stm != null) stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return usuario;

    }
}
