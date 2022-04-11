- 자료출처: Power Java Compact(출판사:인피니트 북스, 저자:천인국)

## Exercise
#1.double 형을 저장하는 ArrayList를 생성하는 문장을 작성하시오.
ANSWER 

``` 
 ArrayList<Double> list = new ArrayList<Double>();
```

#2.여러분이 어떤 정보를 저장하는데 절대 중복이 발생하면 안된다고 가정하자.
그리고 모든 요소들은 삽입된 순서대로 출력되어야 한다. 어떤 컬렉션을 사용하여야 하는가?
ANSWER  

```
(1)java.util.Map (2)java.util.Set (3)java.util.List (4)java.util.Collection
-답변: ②java.util.Set
```

#3.어떤 정보를 키:값의 쌍으로 저장하고자 한다. 어떤 컬렉션을 사용하여야 하는가?
ANSWER  

```
(1)java.util.Map (2)java.util.Set (3)java.util.List (4)java.util.Collection
-답변: ①java.util.Map 
```

#4.다음은 Stack 클래스의 일부분이다.

```
public class Stack {
	private init[] stack;
	public void push(int data) { ... }
	public int pop() { ... }
}
```
ANSWER  

``` 
(1) Stack에 자장되는 데이터의 타입을 int 대신에 제네릭 타입츠로 표시하여 보자.
-답변:
public class Stack<T> {
    private T[] stack;
    public void push(T data) { ... }
    public T pop() { ... }
}

(2) String 타입의 데이터를 가지는 Stack을 생성하는 문장을 쓰시오.
-답변: Stack<String> s = new Stack<String>();
```

#5.다음과 같이 리스트가 생성되었다고 하자. 다음의 각 문장을 실행한 후의 결과를 쓰시오.

```
String[] s = { "사과", "배", "바나나" };
ArrayList list = new ArrayList(Arrays.asList(s));
```
ANSWER  

``` 
(1) lias.add("포도"); System.out.Println(list);
-답변: [사과, 배, 바나나, 포도]
(2) lias.add(2, "자몽"); System.out.Println(list);
-답변: [사과, 배, 자몽, 바나나, 포도]
(3) System.out.Println(list.get(3));
-답변: 바나나
(4) list.remove(1); System.out.println(list);
-답변: [사과, 자몽, 바나나, 포도]
(5) System.out.println(list.contains("사과"));
-답변: true
(6) System.out.println(list.indexOf("사과"));
-답변: 0
```

#6.list가 ArrayList<Double>의 객체를 참조하고 있다고 하자.
list의 모든 원소를 출력하는 문장을 다음과 같이 작성하라.
ANSWER  

``` 
(1) 인덱스 변수를 사용하는 보통의 for 루프
-답변:
for(int i=0;i<list.length;i++)
	System.out.println(list[i]);
(2) for~each 구문을 사용
-답변:
for(Double data: list)
	System.out.println(data);
```

## Program Exercise
#1.   
ANSWER

```
class SimplePair<T> {
	private T data1;
	private T data2;

	public SimplePair(T data1, T data2) {
		this.data1 = data1;
		this.data2 = data2;
	}

	public T getFirst() {		return data1;	}
	public T getSecond() {		return data2;	}

	public void setFirst(T data1) {		this.data1 = data1;	}
	public void setSecond(T data2) {		this.data2 = data2;	}
}
public class SimplePairTest {

	public static void main(String[] args) {
		SimplePair<String> pair = new SimplePair<String>("apple", "tomato");
		System.out.println(pair.getFirst());
		System.out.println(pair.getSecond());
	}
}
```

#2.   
ANSWER

```
class MyMath<T extends Number> {
	double v=0.0;
	public double getAverage(T[] a){
		for (int i = 0; i < a.length; i++)
			v = v + a[i].doubleValue();
		return v/a.length;
	}
}

public class Test
{
	public static void main(String[] args) {
		Integer[] list = { 1, 2, 3, 4, 5, 6 };
		
		MyMath<Integer> m = new MyMath<Integer>();
		System.out.println(m.getAverage(list));
	}
}
```

#3.   
ANSWER

