package repository;

import factory.ConnectionFactory;
import model.M_Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class R_Usuario {
    public M_Usuario cadastrarUsuario(M_Usuario m_usuario){
        Connection conn = ConnectionFactory.getConnection();

        try {
            String sql = "insert into usuario (usuario,apelido,senha)" +
                    "values('"+m_usuario.getUsuario()+
                    "','"+m_usuario.getApelido()+
                    "','"+m_usuario.getSenha()+"')";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.execute();
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public static M_Usuario findUsuarioByUsuarioAndSenha(String usuario, String senha) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("" +
                "select * from usuario where usuario = '"+usuario+
                "' and senha = '"+senha+"'");
        ResultSet resultSet = pstmt.executeQuery();

        while(resultSet.next()){
            M_Usuario m_usuario = new M_Usuario();
            m_usuario.setId(resultSet.getLong("id"));
            m_usuario.setUsuario(resultSet.getString("usuario"));
            m_usuario.setApelido(resultSet.getString("apelido"));
            m_usuario.setSenha(resultSet.getString("senha"));
            return m_usuario;
        }
        return null;
    }
}
