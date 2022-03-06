package proyecto_0103.ThompsonTree;

import java.util.ArrayList;
import proyecto_0103.ExpressionTree.Transition;

/**
 *
 * @author Alexis
 */
public class TransNode2 {
    
    public int id = 0;
    public ArrayList<DataText> numbers = new ArrayList<DataText>();
    public ArrayList<Transition> transitions = new ArrayList<Transition>();

    public TransNode2(int id, ArrayList<DataText> numbers, ArrayList<Transition> transitions) {
        this.id = id;
        this.numbers = numbers;
        this.transitions = transitions;
    }
}

