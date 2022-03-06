package proyecto_0103;

/**
 *
 * @author Alexis
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        String ruta = "src/proyecto_0103/ThompsonTree/";

        //Analizador Léxico
        //String[] aLexico = {ruta + "Lexer3.flex", "-d", ruta};
        //jflex.Main.generate(aLexico);

        //Analizador Sintáctico
        String[] aSintactico = {"-destdir", ruta, "-parser", "Automata2", ruta + "Automata2.cup"};
        java_cup.Main.main(aSintactico);
    }

}
