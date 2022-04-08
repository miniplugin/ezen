package ppt06;
class Animal2 {	
	public void eat()	
	{	
		System.out.println("동물이 먹고 있습니다. ");
	}
}; 

class Dog2 extends Animal2 {	
	public void eat()	
	{
		System.out.println("강아지가 먹고 있습니다.");
	}
};
public class DogTest1  {	
	    public static void main(String[] args) {
	    	Dog2 d = new Dog2();
	    	d.eat();
	    }
};