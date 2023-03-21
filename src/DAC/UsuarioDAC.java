package DAC;

import java.sql.ResultSet;
import java.sql.SQLException;

import FWK.APP;
import FWK.AppException;

public class UsuarioDAC extends DataHelper{

    /**
     * Constructor 
     * @throws AppException
     */
    public UsuarioDAC() throws AppException{
        super(APP.getProperty(APP.GLOBAL.KEY_DB_FULLPATH));
    }

    /**
     * Permite obtener el resultado de la consulta sql
     * @return Retorna el resultado de la consulta sql
     * @throws AppException
     */
    public ResultSet getUsuario() throws AppException{
        try {
            String sql = "SELECT " + APP.GLOBAL.USUARIO + ", "
                                   + APP.GLOBAL.CONTRASENA
                                   + " FROM " + APP.GLOBAL.TABLA_USUARIO;
            return getResultSet(sql);
        } 
        catch (SQLException e) {
            throw new AppException(e, getClass(), "getAllUsuario()" + e.getMessage());
        }
    }
}
