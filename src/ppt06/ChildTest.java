package ppt06;
class Parent {
    public void print() {

        System.out.println("부모 클래스의 print() 메소드");
    }
}
class Child extends Parent {
    public void print() {    

        super.print();
        System.out.println("자식 클래스의 print() 메소드 ");
    }
}
public class ChildTest {
    public static void main(String[] args) {
           Child obj = new Child();
           obj.print();     
    }
}