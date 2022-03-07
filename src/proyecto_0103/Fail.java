package proyecto_0103;

/**
 *
 * @author Alexis
 */
public class Fail {
    public int line = 0;
    public int column = 0;
    public String type = "";
    public String message = "";
    public String value = "";

    public Fail(int line, int column, String type, String message, String value) {
        this.line = line;
        this.column = column;
        this.type = type;
        this.message = message;
        this.value = value;
    }
}
