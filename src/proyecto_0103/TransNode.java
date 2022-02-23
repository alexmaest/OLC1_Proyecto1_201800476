package proyecto_0103;

import java.util.ArrayList;

/**
 *
 * @author Alexis
 */
public class TransNode {
    
    public int id = 0;
    public ArrayList<ScanNode> numbers = new ArrayList<ScanNode>();
    public ArrayList<Transition> transitions = new ArrayList<Transition>();

    public TransNode(int id, ArrayList<ScanNode> numbers, ArrayList<Transition> transitions) {
        this.id = id;
        this.numbers = numbers;
        this.transitions = transitions;
    }
}
