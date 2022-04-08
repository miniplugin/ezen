package ppt12;
import java.util.*;
 
class Student3 {
       int number;
       String name;
 
       public Student3(int number, String name) {
             this.number = number;
             this.name = name;
       }
       public String toString() {        return name;       }
}
 
public class SortTest2 {
    public static void main(String[] args) {
        Student3 array[] = {
            new Student3(2, "김철수"),
            new Student3(3, "이철수"),
            new Student3(1, "박철수"),
        };
        List<Student3> list = Arrays.asList(array);
        Collections.sort(list, (Student3 s1, Student3 s2)->{return (s1.number-s2.number);});

        System.out.println(list);
    }
}