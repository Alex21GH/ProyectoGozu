package ciber.dao;

import ciber.dto.Usuario;

public interface UsuarioDAO {
    
    public Usuario autentica(String usuario, String password);
    
}
