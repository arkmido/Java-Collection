package jframesSamples;

// simple gui Jframe
import java.awt.FlowLayout; // using default layouting system
import javax.swing.JFrame; // windowing features more-like a form
import javax.swing.JLabel; // just some labels, texts

public class Second extends JFrame{ // inherit all stuff from JFrame
    private JLabel item1;
    
    public Second(){
        super("The title bar"); // Title in the window
        setLayout(new FlowLayout()); // dafault layout
        
        item1 = new JLabel("This is a label"); // set value of a JLabel object
        item1.setToolTipText("This is some hover text"); // some tooltip text
        add(item1); // add the label to the JFrame
    }
}
