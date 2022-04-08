package ppt13;
import java.io.*;
public class CopyLines {

    public static void main(String[] args) {

        try( BufferedReader in = new BufferedReader(new FileReader("d://test.txt"));
        		PrintWriter out = new PrintWriter(new FileWriter("d://output.txt"))) {

            String line;
            while (( line = in.readLine()) != null) {
                out.println( line);
            }


        } catch (IOException e) {
			e.printStackTrace();
		}
    }
}