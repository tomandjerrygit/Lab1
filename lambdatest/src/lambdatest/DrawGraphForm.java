package lambdatest;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class DrawGraphForm {
  public final ImageIcon function(DirectedGraph dg,JTextArea text1,JPanel p2) {
    DrawGraphControl drawgraphcontrol=new DrawGraphControl();
    drawgraphcontrol.function(dg);
    text1.setText("");
    text1.setVisible(false);
    p2.setVisible(false);
    ImageIcon icon
    = new ImageIcon("C:\\Users\\11503\\Desktop\\eee2\\dotGif.gif");
    //JLabel label = new JLabel(icon);
    return icon;
  }
}
