/*
 *  This is a driver program to test the HeadTailListimplementation 
 *  This driver program operates from the client perspective.
 */
public class ImplementationTestingDriver {
	public static void main(String[] args) {

		// creates empty list.
		EntryWayListInterface<String> myList = new HeadTailList<String>();

		// testing to display an empty list
		System.out.println("***The list should be empty:  ***");
		myList.display();

		// testing correct adding of entries methods and displaying them.
		myList.insertHead("3-firstHeadEntry");
		myList.insertHead("2-secondlHeadEntry");
		myList.insertTail("4-firstTailEntry");
		myList.insertTail("5-actualTailEntry");
		myList.insertHead("1-actualHeadEntry");

		System.out.println("\n***The order should be: 1-actualHeadEntry, 2-secondHeadEntry, 3-firstHeadEntry, 4-firstTailEntry, 5-actualTailEntry***");
		myList.display();

		// remove the first and last entry
		System.out.println("\n***Should return: 1-actualHeadEntry*** \n" + myList.deleteHead());
		System.out.println("\n***Should return 5-actualTailEntry*** \n" + myList.deleteTail());

		// display list
		System.out.println("\n***The order should be: 2-secondHeadEntry, 3-firstHeadEntry, 4-firstTailEntry***");
		myList.display();

		// test to see if an actual elements is in the list
		System.out.println("\n***The position should be: 3***\n" + myList.contains("4-firstTailEntry"));

		// test a non-existent entry
		System.out.println("\n***-1 ***\n" + myList.contains("banana"));

		// remove the last three elements in the list
		myList.deleteTail();
		myList.deleteTail();
		myList.deleteTail();

		// tries to remove an entry from an empty list
		System.out.println("\n***null***\n" + myList.deleteHead());

	}

}
