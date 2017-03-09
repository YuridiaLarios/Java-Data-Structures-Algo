/*
 * Title: Trio.java
 * Files: Trio.java, TrioTester.java
 * Semester: Spring 2017
 * 
 * Author: Yuridia Larios
 * Professor: Jessica Masters
 * Class: 111C
 * 
 * This class takes three unordered items of the same type 
 * and uses generics to ensure that the three objects are of the same type. 

 */
public class Trio<T> {
	private T item1, item2, item3;

	public Trio(T item1, T item2, T item3) {
		this.item1 = item1;
		this.item2 = item2;
		this.item3 = item3;
	}

	public T getItem1() {
		return item1;
	}

	public T getItem2() {
		return item2;
	}

	public T getItem3() {
		return item3;
	}

	public void setItem1(T newItem1) {
		this.item1 = newItem1;
	}

	public void setItem2(T newItem2) {
		this.item2 = newItem2;
	}

	public void setItem3(T newItem3) {
		this.item3 = newItem3;
	}

	// This method returns whether or not A Trio object contains an item sent in as a parameter.
	public boolean contains(T compareItem) {
		if ((compareItem.equals(item1)) || (compareItem.equals(item2)) || (compareItem.equals(item3))) {
			return true;
		} else
			return false;
	}

	// This method returns true if the three items are equal to each other.
	public boolean sameItems() {
		if ((item1.equals(item2)) && (item2.equals(item3))) {
			return true;
		} else
			return false;
	}

	@Override
	public String toString() {
		String s = "This Trio contains: (" + item1 + ", " + item2 + ", " + item3 + ")";
		return s;
	}

	// This method returns true if the current Trio holds the same three items in any order as 
	// the Trio sent as a parameter.
	@Override
	public boolean equals(Object other) {
		if (other instanceof Trio<?>) {
			Trio<?> otherTrio = (Trio<?>) other;
			boolean sameTrioSet = false;

			if ((this.item1.equals(otherTrio.item1) && (this.item2.equals(otherTrio.item2))
					&& this.item3.equals(otherTrio.item3))) {
				sameTrioSet = true;
			}

			else if ((this.item1.equals(otherTrio.item1) && (this.item2.equals(otherTrio.item3))
					&& this.item3.equals(otherTrio.item2))) {
				sameTrioSet = true;
			}

			else if ((this.item1.equals(otherTrio.item2) && (this.item2.equals(otherTrio.item1))
					&& this.item3.equals(otherTrio.item3))) {
				sameTrioSet = true;
			}

			else if ((this.item1.equals(otherTrio.item3) && (this.item2.equals(otherTrio.item1))
					&& this.item3.equals(otherTrio.item2))) {
				sameTrioSet = true;
			}

			else if ((this.item1.equals(otherTrio.item2) && (this.item2.equals(otherTrio.item3))
					&& this.item3.equals(otherTrio.item1))) {
				sameTrioSet = true;
			}

			else if ((this.item1.equals(otherTrio.item3) && (this.item2.equals(otherTrio.item2))
					&& this.item3.equals(otherTrio.item1))) {
				sameTrioSet = true;
			}

			return sameTrioSet;

		} else {
			return false;
		}
	}

}
