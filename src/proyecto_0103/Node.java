package proyecto_0103;

/**
 *
 * @author Alexis
 */
public class Node {

    public String content = "";
    public String first = "";
    public String last = "";
    public String name = "";
    public boolean anulable = false;
    public int index = 0;

    public Node(String last, String content, String first, String name, boolean anulable, int index) {
        this.last = last;
        this.content = content;
        this.first = first;
        this.name = name;
        this.anulable = anulable;
        this.index = index;
    }
}
