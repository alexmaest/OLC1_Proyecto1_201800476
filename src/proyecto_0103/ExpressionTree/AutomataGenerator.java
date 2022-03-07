package proyecto_0103.ExpressionTree;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import proyecto_0103.Analyzers;
import proyecto_0103.Fail;
import proyecto_0103.Instrucciones;
import proyecto_0103.jsonData;

/**
 *
 * @author Alexis
 */
public class AutomataGenerator {

    public static ArrayList<jsonData> jsonElements = new ArrayList<jsonData>();
    ArrayList<InsideTableNode> siguientes;
    ArrayList<TransNode> GeneralStates;
    static int upgrade = 0;

    public void generateTree(String id) {
        String gText = "digraph G {";
        ArrayList<GraphNode> variables = Automata.GraphVariables;
        ArrayList<String> conexiones = Automata.GraphText;

        // Or, Mas, Asterisco, Interrogacion, Punto
        for (int i = 0; i < variables.size(); i++) {
            String variable = variables.get(i).text;
            //String[] tempVar = variable.split("");
            //if ("O".equals(tempVar[0])) {
            gText += variable;
            //} else if ("M".equals(tempVar[0])) {
            //gText += variable;
            //} else if ("A".equals(tempVar[0])) {
            //gText += variable;
            //} else if ("I".equals(tempVar[0])) {
            //gText += variable;
            //} else if ("P".equals(tempVar[0])) {
            //gText += variable;
            //} else {
            //}
        }
        //Llenar array
        //int[] sort = new int[variables.size()];
        //for (int i = 0; i < variables.size(); i++) {
        //    sort[i] = variables.get(i).indexS;
        //}
        //Ordenamiento
        //int temp = 0;
        //for (int i = 0; i < sort.length; i++) {
        //    for (int j = i + 1; j < sort.length; j++) {
        //        if (sort[i] < sort[j]) {
        //         temp = sort[i];
        //           sort[i] = sort[j];
        //      sort[j] = temp;
        //   }
        //}
        //}
        //Agregar a string final
        /*for (int k = 0; k < sort.length; k++) {
            for (int i = 0; i < variables.size(); i++) {
                String variable = variables.get(i).text;
                String[] tempVar = variable.split("");
                if (!"O".equals(tempVar[0]) && !"M".equals(tempVar[0]) && !"A".equals(tempVar[0]) && !"I".equals(tempVar[0]) && !"P".equals(tempVar[0]) && sort[k] == variables.get(i).indexS) {
                    gText += variable;
                } else {
                }
            }
        }*/
        //Agregar conexiones
        for (int i = 0; i < conexiones.size(); i++) {
            gText += conexiones.get(i);
        }
        gText += "label = \"" + id + "\";";
        gText += "types [\n"
                + "   shape=plaintext\n"
                + "   label=<\n"
                + "     <table border=\"0\" cellborder=\"1\" cellspacing=\"0\">\n"
                + "       <tr><td bgcolor=\"lightblue\"><font color=\"black\">No Anulables</font></td></tr>\n"
                + "       <tr><td bgcolor=\"#ff8282\"><font color=\"white\">Anulables</font></td></tr>\n"
                + "       <tr><td bgcolor=\"white\"><font>Últimos</font></td></tr>\n"
                + "       <tr><td bgcolor=\"black\"><font color=\"white\">Primeros</font></td></tr>\n"
                + "       <tr><td bgcolor=\"#84ff82\"><font>Hojas</font></td></tr>\n"
                + "     </table>>\n"
                + "  ];\n"
                + "}";
        imageGenerator(gText, id, 1);
    }

