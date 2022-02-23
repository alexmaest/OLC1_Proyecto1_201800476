package proyecto_0103;

/**
 *
 * @author Alexis
 */
public class Sentencia {
    private String id;
    private String cadena;

    public Sentencia(String id, String cadena) {
        this.id = id;
        this.cadena = cadena;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
}
