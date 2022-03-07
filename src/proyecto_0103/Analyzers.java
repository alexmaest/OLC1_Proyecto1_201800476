package proyecto_0103;

import proyecto_0103.ExpressionTree.Lexer2;
import proyecto_0103.ExpressionTree.Automata;
import proyecto_0103.ThompsonTree.Lexer3;
import proyecto_0103.ExpressionTree.Automata;
import proyecto_0103.ExpressionTree.InsideTableNode;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import proyecto_0103.Instrucciones;
import proyecto_0103.Lexer;
import proyecto_0103.Sentencia;
import proyecto_0103.Syntax;
import proyecto_0103.ThompsonTree.Automata2;

/**
 *
 * @author Alexis
 */
public class Analyzers {

    String error = "";
    public static ArrayList<InsideTableNode> arrayReg;
    public static ArrayList<Instrucciones> instrucciones;
    public static ArrayList<Sentencia> sentencias;
    public static ArrayList<Fail> errores;

    public Analyzers() {
    }

    public boolean Analize(String text) {
        this.error = "";
        Lexer l = null;
        Syntax s = null;
        try {
            errores = new ArrayList<Fail>();
            l = new Lexer(new BufferedReader(new StringReader(text)));
            s = new Syntax(l);
            s.parse();
            String lexicError = l.getLexicError();
            String syntaxError = s.getSyntaxError();

            if ("".equals(lexicError) && "".equals(syntaxError)) {
                System.out.println("Analisis finalizado sin errores");
                System.out.println("\n");
                //System.out.println("----------- SENTENCIAS -----------");
                /*for (int i = 0; i < sentencias.size(); i++) {
                    System.out.println(sentencias.get(i).getId() + ", " + sentencias.get(i).getCadena());
                }*/

                //System.out.println("----------- INSTRUCCIONES -----------");
                //System.out.println(instrucciones.size());
                arrayReg = new ArrayList<InsideTableNode>();
                for (int i = 0; i < instrucciones.size(); i++) {
                    ArrayList<String> sTemp = new ArrayList<String>();
                    switch (instrucciones.get(i).getTipo()) {
                        case REGEX:
                            //System.out.println("**********regex****************");
                            //System.out.println(instrucciones.get(i).getId());
                            for (int j = 0; j < instrucciones.get(i).getCadena().size(); j++) {
                                String singleRegex = "";
                                for (int k = 0; k < instrucciones.get(i).getCadena().get(j).getListaInst().size(); k++) {
                                    singleRegex += instrucciones.get(i).getCadena().get(j).getListaInst().get(k);
                                    //System.out.print(instrucciones.get(i).getCadena().get(j).getListaInst().get(k));
                                }
                                //System.out.println("");
                                sTemp.add(singleRegex);
                            }
                            arrayReg.add(new InsideTableNode(instrucciones.get(i).getId(), 0, sTemp));
                        case CONJUNTO:
                            //System.out.println("***********conjunto************");
                            //System.out.println(instrucciones.get(i).getId());
                            for (int j = 0; j < instrucciones.get(i).getCadena().size(); j++) {
                                String singleRegex = "";
                                for (int k = 0; k < instrucciones.get(i).getCadena().get(j).getListaInst().size(); k++) {
                                    singleRegex += instrucciones.get(i).getCadena().get(j).getListaInst().get(k);
                                    //System.out.print(instrucciones.get(i).getCadena().get(j).getListaInst().get(k) + "<--");
                                }
                                //System.out.println("");
                                sTemp.add(singleRegex);
                            }
                            
                    }
                }

                //Validate v = new Validate();
                //v.validations();
                return true;
            } else {
                System.out.println("Analisis finalizado con errores");
                System.out.println("\n");
                if (!"".equals(lexicError)) {
                    error += lexicError + "\n";
                }
                if (!"".equals(syntaxError)) {
                    error += syntaxError + "\n";
                }
                return false;
            }
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean getExpressionTree(String text) {
        Lexer2 l = null;
        Automata a = null;
        try {
            l = new Lexer2(new BufferedReader(new StringReader(text)));
            a = new Automata(l);
            a.parse();

            System.out.println("Analisis de automata finalizado");
            System.out.println("\n");
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }

    public boolean getThompsonTree(String text) {
        Lexer3 l = null;
        Automata2 a = null;
        try {
            l = new Lexer3(new BufferedReader(new StringReader(text)));
            a = new Automata2(l);
            a.parse();

            System.out.println("Analisis de automata finalizado");
            System.out.println("\n");
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    public static ArrayList<Instrucciones> getInstrucciones() {
        return instrucciones;
    }

    public static void setInstrucciones(ArrayList<Instrucciones> instrucciones) {
        Analyzers.instrucciones = instrucciones;
    }

    public static ArrayList<Sentencia> getSentencias() {
        return sentencias;
    }

    public static void setSentencias(ArrayList<Sentencia> sentencias) {
        Analyzers.sentencias = sentencias;
    }

    public String Error() {
        return this.error;
    }
}
