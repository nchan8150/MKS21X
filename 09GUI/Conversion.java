import javac.swing.*;
import java.awt.*;
import java.swing.event.*;

public class Conversion extends JFrame implements ActionListener{

    public static double CtoF(double t) {
	return t * 5 / 9 + 32;
    }

    public static double FtoC(double t) {
	return (t - 32) * 5 / 9;
    }
    
    private Conttainer pane;
    private Jbutton fb;
    private JTextField ft;
    private Jbutton cb;
    private JTextField ct;

    public Conversion() {
	this.setTitle("Convering Fahrenheit and Celsuis");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane.this.getContentPane();
	pane.setLayout(new FlowLayout());
	
	fb = new JButton("Convert from F to C");
	ft = new JTextField(12);
	cb = new JButton("Convert from C to F");
	ct = new JTextField(12);
	pane.add(fb);
	pane.add(ft);
	pane.add(cb);
	pane.add(ct);
 }
    
    /*
    public static void main(String[] args) {
	System.out.println(CtoF(0)); //32
	System.out.println(CtoF(-50)); //-58
	System.out.println(FtoC(212)); //100
	System.out.println(FtoC(21.2)); //-6
	System.out.println(FtoC(180)); //82.22
    }
    */
}
