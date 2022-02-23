package proyecto_0103;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Alexis
 */
public class AutomataGenerator {

    ArrayList<InsideTableNode> siguientes;
    ArrayList<TransNode> GeneralStates;

    public String generateTree() {
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
        imageGenerator(gText,"");
        return gText;
    }

    public void generateNextTable() {
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
                        if (already == false) {
                            for (int l = 0; l < nexts.length; l++) {
                                aux.add(nexts[l]);
                            }
                            siguientes.add(new InsideTableNode(variables.get(j).name, variables.get(j).indexS, aux));
                        }
                    }
                }
            }
        }

        for (int i = 0; i < variables.size(); i++) {
            if ("#".equals(variables.get(i).name)) {
                siguientes.add(new InsideTableNode(variables.get(i).name, variables.get(i).indexS, null));
            }
        }

        //imprimir tabla de siguientes
        System.out.println("SIZE: " + siguientes.size());
        for (int i = 0; i < siguientes.size(); i++) {
            System.out.println(siguientes.get(i).name + " " + siguientes.get(i).indexI);
            if (siguientes.get(i).nexts != null) {
                for (int j = 0; j < siguientes.get(i).nexts.size(); j++) {
                    System.out.println(siguientes.get(i).nexts.get(j));
                }
            }
        }
    }

    public void generateTransitionTable() {
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

        //Imprimir tabla de transiciones
        for (int i = 0; i < GeneralStates.size(); i++) {
            System.out.println("Estado S" + GeneralStates.get(i).id);
            System.out.println("-------------Números-------------");
            for (int j = 0; j < GeneralStates.get(i).numbers.size(); j++) {
                System.out.print(GeneralStates.get(i).numbers.get(j).number + " " + GeneralStates.get(i).numbers.get(j).scanned);
            }
            System.out.println("\n");
            System.out.println("-------------Headers-------------");
            for (int j = 0; j < GeneralStates.get(i).transitions.size(); j++) {
                System.out.println(GeneralStates.get(i).transitions.get(j).name + " -> " + GeneralStates.get(i).transitions.get(j).where);
            }
            System.out.println("---------------------------------");
        }
    }

    public void generateAutomata(String text) {
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
            System.out.println("Se encuentra en el estado " + currentState);
            String temp = lexema[i];
            int lexCont = 0;
            if ("\\".equals(temp)) {
                if ("\\\"".equals(temp + lexema[i + 1]) || "\\\'".equals(temp + lexema[i + 1])) {
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
            if (currentState == 1) {
                boolean Accepted = false;
                for (int j = 0; j < GeneralStates.get(currentState - 1).transitions.size(); j++) {
                    String[] t = temp.split("");
                    if (t.length >= 2) {
                        if (transitionConversor(GeneralStates.get(currentState - 1).transitions.get(j).name, temp)) {
                            if (GeneralStates.get(currentState - 1).transitions.get(j).where != 0) {
                                System.out.println("Entrada: " + temp + " aceptada");
                                Accepted = true;
                                currentState = GeneralStates.get(currentState - 1).transitions.get(j).where;
                                i += lexCont + 2;
                                break;
                            } else {
                                Error = true;
                            }
                        }
                    } else {
                        if (transitionConversor(GeneralStates.get(currentState - 1).transitions.get(j).name, temp)) {
                            if (GeneralStates.get(currentState - 1).transitions.get(j).where != 0) {
                                Accepted = true;
                                System.out.println("Caracter: " + temp + " aceptado");
                                currentState = GeneralStates.get(currentState - 1).transitions.get(j).where;
                                break;
                            } else {
                                Error = true;
                            }
                        }
                    }
                }
                if (Accepted == false) {
                    System.out.println("Caracter: " + temp + " denegado");
                    Error = true;
                    break;
                }
            } else {
                for (int j = 0; j < GeneralStates.size(); j++) {
                    if (GeneralStates.get(j).id == currentState) {
                        boolean Accepted = false;
                        for (int k = 0; k < GeneralStates.get(currentState - 1).transitions.size(); k++) {
                            String[] t = temp.split("");
                            if (t.length >= 2) {
                                if (transitionConversor(GeneralStates.get(currentState - 1).transitions.get(k).name, temp)) {
                                    if (GeneralStates.get(currentState - 1).transitions.get(j).where != 0) {
                                        System.out.println("Entrada: " + temp + " aceptada");
                                        Accepted = true;
                                        currentState = GeneralStates.get(currentState - 1).transitions.get(j).where;
                                        i += lexCont + 2;
                                        break;
                                    } else {
                                        Error = true;
                                    }
                                }
                            } else {
                                if (transitionConversor(GeneralStates.get(currentState - 1).transitions.get(k).name, temp)) {
                                    if (GeneralStates.get(currentState - 1).transitions.get(j).where != 0) {
                                        Accepted = true;
                                        System.out.println("Caracter: " + temp + " aceptado");
                                        currentState = GeneralStates.get(currentState - 1).transitions.get(j).where;
                                        break;
                                    } else {
                                        Error = true;
                                    }
                                }
                            }
                        }
                        if (Accepted == false) {
                            System.out.println("Caracter: " + temp + " denegado");
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
        } else {
            System.out.println("Lexema aceptado por la Expresión regular");
        }
    }

    public boolean transitionConversor(String conj, String caracter) {
        ArrayList<Instrucciones> ins = Analyzers.instrucciones;
        String[] c0 = caracter.split("");
        if (c0.length >= 2) {
            String[] s = conj.split("");
            String[] s2 = removeTheElement(s, 0);
            String[] s3 = removeTheElement(s2, s2.length - 1);
            String x = "";
            for (int i = 0; i < s3.length; i++) {
                x += s3[i];
            }
            return x.equals(caracter);
            /*else {
            String[] c = conj.split("");
            if ("\"".equals(c[0]) || "\'".equals(c[0])) {
                String[] f = removeTheElement(c, 0);
                String[] f2 = removeTheElement(f, f.length - 1);
                if ("\\".equals(f2[0])) {
                    if ((f2[0] + f2[1]).equals(caracter)) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    if (caracter.equals(f2[0])) {
                        return true;
                    } else {
                        return false;
                    }
                }*/
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
                            for (int j = 0; j < ins.get(i).cadena.size(); j++) {
                                if (ins.get(i).cadena.get(j).getListaInst().size() == 3) {
                                    if (",".equals(ins.get(i).cadena.get(j).getListaInst().get(1))) {
                                        char character1 = caracter.charAt(0);
                                        int character = (int) character1;

                                        char character2 = ins.get(i).cadena.get(j).getListaInst().get(0).charAt(0);
                                        int limit = (int) character2;

                                        char character3 = ins.get(i).cadena.get(j).getListaInst().get(2).charAt(0);
                                        int limit2 = (int) character3;
                                        if (character == limit || character == limit2) {
                                            return true;
                                        } else {
                                            return false;
                                        }
                                    } else {
                                        char character1 = caracter.charAt(0);
                                        int character = (int) character1;

                                        char character2 = ins.get(i).cadena.get(j).getListaInst().get(0).charAt(0);
                                        int limit = (int) character2;

                                        char character3 = ins.get(i).cadena.get(j).getListaInst().get(2).charAt(0);
                                        int limit2 = (int) character3;
                                        if (character >= limit && character <= limit2) {
                                            return true;
                                        } else {
                                            return false;
                                        }
                                    }
                                } else {
                                    boolean Found = false;
                                    for (int k = 0; k < ins.get(i).cadena.get(j).getListaInst().size(); k += 2) {
                                        if (ins.get(i).cadena.get(j).getListaInst().get(k).equals(caracter)) {
                                            Found = true;
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
            }
        }
        return false;
    }

    public String[] removeTheElement(String[] arr, int index) {
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

    public static void imageGenerator(String text, String name) {
        createFile(text, name);
        ProcessBuilder process = null;
        process = new ProcessBuilder("dot", "-Tpng", "-o", name + ".png", name + ".dot");
        process.redirectErrorStream(true);
        try {
            process.start();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public static void createFile(String text, String name) {
        FileWriter f = null;
        PrintWriter textG = null;
        try {
            String cType = name + ".dot";
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
}
