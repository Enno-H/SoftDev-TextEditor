package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if(element == null) {
			throw new NullPointerException();
		}
		LLNode<E> n = new LLNode<E>(element);
		n.prev = tail.prev;
		n.next = tail;
		tail.prev.next = n;
		tail.prev = n;
		size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if(index < 0||index >= size) {
			throw new IndexOutOfBoundsException();
		}
		int i = 0;
		LLNode<E> chosen = head;
		while(i <= index) {
			chosen = chosen.next;
			i++;
		}
		return chosen.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if(element == null) {
			throw new NullPointerException();
		}
		if(index < 0||index > size) {
			throw new IndexOutOfBoundsException();
		}
		int i = 0;
		LLNode<E> toAdd = head;
		while(i <= index) {
			toAdd = toAdd.next;
			i++;
		}
		LLNode<E> ele = new LLNode<E>(element);
		ele.next = toAdd;
		toAdd.prev.next = ele;
		ele.prev = toAdd.prev;
		toAdd.prev = ele;
		size++;
		
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if(index < 0||index >= size||size==0) {
			throw new IndexOutOfBoundsException();
		}
		int i = 0;
		LLNode<E> toRemove = head;
		while(i <= index) {
			toRemove = toRemove.next;
			i++;
		}
		toRemove.prev.next = toRemove.next;
		toRemove.next.prev = toRemove.prev;
		size--;
		return toRemove.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if(element == null) {
			throw new NullPointerException();
		}
		if(index < 0||index >= size) {
			throw new IndexOutOfBoundsException();
		}
		if(index < 0||index >= size) {
			throw new IndexOutOfBoundsException();
		}
		int i = 0;
		LLNode<E> toSet = head;
		while(i <= index) {
			toSet = toSet.next;
			i++;
		}
		E ans = toSet.data;
		toSet.data = element;
		return ans;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
