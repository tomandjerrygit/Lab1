package lambdatest;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.io.File;
import java.io.FileOutputStream;


import javax.swing.JOptionPane;
//git update
public class FileReaderTest {
	private int edgenum,nodenum;
	private ArrayList<Node> headlist;
	private class Edge
	{
		private int number;
		private int weight;
		private Edge next;
		private boolean come;
		public Edge(int number) {
			this.number=number;
			weight=1;
			come=false;
		}
		public void setnext(Edge next)
		{
			this.next=next;
		}
	}
	private class Node
	{
		private String s;
		private int out;
		private Edge firstedge;
		public Node(String s) {
			this.s=s;
			out=0;	
			firstedge=null;
		}
		public void setnode(Edge first)
		{
			this.firstedge=first;
		}
		public void addout()
		{
			this.out++;
		}
	}
	private class dijpair
	{
		private int weighsum;
		private int index;
		public dijpair(int index)
		{
			weighsum=1000;this.index=index;
		}
		public void setweighsum(int num)
		{
			this.weighsum=num;
		}
		public int getweighsum()
		{
			return weighsum;
		}
		public int getindex()
		{
			return index;
		}	
	}
	public FileReaderTest()
	{
		edgenum=nodenum=0;
		headlist=new ArrayList<Node>();		
	}
	private ArrayList<String> readtxt(String address) throws IOException
	{
		ArrayList<String> words=new ArrayList<String>();
		FileReader fr=new FileReader(address);
		int hasread=0;
		String s="";
		while ((hasread=fr.read())>0)
		{
			if ((hasread<=90 && hasread>=65)||(hasread<=122 && hasread>=97))
			{
				s+=(char)hasread;
			}
			else
			{
				if (!s.equals(""))
				{
					words.add(s);
					s="";
				}
			}
		}
		if (!s.equals(""))
		{
			words.add(s);
		}
		fr.close();
		return words;
	}
	private int findindex(String a)
	{
		int i;
		for (i=0;i<headlist.size() && !(headlist.get(i).s.equals(a));i++);
		return i;
	}
 	private void buildgraph(Set<String> wordsset,ArrayList<String> wordsarray)
	{
		nodenum=wordsset.size();
		for (String word:wordsset)
		{
			Node head=new Node(word);
			headlist.add(head);
		}
		int front,behind;
		String temp=wordsarray.get(0);
		front=findindex(temp);
		for (int i=1;i<(wordsarray.size());i++,front=behind)
		{
			temp=wordsarray.get(i);
			behind=findindex(temp);
			int flag=1;
			for (Edge edgetemp=headlist.get(front).firstedge;edgetemp!=null;edgetemp=edgetemp.next)
			{
				if (edgetemp.number==behind)
				{
					edgetemp.weight++;
					flag=0;
					break;				
				}
			}
			if (flag==1)
			{
				Edge newedge=new Edge(behind);
				newedge.setnext(headlist.get(front).firstedge);
				headlist.get(front).setnode(newedge);
				headlist.get(front).addout();
				edgenum++;
			}
		}		
	}
 	public String showsentence(ArrayList<String> words)
 	{
 		String mystr="";
 		for (String word:words)
 		{
 			mystr+=word+" ";
 		}
 		mystr+="\n";
 		return mystr;
 	}
	private void showDirectedGraph(ArrayList<Node> headlist)
	{
		for (Node head:headlist)
		{
			System.out.print(head.s+":");
			for (Edge theedge=head.firstedge;theedge!=null;theedge=theedge.next)
			{
				System.out.print("->"+theedge.weight+headlist.get(theedge.number).s);
			}
			System.out.println("");
		}
	}
	public String showgraph2()
	{
		String a="";
		for (Node head:headlist)
		{
			a=a+head.s+":";
			for (Edge theedge=head.firstedge;theedge!=null;theedge=theedge.next)
			{
			    a=a+"->"+theedge.weight+headlist.get(theedge.number).s;
			}
			a=a+"\n";
		}
		return a;
	}
	public void function1()
	{
		ArrayList<String> words=new ArrayList<>();
		try
		{
			words=readtxt("F:\\workplace\\lambdatest\\src\\lambdatest\\mytxt.txt");
			//地址自己改
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		System.out.print(showsentence(words));
		Set<String> wordsset=new HashSet<String>();
		wordsset.addAll(words);
		buildgraph(wordsset,words);
		showDirectedGraph(headlist);
	}
	public void function2()
	{
		 GraphViz gViz=new GraphViz("C:\\Users\\11503\\Desktop\\eee2", "E:\\learn\\java\\huatu\\bin\\dot.exe");
	     //地址自己改
		 gViz.start_graph();
	     for (int i=0;i<nodenum;i++)
	     {
	    	 for (Edge itsedge=headlist.get(i).firstedge;itsedge!=null;itsedge=itsedge.next)
	    	 {
	    		 gViz.addln(headlist.get(i).s+"->"+headlist.get(itsedge.number).s);
	    	 }
	     }
	     gViz.end_graph();
	     try 
	     {
	        gViz.run();
         } 
	     catch (Exception e) 
	     {
	        e.printStackTrace();
	     }
	}
	private String queryBridgeWords(String word1,String word2)
	{
		String mystr="";
		int start=findindex(word1);
		if (start==headlist.size())
		{
			return mystr;
		}
		int middle;
		for (Edge itsedge=headlist.get(start).firstedge;itsedge!=null;itsedge=itsedge.next)
		{
			middle=itsedge.number;
			for (Edge middleedge=headlist.get(middle).firstedge;middleedge!=null;middleedge=middleedge.next)
			{
				if (headlist.get(middleedge.number).s.equals(word2))
				{
					mystr=mystr+headlist.get(middle).s+" ";
				}
			}
		}		
		return mystr;
	}
	public void function3()
	{
		String a,b;
		//int size=headlist.size();
		a=JOptionPane.showInputDialog("1:");
		b=JOptionPane.showInputDialog("2:");
		while (!a.equals(" ") | !b.equals(" "))
		{
			System.out.println(function3gui(a,b));
			a=JOptionPane.showInputDialog("1:");
			b=JOptionPane.showInputDialog("2:");
		}
	}
	public String function3gui(String a,String b)
	{
		int size=headlist.size();
		int ain=findindex(a);
		int bin=findindex(b);
		if (ain==size && bin<size) return ("No \""+a+"\" in the graph");
		else if (ain<size && bin==size) return ("No \""+b+"\" in the graph");
		else if (ain==size && bin==size) return ("No \""+a+"\" and \""+b+"\" in the graph");
		else
		{
			String answer=queryBridgeWords(a,b);
			return ("The bridge word from \""+a+"\" to \""+b+"\" is:"+answer);
		}
	}
	private String generateNewText(String inputText)
	{
		String[] words=inputText.split(" ");
		String mystr=words[0];
		for (int i=1;i<words.length;i++)
		{
			String middle=queryBridgeWords(words[i-1],words[i]);
			if (!middle.isEmpty()) mystr+=(" "+middle.split(" ")[0]);
			mystr+=(" "+words[i]);			
		}
		mystr+=("\n");
		return mystr;
	}
	public String function4()
	{
		String mystr="";
		ArrayList<String> words=new ArrayList<>();
		try
		{
			words=readtxt("F:\\workplace\\lambdatest\\src\\lambdatest\\mytxt2.txt");
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		String sentence=showsentence(words);
		mystr+=("initial:"+sentence+"\n");
		mystr+=("after:"+generateNewText(sentence));		
		return mystr;
	}
	public String calcShortestPath(String a,String b)//计算不可达有错
	{
		int anum=findindex(a);
		String mystr="";
		ArrayList<Integer> parent=new ArrayList<>(nodenum);
		ArrayList<Boolean> visit=new ArrayList<>(nodenum);
		ArrayList<dijpair> d=new ArrayList<>(nodenum);
		for (int i=0;i<nodenum;i++) {
			visit.add(false);
			parent.add(-1);
			dijpair pair=new dijpair(i);
			d.add(pair);
		}	
		d.get(anum).setweighsum(0);
		PriorityQueue<dijpair> myqueue=new PriorityQueue<>((o1,o2)->
		{
			dijpair pair1=(dijpair)o1;
			dijpair pair2=(dijpair)o2;
			return pair1.weighsum<pair2.weighsum ? -1
					:pair1.weighsum>pair2.weighsum ? 1:0;
		});
		myqueue.offer(d.get(anum));
		while (!myqueue.isEmpty())
		{
			dijpair pair=myqueue.poll();
			int pairindex=pair.getindex();
			if (visit.get(pairindex))
			{
				continue;
			}
			visit.set(pairindex, true);
			for (Edge itsedge=headlist.get(pairindex).firstedge;itsedge!=null;itsedge=itsedge.next)
			{
				int v=itsedge.number;
				if (!visit.get(v)&& (d.get(v).getweighsum())>(d.get(pairindex).weighsum+itsedge.weight))
				{
					d.get(v).setweighsum(d.get(pairindex).weighsum+itsedge.weight);
					parent.set(v, pairindex);
					myqueue.offer(d.get(v));
				}
			}
		}
		int bnum=findindex(b);
		if (bnum<nodenum)
		{
			mystr+=printpath(anum,bnum,parent);
			if (d.get(bnum).weighsum==1000)
			{
				mystr+=("不可达\n");
			}
			else
			{
				mystr+=("    length is:"+d.get(bnum).weighsum+"\n");

			}
		}
		else
		{
			for (int i=0;i<nodenum;i++)
			{
				mystr+=printpath(anum,i,parent);
				if (d.get(i).weighsum==1000)
				{
					mystr+=("不可达\n");
				}
				else
				{
					mystr+=("    length is:"+d.get(i).weighsum+"\n");
				}				
			}
		}
		return mystr;
	}
	private String printpath(int anum,int bnum,ArrayList<Integer> parent)//出错
	{
		String mystr="";
		if (anum==bnum)
		{
			mystr+=(headlist.get(anum).s);
		}
		else
		{
			mystr+=printpath(anum,parent.get(bnum),parent);
			mystr+=("->"+headlist.get(bnum).s);
		}
		return mystr;
	}
	public void function5()//计算不可达有错
	{
		String a,b;
		a=JOptionPane.showInputDialog("1:");
		b=JOptionPane.showInputDialog("2:");
		while (!a.equals(" "))
		{
			System.out.print(calcShortestPath(a,b));
			a=JOptionPane.showInputDialog("1:");
			b=JOptionPane.showInputDialog("2:");
		}		
	}
	public void function6()
	{
		int a,b,c;
		a=nodenum;
		b=(int)(Math.random()*a);
		Node head= headlist.get(b);		 
		System.out.print("\nThe random path is: ");
		System.out.print(head.s);
		String d;
		d=JOptionPane.showInputDialog("print keep to keep:");		
		while(head.out>0&&(d.equals("keep")))
		{
			c=(int)(Math.random()*head.out);
			Edge edgetemp=head.firstedge;
			for(int i=0;i<c-1;i++)
			{
				edgetemp=edgetemp.next;
			}
			if(edgetemp.come==false)
			{
				edgetemp.come=true;
				System.out.print("->"+headlist.get(edgetemp.number).s );
				head=headlist.get(edgetemp.number);
			}
			else
		        break;
			d=JOptionPane.showInputDialog("print keep to keep:");
		}
		for (int i=0;i<a;i++)
		{
			for (Edge edgetemp=headlist.get(i).firstedge;edgetemp!=null;edgetemp=edgetemp.next)
			{			 
				edgetemp.come=false;				 
			}
		}				
	}
	public String randomWalk()
	{
		int a,b,c;
		String mystr="";
		a=nodenum;
		b=(int)(Math.random()*a);
		Node head= headlist.get(b);		 
		mystr+=("\nThe random path is: "+head.s);
		while(head.out>0)
		{
			c=(int)(Math.random()*head.out);
			Edge edgetemp=head.firstedge;
			for(int i=0;i<c-1;i++)
			{
				edgetemp=edgetemp.next;
			}
			if(edgetemp.come==false)
			{
				edgetemp.come=true;
				mystr+=("\n->"+headlist.get(edgetemp.number).s );
				head=headlist.get(edgetemp.number);
			}
			else
		        break;
		}
		for (int i=0;i<a;i++)
		{
			for (Edge edgetemp=headlist.get(i).firstedge;edgetemp!=null;edgetemp=edgetemp.next)
			{			 
				edgetemp.come=false;				 
			}
		}
		return mystr;
	}
	//main函数在另一个java文件
	/*public static void main(String[] args)
	{
		FileReaderTest t=new FileReaderTest();
		String a;
		a=JOptionPane.showInputDialog("choose function(1,2,3,4,5,6):");
		while (!a.equals("0"))
		{
			switch  (a)
			{
			case  "1":
				t.function1();
				break;
			case "2":
				t.function2();
				break;
			case "3":
				t.function3();
				break;
			case "4":
				System.out.println(t.function4());
				break;
			case "5":
				t.function5();
				break;
			case "6":
				t.function6();
				break;
			default:
				System.out.println("error");	
			}
			a=JOptionPane.showInputDialog("choose function(1,2,3,4,5,6):");
		}		
	}*/
}


class  GraphViz{
    private String runPath = "";
    private String dotPath = ""; 
    private String runOrder="";
    private String dotCodeFile="dotcode.txt";
    private String resultGif="dotGif";
    private StringBuilder graph = new StringBuilder();

    Runtime runtime=Runtime.getRuntime();

    public void run() {
        File file=new File(runPath);
        file.mkdirs();
        writeGraphToFile(graph.toString(), runPath);
        creatOrder();
        try {
            runtime.exec(runOrder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void creatOrder(){
        runOrder+=dotPath+" ";
        runOrder+=runPath;
        runOrder+="\\"+dotCodeFile+" ";
        runOrder+="-T gif ";
        runOrder+="-o ";
        runOrder+=runPath;
        runOrder+="\\"+resultGif+".gif";
        System.out.println(runOrder);
    }

    public void writeGraphToFile(String dotcode, String filename) {
        try {
            File file = new File(filename+"\\"+dotCodeFile);
            if(!file.exists()){
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(dotcode.getBytes());
            fos.close();
        } catch (java.io.IOException ioe) { 
            ioe.printStackTrace();
        }
     }  

    public GraphViz(String runPath,String dotPath) {
        this.runPath=runPath;
        this.dotPath=dotPath;
    }

    public void add(String line) {
        graph.append("\t"+line);
    }

    public void addln(String line) {
        graph.append("\t"+line + "\n");
    }

    public void addln() {
        graph.append('\n');
    }

    public void start_graph() {
        graph.append("digraph G {\n") ;
    }

    public void end_graph() {
        graph.append("}") ;
    }   
} 
