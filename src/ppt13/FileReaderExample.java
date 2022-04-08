package ppt13;
import java.io.FileReader;

public class FileReaderExample {
	public static void main(String args[]) throws Exception {	// (1)
		FileReader fr = new FileReader("D:\\test.txt");	// (2)
		int ch;
		while ((ch = fr.read()) != -1)					// (3)
			System.out.print((char) ch);
		fr.close();										// (4)
	}
}