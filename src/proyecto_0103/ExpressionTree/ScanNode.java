package proyecto_0103.ExpressionTree;

import java.util.ArrayList;

/**
 *
 * @author Alexis
 */
public class ScanNode {

    public String name = "";
    public int number = 0;
    public ArrayList<Integer> follows = new ArrayList<Integer>();
    public boolean scanned = false;

    public ScanNode(String name, int number, ArrayList<Integer> follows, boolean scanned) {
        this.name = name;
        this.number = number;
        this.follows = follows;
        this.scanned = scanned;
    }
}
