package ppt12;
import java.util.*;
 
class Student {
       int number;
       String name;
 
       public Student(int number, String name) {
             this.number = number;
             this.name = name;
       }
 
       public String toString() {
             return name;
       }
}
 
public class MapTest {
       public static void main(String[] args) {
             Map<String, Student> st = new HashMap<String, Student>();
             st.put("100", new Student(100, "홍길동"));
             st.put("200", new Student(200, "김유신"));
             st.put("300", new Student(300, "김철수"));
 
             // 모든 항목을 출력한다.
             System.out.println(st);
 
             // 하나의 항목을 삭제한다.
             st.remove("200");

             // 하나의 항목을 대치한다.
             st.put("100", new Student(20090003, "최자영"));
             // 값을 참조한다.
             System.out.println(st.get("300"));
             // 모든 항목을 방문한다.
             for (Map.Entry<String, Student> s : st.entrySet()) {
                    String key = s.getKey();
                    Student value = s.getValue();
                    System.out.println("key=" + key + ", value=" + value);
             }
       }
}