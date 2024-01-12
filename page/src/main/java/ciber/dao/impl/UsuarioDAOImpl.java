package ciber.dao.impl;

import ciber.dao.SqlConecta;
import ciber.dto.Usuario;
import ciber.dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAOImpl implements UsuarioDAO {
    
    @Override
    public Usuario autentica(String usuario, String password) {
        
        StringBuilder query = new StringBuilder("SELECT idusuario, usuario, password ");
        query.append("FROM USUARIOS ");
        query.append("WHERE (usuario = ?) ");
        query.append("AND (AES_DECRYPT(password, 'cdata') = ?)");
        Usuario u = null;

        try(Connection cn = new SqlConecta().connection();
            PreparedStatement ps = cn.prepareStatement(query.toString())) {
            
            ps.setString(1, usuario);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                u = new Usuario();
                u.setIdusuario(rs.getInt(1));
                u.setUsuario(rs.getString(2));
            }
            cn.close();

        } catch (Exception ex) { ex.printStackTrace(); }

        return u;
    }
   
}