    public void generateNextTable(String id) {
        String gText = "digraph {\n"
                + "  node [ shape=none fontname=Helvetica ]\n"
                + "  n [ label = <\n"
                + "    <table bgcolor=\"black\">"
                + "<tr>\n"
                + "         <td bgcolor=\"#ccccff\">No.</td>\n"
                + "         <td bgcolor=\"#ccccff\">Valor</td>\n"
                + "         <td bgcolor=\"#ccccff\">Siguientes</td>\n"
                + "       </tr>";
        siguientes = new ArrayList<InsideTableNode>();
        ArrayList<GraphNode> variables = Automata.GraphVariables;
        ArrayList<Siguiente> nextT = Automata.nexts;
        //ArrayList<GraphNode> sortVariables = (ArrayList) variables.clone();

        //int tempCont = 0;
        //ArrayList<String> namesAux = new ArrayList<String>();
        //for (int i = 0; i < variables.size(); i++) {
        //    if (variables.get(i).indexS != 0) {
        //        namesAux.add(variables.get(i).name);
        //tempCont += 1;
        //    }
        //}
        /*int AuxCont = tempCont - 2;
        for (int i = 0; i < tempCont - 1; i++) {
            sortVariables.get(i).name = namesAux.get(AuxCont);
            AuxCont -= 1;
        }*/
        for (int i = 0; i < nextT.size(); i++) {
            String[] wheres = nextT.get(i).where.split(",");
            String[] nexts = nextT.get(i).siguientes.split(",");

            for (int k = 0; k < wheres.length; k++) {
                for (int j = 0; j < variables.size(); j++) {
                    if (variables.get(j).indexS == Integer.parseInt(wheres[k])) {
                        ArrayList<String> aux = new ArrayList<String>();

                        boolean already = false;
                        for (int l = 0; l < siguientes.size(); l++) {
                            if (siguientes.get(l).indexI == Integer.parseInt(wheres[k])) {
                                for (int m = 0; m < nexts.length; m++) {
                                    siguientes.get(l).nexts.add(nexts[m]);
                                }
                                already = true;
                            }
                        }
                        String gs = "";
                        if (already == false) {
                            for (int l = 0; l < nexts.length; l++) {
                                if (l + 1 == nexts.length) {
                                    aux.add(nexts[l]);
                                    gs += nexts[l];
                                } else {
                                    aux.add(nexts[l]);
                                    gs += nexts[l] + ", ";
                                }
                            }
                            siguientes.add(new InsideTableNode(variables.get(j).name, variables.get(j).indexS, aux));
                            gText += "<tr>\n"
                                    + "         <td bgcolor=\"#ccffcc\">" + variables.get(j).indexS + "</td>\n"
                                    + "         <td bgcolor=\"#ffffcc\">" + variables.get(j).name + "</td>\n"
                                    + "         <td bgcolor=\"#ffcccc\">" + gs + "</td>\n"
                                    + "      </tr>";
                        }
                    }
                }
            }
        }

        for (int i = 0; i < variables.size(); i++) {
            if ("#".equals(variables.get(i).name)) {
                siguientes.add(new InsideTableNode(variables.get(i).name, variables.get(i).indexS, null));
                gText += "<tr>\n"
                        + "         <td bgcolor=\"#ccffcc\">" + variables.get(i).indexS + "</td>\n"
                        + "         <td bgcolor=\"#ffffcc\">" + variables.get(i).name + "</td>\n"
                        + "         <td bgcolor=\"#ffcccc\">---</td>\n"
                        + "      </tr>";
            }
        }

        //imprimir tabla de siguientes
        /*System.out.println("SIZE: " + siguientes.size());
        for (int i = 0; i < siguientes.size(); i++) {
            System.out.println(siguientes.get(i).name + " " + siguientes.get(i).indexI);
            if (siguientes.get(i).nexts != null) {
                for (int j = 0; j < siguientes.get(i).nexts.size(); j++) {
                    System.out.println(siguientes.get(i).nexts.get(j));
                }
            }
        }*/
        gText += "</table>\n"
                + "  > ]\n"
                + "label = \"" + id + "\";"
                + "}";
        imageGenerator(gText, id, 2);
    }

