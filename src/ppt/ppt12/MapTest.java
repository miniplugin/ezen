package ppt.ppt12;
import java.lang.reflect.Field;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
 
class Student {
       Integer number;
       String name;
 
       public Student(Integer number, String name) {
             this.number = number;
             this.name = name;
       }
 
       public Student() {
			// TODO Auto-generated constructor stub
		}

		public int getNumber() {
			return number;
		}
	
		public void setNumber(int number) {
			this.number = number;
		}
	
		public String getName() {
			return name;
		}
	
		public void setName(String name) {
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
                    Student student = s.getValue();//객체생성 출력시 toString 메서드 자동실행
                    int number = student.getNumber();
                    String name = student.getName();
                    System.out.println("key=" + key + ", name=" + name+ ", number=" + number);
             }
       }
}