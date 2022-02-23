package proyecto_0103;

import java.util.ArrayList;

/**
 *
 * @author Alexis
 */
public class InsideTableNode {
    String name = "";
    int indexI = 0;
    ArrayList<String> nexts = new ArrayList<String>();

    public InsideTableNode(String name, int indexI, ArrayList<String> nexts) {
        this.name = name;
        this.indexI = indexI;
        this.nexts = nexts;
    }
}
