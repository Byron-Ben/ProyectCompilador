package Analizador;

public class Token {
    private final String lexema;
    private final TokenType tipo;
    private final int linea;
    private final int columna;

    public Token(String lexema, TokenType tipo, int linea, int columna) {
        this.lexema  = lexema;
        this.tipo    = tipo;
        this.linea   = linea;
        this.columna = columna;
    }

    public String    getLexema()  { return lexema;  }
    public TokenType getTipo()    { return tipo;    }
    public int       getLinea()   { return linea;   }
    public int       getColumna() { return columna; }
}
