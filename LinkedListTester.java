
/**
 * 
 * CS300 Data Structures
 * @author Stan Bozhinov
 * @credit Tom Capaul, 
 * http://stackoverflow.com/questions/10042/how-do-i-implement-a-linked-list-in-java
 * @credit java hash function http://www.javamex.com/tutorials/collections/hash_function_technical_2.shtml
 */
import java.util.*;

public class LinkedListTester  {


	public static void main(String[] args) {
		boolean quit = false;
		Scanner input = new Scanner(System.in);
		LinkedList list = new LinkedList();
		
		

		while(!quit){
			System.out.println();		
			System.out.println();
			System.out.println("Type in the number for corresponding command: (type 'q' to quit");
			System.out.println("1. add()  to end of list -- add(E e)");
			System.out.println("2. add(int index, E element) ");
			System.out.println("3. addAll(Collection<? extends E> c) ");
			System.out.println("4. addLast(lastitem)");
			System.out.println("5. Contains element? contains(Object o) ");
			System.out.println("6. Print the contents of the list.");
			System.out.println("7. get(i) return element data at index ");
			System.out.println("8. Delete the contents of the current list.");
			System.out.println("8. clear() clears the list");
			System.out.println("9. clone() returns a shallow copy of the list");
			System.out.println("10. removeLast() Removes and returns the last element from this list.");
			System.out.println("11. addAll(Collection c)");
			System.out.println("12. getFirst()  returns first element");
			System.out.println("13. get(index) returns data at the given index");
			System.out.println("14. getLast() returns last element");
			System.out.println("15. element() returns first element");
			System.out.println("16. indexOf() returns index of first occurence of element");
			System.out.println("17. lastIndexOf() returns index of last occurence of element");
			System.out.println("18. boolean offer(e)  adds element at tail");
			System.out.println("19. size() returns size of the list");
			System.out.println("20. isEmpty() checks if list is empty");		
			System.out.println("21. peek()Retrieves, but does not remove, the head (first element) of this list.");
			System.out.println("22. peekFirst() retries head or returns null if list empty");	
			System.out.println("23. peekLast() retrieves last list element, returns null if empty");
			System.out.println("24. poll() retrieves head element + erases from list , returns null if empty");
			System.out.println("25. offerFirst(E e) Inserts the specified element at the front of this list.)");
			System.out.println("26. offerLast() Inserts the specified element at the end of this list. ");
			System.out.println("27. pollFirst() Retrieves and removes the first element of this list, or returns null");
			System.out.println("28. pollLast() Retrieves and removes the last element of this list, or returns null .");
			System.out.println("29. removeFirst()   Removes and returns the first element from this list .");
			System.out.println("30. removeFirstOccurence()   Removes and returns the first occurance of element from this list .");
			System.out.println("31. removeLastOccurence()   Removes and returns the last occurance of element from this list .");
			System.out.println("32. remove(int index)  Removes the element at the specified position in this list. ");
			System.out.println("33. remove()   Removes first element from this list .");
			System.out.println("34. pop() removes and returns the first element of this list. ");
			System.out.println("35. push() inserts the element at the front of this list. ");
			System.out.println("36. toArray() creates array that's a copy of the list and passes it outside ");
			System.out.println("37. set(int index, Object object) Replaces the element at the specified position in this list with the specified element. ");
			System.out.println("38. sublist(int index1, index2) Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive ");
			System.out.println("39. list.hashCode()");
			System.out.println("");
			String ask = input.nextLine().trim();
			
			if(ask.contentEquals("1")){
				System.out.println("Enter a word to add to end of list");
				ask = input.nextLine().trim();
				list.add(ask);
				System.out.println(list);
			}
			else if(ask.contentEquals("2")){
				list.add(0, "shoes");
				System.out.println(list);				
			}
			else if(ask.contentEquals("3")){
				LinkedList list2 = new LinkedList();
				list2.add("ball");
				list2.add("snow");
				list2.add("tea");
//				list.addAll(list2);				
			}
			else if(ask.contentEquals("4")){
				list.addLast("lastitem");
				System.out.println("Added 'lastitem'");
			}
			else if(ask.contentEquals("5")){
				System.out.println("checks if list contains 'lasstitem'");
				System.out.println("result: "+list.contains("lastitem")) ;
				
			}
			else if(ask.contentEquals("6")){
				System.out.println("List contents:");
				System.out.println(list);				
			}
			
			else if(ask.contentEquals("7")){
				System.out.println("element at position 2: "+list.get(2));				
			}
			
			else if(ask.contentEquals("8")){
				list.clear();
				System.out.println("Contents deleted.");
			}
			
			else if(ask.contentEquals("9")){
				System.out.println(list);					
				System.out.println("List cloned.");
				System.out.println("cloned list: "+list.clone());	
			}
			
			else if(ask.contentEquals("10")){
				list.removeLast();
				System.out.println("removeLast()");
				System.out.println(list);
			}
			
			else if(ask.contentEquals("11")){

				System.out.println("Contents deleted.");
			}
			
			else if(ask.contentEquals("12")){
				
				System.out.println(list.getFirst());
			}
			
			else if(ask.contentEquals("13")){
				
				System.out.println(list.get(0));
			}
			
			else if(ask.contentEquals("14")){					
				System.out.println("Last item: "+list.getLast());
			}
			
			else if(ask.contentEquals("15")){				
				System.out.println("returns first element: "+list.element());
			}
			
			else if(ask.contentEquals("16")){				
				System.out.println("returns index of the given element: (-1 if not found): "+list.indexOf("cat"));
			}
			
			else if(ask.contentEquals("17")){	
				System.out.println("Enter a word to lookup");
				ask = input.nextLine().trim();
				System.out.println("returns last occuring index of the given element: (-1 if not found) : "+list.lastIndexOf(ask));
			}
			else if(ask.contentEquals("18")){				
				System.out.println("Adds the specified element as the tail (last element) add success: "+list.offer("offer"));
			}
			else if(ask.contentEquals("19")){				
				System.out.println("returns list size: "+list.size());
			}
			else if(ask.contentEquals("20")){				
				System.out.println("is list empty? : "+list.isEmpty());
			}
			else if(ask.contentEquals("21")){				
				System.out.println("peek at head of list : "+list.peek());
			}
			else if(ask.contentEquals("22")){				
				System.out.println("peekFirst, or return null if empty : "+list.peekFirst());
			}
			else if(ask.contentEquals("23")){				
				System.out.println("peekLast : "+list.peekLast());
			}
			else if(ask.contentEquals("24")){				
				System.out.println("poll : "+list.poll());
			}
			else if(ask.contentEquals("25")){				
				System.out.println("offerFirst : "+list.offerFirst("offerfirst"));
			}
			else if(ask.contentEquals("26")){				
				System.out.println("offerLast : "+list.offerLast("offerlast"));
			}
			else if(ask.contentEquals("27")){				
				System.out.println("pollFirst : "+list.pollFirst());
			}
			else if(ask.contentEquals("28")){				
				System.out.println("pollLast : "+list.pollLast());
			}
			else if(ask.contentEquals("29")){
				System.out.println("removeFirst : "+list.removeFirst());
			}
			else if(ask.contentEquals("30")){
				System.out.println("Enter to remove first occurence of the word");
				ask = input.nextLine().trim();
				System.out.println("removeFirstOccurance : "+list.removeFirstOccurrence(ask));
			}
			else if(ask.contentEquals("31")){
				System.out.println("Enter to remove last occurence of the word");
				ask = input.nextLine().trim();
				System.out.println("removeLastOccurance : "+list.removeLastOccurrence(ask));
			}
			else if(ask.contentEquals("32")){
				System.out.println("Enter to remove at index");
				ask = input.nextLine().trim();
				System.out.println("removing at a given index.. : ");
				list.remove(Integer.parseInt(ask));
				System.out.println(list+""+list.size());
			}
			else if(ask.contentEquals("33")){
				list.remove();
				System.out.println("remove() "  );
			}
			else if(ask.contentEquals("34")){
				System.out.println("pop:  " +list.pop() );
			}
			
			else if(ask.contentEquals("35")){
				System.out.println("Enter a string to push");
				ask = input.nextLine().trim();
				list.push(ask);
				System.out.println("pushed  " );	
			}
			else if(ask.contentEquals("36")){
				System.out.println("toArray()");
				if(list.size() ==0){
					System.out.println("no data to copy to array");
				}
				Object[] test;
				test = list.toArray();
				for(Object s: test){
					System.out.println("["+s+"]");
				}
			}
			
			else if(ask.contentEquals("37")){
				System.out.println("Enter a string to insert");
				String str = input.nextLine().trim();
				System.out.println("Enter index to insert at:" );
				ask = input.nextLine().trim();
				if(list.size()<1 ){
					
				}
				else{
				list.set(Integer.parseInt(ask), str);
				}
			}
			else if(ask.contentEquals("q")){
				quit = true;
				System.out.println("Program ended" );
			}
			else if(ask.contentEquals("38")){
				System.out.println("Enter a index low: ");
				String str = input.nextLine().trim();
				System.out.println("Enter index high:" );
				ask = input.nextLine().trim();
				if(list.size()<1 ){
					
				}
				else{
					Object result = list.subList( Integer.parseInt(str), Integer.parseInt(ask)).toString();
					
					 System.out.println(result );
				}
			}
			else if(ask.contentEquals("39")){
				
				System.out.println("Hash Code: "+list.hashCode() );
			}
		else if(ask.contentEquals("40")){
				
				System.out.println("Hash Code: "+list.equals(list) );
			}
		
		}//end menu loop
		
	}//end main
	
		
}
