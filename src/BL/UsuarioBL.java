package BL;

import java.sql.ResultSet;

import BL.Entities.Usuario;
import DAC.UsuarioDAC;
import FWK.APP;
import FWK.AppException;

public class UsuarioBL {

    /**
     * Permite verificar si el usuario que desea ingresar al sistema se encuentra registrado
     * en la Base de Datos.
     * @param usuario Recibe el email del usuario
     * @param constrasena Recibe la contraseña del usuario
     * @return Encuentra al usuario en la BD y retorna el mismo si es valido
     * @throws Exception
     */
    public Usuario getUsuarioLogin(String usuario, String constrasena) throws Exception {
        try {
            UsuarioDAC userDAC = new UsuarioDAC();
            ResultSet rs = userDAC.getUsuario();
            while (rs.next()) {
                Usuario u = new Usuario(rs.getString(APP.GLOBAL.USUARIO)
                                        , rs.getString(APP.GLOBAL.CONTRASENA));

                if (u.getUsuario().equalsIgnoreCase(usuario) && u.getContrasena().equals(constrasena)){
                    return u;
                }
            }
        } catch (Exception e) {
            throw new AppException(e, getClass(),
                    "Error en getUserLogin(String usuario, String contrasena): " + e.getMessage());
        }
        return null;
    }
}