    public void generateTransitionTable(String id) {
        String gText = "digraph {\n"
                + "  node [ shape=none fontname=Helvetica ]\n"
                + "  n [ label = <\n"
                + "    <table bgcolor=\"black\">";
        String gText2 = "digraph finite_state_machine {\n"
                + "	fontname=\"Helvetica,Arial,sans-serif\"\n"
                + "	node [fontname=\"Helvetica,Arial,sans-serif\"]\n"
                + "	edge [fontname=\"Helvetica,Arial,sans-serif\"]\n"
                + "	rankdir=LR;";
        Node head = Automata.head;
        String[] primeros = head.last.split(",");

        //Llenando la cabecera de transiciones
        ArrayList<Transition> headers = new ArrayList<Transition>();
        for (int i = 0; i < siguientes.size(); i++) {
            if (headers.isEmpty()) {
                headers.add(new Transition((siguientes.get(i).name), 0));
            } else {
                boolean Found = false;
                for (int j = 0; j < headers.size(); j++) {
                    if (siguientes.get(i).name.equals(headers.get(j).name)) {
                        Found = true;
                        break;
                    }
                }
                if (Found == false) {
                    headers.add(new Transition((siguientes.get(i).name), 0));
                }
            }
        }

        //Array de Estados
        GeneralStates = new ArrayList<TransNode>();

        //Llenando el primer estado
        ArrayList<ScanNode> nodesS1 = new ArrayList<ScanNode>();
        for (int i = 0; i < primeros.length; i++) {
            ArrayList<Integer> auxInts = new ArrayList<Integer>();
            for (int j = 0; j < siguientes.size(); j++) {
                if (Integer.parseInt(primeros[i]) == siguientes.get(j).indexI) {
                    for (int k = 0; k < siguientes.get(j).nexts.size(); k++) {
                        auxInts.add(Integer.parseInt(siguientes.get(j).nexts.get(k)));
                    }
                    nodesS1.add(new ScanNode(siguientes.get(j).name, Integer.parseInt(primeros[i]), auxInts, false));
                    break;
                }
            }
        }
        //Añadiendo el primer estado
        int idState = 1;
        GeneralStates.add(new TransNode(idState, nodesS1, headers));
        idState += 1;

        //Generar estados y transiciones
        for (int i = 0; i < GeneralStates.size(); i++) {
            for (int j = 0; j < GeneralStates.get(i).numbers.size(); j++) {
                if (GeneralStates.get(i).numbers.get(j).scanned == true || "#".equals(GeneralStates.get(i).numbers.get(j).name)) {
                    continue;
                }
                GeneralStates.get(i).numbers.get(j).scanned = true;
                ArrayList<Integer> temp = new ArrayList<Integer>();
                String Name = GeneralStates.get(i).numbers.get(j).name;
                boolean pair = false;
                for (int k = 0; k < GeneralStates.get(i).numbers.size(); k++) {
                    if (GeneralStates.get(i).numbers.get(k).scanned == false) {
                        if (GeneralStates.get(i).numbers.get(k).name.equals(GeneralStates.get(i).numbers.get(j).name)) {
                            pair = true;
                            GeneralStates.get(i).numbers.get(k).scanned = true;
                            //Comparador
                            for (int l = 0; l < GeneralStates.get(i).numbers.get(j).follows.size(); l++) {
                                boolean Found = false;
                                for (int n = 0; n < temp.size(); n++) {
                                    if (GeneralStates.get(i).numbers.get(j).follows.get(l) == temp.get(n)) {
                                        Found = true;
                                        break;
                                    }
                                }
                                if (Found == false) {
                                    temp.add(GeneralStates.get(i).numbers.get(j).follows.get(l));
                                }
                            }
                            //Comparado
                            for (int l = 0; l < GeneralStates.get(i).numbers.get(k).follows.size(); l++) {
                                boolean Found = false;
                                for (int n = 0; n < temp.size(); n++) {
                                    if (GeneralStates.get(i).numbers.get(k).follows.get(l) == temp.get(n)) {
                                        Found = true;
                                        break;
                                    }
                                }
                                if (Found == false) {
                                    temp.add(GeneralStates.get(i).numbers.get(k).follows.get(l));
                                }
                            }
                        }
                    }
                }
                //Si no hay comparado para el comparador
                if (pair == false) {
                    for (int m = 0; m < GeneralStates.get(i).numbers.get(j).follows.size(); m++) {
                        temp.add(GeneralStates.get(i).numbers.get(j).follows.get(m));
                    }
                }

                //Comprobar si ya hay un estado igual
                boolean newState = true;
                for (int w = 0; w < GeneralStates.size(); w++) {
                    ArrayList<Integer> temp2 = new ArrayList<Integer>();
                    for (int k = 0; k < GeneralStates.get(w).numbers.size(); k++) {
                        temp2.add(GeneralStates.get(w).numbers.get(k).number);
                    }
                    boolean asigned = false;
                    if (temp.equals(temp2)) {
                        for (int k = 0; k < GeneralStates.get(i).transitions.size(); k++) {
                            if (GeneralStates.get(w).transitions.get(k).name.equals(Name)) {
                                GeneralStates.get(i).transitions.get(k).where = GeneralStates.get(w).id;
                                newState = false;
                                asigned = true;
                                break;
                            }
                        }
                        if (asigned) {
                            break;
                        }
                    }
                }

                if (newState) {
                    ArrayList<ScanNode> nodesSnew = new ArrayList<ScanNode>();
                    for (int p = 0; p < temp.size(); p++) {
                        ArrayList<Integer> auxInts = new ArrayList<Integer>();
                        String name = "";
                        int number = 0;
                        for (int q = 0; q < siguientes.size(); q++) {
                            if (temp.get(p) == siguientes.get(q).indexI) {
                                name = siguientes.get(q).name;
                                number = temp.get(p);
                                if (siguientes.get(q).nexts != null) {
                                    for (int k = 0; k < siguientes.get(q).nexts.size(); k++) {
                                        auxInts.add(Integer.parseInt(siguientes.get(q).nexts.get(k)));
                                    }
                                    break;
                                } else {
                                    auxInts = null;
                                }
                            }

                        }
                        nodesSnew.add(new ScanNode(name, number, auxInts, false));
                    }

                    ArrayList<Transition> headers2 = new ArrayList<Transition>();
                    for (int x = 0; x < siguientes.size(); x++) {
                        if (headers2.isEmpty()) {
                            headers2.add(new Transition((siguientes.get(x).name), 0));
                        } else {
                            boolean Found = false;
                            for (int y = 0; y < headers2.size(); y++) {
                                if (siguientes.get(x).name.equals(headers2.get(y).name)) {
                                    Found = true;
                                    break;
                                }
                            }
                            if (Found == false) {
                                headers2.add(new Transition((siguientes.get(x).name), 0));
                            }
                        }
                    }

                    GeneralStates.add(new TransNode(idState, nodesSnew, headers2));
                    for (int k = 0; k < GeneralStates.get(i).transitions.size(); k++) {
                        if (GeneralStates.get(i).transitions.get(k).name.equals(Name)) {
                            GeneralStates.get(i).transitions.get(k).where = idState;
                            break;
                        }
                    }
                    idState += 1;
                }
            }
        }
        //Arreglar estados vacios y asinacion de transiciones
        for (int i = 0; i < GeneralStates.size(); i++) {
            if (GeneralStates.get(i).numbers.isEmpty()) {
                GeneralStates.remove(i);
                i--;
            }
        }
        gText += "<tr>\n"
                + "<td bgcolor=\"#ccccff\" rowspan=\"2\">Estados</td>\n"
                + "<td bgcolor=\"#ccccff\" colspan=\"" + GeneralStates.get(0).transitions.size() + "\">Transiciones</td>\n"
                + "</tr>";
        for (int i = 0; i < GeneralStates.size(); i++) {
            gText += "<tr>\n";
            for (int j = 0; j < GeneralStates.get(i).transitions.size(); j++) {
                gText += "<td bgcolor=\"#ffcccc\">" + GeneralStates.get(i).transitions.get(j).name + "</td>\n";
            }
            gText += "</tr>";
            break;
        }
        //Imprimir tabla de transiciones
        for (int i = 0; i < GeneralStates.size(); i++) {
            //System.out.println("Estado S" + GeneralStates.get(i).id);
            //System.out.println("-------------Números-------------");
            gText += "<tr>"
                    + "<td bgcolor=\"#ccffcc\">S" + GeneralStates.get(i).id + " {";
            for (int j = 0; j < GeneralStates.get(i).numbers.size(); j++) {
                if (j + 1 == GeneralStates.get(i).numbers.size()) {
                    gText += GeneralStates.get(i).numbers.get(j).number + "(" + GeneralStates.get(i).numbers.get(j).name + ")";
                    //System.out.print(GeneralStates.get(i).numbers.get(j).number + " " + GeneralStates.get(i).numbers.get(j).scanned);
                    break;
                }
                gText += GeneralStates.get(i).numbers.get(j).number + "(" + GeneralStates.get(i).numbers.get(j).name + "),";
                //System.out.print(GeneralStates.get(i).numbers.get(j).number + " " + GeneralStates.get(i).numbers.get(j).scanned);
            }
            gText += "}</td>";
            //System.out.println("\n");
            //System.out.println("-------------Headers-------------");
            for (int j = 0; j < GeneralStates.get(i).transitions.size(); j++) {
                //System.out.println(GeneralStates.get(i).transitions.get(j).name + " -> " + GeneralStates.get(i).transitions.get(j).where);
                if (GeneralStates.get(i).transitions.get(j).where == 0) {
                    gText += "<td bgcolor=\"#ffffcc\"> --- </td>";
                } else {
                    gText += "<td bgcolor=\"#ffffcc\">S" + GeneralStates.get(i).transitions.get(j).where + "</td>";
                }
            }
            //System.out.println("---------------------------------");
            gText += "</tr>";
        }
        String aStates = "";
        for (int i = 0; i < GeneralStates.size(); i++) {
            for (int j = 0; j < GeneralStates.get(i).numbers.size(); j++) {
                if ("#".equals(GeneralStates.get(i).numbers.get(j).name)) {
                    if (j + 1 == GeneralStates.get(i).numbers.size()) {
                        aStates += "S" + GeneralStates.get(i).id + ";";
                    } else {
                        aStates += "S" + GeneralStates.get(i).id + ";";
                    }
                }
            }
        }
        gText2 += "node [shape = doublecircle color=green]; " + aStates + "\n";
        gText2 += "node [shape = circle color=blue];\n";
        for (int i = 0; i < GeneralStates.size(); i++) {
            for (int j = 0; j < GeneralStates.get(i).transitions.size(); j++) {
                if (GeneralStates.get(i).transitions.get(j).where == 0) {
                } else {
                    String[] tempS = GeneralStates.get(i).transitions.get(j).name.split("");
                    if ("\"".equals(tempS[0]) || "\'".equals(tempS[0])) {
                        String[] s2 = removeTheElement(tempS, 0);
                        String[] s3 = removeTheElement(s2, s2.length - 1);
                        String x = "";
                        for (int w = 0; w < s3.length; w++) {
                            x += s3[w];
                        }
                        gText2 += "S" + GeneralStates.get(i).id + " -> S" + GeneralStates.get(i).transitions.get(j).where + " [label = \"\\\"" + x + "\\\"\"];\n";
                    } else {
                        gText2 += "S" + GeneralStates.get(i).id + " -> S" + GeneralStates.get(i).transitions.get(j).where + " [label = \"" + GeneralStates.get(i).transitions.get(j).name + "\"];\n";
                    }
                }
            }
        }

        gText += "</table>\n"
                + "  > ]\n"
                + "label = \"" + id + "\";"
                + "}";
        gText2 += "label = \"" + id + "\";\n"
                + "}";
        imageGenerator(gText, id, 3);
        imageGenerator(gText2, id, 4);
    }

