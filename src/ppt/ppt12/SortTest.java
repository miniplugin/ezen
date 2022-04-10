package ppt.ppt12;
import java.util.*;
 
class Student2 implements Comparable<Student2> {
       int number;
       String name;
 
       public Student2(int number, String name) {
             this.number = number;
             this.name = name;
       }
 
       public String toString() {
             return name;
       }
	@Override
	public int compareTo(Student2 o) {
		return o.number - number;
	}
}
 
public class SortTest {
    public static void main(String[] args) {
        Student2 array[] = {
            new Student2(2, "김철수"),
            new Student2(3, "이철수"),
            new Student2(1, "박철수"),
        };
        List<Student2> list = Arrays.asList(array);
        Collections.sort(list);

        System.out.println(list);
    }
}