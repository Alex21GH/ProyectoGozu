package cdata.dao;

import cdata.dto.Usuario;

public interface UsuarioDAO {
    
    public Usuario autentica(String usuario, String password);
    
}