    public void generateAutomata(String text, String id) {
        //ArrayList<Sentencia> sen = Analyzers.sentencias;
        //ArrayList<Instrucciones> ins = Analyzers.instrucciones;
        //System.out.println("-----------CONJUNTOS-----------");
        /*for (int i = 0; i < ins.size(); i++) {
            switch (ins.get(i).getTipo()) {
                case CONJUNTO:
                    System.out.println(ins.get(i).id);
                    for (int j = 0; j < ins.get(i).cadena.size(); j++) {
                        for (int k = 0; k < ins.get(i).cadena.get(j).getListaInst().size(); k++) {
                            System.out.println("    " + ins.get(i).cadena.get(j).getListaInst().get(k));
                        }
                    }
            }
        }*/
 /*System.out.println("-----------SENTENCIAS-----------");
        for (int i = 0; i < sen.size(); i++) {
            System.out.println(sen.get(i).getId() + sen.get(i).getCadena());
        }*/
        String[] f = text.split("");
        String[] f2 = removeTheElement(f, 0);
        String[] lexema = removeTheElement(f2, f2.length - 1);
        int currentState = 1;
        boolean Error = false;
        for (int i = 0; i < lexema.length; i++) {
            upgrade = i;
            //System.out.println("Se encuentra en el estado " + currentState);
            String temp = lexema[i];
            //System.out.println("temp: " + temp);
            if ("\\".equals(temp)) {
                if ("\\\"".equals(temp + lexema[i + 1])) {
                    temp += "\"";
                } else if ("\\\'".equals(temp + lexema[i + 1])) {
                    temp += "\'";
                } /*for (int j = i + 1; j < lexema.length; j++) {
                        if ("\\\"".equals(lexema[j] + lexema[j + 1]) || "\\\'".equals(lexema[j] + lexema[j + 1])) {
                            temp += lexema[j] + lexema[j + 1];
                            break;
                        }
                        temp += lexema[j];
                        lexCont += 1;
                    }*/ else if ("\\n".equals(temp + lexema[i + 1])) {
                    temp += "n";
                }
            }
            //System.out.println("temp: " + temp);
            if (currentState == 1) {
                boolean Accepted = false;
                for (int j = 0; j < GeneralStates.get(currentState - 1).transitions.size(); j++) {
                    String[] t = temp.split("");
                    if (t.length >= 2) {
                        if (transitionConversor(GeneralStates.get(currentState - 1).transitions.get(j).name, temp, lexema, i)) {
                            if (GeneralStates.get(currentState - 1).transitions.get(j).where != 0) {
                                //System.out.println("Entrada: " + temp + " aceptada");
                                Accepted = true;
                                currentState = GeneralStates.get(currentState - 1).transitions.get(j).where;
                                i = upgrade + 1;
                                break;
                            } else {
                                Error = true;
                            }
                        }
                    } else {
                        if (transitionConversor(GeneralStates.get(currentState - 1).transitions.get(j).name, temp, lexema, i)) {
                            if (GeneralStates.get(currentState - 1).transitions.get(j).where != 0) {
                                Accepted = true;
                                //System.out.println("Caracter: " + temp + " aceptado");
                                currentState = GeneralStates.get(currentState - 1).transitions.get(j).where;
                                i = upgrade;
                                break;
                            } else {
                                Error = true;
                            }
                        }
                    }
                }
                if (Accepted == false) {
                    //System.out.println("Caracter: " + temp + " denegado");
                    Error = true;
                    break;
                }
            } else {
                boolean Accept = false;
                for (int j = 0; j < GeneralStates.size(); j++) {
                    if (GeneralStates.get(j).id == currentState) {
                        if (Accept) {
                            break;
                        }
                        boolean Accepted = false;
                        for (int k = 0; k < GeneralStates.get(currentState - 1).transitions.size(); k++) {
                            String[] t = temp.split("");
                            if (t.length >= 2) {
                                if (transitionConversor(GeneralStates.get(currentState - 1).transitions.get(k).name, temp, lexema, i)) {
                                    if (GeneralStates.get(currentState - 1).transitions.get(k).where != 0) {
                                        //System.out.println("Entrada: " + temp + " aceptada");
                                        Accepted = true;
                                        Accept = true;
                                        currentState = GeneralStates.get(currentState - 1).transitions.get(k).where;
                                        i = upgrade + 1;
                                        break;
                                    } else {
                                        Error = true;
                                    }
                                }
                            } else {
                                if (transitionConversor(GeneralStates.get(currentState - 1).transitions.get(k).name, temp, lexema, i)) {
                                    if (GeneralStates.get(currentState - 1).transitions.get(k).where != 0) {
                                        Accepted = true;
                                        Accept = true;
                                        i = upgrade;
                                        //System.out.println("Caracter: " + temp + " aceptado");
                                        currentState = GeneralStates.get(currentState - 1).transitions.get(k).where;
                                        break;
                                    } else {
                                        Error = true;
                                    }
                                }
                            }
                        }
                        if (Accepted == false) {
                            //System.out.println("Caracter: " + temp + " denegado");
                            Error = true;
                            break;
                        }
                    }
                }
            }
            if (Error) {
                break;
            }
        }
        if (Error) {
            System.out.println("Lexema no aceptado por la Expresión regular");
            jsonElements.add(new jsonData(text, id, false));
        } else {
            boolean Nice = false;
            for (int j = 0; j < GeneralStates.get(currentState - 1).numbers.size(); j++) {
                if (GeneralStates.get(currentState - 1).numbers.get(j).name.equals("#")) {
                    Nice = true;
                    break;
                }
            }
            if (Nice) {
                System.out.println("Lexema aceptado por la Expresión regular");
                jsonElements.add(new jsonData(text, id, true));
            } else {
                System.out.println("Lexema no aceptado por la Expresión regular");
                jsonElements.add(new jsonData(text, id, false));
            }
        }
    }

