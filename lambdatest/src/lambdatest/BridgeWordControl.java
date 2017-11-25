package lambdatest;

public class BridgeWordControl {
    String a,b;

    public String getA() {
      return a;
    }

    public void setA(String a) {
      this.a = a;
    }

    public String getB() {
      return b;
    }

    public void setB(String b) {
      this.b = b;
    }
    public final String function(DirectedGraph dg) {
      String result=dg.queryBridgeWords(a, b);
      return result;
    }
}
