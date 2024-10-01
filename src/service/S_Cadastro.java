package service;

import model.M_Usuario;
import repository.R_Usuario;

public class S_Cadastro {
    public static M_Usuario cadastrarUsuario(String usuario, String apelido, String senha, String conf_senha){
        boolean podeSalvar = true;

        if(usuario.trim().equalsIgnoreCase("")){
            podeSalvar = false;
        }else if(apelido.trim().equalsIgnoreCase("")){
            podeSalvar = false;
        }else if(senha.trim().equalsIgnoreCase("") || !senha.equals(conf_senha)){
            podeSalvar = false;
        }

        if(podeSalvar){
            M_Usuario m_usuario = new M_Usuario(null,usuario,apelido,senha);
            R_Usuario r_usuario = new R_Usuario();
            r_usuario.cadastrarUsuario(m_usuario);
            return m_usuario;
        }
        return null;
    }
}