    public static boolean transitionConversor(String conj, String caracter, String[] complete, int index) {
        //System.out.println("conj: " + conj + ", caracter: " + caracter);
        ArrayList<Instrucciones> ins = Analyzers.instrucciones;
        String[] c0 = conj.split("");
        if (c0[0].equals("\"") || c0[0].equals("\'")) {
            String[] s2 = removeTheElement(c0, 0);
            String[] s3 = removeTheElement(s2, s2.length - 1);
            String x = "";
            for (int i = 0; i < s3.length; i++) {
                x += s3[i];
            }
            //System.out.println("x: " + x+", caracter: " + caracter + ", equals=? " + x.equals(caracter));
            if (x.equals(caracter)) {
                upgrade = index;
                return x.equals(caracter);
            } else {
                String test = "";
                for (int i = index; i < complete.length; i++) {
                    test += complete[i];
                    if (x.equals(test)) {
                        upgrade = i;
                        return x.equals(test);
                    }
                }
                return false;
            }
        } else {

            for (int i = 0; i < ins.size(); i++) {
                switch (ins.get(i).getTipo()) {
                    case CONJUNTO:
                        String[] a = conj.split("");
                        String[] a2 = removeTheElement(a, 0);
                        String[] a3 = removeTheElement(a2, a2.length - 1);
                        String conjunto = "";
                        for (int m = 0; m < a3.length; m++) {
                            conjunto += a3[m];
                        }
                        if (conjunto.equals(ins.get(i).id)) {
                            boolean Found = false;
                            for (int j = 0; j < ins.get(i).getCadena().size(); j++) {
                                String range = ins.get(i).getCadena().get(j).getListaInst().get(0).replaceAll("\\s", "");
                                String[] sign = range.split("");
                                if (ins.get(i).getCadena().get(j).getListaInst().size() == 3) {
                                    if (",".equals(ins.get(i).getCadena().get(j).getListaInst().get(1))) {
                                        char character1 = caracter.charAt(0);
                                        int character = (int) character1;

                                        char character2 = ins.get(i).getCadena().get(j).getListaInst().get(0).charAt(0);
                                        int limit = (int) character2;

                                        char character3 = ins.get(i).getCadena().get(j).getListaInst().get(2).charAt(0);
                                        int limit2 = (int) character3;
                                        if (character == limit || character == limit2) {
                                            return true;
                                        } else {
                                            return false;
                                        }
                                    } else {
                                        char character1 = caracter.charAt(0);
                                        int character = (int) character1;

                                        char character2 = ins.get(i).getCadena().get(j).getListaInst().get(0).charAt(0);
                                        int limit = (int) character2;

                                        char character3 = ins.get(i).getCadena().get(j).getListaInst().get(2).charAt(0);
                                        int limit2 = (int) character3;
                                        if (character >= limit && character <= limit2) {
                                            return true;
                                        } else {
                                            return false;
                                        }
                                    }
                                } else if (sign.length == 3) {
                                    if (sign[1].equals(",")) {
                                        char character1 = caracter.charAt(0);
                                        int character = (int) character1;

                                        char character2 = sign[0].charAt(0);
                                        int limit = (int) character2;

                                        char character3 = sign[2].charAt(0);
                                        int limit2 = (int) character3;
                                        if (character == limit || character == limit2) {
                                            return true;
                                        } else {
                                            return false;
                                        }
                                    } else {
                                        char character1 = caracter.charAt(0);
                                        int character = (int) character1;

                                        char character2 = sign[0].charAt(0);
                                        int limit = (int) character2;

                                        char character3 = sign[2].charAt(0);
                                        int limit2 = (int) character3;
                                        if (character >= limit && character <= limit2) {
                                            return true;
                                        } else {
                                            return false;
                                        }
                                    }
                                } else {
                                    for (int k = 0; k < ins.get(i).getCadena().get(j).getListaInst().size(); k++) {
                                        if (ins.get(i).getCadena().get(j).getListaInst().get(k).equals(caracter)) {
                                            Found = true;
                                            break;
                                        }
                                    }

                                }
                            }
                            if (Found) {
                                return true;
                            } else {
                                return false;
                            }
                        }
                }
            }
        }
        return false;
    }