```
import java.util.ArrayList;

public class Test {
   public static void main(String[] args) {
      ArrayList<String> arrayList = new ArrayList<String>();
      arrayList.add("a");
      arrayList.add("b");
      arrayList.add("c");
      arrayList.add("d");
      arrayList.add("e");
      System.out.println("" + arrayList);
   }
}
```

#4.   
ANSWER

```
import java.util.*;
 
public class SetTest1 {
    public static void main(String[] args) {
        Set<String> s1 = new HashSet<String>();
        Set<String> s2 = new HashSet<String>();
 
        s1.add("A");
        s1.add("B");
        s1.add("C");
 
        s2.add("A");
        s2.add("D");
 
        Set<String> union = new HashSet<String>(s1);
        union.addAll(s2);
 
        Set<String> intersection = new HashSet<String>(s1);
        intersection.retainAll(s2);
 
        System.out.println("합집합 " + union);
        System.out.println("교집합 " + intersection);
    }
}
```

#5.  
ANSWER

```
import java.util.*;
 
public class QueueTest {
    public static void main(String[] args) throws InterruptedException {
        int time = 10;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = time; i >= 0; i--)
            queue.add(i);
        while (!queue.isEmpty()) {
            System.out.print(queue.remove()+" ");
            Thread.sleep(1000);	// 현재의 스레드를 1초간 재운다.
        }
    }
}
```

#6.   
ANSWER

```
import java.util.*;
 
public class EnglishDic {
       public static void main(String[] args) {
             Map<String, String> st = new HashMap<String, String>();

             st.put("map", "지도");
             st.put("java", "자바");
             st.put("school", "학교");

             Scanner sc = new Scanner(System.in);
             do {
                 System.out.print("영어 단어를 입력하시오:");
                 String key = sc.next();
                 if( key.equals("quit") ) break;
                 System.out.println("단어의 의미는 " + st.get(key));
             } while(true);
       }
}
```

#7.   
ANSWER

```
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SimpleWordCounter {
    
    public static void main(String[] args) {
        try {
            File f = new File("d://test.txt");
            Scanner sc;
            sc = new Scanner(f);
            Map<String, Integer> wordCount = new TreeMap<String, Integer>();
            while(sc.hasNext()) {
                String word = sc.next();
                if(!wordCount.containsKey(word))
                    wordCount.put(word, 1);
                else
                    wordCount.put(word, wordCount.get(word) + 1);
            }
            
            for(String word : wordCount.keySet())
                System.out.println(word + "-->" + wordCount.get(word));
            System.out.println("전체 단어 수: "+wordCount.size());
        }
        catch(IOException e) {
            System.out.println("Unable to read from file.");
        }
    }
}
```

#8.   
ANSWER

```
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Test
{
	public static void main(String[] args) {
		ArrayList<Double> list = new ArrayList<Double>();
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<10; i++){
			System.out.print("심사위원의 점수: ");
			double value = sc.nextDouble();
			list.add(value);
		}
		
		double max = Collections.max(list);
		double min = Collections.min(list);
		double sum = 0.0;
		double value = 0.0;
		for(int i=0;i<10; i++){
			value = list.get(i);
			if( value != min && value != max )
				sum += value;
		}
		System.out.print("점수의 합: "+ sum);
	}
}
```

#9.   
ANSWER

```
import java.util.HashSet;

public class Lotto {
	@Override
	public String toString() {
		return "Lotto [set=" + set + "]";
	}

	HashSet<Integer> set = new HashSet<Integer>();

	public Lotto() {
		int d;
		for (int i = 0; i < 6; i++) {
			do {
				d = (int) (Math.random() * 44.0 + 1.0);
			} while (set.contains(d));
			set.add(d);
		}
	}

	public static void main(String[] args) {
		Lotto lotto = new Lotto();
		System.out.println(lotto);

	}

}
```

#10.   
ANSWER

```
import java.util.*;
public class RandomList<T> {
	Random r = new Random();
	String[] sample = {"i", "walk", "the", "line"};
	List<T> list = (List<T>) Arrays.asList(sample);
	public void add(T item){
		list.add(item);
	}
	public T select() {
		int num = r.nextInt(list.size());
		return list.get(num);
	}
}
```