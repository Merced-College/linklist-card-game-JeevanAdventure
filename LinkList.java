import java.util.Random;

public class LinkList
{
	private Link first;            // ref to first link on list

	//-------------------------------------------------------------
	public LinkList()              // constructor
	{
		first = null;               // no links on list yet
	}
	//-------------------------------------------------------------
	public void insertFirst(Card card)
	{                           // make new link
		Link newLink = new Link(card);
		newLink.next = first;       // it points to old first link
		first = newLink;            // now first points to this
	}
	public void add(Card card)
	{                           // make new link
		Link newLink = new Link(card);
		newLink.next = first;       // it points to old first link
		first = newLink;            // now first points to this
	}
	//-------------------------------------------------------------
	public Link find(Card cardToFind)      // find link with given key
	{                           // (assumes non-empty list)
		Link current = first;              // start at 'first'
		while(!current.equals(cardToFind))        // while no match,
		{
			if(current.next == null)        // if end of list,
				return null;                 // didn't find it
			else                            // not end of list,
				current = current.next;      // go to next link
		}
		return current;                    // found it
	}
	//-------------------------------------------------------------
	public Link delete(Card cardToFind)    // delete link with given key
	{                           // (assumes non-empty list)
		Link current = first;              // search for link
		Link previous = first;
		while(!current.equals(cardToFind))
		{
			if(!current.equals(cardToFind))
				return null;                 // didn't find it
			else
			{
				previous = current;          // go to next link
				current = current.next;
			}
		}                               // found it
		if(current.equals(cardToFind))               // if first link,
			first = first.next;             //    change first
		else                               // otherwise,
			previous.next = current.next;   //    bypass it
		return current;
	}
	//-------------------------------------------------------------
	public void displayList()      // display the list
	{
		System.out.print("List (first-->last): ");
		Link current = first;       // start at beginning of list
		while(current != null)      // until end of list,
		{
			current.displayLink();   // print data
			current = current.next;  // move to next link
		}
		System.out.println("");
	}
	//-------------------------------------------------------------

	//-------------------------------------------------------------
	public Card getFirst()    // delete link with given key
	{                           // (assumes non-empty list)
		Link current = first;              // search for link
		first = first.next;             //    change first
		return current.cardLink;
	}
	//-------------------------------------------------------------
	//Create a Shuffle/Random Operation to mimic a real life game, by getting random cards

	//Get size of current LinkedLists
	public int size() {
        int count = 0;
        Link current = first;
        while (current != null) { //Will increment count by 1 until all items have been traversed 
            count++;
            current = current.next;
        }
        return count; //this count represents the total index of cards in LinkedList
    }

	//Get card at its index
	private Link getLinkAt(int index) {
        Link current = first; //First node of linked List
        for (int i = 0; i < index; i++) { //
            if (current == null) return null; //if out of bounds
            current = current.next;
        }
        return current; // node at curent number index
    }
	// Shuffle the list of cards
    public void shuffle() {
        int size = size();
        Random rand = new Random(); //Object to generate random numbers

        for (int i = 0; i < size; i++) { 
            // Select two random positions
            int swapIndex1 = rand.nextInt(size);
            int swapIndex2 = rand.nextInt(size);

            // Swap nodes at these positions
            if (swapIndex1 != swapIndex2) { //so cards don't swap with themselves
                Link link1 = getLinkAt(swapIndex1);
                Link link2 = getLinkAt(swapIndex2);
				
				//Swap operation
                Card temp = link1.cardLink;
                link1.cardLink = link2.cardLink; //card "'1' is now card '2'
                link2.cardLink = temp;//Card '2' is now Card '1' (as it was stored in temp variable)
            }
        }
    }

	
}  // end class LinkList
////////////////////////////////////////////////////////////////
class LinkedLists
{
	public static void main(String[] args)
	{
		LinkList theList = new LinkList();  // make list

		theList.insertFirst(new Card("heart", "ace", 11,"ah.gif"));      // insert 4 items
		theList.insertFirst(new Card("Spade", "ace", 11,"as.gif"));
		//theList.insertFirst(66, 6.99);
		//theList.insertFirst(88, 8.99);

		theList.displayList();              // display list

		Link f = theList.find(new Card("heart", "ace", 11,"ah.gif"));          // find item
		if( f != null)
			System.out.println("Found link with key " + f.cardLink);
		else
			System.out.println("Can't find link");

		Link d = theList.delete(new Card("heart", "ace", 11,"ah.gif"));        // delete item
		if( d != null )
			System.out.println("Deleted link with key " + d.cardLink);
		else
			System.out.println("Can't delete link");

		theList.displayList();              // display list
	}  

	
}  
