package proyecto_0103.ThompsonTree;

import java.util.ArrayList;

/**
 *
 * @author Alexis
 */
public class Transition2 {
    public String name = "";
    private ArrayList<Integer> where = new ArrayList<Integer>();

    public Transition2(String name, ArrayList<Integer> where) {
        this.name = name;
        this.where = where;
    }

    public ArrayList<Integer> getWhere() {
        return where;
    }

    public void setWhere(ArrayList<Integer> where) {
        this.where = where;
    }
}
