package lambdatest;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GenerateNewTextForm {
  public final void function(DirectedGraph dg,JTextArea text1,JPanel p2) {
    text1.setText("");
    p2.setVisible(false);
    text1.setVisible(true);
    GenerateNewTextControl generatenewtextcontrol=new GenerateNewTextControl();
    text1.setText(generatenewtextcontrol.function(dg));
  }
}
