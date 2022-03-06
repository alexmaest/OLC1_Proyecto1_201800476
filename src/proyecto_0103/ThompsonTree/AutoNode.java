package proyecto_0103.ThompsonTree;

/**
 *
 * @author Alexis
 */
public class AutoNode {
    boolean pass = false;
    String name = "";
    int first = 0;
    int last = 0;
    int max = 0;
    
    public AutoNode(boolean pass, String name, int first, int last, int max) {
        this.name = name;
        this.pass = pass;
        this.first = first;
        this.last = last;
        this.max = max;
    }
}
