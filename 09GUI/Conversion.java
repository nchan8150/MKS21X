import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Conversion extends JFrame implements ActionListener{
    
    private Container pane;
    private JTextField t;
    private JButton f;
    private JButton c;

    public void actionPerformed (ActionEvent e) {
	String s = e.getActionCommand();
	if (s.equals("Convert from F to C")) {
	    System.out.println(FtoC(Double.parseDouble(t.getText())));
	}
	else if (s.equals("Convert from C to F")) {
	    System.out.println(CtoF(Double.parseDouble(t.getText())));
	}
    }
	    
    public Conversion() {
	this.setTitle("Converting Fahrenheit and Celsuis");
	this.setSize(600,100);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());

	t = new JTextField(12);
	f = new JButton("Convert from F to C");
	c = new JButton("Convert from C to F");

	t.addActionListener(this);
	f.addActionListener(this);
	c.addActionListener(this);
	
	pane.add(t);
	pane.add(f);
	pane.add(c);
    }
    
    public static double CtoF(double t) {
	return t * 9.0 / 5 + 32;
    }

    public static double FtoC(double t) {
	return (t - 32.0) * 5 / 9;
    }

    public static void main (String[] args) {
	Conversion x = new Conversion();
	x.setVisible(true);
    }
}
