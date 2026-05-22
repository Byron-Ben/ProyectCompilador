package Analizador;

import java.util.*;

/**
 * Analizador Semántico del proyecto "Analizadores".
 */
public class SemanticAnalyzer {

    /**
     * Realiza el análisis semántico sobre la lista de tokens.
     */
    public List<String> analyze(List<Token> tokens) {
        List<String> errores = new ArrayList<>();
        Map<String, Integer> vars = new LinkedHashMap<>();   // nombre → línea de declaración

        for (int i = 0; i < tokens.size() - 2; i++) {
            // Patrón: var <tipo> <identificador>
            if (tokens.get(i).getLexema().equals("var")
                    && tokens.get(i + 1).getTipo() == TokenType.TIPO_DATO
                    && tokens.get(i + 2).getTipo() == TokenType.IDENTIFICADOR) {

                String nombre = tokens.get(i + 2).getLexema();
                int    linea  = tokens.get(i + 2).getLinea();

                if (vars.containsKey(nombre)) {
                    errores.add("Error semántico (línea " + linea + "): variable '"
                            + nombre + "' ya fue declarada en la línea "
                            + vars.get(nombre) + ".");
                } else {
                    vars.put(nombre, linea);
                }
            }
        }

        // Verificar uso de identificadores no declarados
        for (int i = 0; i < tokens.size(); i++) {
            Token t = tokens.get(i);
            // Solo identificadores que NO sean la declaración inmediata (var tipo ID)
            if (t.getTipo() == TokenType.IDENTIFICADOR) {
                boolean esDeclaracion = (i >= 2)
                        && tokens.get(i - 1).getTipo() == TokenType.TIPO_DATO
                        && tokens.get(i - 2).getLexema().equals("var");
                if (!esDeclaracion && !vars.containsKey(t.getLexema())) {
                    errores.add("Error semántico (línea " + t.getLinea()
                            + "): variable '" + t.getLexema() + "' usada pero no declarada.");
                }
            }
        }

        return errores;
    }
}
