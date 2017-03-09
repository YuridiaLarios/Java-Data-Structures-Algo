/**
 * This interface represents a list of book titles where the user can only access the top  entry of the list, simulating a pile of books where you can only
 * remove the top book of the pile. 
 *  
 * 
 * @author Yuridia Larios Aispuro
 * @version 1
 * 
 *
 */

public interface BookListInterface<String> {
	
	/**
	    * Adds a new book title to the top of this list, representing the top of a book pile.
	    * Entries  originally in the list, (if any)  move to the next lower position within the list.
	    * 
	    * @param newBookTitle a new book title is added to the top of the list.
	    * @return true if the book title entry is successfully added.
	    */
	   public boolean insertTop(String newBookTitle);
	   
	   /**
	    * Removes the book title at the top of this list 
	    * Other Entries currently in the list(if any) move up to the next higher position within the list.
	    *  @return The book title that has been deleted from the top of the list.
	    */
	   public String deleteTopBook();
	   
	  	   
	   /**
	    * Retrieves the book title at the top of this list (position 1)
	    * @return The book title at the top of the list.
	    */
	   public String whichBookOnTop();
	   
	   
	   /**
	    * Determine if this list is empty. 
	   * @return True if the list is empty meaning there are no book titles on it, or false otherwise..
	   */
	    public boolean isEmpty();
	    
	    
	    /** Removes all book titles  from this list. */
	    public void clear();
	   
}// end of BookListInterface
