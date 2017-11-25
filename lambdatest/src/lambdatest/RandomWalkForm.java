package lambdatest;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class RandomWalkForm {
  public final void function(DirectedGraph dg,JTextArea text1,JPanel p2) {
    text1.setText("");
    p2.setVisible(false);
    text1.setVisible(true);
    RandomWalkControl randomwalkcontrol=new RandomWalkControl();
    ;
    //t.function1();
    text1.setText(randomwalkcontrol.function(dg));
  }
}
