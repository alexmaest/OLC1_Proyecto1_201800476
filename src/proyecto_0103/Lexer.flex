package proyecto_0103;
import java_cup.runtime.Symbol;
%%
%class Lexer
%type java_cup.runtime.Symbol
%cup
%full
%line
%char

Cadena = [\'\"][^\'\"\n]*[\'\"]
Cadena_Ll = [{][^{}\'\"\n]*[}]
Letra = [A-Za-zÑñ]
Numero = [0-9]
Id = ({Letra}{Letra}|{Letra}{Numero}|{Letra}\_[A-Za-zÑñ0-9])+({Letra}|{Numero}|\_{Numero}|\_{Letra})*
Signo = ([\!-\/]+|[\:-\@]+|[\´]+|[\[-\`]+|[\{-\}]+)
C_signo = {Signo}[~]{Signo}
Coment_m = \<\![^!><]*\!\>
Coment_s = (\/{2})+[^\/\n]*
Espacio = [\s\t\r\f\n]+
%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%
{Espacio} {/*Ignore*/}
{Coment_m} {/*Ignore*/}
{Coment_s} {/*Ignore*/}

"CONJ" {System.out.println("CONJ");
return new Symbol(sym.Conj, yychar, yyline, yytext());}
"{" {System.out.println("Llave_a = " + yytext());
return new Symbol(sym.Llave_a, yychar, yyline, yytext());}
"}" {System.out.println("Llave_c = " + yytext());
return new Symbol(sym.Llave_c, yychar, yyline, yytext());}
";" {System.out.println("P_coma = " + yytext());
return new Symbol(sym.P_coma, yychar, yyline, yytext());}
":" {System.out.println("D_puntos = " + yytext());
return new Symbol(sym.D_puntos, yychar, yyline, yytext());}
"%%" {System.out.println("Separador = " + yytext());
return new Symbol(sym.Separador, yychar, yyline, yytext());}
"->" {System.out.println("Flecha = " + yytext());
return new Symbol(sym.Flecha, yychar, yyline, yytext());}
"~" {System.out.println("G_ondulado = " + yytext());
return new Symbol(sym.G_ondulado, yychar, yyline, yytext());}
"," {System.out.println("Coma = " + yytext());
return new Symbol(sym.Coma, yychar, yyline, yytext());}
"." {System.out.println("Punto = " + yytext());
return new Symbol(sym.Punto, yychar, yyline, yytext());}
"|" {System.out.println("Or = " + yytext());
return new Symbol(sym.Or, yychar, yyline, yytext());}
"*" {System.out.println("Asterico = " + yytext());
return new Symbol(sym.Asterisco, yychar, yyline, yytext());}
"+" {System.out.println("Mas = " + yytext());
return new Symbol(sym.Mas, yychar, yyline, yytext());}
"?" {System.out.println("Interrogacion = " + yytext());
return new Symbol(sym.Interrogacion, yychar, yyline, yytext());}
"\'" {System.out.println("Comilla_simple = " + yytext());
return new Symbol(sym.Comilla_simple, yychar, yyline, yytext());}
"\"" {System.out.println("Comilla_doble = " + yytext());
return new Symbol(sym.Comilla_doble, yychar, yyline, yytext());}

{Cadena} {System.out.println("Cadena = " + yytext());
return new Symbol(sym.Cadena, yychar, yyline, yytext());}
{Cadena_Ll} {System.out.println("Cadena_Ll = " + yytext());
return new Symbol(sym.Cadena_Ll, yychar, yyline, yytext());}
{Id} {System.out.println("Id = " + yytext());
return new Symbol(sym.Id, yychar, yyline, yytext());}
{Numero} {System.out.println("Numero = " + yytext());
return new Symbol(sym.Numero, yychar, yyline, yytext());}
{Letra} {System.out.println("Letra = " + yytext());
return new Symbol(sym.Letra, yychar, yyline, yytext());}
{C_signo} {System.out.println("C_signo = " + yytext());
return new Symbol(sym.C_signo, yychar, yyline, yytext());}

. {
    System.out.println("Advertencia : Error léxico con \"" + yytext() + "\" en la fila " + yyline + " y columna: " + yycolumn + "\n");
}