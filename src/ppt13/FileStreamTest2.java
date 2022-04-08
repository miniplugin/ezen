﻿package ppt13;
import java.io.*;

public class FileStreamTest2 {

	public static void main(String[] args) {

		byte list[] = new byte[6];
		try (FileInputStream out = new FileInputStream("D://test.bin")) {
			out.read(list);
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (byte b : list)
			System.out.print(b + " ");
		System.out.println();
	}
}