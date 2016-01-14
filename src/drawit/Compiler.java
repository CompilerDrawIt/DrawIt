/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawit;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;

/**
 *
 * @author Jestin Jaye Tan
 */
public class Compiler extends JPanel {

    /**
     * @param args the command line arguments
     */
    String[] lines;
    private ArrayList<String> stack;
    JTextArea code;
    JButton run;
    int x = 1;
    int y = 1;
    DrawIt d = new DrawIt();
    Integer z;
    Constants.direction dir;
    String objName;

    public Compiler() {
        initializeWindow();

    }

    public void initializeWindow() {
        run = new JButton();
        run.setText("Run");
        run.addActionListener(new runListener());
        code = new JTextArea(25, 50);

        add(code);
        add(run);
    }

    private void push(int i) {
        stack.add(lines[i]);
    }

    private class runListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            lines = code.getText().split("\\n");
            for (int i = 0; i < lines.length; i++) {
                System.out.println(lines[i]);

            }
            stack = new ArrayList<String>(lines.length);
            parse(lines);
        }
    }

    public void parse(String[] line) {
        Pattern testAll = Pattern.compile("((^draw)(\\s*)([a-zA-Z]+)(\\s*)(\\{)(\\s*$))|"
                + "((^move)(\\s*)(\\()(\\s*)(left|right|up|down|upwardLeft|upwardRight|downwardLeft|downwardRight)(\\s*)(\\))(\\s*$))|"
                + "((^setPoint)(\\s*)(\\()(\\s*)(\\d{1,2})(\\s*)(,)(\\s*)(\\d{1,2})(\\s*)(\\))(\\s*$))|"
                + "((^atTheTopOf|^atTheRightOf|^atTheLeftOf|^insideOf|^copy)(\\s*)([a-zA-Z]+)(\\s*$))|"
                + "((^fill)(\\s*)(\\()(\\s*)(Black|Red|Green|Blue)(\\s*)(\\))(\\s*$))|"
                + "((^\\d)(\\s*)(times)(\\s*)(\\{)(\\s*))|(\\}\\s*$)");
        Pattern draw = Pattern.compile("(^draw)(\\s*)([a-zA-Z]+)(\\s*)(\\{)(\\s*$)");
        Pattern move = Pattern.compile("(^move)(\\s*)(\\()(\\s*)(left|right|up|down|upwardLeft|upwardRight|downwardLeft|downwardRight)(\\s*)(\\))(\\s*$)");
        Pattern setPoint = Pattern.compile("(^setPoint)(\\s*)(\\()(\\s*)(\\d{1,2})(\\s*)(,)(\\s*)(\\d{1,2})(\\s*)(\\))(\\s*$)");
        Pattern direction = Pattern.compile("(^atTheTopOf|^atTheRightOf|^atTheLeftOf|^insideOf|^copy)(\\s*)([a-zA-Z]+)(\\s*$)");
        Pattern fill = Pattern.compile("(^fill)(\\s*)(\\()(\\s*)(Black|Red|Green|Blue)(\\s*)(\\))(\\s*$)");
        Pattern loop = Pattern.compile("(^\\d)(\\s*)(times)(\\s*)(\\{)(\\s*)");
        Matcher m;
        int braceCnt = 0;
        boolean correctSyntax = true;
        code.getHighlighter().removeAllHighlights();
        for (int i = 0; i < line.length; i++) {
            m = testAll.matcher(line[i]);
            if (!m.find()) {
                try {
                    code.getHighlighter().addHighlight(code.getLineStartOffset(i), code.getLineEndOffset(i), new DefaultHighlighter.DefaultHighlightPainter(Color.RED));
                } catch (BadLocationException ex) {
                    Logger.getLogger(Compiler.class.getName()).log(Level.SEVERE, null, ex);
                }
                correctSyntax = false;
            }
            //if (correctSyntax) {
                m = move.matcher(line[i]);
                if (m.find()) {
                    System.out.println(m.group(5));
                    System.out.println(" ni sud");
                    switch (m.group(5)) {
                        case "right":
                            dir = Constants.direction.RIGHT;
                            break;
                        case "up":
                            dir = Constants.direction.UP;
                            break;
                        case "down":
                            dir = Constants.direction.DOWN;
                            break;
                        case "left":
                            dir = Constants.direction.LEFT;
                            break;
                        case "upwardRight":
                            dir = Constants.direction.UPWARDRIGHT;
                            break;
                        case "upwardLeft":
                            dir = Constants.direction.UPWARDLEFT;
                            break;
                        case "downwardRight":
                            dir = Constants.direction.DOWNWARDRIGHT;
                            break;
                        case "downwardLeft":
                            dir = Constants.direction.DOWNWARDLEFT;
                            break;
                    }
                    d.move(dir, objName);
                    System.out.println("nisud");
                }
                m = setPoint.matcher(line[i]);
                if (m.find()) {
                    System.out.println(m.group(5) + " " + m.group(9));
                    x = Integer.parseInt(m.group(5));
                    y = Integer.parseInt(m.group(9));
                    System.out.println("x: " + x);
                    System.out.println("y: " + m.group(9));
                    d.setPoint(objName, x, y);
                }
                m = fill.matcher(line[i]);
                if (m.find()) {
                    System.out.println(m.group(5));
                }
                m = loop.matcher(line[i]);
                if (m.find()) {
                    System.out.println(m.group(1));
                    braceCnt++;
                }
                m = draw.matcher(line[i]);
                if (m.find()) {
                    System.out.println(m.group(3));
                    braceCnt++;
                    d.draw(m.group(3), x, y);
                    objName = m.group(3);
                }
                m = direction.matcher(line[i]);
                if (m.find()) {
                    if (m.group(1).equals("atTheTopOf")) {
                        System.out.println(m.group(3));
                    } else if (m.group(1).equals("atTheRightOf")) {

                    } else if (m.group(1).equals("atTheLeftOf")) {

                    } else if (m.group(1).equals("insideOf")) {

                    } else if (m.group(1).equals("copy")) {

                    }
                }

                if (line[i].matches("(\\s*)(\\})(\\s*)")) {
                    System.out.println(line.length);
                    braceCnt--;
                }

                if (i == line.length - 1 && braceCnt != 0) {
                    JOptionPane.showMessageDialog(null, "Take a look at your braces!");
                    System.out.println(braceCnt);
                }
            }

       // }
        if (correctSyntax) {
            d.initialize();
        }
    }

    public void parseColor() {

    }
}
