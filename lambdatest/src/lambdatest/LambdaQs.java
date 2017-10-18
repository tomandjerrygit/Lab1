package lambdatest;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

    
public class LambdaQs extends JFrame{
	JPanel p, p1, p2;
	FileReaderTest t=new FileReaderTest();
	JTextArea text1 = new JTextArea();
	JTextField f1 = new JTextField();
	JTextField f2 = new JTextField();
	JButton b = new JButton("search");
	Searchaction act = new Searchaction(3);
    public LambdaQs() {
    	this.setLayout(new BorderLayout());
    	p = new JPanel();
    	p1 = new JPanel();
    	p2 = new JPanel();
    	p.setLayout(new GridLayout(2, 1));
    	p1.setLayout(new GridLayout(1, 6));
    	p2.setLayout(new GridLayout(1, 4));
    	p.add(p1);
    	p.add(p2);
    	for (int i = 1; i <= 6; i++) {
    		JButton b = new JButton("" + i);
    		b.addActionListener(new Buttomaction(i));
    		JPanel p3 = new JPanel();
    		p3.add(b);
    		p1.add(p3);
    	}

    	JLabel l = new JLabel("input words��");
    	b.addActionListener(act);
    	p2.add(l);
    	p2.add(f1);
    	p2.add(f2);
    	p2.add(b);
    	p2.setVisible(false);

    	this.add(p, BorderLayout.NORTH);

    	Font x = new Font("Serif", 0, 20);
    	text1.setFont(x);
    	text1.setBackground(getBackground());
    	this.add(text1);
    	this.setSize(600, 650);
    	this.setVisible(true);
    }
    private class Buttomaction implements ActionListener {
    	private int functionnum;
    	public Buttomaction(int i) {
    		functionnum = i;
    		System.out.println(i);
    	}
    	public void actionPerformed(ActionEvent event) {
    		switch (functionnum) {
    		case 1:
    			text1.setText("");
    			p2.setVisible(false);
    			text1.setVisible(true);
    			t.function1();
    			text1.setText(t.showgraph2());
    			break;
    		case 2:
    			t.function2();
    			text1.setText("");
    			text1.setVisible(false);
    			p2.setVisible(false);
    			ImageIcon icon
    			= new ImageIcon("C:\\Users\\11503\\Desktop\\eee2\\dotGif.gif");
    			JLabel label = new JLabel(icon);
    			add(label);
    			break;
    		case 3:
    			text1.setText("");
    			p2.setVisible(true);
    			text1.setVisible(true);
    			act.isetter(3);
    			break;
    		case 4:
    			text1.setText("");
    			p2.setVisible(false);
    			text1.setVisible(true);
    			text1.setText(t.function4());
    			break;
    		case 5:
    			b.addActionListener(new Searchaction(5));
    			text1.setText("");
    			p2.setVisible(true);
    			text1.setVisible(true);
    			act.isetter(5);
    			break;
    		case 6:
    			text1.setText("");
    			p2.setVisible(false);
    			text1.setVisible(true);
    			text1.setText(t.randomWalk());
    			break;
    		default:
    			break;
    		}
    	}
    }
    private class Searchaction implements ActionListener {
    	private int i;
    	public Searchaction(final int iset) {
    		i = iset;
    	}
    	public void isetter(final int iset) {
    		i = iset;
    	}
    	public void actionPerformed(final ActionEvent event) {
    		String s1 = f1.getText();
    		String s2 = f2.getText();
    		//System.out.println(s1);
    		//System.out.println(s2);
    		if (i == 3) {
    			String s3 = t.function3gui(s1, s2);
        		text1.setText(s3);
    		}
    		else if (i == 5) {
    			String s3 = t.calcShortestPath(s1, s2);
        		text1.setText(s3);
    		}
    	}
    }
    public static void main(final String[] args) {
    	new LambdaQs();
    }
}
