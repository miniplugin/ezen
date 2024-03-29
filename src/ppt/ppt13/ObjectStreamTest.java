﻿package ppt.ppt13;
import java.io.*;
import java.util.*;

public class ObjectStreamTest {
	public static void main(String[] args) throws IOException {
		ObjectInputStream in = null;
		ObjectOutputStream out = null;
		try {
			int c;

			out = new ObjectOutputStream(new FileOutputStream("d://object.dat"));
			out.writeObject(new Date());

			out.flush();
			in = new ObjectInputStream(new FileInputStream("d://object.dat"));
			Date d = (Date) in.readObject();
			System.out.println(d);

		} catch (ClassNotFoundException e) {
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}
}