package ppt.ppt07;
public class TokenTest {
       public static void main(String[] args) {
    	   String[] tokens = "I am a boy.".split(" ");
    	   for (String token : tokens)    {
    	       System.out.println(token);
    	   }
       }
}