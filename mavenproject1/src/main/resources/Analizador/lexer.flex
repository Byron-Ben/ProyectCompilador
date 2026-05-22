
package Analizador;

import java_cup.runtime.*;
import java.util.ArrayList;
import java.util.List;

%%

%class       Lexer
%unicode
%line
%column
%cup

%{
    /* Lista pública de tokens para mostrar en la tabla de la GUI */
    public final List<Token> tokenList = new ArrayList<>();

    /** Crea un Symbol con valor Token y lo registra en tokenList */
    private Symbol sym(int type, TokenType tt) {
        Token t = new Token(yytext(), tt, yyline + 1, yycolumn + 1);
        tokenList.add(t);
        return new Symbol(type, yyline, yycolumn, t);
    }

    /** Symbol sin valor semántico (para tokens sin datos extra) */
    private Symbol sym(int type, TokenType tt, Object val) {
        Token t = new Token(yytext(), tt, yyline + 1, yycolumn + 1);
        tokenList.add(t);
        return new Symbol(type, yyline, yycolumn, val);
    }
%}

/* ---- Definiciones de clase de caracteres ---- */
Letra       = [a-zA-Z_]
Digito      = [0-9]
Alfanum     = ({Letra}|{Digito})
Espacios    = [ \t\r\n]+

%%

/* ---- Palabras reservadas ---- */
"inicio"     { return sym(sym.INICIO,      TokenType.PALABRA_RESERVADA); }
"fin"        { return sym(sym.FIN,         TokenType.PALABRA_RESERVADA); }
"var"        { return sym(sym.VAR,         TokenType.PALABRA_RESERVADA); }
"si"         { return sym(sym.SI,    TokenType.PALABRA_RESERVADA); }
"sino"       { return sym(sym.SINO,    TokenType.PALABRA_RESERVADA); }
"mientras"   { return sym(sym.MIENTRAS,    TokenType.PALABRA_RESERVADA); }
"para"       { return sym(sym.PARA,    TokenType.PALABRA_RESERVADA); }
"segun"      { return sym(sym.SEGUN, TokenType.PALABRA_RESERVADA); }
"caso"       { return sym(sym.CASO, TokenType.PALABRA_RESERVADA); }
"defecto"    { return sym(sym.DEFECTO, TokenType.PALABRA_RESERVADA); }
"romper"     { return sym(sym.ROMPER, TokenType.PALABRA_RESERVADA); }
"imprimir"   { return sym(sym.IMPRIMIR,    TokenType.PALABRA_RESERVADA); }

/* ---- Tipos de dato ---- */
"entero"     { return sym(sym.TIPO_ENTERO, TokenType.TIPO_DATO); }
"decimal"    { return sym(sym.TIPO_DECIMAL,TokenType.TIPO_DATO); }
"texto"      { return sym(sym.TIPO_TEXTO,  TokenType.TIPO_DATO); }

/* ---- Literales ---- */
{Digito}+"."{Digito}+   { return sym(sym.DECIMAL, TokenType.DECIMAL, Double.parseDouble(yytext())); }
{Digito}+               { return sym(sym.ENTERO,  TokenType.ENTERO,  Integer.parseInt(yytext()));   }
\"[^\"]*\"              { return sym(sym.CADENA,  TokenType.CADENA,  yytext());                     }

/* ---- Identificadores ---- */
{Letra}{Alfanum}*       { return sym(sym.IDENTIFICADOR, TokenType.IDENTIFICADOR, yytext()); }

/* ---- Operadores y puntuación ---- */
"="   { return sym(sym.ASIGNACION,     TokenType.ASIGNACION);    }
"+"   { return sym(sym.MAS,            TokenType.OPERADOR);       }
"-"   { return sym(sym.MENOS,          TokenType.OPERADOR);       }
"*"   { return sym(sym.MULT,           TokenType.OPERADOR);       }
"/"   { return sym(sym.DIV,            TokenType.OPERADOR);       }
";"   { return sym(sym.PUNTO_Y_COMA,   TokenType.PUNTO_Y_COMA);   }
"("   { return sym(sym.PARENTESIS_IZQ, TokenType.PARENTESIS_IZQ); }
")"   { return sym(sym.PARENTESIS_DER, TokenType.PARENTESIS_DER); }
","   { return sym(sym.COMA,           TokenType.COMA);           }
","   { return sym(sym.DOS_PUNTOS,           TokenType.SIMBOLO);  }

/* ---- Ignorar espacios en blanco ---- */
{Espacios}   { /* ignorar */ }

/* ---- Token desconocido ---- */
.    {
        Token t = new Token(yytext(), TokenType.DESCONOCIDO, yyline + 1, yycolumn + 1);
        tokenList.add(t);
        /* No retorna Symbol — el parser no lo reconocerá y generará error */
     }
