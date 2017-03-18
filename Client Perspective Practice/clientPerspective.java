// Practicing writing metods from the client perspective using both BagInterface and ListInterface with 
// some objects created from the ArrayBag and AList
import java.util.Arrays;

public class clientPerspective {
	public static void main(String[] args) {
		AList<Integer> list1 = new AList<Integer>();
		AList<Integer> list2 = new AList<Integer>();

		list1.add(1);
		list1.add(12);
		list1.add(14);
		list1.add(14);

		list2.add(4);
		list2.add(6);
		list2.add(8);
		list2.add(10);

		///////////////////////////////////////////////////////////////////////////////////////////////

		ListInterface<Integer> bothListsMerged = mergeList(list1, list2);
		System.out.println("MergedLists should contain    {1, 4, 2, 6, 3, 8,4, 10} \n\t\t"
				+ Arrays.toString(bothListsMerged.toArray()));

		///////////////////////////////////////////////////////////////////////////////////////////////

		System.out.println(containsDuplicates(list1));

		///////////////////////////////////////////////////////////////////////////////////////////////

		ArrayBag<Integer> bag1 = new ArrayBag<Integer>();
		ArrayBag<Integer> bag2 = new ArrayBag<Integer>();

		bag1.add(1);

		bag2.add(2);
		bag2.add(2);

		BagInterface<Integer> bothbagsMerged = mergeBag(bag1, bag2);
		System.out.println("Mergedbags should contain    {1, 4, 2, 6, 3, 8,4, 10} \n\t\t"
				+ Arrays.toString(bothbagsMerged.toArray()));
		
		
		///////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println(currentSize(bag2));
		

	}

	// Write code at the client level that merges two lists. The method takes
	// two lists as parameters and returns the new list.
	// For example: List1 = {1, 2, 3}, List2 = {4, 6, 8, 10}, return a new list:
	// {1, 4, 2, 6, 3, 8, 10}. The original two lists should not be
	// modified when your program ends.

	public static <T> AList<T> mergeList(ListInterface<T> list1, ListInterface<T> list2) {
		AList<T> mergedList = new AList<T>();

		ListInterface<T> longList, shortList;

		if (list1.getLength() >= list2.getLength()) {
			longList = list1;
			shortList = list2;
		} else {
			longList = list2;
			shortList = list1;
		}

		for (int i = 1; i <= longList.getLength(); i++) {
			if (i <= shortList.getLength()) {
				mergedList.add(list1.getEntry(i));
				mergedList.add(list2.getEntry(i));
			} else {
				mergedList.add(longList.getEntry(i));
			}
		}

		return mergedList;
	}

	// Write code at the client level that merges two bags.

	public static ArrayBag<Integer> mergeBag(BagInterface<Integer> bag1, BagInterface<Integer> bag2) {
		ArrayBag<Integer> mergedBag = new ArrayBag<Integer>();
		BagInterface<Integer> moreItems, lessItems;
		BagInterface<Integer> tempBag1 = new ArrayBag<Integer>();
		BagInterface<Integer> tempBag2 = new ArrayBag<Integer>();
		BagInterface<Integer> tempMoreItems = new ArrayBag<Integer>();

		Integer item1, item2;

		if (bag1.getCurrentSize() >= bag2.getCurrentSize()) {
			moreItems = bag1;
			lessItems = bag2;
		} else {
			moreItems = bag2;
			lessItems = bag1;
		}

		while (!moreItems.isEmpty()) {
			if (!lessItems.isEmpty()) {
				item1 = bag1.remove();
				item2 = bag2.remove();
				mergedBag.add(item1);
				mergedBag.add(item2);
				tempBag1.add(item1);
				tempBag2.add(item2);
			} else {
				item1 = moreItems.remove();
				mergedBag.add(item1);
				tempMoreItems.add(item1);
			}
		}

		while (!tempBag1.isEmpty()) {
			bag1.add(tempBag1.remove());
		}
		while (!tempBag2.isEmpty()) {
			bag2.add(tempBag2.remove());
		}
		while (!tempMoreItems.isEmpty()) {
			moreItems.add(tempMoreItems.remove());
		}

		return mergedBag;

	}
	// Write a containsDuplicates method for lists from the client perspective.
	// The method takes a list as a parameter. The list should not be modified
	// when the method ends.

	public static boolean containsDuplicates(ListInterface<Integer> list) {

		if (!list.isEmpty()) {
			for (int i = 1; i <= list.getLength(); i++) {
				for (int j = i + 1; i < list.getLength() && j <= list.getLength(); j++) {
					if (list.getEntry(i).equals(list.getEntry(j))) {
						return true;
					}
				}
			}
		}

		return false;
	}
	
	
	// Assume there is no getCurrentSize() method in BagInterface.
	//Write a getSize method for bags from the client perspective. 
	//The method takes a bag as a parameter. The bag should not be modified when the method ends.
	
	public static <T> int currentSize(BagInterface<T> bag){
		BagInterface<T> tempBag = new ArrayBag();
		int currentSize = 0;
		T item;
		
		while(!bag.isEmpty()){
			item = bag.remove();
			tempBag.add(item);
			currentSize++;
		}
		
		while(!tempBag.isEmpty()){
			bag.add(tempBag.remove());
		}
		
		
		return currentSize;
	}
}
