import java.util.ArrayList;

import utilitario.Extras;

public class Persona extends Integrante implements IActividad {
    private ArrayList<Persona> amigos;

    public Persona() {
        super(0, "");
        amigos = new ArrayList<Persona>();
        newPersona(this);
    }

    public void newPersona(Persona p){
        System.out.println("<+> Por favor registra: " );
        p.ID  = Extras.getNumeroPositivo(" +  Codigo  (ID) : ");
        p.Nombre = Extras.getCaracteres  (" +  Nombre o nick: ");
        //Convierte primera letra a mayuscula
        p.Nombre = p.Nombre.substring(0,1).toUpperCase() + p.Nombre.substring(1,p.Nombre.length()).toLowerCase();
    }

     //Interface
     public void addAmigo(){
        amigos.add(new Persona());
    }

    public void addAmigoDe(){
        System.out.println("<+> Agrega un amigo a tu Amigo: " );
        int id = Extras.getNumeroPositivo  (" + Cual es el ID de tu amigo: ");
        for (Persona persona : amigos) {
            if (persona.ID == id)
                persona.addAmigo();
        }
    }

    public void showAmigos(Persona p, int n){
        for(int i=1; i<n; i++)
            System.out.print("\t");
        System.out.println(" ["+p.ID+"] "+ p.Nombre);
        
        for (Persona persona : p.amigos) {
            System.out.print("\t");
            if( persona.amigos.size()>=0)
                showAmigos(persona, n+1);
       }
    }
    
}
