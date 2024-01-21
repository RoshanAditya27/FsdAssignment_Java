package oops;

public class Parent extends Object{
	int pid = 100;
	
	public Parent() {
		super();
		System.out.println("Parent object is created...");
	}

	@Override
	public String toString() {
		return "Parent [pid=" + pid + "]";
	}
	
	public void m1()
	{
		System.out.println("m1() called from Parent..");
	}
}
