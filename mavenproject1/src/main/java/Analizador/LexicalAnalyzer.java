package Analizador;

import java.util.*;
import java.util.regex.*;


public class LexicalAnalyzer {

    // ---------------------------------------------------------------
    // Vocabulario del lenguaje
    // ---------------------------------------------------------------
    private static final Set<String> RES   = Set.of("inicio", "fin", "var", "imprimir");
    private static final Set<String> TIPOS = Set.of("entero", "decimal", "texto");

    /**
     * Patrón principal de tokenización.
    */
    private static final Pattern PATRON = Pattern.compile(
            "\"[^\"]*\""          +   // Cadena literal
            "|\\d+\\.\\d+"        +   // Decimal
            "|\\d+"               +   // Entero
            "|[a-zA-Z_][a-zA-Z0-9_]*" +  // Identificador / palabra reservada
            "|=|\\+|-|\\*|/|;|\\(|\\)|,"  // Operadores y puntuación
    );


    /**
     * Tokeniza el código fuente completo.

     */
    public List<Token> analyze(String codigo) {
        List<Token> tokens = new ArrayList<>();
        String[] lineas = codigo.split("\n", -1);

        for (int i = 0; i < lineas.length; i++) {
            Matcher m = PATRON.matcher(lineas[i]);
            while (m.find()) {
                String lex = m.group();
                tokens.add(new Token(lex, clasificar(lex), i + 1, m.start() + 1));
            }
        }
        return tokens;
    }

    // ---------------------------------------------------------------
    // Clasificación interna
    // ---------------------------------------------------------------

    private TokenType clasificar(String lex) {
        if (RES.contains(lex))               return TokenType.PALABRA_RESERVADA;
        if (TIPOS.contains(lex))             return TokenType.TIPO_DATO;
        if (lex.matches("\"[^\"]*\""))        return TokenType.CADENA;
        if (lex.matches("\\d+\\.\\d+"))      return TokenType.DECIMAL;
        if (lex.matches("\\d+"))             return TokenType.ENTERO;
        if (lex.equals("="))                 return TokenType.ASIGNACION;
        if (lex.equals(";"))                 return TokenType.PUNTO_Y_COMA;
        if (lex.equals("("))                 return TokenType.PARENTESIS_IZQ;
        if (lex.equals(")"))                 return TokenType.PARENTESIS_DER;
        if (lex.equals(","))                 return TokenType.COMA;
        if (lex.matches("[+\\-*/]"))         return TokenType.OPERADOR;
        if (lex.matches("[a-zA-Z_][a-zA-Z0-9_]*")) return TokenType.IDENTIFICADOR;
        return TokenType.DESCONOCIDO;
    }
}
