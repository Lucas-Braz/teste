package service;

import model.M_Usuario;
import repository.R_Usuario;

public class S_Login {
    public static boolean validaLogin(String usuario, String senha){
        M_Usuario m_usuario;
        try{
            m_usuario = R_Usuario.findUsuarioByUsuarioAndSenha(usuario,senha);
            if(m_usuario != null){
                return true;
            }
        }catch (Exception e){
        }
        return false;
    }
}
