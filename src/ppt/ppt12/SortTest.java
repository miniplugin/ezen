package ppt.ppt12;
import java.util.*;
 
class Student2 implements Comparable<Student2> {
	   Integer number;
       String name;
 
	public Student2(Integer number, String name) {
             this.number = number;
             this.name = name;
       }
 
       public String toString() {
             return name;
       }
	@Override
	public int compareTo(Student2 o) {
		System.out.println(o.toString() + name + "=" + (number - o.number));
		return o.number - number;//비교조건 양수면 그대로, 음수면 자리를 바꾼다.
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
        int index = Collections.binarySearch(list, new Student2(1, null));
        System.out.println(list.get(index));
    }
}