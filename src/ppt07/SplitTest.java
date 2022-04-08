package ppt07;
public class SplitTest {  
 public static void main(String args[]){  
    	   String[] tokens = "100,200,300".split(",");
    	   for (String token : tokens)   	   {
    	       System.out.println(token);
    	   }

       }
}