package stringBasics;

public class StringBasicsImpl {
	public static void main(String[] args) {
		StringBasicsImpl d1 = new StringBasicsImpl();
		StringBasicsImpl d2 = new StringBasicsImpl();
		StringBasicsImpl d3 = new StringBasicsImpl();
		StringBasicsImpl d4 = d3;
		System.out.println(d1.equals(d2)); //false
		System.out.println(d3.equals(d4)); //true

		String str1 = new String("Hello");
		String str2 = new String("Hello");
		System.out.println("Values:"+str1.equals(str2)); //true
		System.out.println("Hashcode ");
		System.out.println(str1==str2);
	
		String str3 = "roshan";
		String str4 = "roshan";
		System.out.println("Values SCP:"+str3.equals(str4));
		System.out.println("Hashcode ");
		System.out.println(str3==str4); // it compare references or hashcode
		
		String s1 = new String("hello");
		s1 = s1.concat(" world");
		System.out.println(s1);
		s1 = s1 + " again";
		System.out.println(s1);
		
		StringBuffer sb1 = new StringBuffer("hello");
		sb1.append(" world");
		
		String name1 = new String("A");
		String name2 = new String("B");
		System.out.println(name1.compareTo(name2));
	}
}
