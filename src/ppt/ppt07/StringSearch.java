﻿package ppt.ppt07;
public class StringSearch {
   public static void main(String[] args) {
      String s = "The cat is on the table";
      int index = s.indexOf("table");
      
      if(index == -1) 
         System.out.println("table은 없습니다. ");
      else 
         System.out.println("table의 위치: " + index);
   }
}