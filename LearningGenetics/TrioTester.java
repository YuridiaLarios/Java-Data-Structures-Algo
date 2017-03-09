/*
 * Title: TrioTester.java
 * Files: Trio.java, TrioTester.java
 * Semester: Spring 2017
 * 
 * Author: Provided File
 * Professor: Jessica Masters
 * Class: 111C
 * 
 * This is the  driver program used to test the Trio.java class 
 */

public class TrioTester {

	public static void main(String[] args) {
		
		Trio<Integer> trio1 = new Trio<Integer>(3, 4, 5);
		System.out.println("Should print a text representation:");
		System.out.println(trio1);
		System.out.println("Item 1 should be 3: " + trio1.getItem1());
		System.out.println("Item 2 should be 4: " + trio1.getItem2());
		System.out.println("Item 3 should be 5: " + trio1.getItem3());
		System.out.println("Contains 4? Should be true: " + trio1.contains(4));
		System.out.println("Contains 7? Should be false: " + trio1.contains(7));
		System.out.println("Items are the same? Should be false: " + trio1.sameItems());
		trio1.setItem1(6);
		trio1.setItem2(6);
		System.out.println("Item 1 should be 6: " + trio1.getItem1());
		System.out.println("Item 2 should be 6: " + trio1.getItem2());
		System.out.println("Items are the same? Should be false: " + trio1.sameItems());
		trio1.setItem3(6);
		System.out.println("Item 3 should be 6: " + trio1.getItem3());
		System.out.println("Items are the same? Should be true: " + trio1.sameItems());
		System.out.println();
		
		/* 
		 * un-comment the line of code below and it should cause a compiler error 
		 * because numberTrio1 should only accept Integers, not Strings
		 */
		//trio1.setItem1("hello");
		
		Trio<String> wordTrio = new Trio<String>("hello", "goodbye", "nice knowing you");
		System.out.println(wordTrio);
		System.out.println("Item 1 should be hello: " + wordTrio.getItem1());
		System.out.println("Item 2 should be goodbye: " + wordTrio.getItem2());
		System.out.println("Item 3 should be nice knowing you: " + wordTrio.getItem3());
		System.out.println("Contains hello? Should be true: " + wordTrio.contains("hello"));
		System.out.println("Contains hi? Should be false: " + wordTrio.contains("hi"));
		System.out.println("Items are the same? Should be false: " + wordTrio.sameItems());
		wordTrio.setItem2("hello");
		System.out.println("Items are the same? Should be false: " + wordTrio.sameItems());
		wordTrio.setItem3("hello");
		System.out.println("Items are the same? Should be true: " + wordTrio.sameItems());
		System.out.println();
		
		/* 
		 * un-comment the line of code below and it should cause a compiler error 
		 * because wordTrio should only accept Strings
		 */
		//wordTrio.setItem2(3);

		
		Trio<Integer> numberTrio2 = new Trio<Integer>(5, 6, 8);
		Trio<Integer> numberTrio3 = new Trio<Integer>(8, 5, 6);
		System.out.println("Trios the same? Should be true: " + numberTrio2.equals(numberTrio3));
		numberTrio2.setItem2(5);
		System.out.println("Trios the same? Should be false: " + numberTrio2.equals(numberTrio3));
		System.out.println("Trios the same? Should be false: " + numberTrio2.equals(wordTrio));
		System.out.println();
		Trio<Integer> numberTrio4 = new Trio<Integer>(1, 1, 2);
		Trio<Integer> numberTrio5 = new Trio<Integer>(1, 2, 1);
		System.out.println("Trios the same? Should be true: " + numberTrio4.equals(numberTrio5));

	}

}
