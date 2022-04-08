package ppt13;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFile1 {

 public static void main(String[] args) throws IOException {
        try(FileReader  in = new FileReader("D://test.txt");
        		FileWriter out = new FileWriter("D://copy.txt")){
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } 
    }
}