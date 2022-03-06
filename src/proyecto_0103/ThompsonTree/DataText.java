package proyecto_0103.ThompsonTree;

/**
 *
 * @author Alexis
 */
public class DataText implements Comparable {

    String data = "";
    int first = 0;
    int last = 0;
    int index = 0;

    public DataText(int first, int last, String data, int index) {
        this.data = data;
        this.first = first;
        this.last = last;
        this.index = index;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    @Override
    public int compareTo(Object t) {
        int compareage = ((DataText) t).getFirst();
        /* For Ascending order*/
        return this.first - compareage;
    }
}
