import java.util.List;

import BL.UsuarioBL;
import BL.Entities.Usuario;
import utilitario.Extras;

public class App {
    static String User;
    static final String Tema = "Examen";
    public static void main(String[] args) throws Exception {
        Extras.clear();
        System.out.println("\n\n\n"+ Tema);
        if( !login() )  
            System.exit(0); 
            
        Persona p = new Persona();
        do{
            switch (menu())
            {
                case SALIR : 	        System.out.println(" Regresa pronto "+ User );
                                        System.exit(0); 
                case AGREGAR: 	        p.addAmigo();
                                        break;
                case AGREGAR_SI: 	    p.addAmigoDe();
                                        break;
                case MOSTRAR_NETWORK: 	p.showAmigos(p,0);
                                        break;
            }
            Extras.pressKey();
        } while (true);
    }

    /**
     * Metodo tipo enumerador que permite elegir las acciones a realizar
     * @return el numero de la opcion deseada
     */
    public static MENU menu(){
        int numero=-1; 
        Extras.clear();
        System.out.println("\n\n\n"+ Tema);
        System.out.println("\t  Usuario: "+ User +"\n\n\n");
        System.out.println(MENU.AGREGAR.ordinal()  	        + " AGREGAR AMIGO"               ); 	
        System.out.println(MENU.AGREGAR_SI.ordinal()  	    + " AGREGAR AMIGO DE AMIGO"      ); 	
        System.out.println(MENU.MOSTRAR_NETWORK.ordinal()   + " MOSTRAR NETWORK "	         ); 
        System.out.println(MENU.SALIR.ordinal()     		+ " SALIR "	                     );
        do
        {
            numero = Extras.getNumeroPositivo("<+> Ingresa Opc: ");
            if (numero>= 0 && numero <= 4 )
            {	
                Extras.clear();
                System.out.println("\n\n\n"+ Tema);
                System.out.println("\t  Usuario: "+ User +"\n\n\n");
                break;
            }
        } while (true);
        return MENU.values()[numero];
    }

    /**
     * Permite loguearse al momento de iniciar la app y si el logeo es exito permite seguir
     * pero si el logueo falla entonces la aplicacion se cierra
     * @return true si el login es exitoso
     *         false si el login fracasa luego de 3 intentos
     * @throws Exception
     */
    public static boolean login() throws Exception {
        int intentos = 3;
        UsuarioBL user = new UsuarioBL();
        //List<String> usuariosClaves = List.of("patmicpatmic","pat_micpat_mic","profe1234");
        do
        {
            System.out.println("\n\n \t\t ........................ ");
            String nombreUsuario = Extras.getCaracteres  ("\t\t +  usuario: ");
            String contrasena = Extras.getCaracteres  ("\t\t +  clave  : ");
            Usuario nuevoUsuario = user.getUsuarioLogin(nombreUsuario, contrasena);
            System.out.println("\t\t ........................ ");
            if( nuevoUsuario != null)
            {
                User = nombreUsuario.toUpperCase();
                System.out.println("\n :: Bienvenido "+ User);
                return true;
            }else{
                System.out.println("El usuario " + nombreUsuario + " no se encuentra en la base de datos.");
                System.out.println("\t\t * Intentos restantes: " + --intentos );
            }
        } while (intentos > 0);
        System.out.println("\n\n \t :(  Lo sentimos tu usuario y clave son incorrectos..! " );
        return false;
    }
}
