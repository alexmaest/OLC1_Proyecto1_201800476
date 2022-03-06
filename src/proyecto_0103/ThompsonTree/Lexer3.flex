package proyecto_0103.ThompsonTree;
import java_cup.runtime.Symbol;
%%
%class Lexer3
%type java_cup.runtime.Symbol
%cup
%full
%line
%char

Cadena = [\'\"](\\\"|\\\'|\\\n|[^\"\'\n])*[\'\"]
Cadena_Ll = [{][^{}\'\"\n]*[}]
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

{Cadena} {System.out.println("Cadena = " + yytext());
return new Symbol(sym.Cadena, yychar, yyline, yytext());}
{Cadena_Ll} {System.out.println("Cadena_Ll = " + yytext());
return new Symbol(sym.Cadena_Ll, yychar, yyline, yytext());}

. {
System.out.println("");
}