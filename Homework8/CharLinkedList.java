package linked;

import java.util.*;


public class CharLinkedList 
{
	private CharNode		head;	// Empty if head and
	private CharNode		tail;	// tail are null
	
	
	public CharLinkedList()		{ }
	
	
	public CharLinkedList(String s)
	{
		for (int i=s.length()-1; i>=0; i--)
			insertAtHead(s.charAt(i));
	}
	
	
	public void insertAtHead(char ch)
	{
		assert hasIntegrity();		// Precondition
		
		CharNode node = new CharNode(ch);
		node.setNext(head);
		head = node;
		if (tail == null)
			tail = node;			// Corner case: inserting into empty node
		
		assert hasIntegrity();		// Postcondition
	}
	
	
	
	//Returns the first node in the list whose data is equal to char
	//If no such node is found, return null
	public CharNode find(char ch)
	{
		assert hasIntegrity();
		
		CharNode current = head; 
		while (current != null)
		{
			if (current.getData() == ch)
			{
				return current;
			}
			else 
			{
				current = current.getNext();
			}
		}
		return null;
	
	}
	
	
	//Finds the first node in the list whose data is equal to ch 
	//If the node is found, then a duplicate of it will be made and will be inserted after the position of the current node 
	//If no such node is found, throw a IllegalArgumentException
	public void duplicate(char ch)
	{
		
		CharNode target = find(ch); 
		if (target == null)
		{
			throw new IllegalArgumentException("Cannot find target node " + ch + " in list.");
		}
		
		CharNode current = head; 
		
		if (current.getData() == ch)
		{
			CharNode duplicate = new CharNode(ch); 
			CharNode n1 = target.getNext();
				
			current.setNext(duplicate);
			duplicate.setNext(n1);
		}
		else 
		{
			current = current.getNext();
		}
			
		if (current == tail)
		{
			CharNode duplicate = new CharNode(ch);
			current.setNext(duplicate);
			tail = duplicate;
		}
		
		
	}
	
	
	
	
	public String toString()
	{
		String s = "";
		CharNode node = head;
		while (node != null)
		{
			s += node.getData();
			node = node.getNext();
		}
		return s;
	}
	
	
	//
	// Returns true if this list has emptiness integrity, has tail integrity, has no loops,  
	// and tail is reachable from head.
	//
	// Caution: this checks for most but not all common integrity problems. 
	//
	boolean hasIntegrity()
	{
		// Check emptiness. If either head or tail is null, the other must
		// also be null. Different logic from what you saw in lecture. Returns
		// immediately if this list is empty.
		if (head == null  ||  tail == null)
			return head == null  &&  tail == null;
		
		// Check tail integrity (tail.next must be null).
		if (tail.getNext() != null)
			return false;
		
		// Check for loops.
		Set<CharNode> visitedNodes = new HashSet<>();
		CharNode node = head;
		while (node != null)
		{
			if (visitedNodes.contains(node))
				return false;		// Current node has been visited before, we must have a loop
			visitedNodes.add(node); // First visit to this node
			node = node.getNext();
		}
		
		// Make sure tail is reachable from head.
		node = head;
		while (node != null && node != tail)
			node = node.getNext();
		return node == tail;
	}
}
