package FWK;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * AppConfiguration
 * Definicion de variables globales, constantes y configuraciones
 * para toda la aplicacion
 */
public enum APP {
    GLOBAL;

    // Variables globales obligatorias en el examen

    public final  String  KEY_DB_FULLPATH   = "DB_FULLPATH";
    public final  int     METHOD_OK         = 200;
    public final  int     METHOD_ERROR      = 400;

    // Constantes para invocar a las tablas de la base de datos
    public final String TABLA_USUARIO = "USUARIO";

    // Constantes de la tabla USUARIO de la base de datos
    public final String PK_ID_USUARIO = "PK_ID_USUARIO";
    public final String USUARIO = "USUARIO";
    public final String CONTRASENA = "CONTRASENA";

    //Constantes por definir en el contructor
    private final String  CONFIG_PATH;
    private final String  EXCEPTION_UNDEFINED;
    private final String  EXCEPTION_UNDEFINED_CLASS;
    private final Boolean LOG_ON_OFF;
    private Properties config=null;
    APP() {
        //Definir constantes
        LOG_ON_OFF                  = true;
        CONFIG_PATH                 = "src/appConfig.properties";
        EXCEPTION_UNDEFINED         = "Error no identificado";
        EXCEPTION_UNDEFINED_CLASS   = "Error en clase no especificada ";

        //Load : appConfig.properties
        try{
            config = new Properties();
            InputStream configInput = new FileInputStream(CONFIG_PATH);
            config.load(configInput);
        }  
        catch (Exception e) {  // IOException - FileNotFoundException
            System.out.println("<<ERROR>> : appConfig.properties, No ha encontrado \nAPP.APP()");
        }
    }

    /**
     * getProperty  : retorna el valor de Key configurado en el archivo appConfig.properties
     * @throws AppException : xcepcion personalizada
     * @Key    : Palabra clave definida en el achivo appConfig.properties caso contrario null
     * */ 
    public static String getProperty(String Key) { 
        String value = APP.GLOBAL.config.getProperty(Key);  
        if (value == null)
            System.out.println("<<ISSUE>> : "+Key+"  no definida en appConfig.properties \nAPP.getProperty()");
        return value;
    }

    // metodos de acceso a las constastes
    public static String  getConfigPath()   {   return  APP.GLOBAL.CONFIG_PATH; }
    public static Boolean getLogOnOff()     {   return  APP.GLOBAL.LOG_ON_OFF; }
    // metodos de acceso restringido
    protected String  getExceptionUndefined()      {   return  EXCEPTION_UNDEFINED; }
    protected String  getExceptionUndefinedClass() {   return  EXCEPTION_UNDEFINED_CLASS; }
}