


package Analizador;

import java_cup.runtime.*;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("fallthrough")
class Lexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;


  private static final int ZZ_LEXSTATE[] = {
     0, 0
  };


  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\37\u0100\1\u0200\267\u0100\10\u0300\u1020\u0100";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }



  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\2\1\2\2\1\1\22\0\1\1\1\0\1\3"+
    "\5\0\1\4\1\5\1\6\1\7\1\10\1\11\1\12"+
    "\1\13\12\14\1\0\1\15\1\0\1\16\3\0\32\17"+
    "\4\0\1\17\1\0\1\20\1\17\1\21\1\22\1\23"+
    "\1\24\2\17\1\25\2\17\1\26\1\27\1\30\1\31"+
    "\1\32\1\17\1\33\1\17\1\34\1\17\1\35\1\17"+
    "\1\36\2\17\12\0\1\2\u01a2\0\2\2\326\0\u0100\2";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[1024];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       
    int j = offset;  
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

 
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\1\1\3\1\4\1\5\1\6"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\7\15\1\0"+
    "\1\16\1\0\7\15\1\17\2\15\1\20\3\15\1\21"+
    "\11\15\1\22\1\15\1\23\1\15\1\24\1\25\1\15"+
    "\1\26";

  private static int [] zzUnpackAction() {
    int [] result = new int[56];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       
    int j = offset;
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\37\0\76\0\135\0\37\0\37\0\37\0\37"+
    "\0\37\0\37\0\37\0\174\0\37\0\37\0\233\0\272"+
    "\0\331\0\370\0\u0117\0\u0136\0\u0155\0\135\0\37\0\u0174"+
    "\0\u0193\0\u01b2\0\u01d1\0\u01f0\0\u020f\0\u022e\0\u024d\0\u0174"+
    "\0\u026c\0\u028b\0\233\0\u02aa\0\u02c9\0\u02e8\0\233\0\u0307"+
    "\0\u0326\0\u0345\0\u0364\0\u0383\0\u03a2\0\u03c1\0\u03e0\0\u03ff"+
    "\0\233\0\u041e\0\233\0\u043d\0\233\0\233\0\u045c\0\233";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[56];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  
    int j = offset;  
    int l = packed.length() - 1;
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  private static final int [] ZZ_TRANS = zzUnpacktrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\0\1\4\1\5\1\6\1\7\1\10"+
    "\1\11\1\12\1\2\1\13\1\14\1\15\1\16\3\17"+
    "\1\20\1\21\1\22\1\23\6\17\1\24\1\25\1\17"+
    "\40\0\1\3\35\0\3\26\1\27\33\26\12\0\1\30"+
    "\1\0\1\14\36\0\1\17\2\0\20\17\14\0\1\17"+
    "\2\0\4\17\1\31\13\17\14\0\1\17\2\0\11\17"+
    "\1\32\6\17\14\0\1\17\2\0\6\17\1\33\11\17"+
    "\14\0\1\17\2\0\10\17\1\34\1\35\6\17\14\0"+
    "\1\17\2\0\4\17\1\36\13\17\14\0\1\17\2\0"+
    "\1\17\1\37\16\17\14\0\1\40\36\0\1\17\2\0"+
    "\2\17\1\41\15\17\14\0\1\17\2\0\15\17\1\42"+
    "\2\17\14\0\1\17\2\0\11\17\1\43\6\17\14\0"+
    "\1\17\2\0\13\17\1\44\4\17\14\0\1\17\2\0"+
    "\6\17\1\45\11\17\14\0\1\17\2\0\17\17\1\46"+
    "\14\0\1\17\2\0\14\17\1\47\3\17\14\0\1\17"+
    "\2\0\6\17\1\50\11\17\14\0\1\17\2\0\4\17"+
    "\1\51\13\17\14\0\1\17\2\0\14\17\1\52\3\17"+
    "\14\0\1\17\2\0\2\17\1\53\15\17\14\0\1\17"+
    "\2\0\15\17\1\54\2\17\14\0\1\17\2\0\10\17"+
    "\1\55\7\17\14\0\1\17\2\0\14\17\1\56\3\17"+
    "\14\0\1\17\2\0\6\17\1\57\11\17\14\0\1\17"+
    "\2\0\6\17\1\60\11\17\14\0\1\17\2\0\12\17"+
    "\1\61\5\17\14\0\1\17\2\0\1\17\1\62\16\17"+
    "\14\0\1\17\2\0\12\17\1\63\5\17\14\0\1\17"+
    "\2\0\10\17\1\64\7\17\14\0\1\17\2\0\12\17"+
    "\1\65\5\17\14\0\1\17\2\0\7\17\1\66\10\17"+
    "\14\0\1\17\2\0\6\17\1\67\11\17\14\0\1\17"+
    "\2\0\14\17\1\70\3\17";

  private static int [] zzUnpacktrans() {
    int [] result = new int[1147];
    int offset = 0;
    offset = zzUnpacktrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpacktrans(String packed, int offset, int [] result) {
    int i = 0;       
    int j = offset;  
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }



  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;


  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };


  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\2\1\7\11\1\1\2\11\7\1\1\0"+
    "\1\11\1\0\40\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[56];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       
    int j = offset;  
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

 
  private java.io.Reader zzReader;
  private int zzState;
  private int zzLexicalState = YYINITIAL;
  private char zzBuffer[] = new char[Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen())];
  private int zzMarkedPos;
  private int zzCurrentPos;
  private int zzStartRead;
  private int zzEndRead;
  private boolean zzAtEOF;
  private int zzFinalHighSurrogate = 0;
  private int yyline;
  private int yycolumn;
  @SuppressWarnings("unused")
  private long yychar;
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;
  private boolean zzEOFDone;


    public final List<Token> tokenList = new ArrayList<>();

    private Symbol sym(int type, TokenType tt) {
        Token t = new Token(yytext(), tt, yyline + 1, yycolumn + 1);
        tokenList.add(t);
        return new Symbol(type, yyline, yycolumn, t);
    }

    private Symbol sym(int type, TokenType tt, Object val) {
        Token t = new Token(yytext(), tt, yyline + 1, yycolumn + 1);
        tokenList.add(t);
        return new Symbol(type, yyline, yycolumn, val);
    }



  Lexer(java.io.Reader in) {
    this.zzReader = in;
  }


  private int zzMaxBufferLen() {
    return Integer.MAX_VALUE;
  }

  private boolean zzCanGrow() {
    return true;
  }

  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }


  private boolean zzRefill() throws java.io.IOException {


    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate && zzCanGrow()) {
      char newBuffer[] = new char[Math.min(zzBuffer.length * 2, zzMaxBufferLen())];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }


    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

  
    if (numRead == 0) {
      if (requested == 0) {
        throw new java.io.EOFException("Scan buffer limit reached ["+zzBuffer.length+"]");
      }
      else {
        throw new java.io.IOException(
            "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
      }
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { 
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    
          int c = zzReader.read(); 
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      
      return false;
    }


    return true;
  }



  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; 
    zzEndRead = zzStartRead; 

    if (zzReader != null) {
      zzReader.close();
    }
  }



  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    int initBufferSize = Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen());
    if (zzBuffer.length > initBufferSize) {
      zzBuffer = new char[initBufferSize];
    }
  }


  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }



  public final boolean yyatEOF() {
    return zzAtEOF;
  }



  public final int yystate() {
    return zzLexicalState;
  }


  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }



  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }



  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }

  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }



  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
  yyclose();    }
  }




  @Override  public java_cup.runtime.Symbol next_token() throws java.io.IOException
  {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {

        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];


      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {

            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();

            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }


      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          { return new java_cup.runtime.Symbol(sym.EOF); }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { Token t = new Token(yytext(), TokenType.DESCONOCIDO, yyline + 1, yycolumn + 1);
        tokenList.add(t);
     
            }
       
          case 23: break;
          case 2:
            { 
            }
        
          case 24: break;
          case 3:
            { return sym(sym.PARENTESIS_IZQ, TokenType.PARENTESIS_IZQ);
            }
         
          case 25: break;
          case 4:
            { return sym(sym.PARENTESIS_DER, TokenType.PARENTESIS_DER);
            }
       
          case 26: break;
          case 5:
            { return sym(sym.MULT,           TokenType.OPERADOR);
            }
      
          case 27: break;
          case 6:
            { return sym(sym.MAS,            TokenType.OPERADOR);
            }
   
          case 28: break;
          case 7:
            { return sym(sym.COMA,           TokenType.COMA);
            }
        
          case 29: break;
          case 8:
            { return sym(sym.MENOS,          TokenType.OPERADOR);
            }
     
          case 30: break;
          case 9:
            { return sym(sym.DIV,            TokenType.OPERADOR);
            }
         
          case 31: break;
          case 10:
            { return sym(sym.ENTERO,  TokenType.ENTERO,  Integer.parseInt(yytext()));
            }
        
          case 32: break;
          case 11:
            { return sym(sym.PUNTO_Y_COMA,   TokenType.PUNTO_Y_COMA);
            }
        
          case 33: break;
          case 12:
            { return sym(sym.ASIGNACION,     TokenType.ASIGNACION);
            }
        
          case 34: break;
          case 13:
            { return sym(sym.IDENTIFICADOR, TokenType.IDENTIFICADOR, yytext());
            }
      
          case 35: break;
          case 14:
            { return sym(sym.CADENA,  TokenType.CADENA,  yytext());
            }
       
          case 36: break;
          case 15:
            { return sym(sym.DECIMAL, TokenType.DECIMAL, Double.parseDouble(yytext()));
            }
        
          case 37: break;
          case 16:
            { return sym(sym.FIN,         TokenType.PALABRA_RESERVADA);
            }
       
          case 38: break;
          case 17:
            { return sym(sym.VAR,         TokenType.PALABRA_RESERVADA);
            }
     
          case 39: break;
          case 18:
            { return sym(sym.TIPO_TEXTO,  TokenType.TIPO_DATO);
            }
   
          case 40: break;
          case 19:
            { return sym(sym.TIPO_ENTERO, TokenType.TIPO_DATO);
            }
 
          case 41: break;
          case 20:
            { return sym(sym.INICIO,      TokenType.PALABRA_RESERVADA);
            }
  
          case 42: break;
          case 21:
            { return sym(sym.TIPO_DECIMAL,TokenType.TIPO_DATO);
            }
    
          case 43: break;
          case 22:
            { return sym(sym.IMPRIMIR,    TokenType.PALABRA_RESERVADA);
            }
    
          case 44: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
