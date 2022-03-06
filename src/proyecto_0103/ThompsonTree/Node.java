package proyecto_0103.ThompsonTree;

/**
 *
 * @author Alexis
 */
public class Node implements Comparable{

    int state = 0;
    String data = "";
    int id = 0;
    private boolean added = false;

    public Node(int state, String data, int id, boolean added) {
        this.state = state;
        this.data = data;
        this.id = id;
        this.added = added;
    }

    public boolean isAdded() {
        return added;
    }

    public void setAdded(boolean added) {
        this.added = added;
    }
    
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    
    
    @Override
    public int compareTo(Object t) {
        int comparestate = ((Node) t).getState();
        /* For Ascending order*/
        return this.state - comparestate;
    }
}
