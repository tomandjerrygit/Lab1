package lambdatest;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CalcShortestPathForm {
  public final void function(DirectedGraph dg,JTextArea text1,JPanel p2,JTextField f1,JTextField f2) {
    text1.setText("");
    p2.setVisible(true);
    text1.setVisible(true);
    String s1 = f1.getText();
    String s2 = f2.getText();
    CalcShortestPathControl calcshortestpathcontrol=new CalcShortestPathControl();
    calcshortestpathcontrol.setA(s1);
    calcshortestpathcontrol.setB(s2);
    text1.setText(calcshortestpathcontrol.function(dg));
  }
}
