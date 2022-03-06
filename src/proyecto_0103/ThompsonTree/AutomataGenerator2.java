package proyecto_0103.ThompsonTree;

import java.util.ArrayList;
import java.util.Collections;
import static proyecto_0103.ExpressionTree.AutomataGenerator.imageGenerator;
import static proyecto_0103.ExpressionTree.AutomataGenerator.jsonElements;
import static proyecto_0103.ExpressionTree.AutomataGenerator.removeTheElement;
import static proyecto_0103.ExpressionTree.AutomataGenerator.transitionConversor;
import proyecto_0103.jsonData;

/**
 *
 * @author Alexis
 */
public class AutomataGenerator2 {

    ArrayList<DataText> conexiones;
    ArrayList<Node> nodos2;
    ArrayList<TransNode3> transiciones;
    int max = 0;

    public void generateTree(String id) {
        transiciones = new ArrayList<TransNode3>();
        conexiones = Automata2.GraphThompson;
        nodos2 = Automata2.nodes;

        /*for (Node nodo : nodos2) {
            System.out.println("S" + nodo.state + " -> data: " + nodo.data + " -> id: " + nodo.id);
        }
        System.out.println("..........................");
        for (int i = 0; i < conexiones.size(); i++) {
            System.out.println("S" + conexiones.get(i).first + " -> S" + conexiones.get(i).last + " -> id: " + conexiones.get(i).index);
        }*/
        max = 0;
        for (int i = 0; i < conexiones.size(); i++) {
            if (max <= conexiones.get(i).last) {
                max = conexiones.get(i).last;
            }
        }
        String gText = "digraph finite_state_machine {\n"
                + "	fontname=\"Helvetica,Arial,sans-serif\"\n"
                + "	node [fontname=\"Helvetica,Arial,sans-serif\"]\n"
                + "	edge [fontname=\"Helvetica,Arial,sans-serif\"]\n"
                + "	rankdir=LR;\n"
                + "node [shape = doublecircle color=green];\"S" + max + "\"\n"
                + "node [shape = circle color=blue];\n";
        String gText2 = "digraph finite_state_machine {\n"
                + "	fontname=\"Helvetica,Arial,sans-serif\"\n"
                + "	node [fontname=\"Helvetica,Arial,sans-serif\"]\n"
                + "	edge [fontname=\"Helvetica,Arial,sans-serif\"]\n"
                + "	rankdir=LR;";
        ArrayList<String> sort = new ArrayList<String>();
        for (int i = 0; i < conexiones.size(); i++) {
            String[] temp = conexiones.get(i).data.split("");
            if ("\"".equals(temp[0]) || "\'".equals(temp[0])) {
                String[] a2 = removeTheElement(temp, 0);
                String[] a3 = removeTheElement(a2, a2.length - 1);
                String temp2 = "";
                for (int m = 0; m < a3.length; m++) {
                    temp2 += a3[m];
                }
                sort.add("\"S" + conexiones.get(i).first + "\"->" + "\"S" + conexiones.get(i).last + "\"[label=\"\\\"" + temp2 + "\\\"\"];\n");
            } else {
                sort.add("\"S" + conexiones.get(i).first + "\"->" + "\"S" + conexiones.get(i).last + "\"[label=\"" + conexiones.get(i).data + "\"];\n");
            }
        }
        Collections.sort(sort);
        //Collections.sort(conexiones);
        ArrayList<DataText> single = new ArrayList<DataText>();
        single.add(conexiones.get(0));
        DataText first = conexiones.get(conexiones.size() - 1);
        //System.out.println("nodefirst= S" + first.first + " -> S" + first.last);
        ArrayList<Node> firstOne = new ArrayList<Node>();
        for (int i = 0; i < nodos2.size(); i++) {
            if (first.index == nodos2.get(i).id && first.first == nodos2.get(i).state) {
                nodos2.get(i).setAdded(true);
                firstOne.add(nodos2.get(i));
                break;
            }
        }
        ArrayList<Node> firstList = new ArrayList<Node>();
        for (int i = 0; i < nodos2.size(); i++) {
            nodos2.get(i).setAdded(false);
            firstList.add(nodos2.get(i));
        }
        generateTransitionTable(firstOne, firstList);

        for (int i = 0; i < sort.size(); i++) {
            gText += sort.get(i);
        }
        String states = "";
        for (int i = 0; i < transiciones.size(); i++) {
            for (int j = 0; j < transiciones.get(i).numbers.size(); j++) {
                //System.out.println(transiciones.get(i).numbers.get(j).state + " =? " + max);
                if (transiciones.get(i).numbers.get(j).state == max) {
                    states += "\"S(";
                    for (int k = 0; k < transiciones.get(i).idNumbers.size(); k++) {
                        if (k + 1 == transiciones.get(i).idNumbers.size()) {
                            states += transiciones.get(i).idNumbers.get(k);
                        } else {
                            states += transiciones.get(i).idNumbers.get(k) + ",";
                        }
                    }
                    states += ")\";";
                }
            }
        }
        gText2 += "node [shape = doublecircle color=green]; " + states + "\n";
        gText2 += "node [shape = circle color=blue];\n";
        for (int i = 0; i < transiciones.size(); i++) {
            for (int j = 0; j < transiciones.get(i).getTransitions().size(); j++) {
                if (transiciones.get(i).getTransitions().get(j).getWhere().isEmpty()) {
                } else {
                    String states2 = "\"S(";
                    for (int k = 0; k < transiciones.get(i).idNumbers.size(); k++) {
                        if (k + 1 == transiciones.get(i).idNumbers.size()) {
                            states2 += transiciones.get(i).idNumbers.get(k);
                        } else {
                            states2 += transiciones.get(i).idNumbers.get(k) + ",";
                        }
                    }
                    states2 += ")\"";
                    String states3 = "\"S(";
                    for (int k = 0; k < transiciones.get(i).getTransitions().get(j).getWhere().size(); k++) {
                        if (k + 1 == transiciones.get(i).getTransitions().get(j).getWhere().size()) {
                            states3 += transiciones.get(i).getTransitions().get(j).getWhere().get(k);
                        } else {
                            states3 += transiciones.get(i).getTransitions().get(j).getWhere().get(k) + ",";
                        }
                    }
                    states3 += ")\"";
                    String[] tempS = transiciones.get(i).getTransitions().get(j).name.split("");
                    if ("\"".equals(tempS[0]) || "\'".equals(tempS[0])) {
                        String[] s2 = removeTheElement(tempS, 0);
                        String[] s3 = removeTheElement(s2, s2.length - 1);
                        String x = "";
                        for (int w = 0; w < s3.length; w++) {
                            x += s3[w];
                        }
                        gText2 += states2 + " -> " + states3 + " [label = \"\\\"" + x + "\\\"\"];\n";
                    } else {
                        gText2 += states2 + " -> " + states3 + " [label = \"" + transiciones.get(i).getTransitions().get(j).name + "\"];\n";
                    }
                }
            }
        }
        gText += "label = \"" + id + "\";\n"
                + "}";
        gText2 += "label = \"" + id + "\";\n"
                + "}";
        imageGenerator(gText, id, 5);
        imageGenerator(gText2, id, 4);
    }

