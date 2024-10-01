package model;

public class M_Usuario {
    private Long id;
    private String usuario;
    private String apelido;
    private String senha;

    public M_Usuario() {
        id = null;
        usuario = null;
        apelido = null;
        senha = null;
    }

    public M_Usuario(Long id, String usuario, String apelido, String senha) {
        this.id = id;
        this.usuario = usuario;
        this.apelido = apelido;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
