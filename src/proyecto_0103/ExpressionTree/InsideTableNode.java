package proyecto_0103.ExpressionTree;

import java.util.ArrayList;

/**
 *
 * @author Alexis
 */
public class InsideTableNode {
    public String name = "";
    public int indexI = 0;
    public ArrayList<String> nexts = new ArrayList<String>();

    public InsideTableNode(String name, int indexI, ArrayList<String> nexts) {
        this.name = name;
        this.indexI = indexI;
        this.nexts = nexts;
    }
}
