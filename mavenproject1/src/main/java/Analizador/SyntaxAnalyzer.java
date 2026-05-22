package Analizador;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Analizador Sintáctico .
 */
public class SyntaxAnalyzer {

    /**
     * Ejecuta el análisis sintáctico sobre el código fuente.
     */
    public List<String> analyze(String codigoFuente) {

        try {

            Lexer lexer = new Lexer(new StringReader(codigoFuente));

            // parser generado por CUP (minúscula)
            parser parserObj = new parser(lexer);

            parserObj.parse();

            return parserObj.erroresSintacticos;

        } catch (Exception e) {

            List<String> errores = new ArrayList<>();
            errores.add("Error sintáctico: " + e.getMessage());

            return errores;
        }
    }
}