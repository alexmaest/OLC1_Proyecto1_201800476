package proyecto_0103;

import proyecto_0103.ExpressionTree.Conjunto;
import proyecto_0103.ExpressionTree.Expresion;
import java.util.ArrayList;

/**
 *
 * @author Alexis
 */
public class Instrucciones {

    public String id;
    public ArrayList<Expresion> cadena;
    public Instruccion tipo;
    public ArrayList<Conjunto> conj;
    public ArrayList<Expresion> exp;
    public ArrayList<Sentencia> sen;

    public Instrucciones(String id, ArrayList<Expresion> cadena, Instruccion tipo) {
        this.id = id;
        this.cadena = cadena;
        this.tipo = tipo;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Expresion> getCadena() {
        return cadena;
    }

    public void setCadena(ArrayList<Expresion> cadena) {
        this.cadena = cadena;
    }

    public Instruccion getTipo() {
        return tipo;
    }

    public void setTipo(Instruccion tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Conjunto> getConj() {
        return conj;
    }

    public void setConj(ArrayList<Conjunto> conj) {
        this.conj = conj;
    }

    public ArrayList<Expresion> getExp() {
        return exp;
    }

    public void setExp(ArrayList<Expresion> exp) {
        this.exp = exp;
    }

    public ArrayList<Sentencia> getSen() {
        return sen;
    }

    public void setSen(ArrayList<Sentencia> sen) {
        this.sen = sen;
    }
}