    public static String[] removeTheElement(String[] arr, int index) {
        if (arr == null || index < 0
                || index >= arr.length) {
            return arr;
        }
        String[] anotherArray = new String[arr.length - 1];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }
            anotherArray[k++] = arr[i];
        }
        return anotherArray;
    }

    public static void imageGenerator(String text, String name, int type) {
        createFile(text, name, type);
        ProcessBuilder process = null;
        File directory;
        if (type == 1) {
            directory = new File("Reportes/ARBOLES_201800476/");
            if (!directory.exists()) {
                directory.mkdir();
            }
            process = new ProcessBuilder("dot", "-Tpng", "-o", "Reportes/ARBOLES_201800476/" + name + ".png", "Reportes/ARBOLES_201800476/" + name + ".dot");
        } else if (type == 2) {
            directory = new File("Reportes/SIGUIENTES_201800476/");
            if (!directory.exists()) {
                directory.mkdir();
            }
            process = new ProcessBuilder("dot", "-Tpng", "-o", "Reportes/SIGUIENTES_201800476/" + name + ".png", "Reportes/SIGUIENTES_201800476/" + name + ".dot");
        } else if (type == 3) {
            directory = new File("Reportes/TRANSICIONES_201800476/");
            if (!directory.exists()) {
                directory.mkdir();
            }
            process = new ProcessBuilder("dot", "-Tpng", "-o", "Reportes/TRANSICIONES_201800476/" + name + ".png", "Reportes/TRANSICIONES_201800476/" + name + ".dot");
        } else if (type == 4) {
            directory = new File("Reportes/AFD_201800476/");
            if (!directory.exists()) {
                directory.mkdir();
            }
            process = new ProcessBuilder("dot", "-Tpng", "-o", "Reportes/AFD_201800476/" + name + ".png", "Reportes/AFD_201800476/" + name + ".dot");
        } else if (type == 5) {
            directory = new File("Reportes/AFND_201800476/");
            if (!directory.exists()) {
                directory.mkdir();
            }
            process = new ProcessBuilder("dot", "-Tpng", "-o", "Reportes/AFND_201800476/" + name + ".png", "Reportes/AFND_201800476/" + name + ".dot");
        }
        process.redirectErrorStream(true);
        try {
            process.start();
            System.out.println("Archivo generado");
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public static void createFile(String text, String name, int type) {
        FileWriter f = null;
        PrintWriter textG = null;
        try {
            String cType = "";
            File directory;
            if (type == 1) {
                cType = "Reportes/ARBOLES_201800476/" + name + ".dot";
                directory = new File("Reportes/ARBOLES_201800476/");
                if (!directory.exists()) {
                    directory.mkdir();
                }
            } else if (type == 2) {
                cType = "Reportes/SIGUIENTES_201800476/" + name + ".dot";
                directory = new File("Reportes/SIGUIENTES_201800476/");
                if (!directory.exists()) {
                    directory.mkdir();
                }
            } else if (type == 3) {
                cType = "Reportes/TRANSICIONES_201800476/" + name + ".dot";
                directory = new File("Reportes/TRANSICIONES_201800476/");
                if (!directory.exists()) {
                    directory.mkdir();
                }
            } else if (type == 4) {
                cType = "Reportes/AFD_201800476/" + name + ".dot";
                directory = new File("Reportes/AFD_201800476/");
                if (!directory.exists()) {
                    directory.mkdir();
                }
            } else if (type == 5) {
                cType = "Reportes/AFND_201800476/" + name + ".dot";
                directory = new File("Reportes/AFND_201800476/");
                if (!directory.exists()) {
                    directory.mkdir();
                }
            }
            f = new FileWriter(cType);
            textG = new PrintWriter(f);
            textG.write(text);
            textG.close();
            f.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (textG != null) {
                textG.close();
                try {
                    f.close();
                } catch (IOException ex) {
                }
            }
        }
    }

    public static void failsReport() throws IOException {
        ArrayList<Fail> fails = Analyzers.errores;
        String fText = "";
        fText += "<!DOCTYPE html>\n"
                + "            <html lang=\"en\">\n"
                + "\n"
                + "            <head>\n"
                + "\n"
                + "                <meta charset=\"utf-8\">\n"
                + "                <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n"
                + "                <meta name=\"description\" content=\"\">\n"
                + "                <meta name=\"author\" content=\"TemplateMo\">\n"
                + "                <link href=\"https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700\" rel=\"stylesheet\">\n"
                + "\n"
                + "                <title>Reporte</title>\n"
                + "\n"
                + "                <!-- Bootstrap core CSS -->\n"
                + "                <link href=\"vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n"
                + "\n"
                + "                <!-- Additional CSS Files -->\n"
                + "                <link rel=\"stylesheet\" href=\"assets/css/fontawesome.css\">\n"
                + "                <link rel=\"stylesheet\" href=\"assets/css/templatemo-host-cloud.css\">\n"
                + "                <link rel=\"stylesheet\" href=\"assets/css/owl.css\">\n"
                + "            <!--\n"
                + "\n"
                + "            Host Cloud Template\n"
                + "\n"
                + "            https://templatemo.com/tm-541-host-cloud\n"
                + "\n"
                + "            -->\n"
                + "            </head>\n"
                + "\n"
                + "            <body>\n"
                + "        <!-- Header -->\n"
                + "        <header class=\"\">\n"
                + "        <nav class=\"navbar navbar-expand-lg\">\n"
                + "            <div class=\"container\">\n"
                + "            <a class=\"navbar-brand\" href=\"reporte_Errores.html\"><h2>Reportes<em>OLC1</em></h2></a>\n"
                + "            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarResponsive\" aria-controls=\"navbarResponsive\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n"
                + "                <span class=\"navbar-toggler-icon\"></span>\n"
                + "            </button>\n"
                + "            <div class=\"collapse navbar-collapse\" id=\"navbarResponsive\">\n"
                + "                <ul class=\"navbar-nav ml-auto\">\n"
                + "                </ul>\n"
                + "            </div>\n"
                + "            <div class=\"functional-buttons\">\n"
                + "            </div>\n"
                + "            </div>\n"
                + "        </nav>\n"
                + "        </header>\n"
                + "\n"
                + "        <!-- Page Content -->\n"
                + "        <!-- Banner Starts Here -->\n"
                + "        <div class=\"banner\">\n"
                + "        <div class=\"container\">\n"
                + "            <div class=\"row\">\n"
                + "            <div class=\"col-md-8 offset-md-2\">\n"
                + "                <div class=\"header-text caption\">\n"
                + "                <h2 style=>Reporte de</h2>\n"
                + "                <h1 style=\"color: white; font-size:120px; text-align: center; font-style: italic; font-family:'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif; text-transform:uppercase\">Errores</h1>\n"
                + "                </div>\n"
                + "            </div>\n"
                + "            </div>\n"
                + "        </div>\n"
                + "        </div>"
                + "<div style=\"padding-bottom: 100px;\" class=\"services-section\">\n"
                + "                <div class=\"container\">\n"
                + "                    <div class=\"row\">\n"
                + "                        <div class=\"col-md-8 offset-md-2\">\n"
                + "                            <div class=\"section-heading\">\n"
                + "                            <h2 style=\"text-transform:uppercase; text-align: center;\">Tokens</h2>\n"
                + "                            </div>\n"
                + "                            <table class=\"table\">\n"
                + "                            <thead style=\"color:white; background-color: rgb(0, 50, 199); text-transform:uppercase; text-align: center;\">\n"
                + "                                <tr>"
                + "<th scope=\"col\">No.</th>"
                + "<th scope=\"col\">Tipo</th>"
                + "<th scope=\"col\">Descripción</th>"
                + "<th scope=\"col\">Linea</th>"
                + "<th scope=\"col\">Columna</th>"
                + "</tr>"
                + "</thead>"
                + "<tbody>";
        for (int i = 0; i < fails.size(); i++) {
            fText += "<tr>"
                    + "<td style=\"text-align: center;\">" + (i + 1) + "</td>"
                    + "<td style=\"text-align: center;\">" + fails.get(i).type + "</td>"
                    + "<td style=\"text-align: center;\">" + fails.get(i).message + "</td>"
                    + "<td style=\"text-align: center;\">" + fails.get(i).line + "</td>"
                    + "<td style=\"text-align: center;\">" + fails.get(i).column + "</td>"
                    + "</tr>";
        }
        fText += "</tbody>\n"
                + "                        </table>\n"
                + "                        </div>\n"
                + "                    </div>\n"
                + "                    </div>\n"
                + "                </div>\n"
                + "                </div>"
                + "<script src=\"vendor/jquery/jquery.min.js\"></script>\n"
                + "                <script src=\"vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\n"
                + "\n"
                + "                <!-- Additional Scripts -->\n"
                + "                <script src=\"assets/js/custom.js\"></script>\n"
                + "                <script src=\"assets/js/owl.js\"></script>\n"
                + "                <script src=\"assets/js/accordions.js\"></script>\n"
                + "\n"
                + "\n"
                + "                <script language = \"text/Javascript\"> \n"
                + "                cleared[0] = cleared[1] = cleared[2] = 0; //set a cleared flag for each field\n"
                + "                function clearField(t){                   //declaring the array outside of the\n"
                + "                if(! cleared[t.id]){                      // function makes it static and global\n"
                + "                    cleared[t.id] = 1;  // you could use true and false, but that's more typing\n"
                + "                    t.value='';         // with more chance of typos\n"
                + "                    t.style.color='#fff';\n"
                + "                    }\n"
                + "                }\n"
                + "                </script>\n"
                + "            </body>\n"
                + "            </html>";
        File directory = new File("Reportes/ERRORES_201800476/");
        if (!directory.exists()) {
            directory.mkdir();
        }
        File f = new File("Reportes/ERRORES_201800476/reporte_Errores.html");
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        bw.write(fText);
        bw.close();
    }

    public static String consolePrintResult() {
        String result = "";
        for (int i = 0; i < jsonElements.size(); i++) {
            if (jsonElements.get(i).result) {
                result += "La expresión: " + jsonElements.get(i).value + " es válida con la expresión regular " + jsonElements.get(i).regex + "\n";
            } else {
                result += "La expresión: " + jsonElements.get(i).value + " no es válida con la expresión regular " + jsonElements.get(i).regex + "\n";
            }
        }
        return result;
    }
}
