import java.util.*;
import java.io.*;

/**
 * CS300 Data Structures
 * @author Stan Bozhinov
 * @credit Tom Capaul, 
 * data structures with java (set, sublist)
 */

public class LinkedList implements Serializable, Cloneable,  Queue<Object>, Deque<Object>, Iterable<Object>, Collection<Object>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private class LinkedListIterator implements Iterator<Object>
	{        
		private Node cur;
		
		public LinkedListIterator(Node front)
		{
			this.cur = front;
		}

	public boolean hasNext() {

		
		return this.cur.next != null;
	}

	public Object next() {
		if (hasNext())
		{
			
			cur = cur.next;
			return cur.data;
		}
		throw new NoSuchElementException("at end of list on call to next");
	}

	public void remove() {
		throw new UnsupportedOperationException("Unsupported Operation");
		
	}

	
}
	
	private class Node
	{
		@SuppressWarnings("rawtypes")
		public Comparable data;
		public Node next;
		
		public Node(Object data)
		{
			this.data = data.toString();
		}
		
	}
	
	private Node head;
	private int size;
	
	public LinkedList()
	{
		this.head = null;
	}
	
	public boolean add(Object data)
	{
		
		Node newNode = new Node(data);
		if (size == 0)
		{
			head = newNode;
		}
		else
		{
			Node cur = head;
			while (cur.next != null)
			{
				cur = cur.next;
			}
			cur.next = newNode;
		}
		size++;
		return true;
	}
	
	public int size(){
		return this.size;
	}
	
	public void add(int index, Object value)
	{
		if (index >= 0 && index <= size)
		{
			Node newNode = new Node(value);
			if(index == 0)
			{
				newNode.next = head;
				head = newNode;
			}
			else
			{
				Node prev = find(index - 1);
				newNode.next = prev.next;
				prev.next = newNode;
			}
			size++;
		}
		else
		{
			throw new IndexOutOfBoundsException("List index error on add (out of range): " + index);
		}
	}
	
	private Node find(int index)
	{
		Node cur = head;
		for (int skip = 0; skip < index; skip++)
		{
			cur = cur.next;
		}
		
		return cur;
	}
	
	@Override
	public String toString()
	{
		String s = "";
		//iterate through linked list
		for(Node cur = head; cur != null; cur = cur.next)
		{
			//append all values to the string
			s += cur.data + " ";
		}
		return s;
	}
	
	
	   // Sort the list (selection sort)
	   @SuppressWarnings({"rawtypes", "unchecked"})
	void sort()
	   {
		   if(size>0){
	      Node cur, start, smallest;
	      
			Comparable temp;
			
			for(start= this.head; start != null; start = start.next)
			{
				smallest = start;
				
				for(cur = start.next; cur != null; cur = cur.next)
				{
					if(cur.data.compareTo(smallest.data)<0)
						smallest = cur;
				}
				
				temp = start.data;
				start.data = smallest.data;
				smallest.data = temp;		
				
			}// end for
		   }
	   }// end sort
	   
	   
	public void clear(){
		   this.head.next = null;
		   this.head = null;
		   size=0;
	   }

	public void addAll(Collections list) {
		
		Node cur = this.head.next;	
		for(Node prev = this.head; cur != null && cur.data.compareTo(list)<0; cur = cur.next ){
			prev = cur;
		}
//		prev.next = new Node(dataToAdd, cur);
		
	}
	
  	
	public int indexOf(Object o){
			int index = 0;
			Node cur = head;
			while (cur != null) {
			   if (cur.data.toString().equals(o))
			   return index;
			   index++;
			   cur = cur.next;
			 }
			
			return -1;	
		  }
	
	public int lastIndexOf(Object o){
		boolean found = false;		
		int index = 0;
		int lastindex = 0;
		Node cur = head;
		while (cur != null){
			if (cur.data.toString().equals(o)){
				lastindex = index;
			    found = true;
			}
		   index++;
		 cur = cur.next;
		 }
		if(found){
			return lastindex;
		}
		else{
			return -1;	
		}
	  }
	
		public Object set(int index, Object object){
			if(index<0){
				throw new IndexOutOfBoundsException();
			}
			Node cur = head;
			for(int i=0; i<index; i++){
				if(head==null){
					throw new NoSuchElementException();
				}
				cur=cur.next;
			}
			cur.data = object.toString();
			
		  return object;
		  }
		
		public String getFirst(){
			if (size == 0)
				 throw new NoSuchElementException();
			return head.data.toString();
		}
			
	public void addLast(Object str) {
		add(str);				
	}

	public boolean contains(Object string) {
		boolean found = false;
		for(Node cur = head; cur !=null; cur =cur.next ){
			if(cur.data.equals(string)){
				found = true;
			}
		}
		return found;
	}

	public String get(int i) {
		
		if(i<0){
			throw new java.util.NoSuchElementException();
		}
		
		String str =  find(i).data.toString();
		return str;
	}
	
	   public Object clone() {
		 LinkedList myclone = new LinkedList();  
	     for(Node cur = this.head; cur != null; cur = cur.next){
	    	myclone.add(cur.data.toString()) ;
	     }
	     
	     return myclone;
	   }
	   
	   
	public Object removeLast() {
		
			//case: list empty
			if (head == null) {
				return "";
			}
			
			Node cur = head; 
			Node prev = null;
			while (cur.next != null){
				prev = cur;
				cur = cur.next;
			}
						
			if (prev != null){
				prev.next = null;
				size--;
			}
			
			else{
				head = null;
				size--;
			}
		return cur.data.toString();
	}//end removeLast()

	public String getLast() {		
		String str = "";
		//case: list empty
		if (head == null) {
			return str;
		}
		Node cur = head; // This is the head, or Node current = first;
		while (cur.next != null){
			cur = cur.next;
		}
		str = cur.data.toString();		
		return str;
	}

	public String element() {		
		return getFirst();
	}
	
	public boolean isEmpty(){
		return size==0 || head == null;	
	}

	public boolean offer(Object str) {		
		return add(str);
	}

	public String peek() {
		 return getFirst();
	}
	
	public String peekFirst() {
		if(size > 0){
			return getFirst();
		}
		else {
			return null;
		}
	}
	public String removeFirst(){
		if (size > 0)
		{
		 size--;
		 Node temp = head;
		 head = head.next; 		 
	    
	     return temp.data.toString();
		 }
		 else{
		 		throw new NoSuchElementException();
		}
	}
	public Object peekLast() {
		if(size > 0){
			return getLast();
		}
		else {
			return null;
		}
	}

	public Object poll() {
		if(size>0){
		return removeFirst();
		}
		return null;
	}

	public boolean offerFirst(Object data) {
		addFirst(data);
		return true;
	}

	public void addFirst(Object data) {
		Node temp = new Node(data);
		Node prev = find(size-1);
		if(size == 0)
			head = prev = temp;
		else{
			temp.next = head;
			head = temp;
		}				
		size++;
				
	}

	public boolean offerLast(Object str) {
		
		 return add(str);
	}

	public Object pollFirst() {
		if(size==0){
			return null;
		}
		
		return removeFirst();
	}

	public Object pollLast() {
		if(size== 0){
			return null;
		}
		return removeLast();
	}
	
	
	public boolean remove(Object dataToRemove) {
		boolean found = false;
		Node cur = head;
		
		//loop through linkedlist
		for(int i=0;i< size();i++){	  
              if(cur.data.equals(dataToRemove) &&size !=0) {
            	 found = true;
            	Node prev = find(i - 1);
            	//update nodes
  				cur = prev.next;
  				prev.next = cur.next;
  				this.size--;
              }  
              cur=cur.next;
		}
		return found;
		
	}//end remove(data torem)

	public boolean removeFirstOccurrence(Object ask) {

		Node cur = head;
		
		//loop through linkedlist
		for(int i=0;i< size();i++){
			
              if(cur.data.equals(ask) ) {
            	 
            	Node prev = find(i - 1);
            	//update nodes
  				cur = prev.next;
  				prev.next = cur.next;
  				this.size--;
  				 return true;
              }  
              cur=cur.next;
		}
		
		return false;
	}

	public boolean removeLastOccurrence(Object ask) {

		int index = lastIndexOf(ask);
		System.out.println(index);
		remove(index);
		return false;
	}

	public Object remove() {
		if (size > 0){
		 size--;
		 head = head.next; 		 	    
		 }
		 else{
		 		throw new NoSuchElementException();
		}
		return head;
	}

	public Object remove(int index) {
		if(index >= 0 && size >0){
			if(index==0){
				removeFirst();
			}
			else{
			Node cur = find(index);
			remove(cur.data.toString());
			}			
		}
		return index;		
	}

	public Object pop() {
		return poll();
	}
	
	public void push(Object str){
		addFirst(str);
	}
	
	public Object[] toArray(){
		Object[] array = new Object[size];
		Node cur = head;
		for(int i = 0; i< size; i++){
			array[i] = cur.data.toString();
			cur=cur.next;
		}
		
		return array;
	}


	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("unchecked")
	public Iterator<Object> iterator() {
		
		return new LinkedListIterator(this.head);
	}


	public boolean removeAll(Collection<?> c) {
		head = null;
		return true;
	}

	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean addAll(int index, Collection<? extends Object> data) {
		
//		int size
		return false;
	}


	public Object subList(int low, int high) {
		if(low <0 || high < low){
			throw new IllegalArgumentException();
		}
		else if(low==high){
			return null;
		}
		//walk up
		Node cur = head;
		for(int i =0;i < high; i++ ){
			cur = cur.next;
		}

		String str = "";
		Node clone = new Node(cur.data);
		Node p = cur, q=clone;
		for(int i=low+1; i<high; i++){
			if(p.next == null){
				throw new IllegalArgumentException();
			}
			q.next = new Node(p.next.data);
			p= p.next;
			q= q.next;
			
			str+=clone.data.toString();
			
		}
		return str;

	
	}
	
@Override
	public int hashCode() {
		    final int PRIME = 31;
		    int hash = 1;
		    for (Node cur = this.head; cur != null; cur = cur.next) {
		      hash = PRIME * hash + cur.hashCode();
		    }
		    return hash;
	}
	

	public boolean equals(Collection<Object> list){
		for(Object data: list){
			System.out.println(data);
		}
		return false;
		
	}
	 
	public boolean addAll(Collection<? extends Object> c) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public <T> T[] toArray(T[] a) {
		throw new UnsupportedOperationException( "Not required" );
	}

	public Iterator<Object> descendingIterator() {
		throw new UnsupportedOperationException( "Not required" );
	}

}