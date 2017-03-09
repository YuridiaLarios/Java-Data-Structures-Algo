/**
 * A class that implements the EntryWayListInterface by using a chain of linked
 * nodes that has a head reference and a tail reference.
 * 
 * @author Yuridia Larios-Aispuro
 */
public class HeadTailList<T> implements EntryWayListInterface<T> {

	private Node firstNode; // Reference to first node of chain
	private Node lastNode; // Reference to last node of chain
	private int numberOfEntries;

	public HeadTailList() {
		initializeDataFields();
	} // end default constructor

	public void clear() {
		initializeDataFields();
	} // end clear

	// Adds a new entry to the top of this list.
	public boolean insertHead(T newEntry) {
		Node newNode = new Node(newEntry);
		boolean isSuccessful = false;

		if (isEmpty()) {
			firstNode = newNode;
			lastNode = newNode;
			numberOfEntries++;
			isSuccessful = true;
		}

		else {
			newNode.next = firstNode;
			firstNode = newNode;
			numberOfEntries++;
			isSuccessful = true;
		}
		return isSuccessful;
	}

	// adds a new entry to the tail of this list.
	public boolean insertTail(T newEntry) {
		Node newNode = new Node(newEntry);
		boolean isSuccessful = false;

		if (isEmpty()) {// Add to end of non-empty list
			firstNode = newNode;
			lastNode = newNode;
			numberOfEntries++;
			isSuccessful = true;
		} else {
			lastNode.next = newNode; // Make last node reference new node
			lastNode = newNode;
			numberOfEntries++;
			isSuccessful = true;
		}

		return isSuccessful;
	}

	// deletes an entry from the top of the list.
	public T deleteHead() {
		T result = null; // Return value

		if (!isEmpty()) {
			result = firstNode.getData();
			firstNode = firstNode.getNextNode();
			if (numberOfEntries == 1) {
				firstNode = null;
				lastNode = null;
			}
			numberOfEntries--;
		}

		return result;
	}

	// deletes an entry from the tail of the list.
	public T deleteTail() {
		T result = null;

		if (!isEmpty()) {

			if (numberOfEntries == 1) {
				result = firstNode.getData();
				firstNode = firstNode.getNextNode();
				lastNode = null;
			} else {
				result = lastNode.getData();
				Node nodeBeforeLast = getNodeAt(numberOfEntries - 1);
				nodeBeforeLast.next = null;
				lastNode = nodeBeforeLast;
			}
			numberOfEntries--;
		}
		return result;
	}

	// Print the list of entries in the order in which they occur in the list or
	// a message if the list is empty.
	public void display() {
		if (isEmpty()) {
			System.out.println("The list is empty");
		} else {
			Node currentNode = firstNode;
			for (int i = 0; i < numberOfEntries; i++) {
				System.out.println(currentNode.data);
				currentNode = currentNode.next;
			}
		}
	}

	// Sees whether this list contains a given entry and if it does it returns
	// its position, otherwise it returns -1.
	public int contains(T anEntry) {
		int position = -1;
		int counter = 1;
		boolean found = false;
		Node currentNode = firstNode;

		while (!found && (currentNode != null)) {
			if (anEntry.equals(currentNode.getData())) {
				found = true;
				position = counter;
			} else {
				currentNode = currentNode.getNextNode();
				counter++;
			}
		} // end while

		return position;
	} // end contains

	// Sees whether this list is empty.
	public boolean isEmpty() {
		boolean result;

		if (numberOfEntries == 0) // Or getLength() == 0
		{
			assert firstNode == null;
			result = true;
		} else {
			assert firstNode != null;
			result = false;
		} // end if

		return result;
	} // end isEmpty

	// sees whether the list is full.
	public boolean isFull() {
		return false;
	}

	// Initializes the class's data fields to indicate an empty list.
	private void initializeDataFields() {
		firstNode = null;
		lastNode = null;
		numberOfEntries = 0;
	} // end initializeDataFields

	// Returns a reference to the node at a given position.
	// Precondition: The chain is not empty;
	// 1 <= givenPosition <= numberOfEntries.
	private Node getNodeAt(int givenPosition) {
		assert !isEmpty() && (1 <= givenPosition) && (givenPosition <= numberOfEntries);
		Node currentNode = firstNode;

		// Traverse the chain to locate the desired node
		// (skipped if givenPosition is 1)
		for (int counter = 1; counter < givenPosition; counter++)
			currentNode = currentNode.getNextNode();

		assert currentNode != null;

		return currentNode;
	} // end getNodeAt

	private class Node {
		private T data; // Entry in list
		private Node next; // Link to next node

		private Node(T dataPortion) {
			data = dataPortion;
			next = null;
		} // end constructor

		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		} // end constructor

		private T getData() {
			return data;
		} // end getData

		private void setData(T newData) {
			data = newData;
		} // end setData

		private Node getNextNode() {
			return next;
		}
	} // end getNextNode

}
