package lambdatest;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BridgeWordForm {
  public final void function(DirectedGraph dg,JTextArea text1,JPanel p2,JTextField f1,JTextField f2) {
    text1.setText("");
    p2.setVisible(true);
    text1.setVisible(true);
    String s1 = f1.getText();
    String s2 = f2.getText();
    BridgeWordControl bridgewordcontrol=new BridgeWordControl();
    bridgewordcontrol.setA(s1);
    bridgewordcontrol.setB(s2);
    text1.setText(bridgewordcontrol.function(dg));
  }
}
