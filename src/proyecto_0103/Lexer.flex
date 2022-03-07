package proyecto_0103;
import java_cup.runtime.Symbol;
%%
%class Lexer
%type java_cup.runtime.Symbol
%cup
%full
%line
%column
%char

Caracter = ([A-Za-zÑñ]|[0-9]|[\'\"](\\\"|\\\'|\\\n|[^\"\'\n])*[\'\"])
Cadena_Ll = [{][^{}\'\"\n~]*[}]
Id = ([A-Za-zÑñ][A-Za-zÑñ]|[A-Za-zÑñ][0-9]|[A-Za-zÑñ]\_[A-Za-zÑñ0-9])+([A-Za-zÑñ]|[0-9]|\_[0-9]|\_[A-Za-zÑñ])*
Signo = ([\!-\/]|[\:-\@]|[\´]|[\[-\`]|[\{-\}])
C_signo = {Signo}({Espacio})*[~-]({Espacio})*{Signo}
Guion = [~-]
Coment_m = \<\![^!><]*\!\>
Coment_s = (\/{2})+[^\/\n]*
Espacio = [\s\t\r\f\n]+
Separador = ([%]{2}{Espacio}*)+

%init{ 
    yyline = 1; 
    yycolumn = 1; 
%init} 

%{
    public String error = "";

    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }

    public String getLexicError() {
        return this.error;
    }
%}
%%
{Espacio} {/*Ignore*/}
{Coment_m} {/*Ignore*/}
{Coment_s} {/*Ignore*/}

"CONJ" {System.out.println("CONJ");
return new Symbol(sym.Conj, yyline, yycolumn, yytext());}
"{" {System.out.println("Llave_a = " + yytext());
return new Symbol(sym.Llave_a, yyline, yycolumn, yytext());}
"}" {System.out.println("Llave_c = " + yytext());
return new Symbol(sym.Llave_c, yyline, yycolumn, yytext());}
";" {System.out.println("P_coma = " + yytext());
return new Symbol(sym.P_coma, yyline, yycolumn, yytext());}
":" {System.out.println("D_puntos = " + yytext());
return new Symbol(sym.D_puntos, yyline, yycolumn, yytext());}
"->" {System.out.println("Flecha = " + yytext());
return new Symbol(sym.Flecha, yyline, yycolumn, yytext());}
"," {System.out.println("Coma = " + yytext());
return new Symbol(sym.Coma, yyline, yycolumn, yytext());}
"." {System.out.println("Punto = " + yytext());
return new Symbol(sym.Punto, yyline, yycolumn, yytext());}
"|" {System.out.println("Or = " + yytext());
return new Symbol(sym.Or, yyline, yycolumn, yytext());}
"*" {System.out.println("Asterico = " + yytext());
return new Symbol(sym.Asterisco, yyline, yycolumn, yytext());}
"+" {System.out.println("Mas = " + yytext());
return new Symbol(sym.Mas, yyline, yycolumn, yytext());}
"?" {System.out.println("Interrogacion = " + yytext());
return new Symbol(sym.Interrogacion, yyline, yycolumn, yytext());}

{Cadena_Ll} {System.out.println("Cadena_Ll = " + yytext());
return new Symbol(sym.Cadena_Ll, yyline, yycolumn, yytext());}
{Id} {System.out.println("Id = " + yytext());
return new Symbol(sym.Id, yyline, yycolumn, yytext());}
{Caracter} {System.out.println("Caracter = " + yytext());
return new Symbol(sym.Caracter, yyline, yycolumn, yytext());}
{C_signo} {System.out.println("C_signo = " + yytext());
return new Symbol(sym.C_signo, yyline, yycolumn, yytext());}
{Separador} {System.out.println("Separador = " + yytext());
return new Symbol(sym.Separador, yyline, yycolumn, yytext());}
{Guion} {System.out.println("G_ondulado = " + yytext());
return new Symbol(sym.G_ondulado, yyline, yycolumn, yytext());}

. {
    this.error += "Advertencia : Error léxico con \"" + yytext() + "\" en la fila " + yyline + " y columna: " + yycolumn + "\n";
    Analyzers.errores.add(new Fail(yyline, yycolumn, "Lexico", "Hay un error con el caracter " + yytext(), yytext()));
}