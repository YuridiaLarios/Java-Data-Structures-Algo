/**
 * This interface represents a list where the user can only access the beginning or ending elements of a list, not any elements from the middle of the list. 
 *  
 * 
 * @author Yuridia Larios Aispuro
 * @version 1
 * 
 *
 */

public interface EntryWayListInterface<T>
{

   /**
    * Adds a new entry to the top of this list.
    * Entries  originally in the list, (if any)  move to the next lower position within the list.
    * @param newEntry The object to be added as a new entry
    * @return true if the entry is successfully added to the top of the list, false otherswise.
    */
   public boolean insertHead(T newEntry);
   
   /**
    * Adds a new entry to the end of this list.
    * Entries currently in the list are unaffected,.
    * The list's size is increased by 1.
    * @param newEntry The object to be added to the end of the list. 
    * @return true if the entry is successfully added to the end of the list, false otherwise.
    */
  public  boolean insertTail(T newEntry);
  
  /**
   * Removes the entry at the top of this list
   * Other Entries currently in the list(if any) move up to the next higher position within the list.
   * The list's size is decreased by 1.
   * @return The object that has been deleted from the top of the list.
   */
  public T deleteHead();
   
   /**
    * Removes the entry at the end of this list.
    * Other Entries currently in the list(if any) are unaffected.
    * The list's size is decreased by 1.
    * @return The object that has been deleted from the end of the list.
    */
  public T deleteTail();

  /**
   * Print the list of entries in the order in which they occur in the list.
   */
  public void display();
  
  /**
   * Sees whether this list contains a given entry.
   * @param anEntry The object to look for within this list.
   * @return the position of the entry that was found.
   */
  public int contains(T anEntry);
  
/**
 * Sees whether this list is empty. 
 * @return True if the list is empty, or false if not.
 */
  public boolean isEmpty();
  
  /**
   * Sees whether this list is full.
   * @return true if list is full, or false otherwise
   */
 public  boolean isFull();
   
} // end of  EntryWayListInterface
