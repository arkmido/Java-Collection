package jframesSamples;

// event handling

import java.awt.FlowLayout; // some default layout formatting
import java.awt.event.ActionListener; // used for event listening
import java.awt.event.ActionEvent; // actual events

import javax.swing.JFrame; // the Form yeah
import javax.swing.JTextField; // some textfield, oh you know it already
import javax.swing.JPasswordField; // password of-course
import javax.swing.JOptionPane; // some popup dialog boxes

public class Second_2 extends JFrame{ // always inherit JFrame
    private JTextField text1;
    private JTextField text2;
    private JTextField text3;
    
    private JPasswordField pass1;
    
    public Second_2(){
        super("The title bar");
        setLayout(new FlowLayout());
        
        text1 = new JTextField(10); // 10 is just the length
        text2 = new JTextField("enter text here"); // with default text
        text3 = new JTextField("uneditable", 20); // set this later to uneditable
        
        add(text1);
        add(text2);
        text3.setEditable(false);
        add(text3);
        
        pass1 = new JPasswordField("myPass", 20);
        add(pass1);
        
        TheHandler handler = new TheHandler();
        text1.addActionListener(handler);
        text2.addActionListener(handler);
        pass1.addActionListener(handler);
    }
    
    // this class inherits all crap inside
    private class TheHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            String string = "";
            if(event.getSource() == text1){
                // change or just format the string and get the string from the field source
                string = String.format("Field 1: %s", event.getActionCommand());
            }else if(event.getSource() == text2){
                string = String.format("Field 2: %s", event.getActionCommand());
            }else if(event.getSource() == pass1){
                string = String.format("PassField: %s", event.getActionCommand());
            }
            
            JOptionPane.showMessageDialog(null, string);
        }
    }
}
