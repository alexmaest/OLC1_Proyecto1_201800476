package proyecto_0103;

import java.io.BufferedReader;
import java.io.StringReader;
import java_cup.runtime.Symbol;

/**
 *
 * @author Alexis
 */
public class Analyzers {

    String error = "";

    public Analyzers() {
    }

    public boolean Analize(String text) {
        this.error = "";
        Lexer l = null;
        Syntax s = null;
        try {
            l = new Lexer(new BufferedReader(new StringReader(text)));
            s = new Syntax(l);
            s.parse();
            String lexicError = l.getLexicError();
            String syntaxError = s.getSyntaxError();

            if ("".equals(lexicError) && "".equals(syntaxError)) {
                System.out.println("Analisis finalizado mi pai");
                return true;
            } else {
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

    public String Error() {
        return this.error;
    }
}
