package ppt.ppt12;
import java.util.*;
 
class Student3 {
	   Integer number;
       String name;
 
       public Student3(Integer number, String name) {
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
        Collections.sort(list, new Comparator<Student3>() {

			@Override
			public int compare(Student3 o1, Student3 o2) {
				// TODO Auto-generated method stub
				//return o1.number - o2.number;
				return o2.name.compareTo(o1.name);
			}
		});
        //Collections.sort(list, (Student3 s1, Student3 s2)->{return (s1.number-s2.number);});
        
        System.out.println(list);
        Comparator<Student3> cmp = new Comparator<Student3>() {
        	public int compare(Student3 o1, Student3 o2) {
				//return o2.name.compareTo(o1.name);
        		return o1.number - o2.number;
			}
        };
        //int index = Collections.binarySearch(list, new Student3(null, "박철수"),cmp);
        int index = Collections.binarySearch(list, new Student3(2, null),cmp);
        System.out.println(list.get(index));
    }
}