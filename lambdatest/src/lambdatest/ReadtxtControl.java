package lambdatest;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadtxtControl {
  public ArrayList<String> readtxt(
      final String address) throws IOException {
    ArrayList<String> words = new ArrayList<String>();
    FileReader fr = new FileReader(address);
    int hasread = 0;
    String s = "";
    while ((hasread = fr.read()) > 0) {
      if ((hasread <= 90 && hasread >= 65) ||
          (hasread <= 122 && hasread >= 97)){
        s += (char) hasread;
      }
      else {
        if (s.equals("") == false) {
          words.add(s);
          s = "";
        }
      }
    }
    if (s.equals("") == false) {
      words.add(s);
    }
    fr.close();
    return words;
  }
}
