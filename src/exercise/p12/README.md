## Excercise
#1.   
ANSWER 

``` 
 ArrayList<Double> list = new ArrayList<Double>();
```

#2.   
ANSWER  

```
 ②java.util.Set
```

#3.   
ANSWER  

```
 ①java.util.Map 
```

#4.   
ANSWER  

``` 
(1)
public class Stack <T> {
    private T[] stack;
    public void push(T data) { ... }
    public T pop() { ... }
}

(2) 
Stack<String> s = new Stack<String>();
```

#5.   
ANSWER  

``` 
(1) [사과, 배, 바나나, 포도]
(2) [사과, 배, 자몽, 바나나, 포도]
(3) 바나나
(4) [사과, 자몽, 바나나, 포도]
(5) true
(6) 0
```

#6.   
ANSWER  

``` 
(1) 
for(int i=0;i<list.length;i++)
	System.out.println(list[i]);
(2) 
for(Double data; list)
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