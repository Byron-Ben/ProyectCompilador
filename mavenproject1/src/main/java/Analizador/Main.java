package Analizador;

import java.awt.*;
import java.io.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new MainFrame().setVisible(true));
    }

    public static class MainFrame extends JFrame {

        private final JTextArea codeArea = new JTextArea();
        private final JTextArea consoleArea = new JTextArea();
        private final JTable tokenTable = new JTable();

        private final JLabel lblTokens = new JLabel("0");
        private final JLabel lblLex = new JLabel("0");
        private final JLabel lblSyn = new JLabel("0");
        private final JLabel lblSem = new JLabel("0");

        public MainFrame() {

            setTitle("Analizadores — JFlex + JCup v3.0");
            setSize(1400, 850);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);

            initUI();
        }

        private JButton crearBoton(String texto) {
            JButton b = new JButton(texto);
            b.setFocusPainted(false);
            b.setBackground(new Color(37, 99, 235));
            b.setForeground(Color.WHITE);
            b.setFont(new Font("Segoe UI", Font.BOLD, 13));
            return b;
        }

        private void estilizar(JTextArea a) {
            a.setBackground(new Color(3, 7, 18));
            a.setForeground(new Color(229, 231, 235));
            a.setCaretColor(Color.WHITE);
            a.setFont(new Font("Consolas", Font.PLAIN, 15));
        }

        private void initUI() {

            setLayout(new BorderLayout(10, 10));
            ((JComponent) getContentPane())
                    .setBorder(new EmptyBorder(10,10,10,10));

            JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
            top.setBackground(new Color(2, 6, 23));

            JButton analizar = crearBoton("Analizar");
            JButton guardar = crearBoton("Guardar");
            JButton abrir = crearBoton("Explorar");
            JButton limpiar = crearBoton("Limpiar");

            JLabel titulo = new JLabel("ANALIZADORES");
            titulo.setForeground(new Color(96,165,250));
            titulo.setFont(new Font("Segoe UI", Font.BOLD, 28));

            top.add(titulo);
            top.add(analizar);
            top.add(guardar);
            top.add(abrir);
            top.add(limpiar);

            estilizar(codeArea);
            estilizar(consoleArea);
            consoleArea.setEditable(false);

            JPanel stats = new JPanel(new GridLayout(4,2,8,8));
            stats.setBackground(new Color(17,24,39));

            addStat(stats,"Tokens",lblTokens);
            addStat(stats,"Errores Léxicos",lblLex);
            addStat(stats,"Errores Sintácticos",lblSyn);
            addStat(stats,"Errores Semánticos",lblSem);

            JPanel right = new JPanel(new BorderLayout(10,10));
            right.setBackground(new Color(2,6,23));

            right.add(new JScrollPane(tokenTable),BorderLayout.CENTER);
            right.add(stats,BorderLayout.SOUTH);

            // 🔥 CONSOLA ARREGLADA (VISIBLE)
            JSplitPane left = new JSplitPane(
                    JSplitPane.VERTICAL_SPLIT,
                    new JScrollPane(codeArea),
                    new JScrollPane(consoleArea)
            );

            left.setDividerLocation(450);

            JSplitPane split = new JSplitPane(
                    JSplitPane.HORIZONTAL_SPLIT,
                    left,
                    right
            );

            split.setDividerLocation(850);

            add(top,BorderLayout.NORTH);
            add(split,BorderLayout.CENTER);

            analizar.addActionListener(e -> analizar());
            guardar.addActionListener(e -> guardar());
            abrir.addActionListener(e -> abrir());
            limpiar.addActionListener(e -> limpiar());

            codeArea.setText("inicio\nvar entero x = 10;\nvar decimal pi = 3.14;\nimprimir(x);\nfin");
        }

        private void analizar() {

            String codigo = codeArea.getText();
            int erroresLex = 0;

            try {

                Lexer lexer = new Lexer(new StringReader(codigo));
                java_cup.runtime.Symbol s;

                while ((s = lexer.next_token()).sym != sym.EOF) {}

                List<Token> tokens = lexer.tokenList;

                for (Token t : tokens)
                    if (t.getTipo() == TokenType.DESCONOCIDO)
                        erroresLex++;

                SyntaxAnalyzer syn = new SyntaxAnalyzer();
                List<String> erroresSyn = syn.analyze(codigo);

                SemanticAnalyzer sem = new SemanticAnalyzer();
                List<String> erroresSem = sem.analyze(tokens);

                DefaultTableModel model = new DefaultTableModel(
                        new Object[]{"Tipo","Contenido","Línea"},0
                );

                for (Token t : tokens)
                    model.addRow(new Object[]{
                            "TOKEN",
                            t.getLexema()+" ("+t.getTipo()+")",
                            t.getLinea()
                    });

                for (String e : erroresSyn)
                    model.addRow(new Object[]{"SINTÁCTICO",e,"-"});

                for (String e : erroresSem)
                    model.addRow(new Object[]{"SEMÁNTICO",e,"-"});

                tokenTable.setModel(model);

                lblTokens.setText(String.valueOf(tokens.size()));
                lblLex.setText(String.valueOf(erroresLex));
                lblSyn.setText(String.valueOf(erroresSyn.size()));
                lblSem.setText(String.valueOf(erroresSem.size()));

                StringBuilder sb = new StringBuilder();

                sb.append("════ RESULTADOS ════\n\n");
                sb.append("[LEX] Tokens: ").append(tokens.size())
                        .append(" | Errores: ").append(erroresLex).append("\n\n");

                sb.append("[SYN] Errores: ").append(erroresSyn.size()).append("\n");
                sb.append("[SEM] Errores: ").append(erroresSem.size()).append("\n");

                consoleArea.setText(sb.toString());

            } catch (Exception e) {
                consoleArea.setText("Error:\n" + e.getMessage());
            }
        }

        private void limpiar() {

            codeArea.setText("");
            consoleArea.setText("");

            tokenTable.setModel(new DefaultTableModel(
                    new Object[]{"Tipo","Contenido","Línea"},0));

            lblTokens.setText("0");
            lblLex.setText("0");
            lblSyn.setText("0");
            lblSem.setText("0");
        }

        private void guardar() {

            JFileChooser c = new JFileChooser();
            if (c.showSaveDialog(this)==JFileChooser.APPROVE_OPTION) {

                File f = c.getSelectedFile();
                if (!f.getName().endsWith(".txt"))
                    f = new File(f.getAbsolutePath()+".txt");

                try(FileWriter w=new FileWriter(f)){
                    w.write(codeArea.getText());
                }catch(Exception e){}
            }
        }

        private void abrir() {

            JFileChooser c = new JFileChooser();
            if (c.showOpenDialog(this)==JFileChooser.APPROVE_OPTION) {

                File f = c.getSelectedFile();

                try(FileReader r=new FileReader(f)){

                    StringBuilder sb=new StringBuilder();
                    int i;
                    while((i=r.read())!=-1)
                        sb.append((char)i);

                    codeArea.setText(sb.toString());

                }catch(Exception e){}
            }
        }

        private void addStat(JPanel p,String t,JLabel v){
            p.add(new JLabel(t));
            p.add(v);
        }
    }
}