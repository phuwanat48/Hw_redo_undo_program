package Lib;
import java.awt.*;
import java.awt.event.*;
import java.util.Stack;
import javax.swing.*;

public class Form1 extends JFrame implements ActionListener , KeyListener {

    JTextArea t ;
    JButton b1 ;
    JButton b2 ;
    Stack<String> st ;
    Stack<String> redoStack = new Stack<>();

    public Form1(){

        st = new Stack<>();
        
        
        st.push("");
        redoStack.push("");
        Container cp = this.getContentPane();
        cp.setLayout(null);
        
        t = new JTextArea();
        b1 = new JButton("UNDO");
        b2 = new JButton("REDO");
        t.setBounds(10, 10, 160, 80);
        b1.setBounds(10, 110, 70, 40); 
        b2.setBounds(100, 110, 70, 40);

        cp.add(t); cp.add(b1); cp.add(b2);

        t.addKeyListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);

        setSize(200,200);
        setResizable(false); 
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()== b1  ){ 
            if(!st.isEmpty()&& st.size()>1){
                redoStack.push(t.getText());
                st.pop();
                t.setText(st.peek());
                
               
                
              //  System.out.println(redoStack.peek()); //เอาไว้ดูว่า redoStack มีอะไรบ้าง
                
            }       
        }else if(e.getSource()== b2){
            if(!st.isEmpty()){
               
                String redoText = redoStack.pop();
                t.setText(redoText);
                st.push(redoText);
                
            }

        }
       
    }

    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar()==' '|| e.getKeyChar()=='\n'){
            st.push(t.getText());
            redoStack.clear();
        }
    }

    public void keyPressed(KeyEvent e) {
        
    }

    public void keyReleased(KeyEvent e) {
        
    }
}

