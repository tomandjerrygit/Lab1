package lambdatest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FileReaderTestTest {
  public DirectedGraph f=new DirectedGraph();
  @Before
  public void setUp() throws Exception {
    GenerateGraphControl generategraphcontrol=new GenerateGraphControl();
    String g=generategraphcontrol.function(f);
  }
 
  @Test
  public void testCalcShortestPath1() {
    String result = f.calcShortestPath("the", "In");
    assertEquals("²»¿É´ï",result);
  }

  @Test
  public void testCalcShortestPath2() {
    String result = f.calcShortestPath("the", "important");
    System.out.println(result);
    assertEquals("the->important    length is:1\n",result);
  }

  /*@Test
  public void testCalcShortestPath3() {
    String result = f.calcShortestPath("the", "");
    assertEquals("",result);
  }*/

  @Test
  public void testCalcShortestPathUP_DATE() {
    String result = f.calcShortestPath("", "");
    assertEquals("",result);
  }

  @Test
  public void testCalcShortestPath5() {
    String result = f.calcShortestPath("90909090", "121212");
    assertEquals("",result);
  }

  /*@Test
  public void testCalcShortestPath6() {
    String result = f.calcShortestPath("the", "pppppp");
    assertEquals("",result);
  }*/

  @Test
  public void testCalcShortestPath7() {
    String result = f.calcShortestPath("pppppp", "the"); 
    assertEquals("",result);
  }
  
  @Test
  public void testCalcShortestPath8() {
    String result = f.calcShortestPath("pppppp", "qqqqq");
    assertEquals("",result);
  }
  
  @Test
  public void testCalcShortestPath9() {
    String result = f.calcShortestPath("1234", "");
    assertEquals("",result);
  }
  
  @Test
  public void test1() {
    String result=f.BridgeWords("sin","cos");
    assertEquals("",result);
  }
  @Test
  public void test2() {
    String result=f.BridgeWords("word","hello");
    assertEquals("",result);
  }
  @Test
  public void test3() {
    String result=f.BridgeWords("this","hello");
    assertEquals("",result);
  }
  @Test
  public void test4() {
    String result=f.BridgeWords("time","one");
    assertEquals("",result);
  }
  @Test
  public void test5() {
    String result=f.BridgeWords("of","word");
    int fjal=0;
    assertEquals("this ",result);
  }

}
