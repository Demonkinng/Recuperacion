package DAC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DataHelper, permite la gestion y el acceso a los datos a una base de datos SQLite3
 */
public abstract class DataHelper {
    private static String DBPathConnection = null;
    private static Connection conn = null;

    public DataHelper(String  dbPathConnection){
        // Definir la cadena de conneccion : jdbc:sqlite:data\\TinderPet.db
        if (!dbPathConnection.isEmpty())
            DataHelper.DBPathConnection = dbPathConnection;
    }
    /**
     * getDBConnection, obtiene el cadena de coneccion a la base de datos
     * @return
     */
    protected String getDBConnection() {
        return DBPathConnection;
    }

    /**
     * <b>connSQLITE</b>, permite crear una sola instancia-Singeton para la coneccion a la base de datos
     * @return retorna coneccion a la base de datos definida en el contructor
     * @throws SQLException
     */
    protected static Connection getConnection() throws SQLException{
        if(conn == null)
            conn = DriverManager.getConnection(DBPathConnection);
        return conn;
    }

    /**
     * Permite realizar CRUD en la base de datos
     * @param sql Se envia el comando de la consulta sql
     * @return Retorna la ejecucion de la consulta sql
     * @throws SQLException
     */
    protected static ResultSet getResultSet(String sql) throws SQLException     
    {
        Connection conn = null;
        Statement  stmt = null;
        ResultSet  rs   = null;
        
        conn = getConnection();            
        stmt = conn.createStatement();     
        rs   = stmt.executeQuery(sql);     

        return rs;
    }
}