    public void generateTransitionTable(ArrayList<Node> transitionNodes, ArrayList<Node> nodos) {//s0=11T,s0=14T
        ArrayList<Integer> idThis = new ArrayList<Integer>();
        //Copiar numeros a id
        for (int i = 0; i < transitionNodes.size(); i++) {
            idThis.add(transitionNodes.get(i).state);
        }
        //Añadir nodos iniciales
        for (int x = 0; x < transitionNodes.size(); x++) {
            for (int i = 0; i < nodos.size(); i++) {
                if (transitionNodes.get(x).state == nodos.get(i).state && !nodos.get(i).isAdded()) {
                    nodos.get(i).setAdded(true);
                    transitionNodes.add(nodos.get(i));
                }
            }
        }
        /*System.out.println("----------------TransitionNodes sin epsilon------------------");
        for (int i = 0; i < transitionNodes.size(); i++) {
            System.out.println("S" + transitionNodes.get(i).state + " -> data: " + transitionNodes.get(i).data + " -> id: " + transitionNodes.get(i).id);
        }
        System.out.println("\n");*/
        //Buscar epsilons
        for (int i = 0; i < transitionNodes.size(); i++) {
            //---------------Estado S-1---------------------
            //s-1=15T
            //---------------Estado S0---------------------
            //*s0=11T,*s0=14T,*s0=15T,*s1=6T,*s1=7T,*s1=11T,*s1=12T,*s13=14T,*s13=13T,*s2=6T,*s2=8T
            //*s4=7T,*s4=3T,*s4=0T,*s8=3T,*s8=4T,*s5=0T,*s5=1T
            for (int j = 0; j < conexiones.size(); j++) {
                if (transitionNodes.get(i).id == conexiones.get(j).index) {
                    if ("ε".equals(conexiones.get(j).data)) {
                        for (int k = 0; k < nodos.size(); k++) {
                            //System.out.println("S" + conexiones.get(j).last + "?= S" + nodos.get(k).state + " - index: " + conexiones.get(j).index + "?=" + nodos.get(k).id + " -> added?" + nodos.get(k).added);
                            if (conexiones.get(j).last == nodos.get(k).state && conexiones.get(j).index == nodos.get(k).id) {
                                if (!nodos.get(k).isAdded()) {
                                    for (int x = 0; x < nodos.size(); x++) {
                                        if (nodos.get(k).state == nodos.get(x).state && !nodos.get(x).isAdded()) {
                                            nodos.get(x).setAdded(true);
                                            transitionNodes.add(nodos.get(x));
                                        }
                                    }
                                } else {
                                    for (int x = 0; x < nodos.size(); x++) {
                                        if (nodos.get(k).state == nodos.get(x).state && !nodos.get(x).isAdded()) {
                                            nodos.get(x).setAdded(true);
                                            transitionNodes.add(nodos.get(x));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        /*System.out.println("----------------TransitionNodes con epsilon------------------");
        for (int i = 0; i < transitionNodes.size(); i++) {
            System.out.println("S" + transitionNodes.get(i).state + " -> data: " + transitionNodes.get(i).data + " -> id: " + transitionNodes.get(i).id);
        }
        System.out.println("\n");*/
        ArrayList<Transition2> headers = new ArrayList<Transition2>();
        //Creacion de cabecera
        for (int x = 0; x < conexiones.size(); x++) {
            if (headers.isEmpty()) {
                if (!"ε".equals(conexiones.get(x).data)) {
                    ArrayList<Integer> x1 = new ArrayList<Integer>();
                    headers.add(new Transition2((conexiones.get(x).data), x1));
                }
            } else {
                boolean Found = false;
                for (int j = 0; j < headers.size(); j++) {
                    if (conexiones.get(x).data.equals(headers.get(j).name)) {
                        Found = true;
                        break;
                    }
                }
                if (Found == false) {
                    ArrayList<Integer> x1 = new ArrayList<Integer>();
                    if (!"ε".equals(conexiones.get(x).data)) {
                        headers.add(new Transition2((conexiones.get(x).data), x1));
                    }
                }
            }
        }
        //Limpiador
        for (int i = 0; i < nodos.size(); i++) {
            nodos.get(i).setAdded(false);
        }
        //Nuevo Estado
        Collections.sort(transitionNodes);
        Collections.sort(idThis);
        boolean newState = true;
        for (int i = 0; i < transiciones.size(); i++) {
            if (transiciones.get(i).idNumbers.equals(idThis)) {
                newState = false;
                break;
            }
        }
        if (newState) {
            transiciones.add(new TransNode3(idThis, transitionNodes, headers));
        }

        //Buscar a donde va cada estado
        for (int i = 0; i < headers.size(); i++) {//{digito},"."
            //Limpiador
            ArrayList<Node> temp = new ArrayList<Node>();
            for (int j = 0; j < nodos.size(); j++) {
                nodos.get(j).setAdded(false);
            }
            for (int j = 0; j < transitionNodes.size(); j++) {//s5=1T,s5=2T,s5=3T,s4=0T,s4=1T,s4=2T,s6=3T
                for (int k = 0; k < conexiones.size(); k++) {
                    //System.out.println("id-> " + transitionNodes.get(j).id + "?=" + conexiones.get(k).index + ", data-> " + conexiones.get(k).data + "?=" + headers.get(i).name);
                    if (transitionNodes.get(j).id == conexiones.get(k).index && conexiones.get(k).data.equals(headers.get(i).name)) {
                        for (int l = 0; l < nodos.size(); l++) {
                            if (nodos.get(l).state == conexiones.get(k).last && nodos.get(l).id == conexiones.get(k).index) {
                                boolean Found = false;
                                for (int m = 0; m < transitionNodes.size(); m++) {
                                    if (transitionNodes.get(m).id == conexiones.get(k).index && transitionNodes.get(m).state == conexiones.get(k).first) {
                                        Found = true;
                                        break;
                                    }
                                }
                                if (Found && !nodos.get(l).isAdded()) {
                                    nodos.get(l).setAdded(true);
                                    temp.add(nodos.get(l));
                                }
                            }
                        }
                    }
                }
            }
            if (!temp.isEmpty()) {
                Collections.sort(temp);
                boolean Found = false;
                ArrayList<Integer> temp2 = new ArrayList<Integer>();
                for (int j = 0; j < temp.size(); j++) {
                    temp2.add(temp.get(j).state);
                }
                for (int j = 0; j < transiciones.size(); j++) {
                    if (transiciones.get(j).idNumbers.equals(temp2)) {
                        Found = true;
                        break;
                    }
                }
                if (!Found) {
                    for (int j = 0; j < temp.size(); j++) {
                        temp.get(j).setAdded(true);
                    }
                    for (int j = 0; j < transiciones.size(); j++) {
                        if (transiciones.get(j).idNumbers.equals(idThis)) {
                            for (int k = 0; k < transiciones.get(j).getTransitions().size(); k++) {
                                if (transiciones.get(j).getTransitions().get(k).name.equals(headers.get(i).name)) {
                                    transiciones.get(j).getTransitions().get(k).setWhere(temp2);
                                }
                            }
                        }
                    }
                    //Crear lista nueva de nodos de referencia
                    ArrayList<Node> newList = new ArrayList<Node>();
                    for (int j = 0; j < nodos2.size(); j++) {
                        nodos2.get(j).setAdded(false);
                        newList.add(nodos2.get(j));
                    }
                    generateTransitionTable(temp, newList);
                } else {
                    for (int j = 0; j < transiciones.size(); j++) {
                        if (transiciones.get(j).idNumbers.equals(idThis)) {
                            for (int k = 0; k < transiciones.get(j).getTransitions().size(); k++) {
                                if (transiciones.get(j).getTransitions().get(k).name.equals(headers.get(i).name)) {
                                    transiciones.get(j).getTransitions().get(k).setWhere(temp2);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void graphTransitionTable(String id) {
        String gText = "digraph {\n"
                + "  node [ shape=none fontname=Helvetica ]\n"
                + "  n [ label = <\n"
                + "    <table bgcolor=\"black\">";
        gText += "<tr>\n"
                + "<td bgcolor=\"#ccccff\" rowspan=\"2\">Estados</td>\n"
                + "<td bgcolor=\"#ccccff\" colspan=\"" + transiciones.get(0).getTransitions().size() + "\">Transiciones</td>\n"
                + "</tr>";
        for (int i = 0; i < transiciones.size(); i++) {
            gText += "<tr>\n";
            for (int j = 0; j < transiciones.get(i).getTransitions().size(); j++) {
                gText += "<td bgcolor=\"#ffcccc\">" + transiciones.get(i).getTransitions().get(j).name + "</td>\n";
            }
            gText += "</tr>";
            break;
        }
        //Imprimir tabla de transiciones
        for (int i = 0; i < transiciones.size(); i++) {
            //System.out.println("Estado S" + GeneralStates.get(i).id);
            //System.out.println("-------------Números-------------");
            String temp = "";
            for (int k = 0; k < transiciones.get(i).idNumbers.size(); k++) {
                if (k + 1 == transiciones.get(i).idNumbers.size()) {
                    temp += transiciones.get(i).idNumbers.get(k);
                } else {
                    temp += transiciones.get(i).idNumbers.get(k) + ", ";
                }
            }
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            for (int j = 0; j < transiciones.get(i).numbers.size(); j++) {
                boolean Found = false;
                for (int k = 0; k < numbers.size(); k++) {
                    if (transiciones.get(i).numbers.get(j).state == numbers.get(k)) {
                        Found = true;
                        break;
                    }
                }
                if (!Found) {
                    numbers.add(transiciones.get(i).numbers.get(j).state);
                }
            }
            gText += "<tr>"
                    + "<td bgcolor=\"#ccffcc\">(" + temp + ")={";
            for (int j = 0; j < numbers.size(); j++) {
                if (j + 1 == numbers.size()) {
                    gText += numbers.get(j);
                    break;
                }
                gText += numbers.get(j) + ",";
            }
            gText += "}</td>";
            //System.out.println("\n");
            //System.out.println("-------------Headers-------------");

            for (int j = 0; j < transiciones.get(i).getTransitions().size(); j++) {
                ArrayList<Integer> numbers2 = new ArrayList<Integer>();
                for (int k = 0; k < transiciones.get(i).getTransitions().get(j).getWhere().size(); k++) {
                    boolean Found = false;
                    for (int h = 0; h < numbers2.size(); h++) {
                        if (transiciones.get(i).getTransitions().get(j).getWhere().get(k) == numbers2.get(h)) {
                            Found = true;
                            break;
                        }
                    }
                    if (!Found) {
                        numbers2.add(transiciones.get(i).getTransitions().get(j).getWhere().get(k));
                    }
                }

                if (numbers2.isEmpty()) {
                    gText += "<td bgcolor=\"#ffffcc\"> --- </td>";
                } else {
                    String temp2 = "";
                    for (int k = 0; k < numbers2.size(); k++) {
                        if (k + 1 == numbers2.size()) {
                            temp2 += numbers2.get(k);
                            break;
                        } else {
                            temp2 += numbers2.get(k) + ",";
                        }
                    }
                    gText += "<td bgcolor=\"#ffffcc\"> Mueve={" + temp2 + "}</td>";
                }
            }
            gText += "</tr>";
        }

        gText += "</table>\n"
                + "  > ]\n"
                + "label = \"" + id + "\";"
                + "}";
        imageGenerator(gText, id, 3);
    }

    public void generateAutomata(String text, String id) {
        String[] f = text.split("");
        String[] f2 = removeTheElement(f, 0);
        String[] lexema = removeTheElement(f2, f2.length - 1);
        TransNode3 firstTransition = transiciones.get(0);
        ArrayList<Integer> first = transiciones.get(0).idNumbers;
        ArrayList<Integer> currentState = transiciones.get(0).idNumbers;
        for (int i = 0; i < transiciones.get(0).idNumbers.size(); i++) {
            System.out.println("... " + transiciones.get(0).idNumbers.get(i));
        }
        boolean Error = false;
        for (int i = 0; i < lexema.length; i++) {
            //System.out.println("Se encuentra en el estado " + currentState);
            String temp = lexema[i];
            System.out.println("temp = " + temp);
            int lexCont = 0;
            if ("\\".equals(temp)) {
                System.out.println("Entra1");
                if ("\\\"".equals(temp + lexema[i + 1]) || "\\\'".equals(temp + lexema[i + 1])) {
                    System.out.println("Entra2");
                    for (int j = i + 1; j < lexema.length; j++) {
                        if ("\\\"".equals(lexema[j] + lexema[j + 1]) || "\\\'".equals(lexema[j] + lexema[j + 1])) {
                            temp += lexema[j] + lexema[j + 1];
                            break;
                        }
                        temp += lexema[j];
                        lexCont += 1;
                    }
                } else if ("\\n".equals(temp + lexema[i + 1])) {
                    temp += "n";
                    lexCont += 1;
                }
            }
            if (currentState.equals(first)) {
                boolean Accepted = false;
                for (int j = 0; j < firstTransition.getTransitions().size(); j++) {
                    String[] t = temp.split("");
                    if (t.length >= 2) {
                        if (transitionConversor(firstTransition.getTransitions().get(j).name, temp)) {
                            if (!firstTransition.getTransitions().get(j).getWhere().isEmpty()) {
                                //System.out.println("Entrada: " + temp + " aceptada");
                                Accepted = true;
                                currentState = firstTransition.getTransitions().get(j).getWhere();
                                i += lexCont + 2;
                                break;
                            } else {
                                Error = true;
                            }
                        }
                    } else {
                        if (transitionConversor(firstTransition.getTransitions().get(j).name, temp)) {
                            if (!firstTransition.getTransitions().get(j).getWhere().isEmpty()) {
                                Accepted = true;
                                //System.out.println("Caracter: " + temp + " aceptado");
                                currentState = firstTransition.getTransitions().get(j).getWhere();
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
                for (int j = 0; j < transiciones.size(); j++) {
                    if (transiciones.get(j).idNumbers.equals(currentState)) {
                        if (Accept) {
                            break;
                        }
                        boolean Accepted = false;
                        for (int k = 0; k < transiciones.get(j).getTransitions().size(); k++) {
                            String[] t = temp.split("");
                            if (t.length >= 2) {
                                if (transitionConversor(transiciones.get(j).getTransitions().get(k).name, temp)) {
                                    if (!transiciones.get(j).getTransitions().get(k).getWhere().isEmpty()) {
                                        //System.out.println("Entrada: " + temp + " aceptada");
                                        Accepted = true;
                                        Accept = true;
                                        currentState = transiciones.get(j).getTransitions().get(k).getWhere();
                                        i += lexCont + 2;
                                        break;
                                    } else {
                                        Error = true;
                                    }
                                }
                            } else {
                                if (transitionConversor(transiciones.get(j).getTransitions().get(k).name, temp)) {
                                    if (!transiciones.get(j).getTransitions().get(k).getWhere().isEmpty()) {
                                        Accepted = true;
                                        Accept = true;
                                        //System.out.println("Caracter: " + temp + " aceptado");
                                        currentState = transiciones.get(j).getTransitions().get(k).getWhere();
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
            System.out.println("Lexema aceptado por la Expresión regular");
            jsonElements.add(new jsonData(text, id, true));
        }
    }

}