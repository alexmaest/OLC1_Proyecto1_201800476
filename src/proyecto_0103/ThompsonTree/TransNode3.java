package proyecto_0103.ThompsonTree;

import java.util.ArrayList;

/**
 *
 * @author Alexis
 */
public class TransNode3 {

    public ArrayList<Integer> idNumbers = new ArrayList<Integer>();
    public ArrayList<Node> numbers = new ArrayList<Node>();
    private ArrayList<Transition2> transitions = new ArrayList<Transition2>();

    public TransNode3(ArrayList<Integer> idNumbers, ArrayList<Node> numbers, ArrayList<Transition2> transitions) {
        this.idNumbers = idNumbers;
        this.numbers = numbers;
        this.transitions = transitions;
    }

    public ArrayList<Transition2> getTransitions() {
        return transitions;
    }

    public void setTransitions(ArrayList<Transition2> transitions) {
        this.transitions = transitions;
    }
}
