﻿package ppt.ppt07;
public class StringCompare1 {
   public static void main(String []args){
      String s1 = "Apple";
      String s2 = "Apple";
      String s3 = new String ("Apple");
      System.out.println(s1==s2);
      System.out.println(s1==s3);
   }
}