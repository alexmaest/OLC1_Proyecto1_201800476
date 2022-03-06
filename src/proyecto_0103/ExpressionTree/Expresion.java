package proyecto_0103.ExpressionTree;

import java.util.ArrayList;

/**
 *
 * @author Alexis
 */
public class Expresion {
    private ArrayList<String> listaInst;

    public Expresion(ArrayList<String> listaInst) {
        this.listaInst = listaInst;
    }
    
    public ArrayList<String> getListaInst() {
        return listaInst;
    }

    public void setListaInst(ArrayList<String>  listaInst) {
        this.listaInst = listaInst;
    }
}
