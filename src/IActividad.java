public interface IActividad {
    /**
     * Permite añadir amigos
     */
    public void addAmigo();

    /**
     * Permite añadir como amigo al amigo de un amigo
     */
    public void addAmigoDe();

    /**
     * Permite presentar los amigos
     * @param p: la persona a presentar
     * @param n: el nivel de la persona
     */
    public void showAmigos(Persona p, int n);
}
