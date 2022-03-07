package proyecto_0103;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 *
 * @author Alexis
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }
        Screen s = new Screen();
        s.setVisible(true);
        /*String ruta = "src/proyecto_0103/";

        //Analizador Léxico
        String[] aLexico = {ruta + "Lexer.flex", "-d", ruta};
        jflex.Main.generate(aLexico);

        //Analizador Sintáctico
        String[] aSintactico = {"-destdir", ruta, "-parser", "Syntax", ruta + "Syntax.cup"};
        java_cup.Main.main(aSintactico);*/
    }

}
