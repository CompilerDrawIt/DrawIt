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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
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
    String objName,objL, objN;
    Color c = Color.BLACK;
    public Compiler() {
        initializeWindow();
        d.initializeArr();

    }

    public void initializeWindow() {
        run = new JButton();
        run.setText("Draw");
        run.addActionListener(new runListener());
        code = new JTextArea(25, 50);
        JScrollPane scroll= new JScrollPane(code);
       scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(scroll);
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
                + "((^setPoint)(\\s*)(\\()(\\s*)(\\d{1,3})(\\s*)(,)(\\s*)(\\d{1,3})(\\s*)(\\))(\\s*$))|"
                + "((^atTheTopOf|^atTheRightOf|^atTheLeftOf|^insideOf|^copy)(\\s*)([a-zA-Z]+)(\\s*$))|"
                + "((^color)(\\s*)(\\()(\\s*)(Black|Red|Green|Blue)(\\s*)(\\))(\\s*$))|"
                + "((^\\d{1,3})(\\s*)(times)(\\s*)(\\{)(\\s*))|(\\}$)");
        Pattern draw = Pattern.compile("(^draw)(\\s*)([a-zA-Z]+)(\\s*)(\\{)(\\s*$)");
        Pattern move = Pattern.compile("(^move)(\\s*)(\\()(\\s*)(left|right|up|down|upwardLeft|upwardRight|downwardLeft|downwardRight)(\\s*)(\\))(\\s*$)");
        Pattern setPoint = Pattern.compile("(^setPoint)(\\s*)(\\()(\\s*)(\\d{1,3})(\\s*)(,)(\\s*)(\\d{1,3})(\\s*)(\\))(\\s*$)");
        Pattern direction = Pattern.compile("(^atTheTopOf|^atTheRightOf|^atTheLeftOf|^insideOf|^copy)(\\s*)([a-zA-Z]+)(\\s*$)");
        Pattern color = Pattern.compile("(^color)(\\s*)(\\()(\\s*)(black|red|green|blue)(\\s*)(\\))(\\s*$)");
        Pattern loop = Pattern.compile("(^\\d{1,3})(\\s*)(times)(\\s*)(\\{)(\\s*)");
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
                    d.move(dir, objName,c);
                    System.out.println("nisud");
                }
                m = setPoint.matcher(line[i]);
                if (m.find()) {
                    System.out.println(m.group(5) + " " + m.group(9));
                    x = Integer.parseInt(m.group(5));
                    y = Integer.parseInt(m.group(9));
                    System.out.println("x: " + x);
                    System.out.println("y: " + m.group(9));
                    d.setPoint(objName, x, y, c);
                }
                m = color.matcher(line[i]);
                if (m.find()) {
                    System.out.println(m.group(5));
                    if(m.group(5).equals("black")){
                        c = Color.BLACK;
                    } else if(m.group(5).equals("red")){
                         c = Color.RED;
                    } else if(m.group(5).equals("green")){
                         c = Color.GREEN;
                    } if(m.group(5).equals("blue")){
                         c = Color.BLUE;
                    }
                            
                }
                m = loop.matcher(line[i]);
                if (m.find()) {
                    String[] loopline;
                    int j;
                    System.out.println("Test");
              
                    braceCnt++;
                    System.out.println("braceCnt: "+ braceCnt);
                    for(j=i;!(line[j].matches("\\}"));j++){
                    }
                    System.out.println("j: "+ j);
                    System.out.println("i: "+ i);
                    System.out.println("j-i: "+ (j-i));
                    loopline = new String[j-i-1];
                    
                    System.out.println("loopline length: "+ loopline.length);
                    int k, l;
                    for(k=i+1, l=0; k<j; k++, l++){
                        loopline[l]=line[k];
                    }
                    i=j;
                    System.out.println("k: " + k);
                    System.out.println("l: " + l);
                    int counter = Integer.parseInt(m.group(1));
                    System.out.println("counter: " + counter);
                    
                    for(int h=0; h<counter;h++){
                        parse(loopline);
                    }
                    
                    
                }
                m = draw.matcher(line[i]);
                if (m.find()) {
                    System.out.println(m.group(3));
                    braceCnt++;
                    d.draw(m.group(3), x, y, c);
                    objName = m.group(3);
                }
                m = direction.matcher(line[i]);
                if (m.find()) {
                    if (m.group(1).equals("atTheTopOf")) {
                        System.out.println(m.group(3));
                        objL= m.group(3);
                        objN= objName;
                        System.out.println("name: "+objN);
                        //d.atTheTopOf(objL,objN);

                    } else if (m.group(1).equals("atTheRightOf")) {
                        objL= m.group(3);
                        objN= objName;
                        System.out.println("name: "+objN);
                       // d.atTheRightOf(objL,objN);
                    } else if (m.group(1).equals("atTheLeftOf")) {
                        objL= m.group(3);
                        objN= objName;
                        System.out.println("name: "+objN);
                        //d.atTheLeftOf(objL,objN);
                    } else if (m.group(1).equals("insideOf")) {
                        objL= m.group(3);
                        objN= objName;
                        System.out.println("name: "+objN);
                        //d.insideOf(objL,objN);
                    } else if (m.group(1).equals("copy")) {

                    }
                }

                if (line[i].matches("\\}")) {
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
