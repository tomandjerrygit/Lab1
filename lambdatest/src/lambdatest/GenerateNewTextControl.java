package lambdatest;

import java.io.IOException;
import java.util.ArrayList;

public class GenerateNewTextControl {
  public final String function(DirectedGraph dg) {
    String mystr = "";
    ArrayList<String> words = new ArrayList<>();
    ReadtxtControl readtxtcontrol=new ReadtxtControl();
    try {
      words = readtxtcontrol.readtxt(
          "F:\\workplace\\lambdatest\\src\\lambdatest\\mytxt2.txt");
    }
    catch (IOException ex) {
      ex.printStackTrace();
    }
    String sentence = dg.showsentence(words);
    mystr += ("initial:" + sentence+ "\n");
    mystr += ("after:" + dg.generateNewText(sentence));
    return mystr;
  }
}
