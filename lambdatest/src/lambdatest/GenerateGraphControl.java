package lambdatest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GenerateGraphControl {
  public final String function(DirectedGraph dg) {
    ArrayList<String> words = new ArrayList<>();
    ReadtxtControl readtxtcontrol=new ReadtxtControl();
    try {
      words = readtxtcontrol.readtxt
          ("F:\\workplace\\lambdatest\\src\\lambdatest\\mytxt.txt");
    }
    catch (IOException ex) {
      ex.printStackTrace();
    }
    Set<String> wordsset = new HashSet<String>();
    wordsset.addAll(words);
    dg.buildgraph(wordsset, words);
    return dg.showgraph2();
  }
}
