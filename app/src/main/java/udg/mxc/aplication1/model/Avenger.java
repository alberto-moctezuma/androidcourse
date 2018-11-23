package udg.mxc.aplication1.model;

public class Avenger {

    private String nombre;
    private String imagenUrl;
    private String frase;
    private boolean dead;
    private boolean gema;

    public Avenger( String nombre, String imagenUrl ) {
        this.nombre = nombre;
        this.imagenUrl = imagenUrl;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public boolean isGema() {
        return gema;
    }

    public void setGema(boolean gema) {
        this.gema = gema;
    }
}
