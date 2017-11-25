package lambdatest;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GenerateGraphForm {
  public final void function(DirectedGraph dg,JTextArea text1,JPanel p2) {
    text1.setText("");
    p2.setVisible(false);
    text1.setVisible(true);
    GenerateGraphControl generategraphcontrol=new GenerateGraphControl();
    ;
    //t.function1();
    text1.setText(generategraphcontrol.function(dg));
  }
}
