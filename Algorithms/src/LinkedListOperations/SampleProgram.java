package LinkedListOperations;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

import FloydCylceProblems.CycleDetection;
import FloydCylceProblems.LinkedList_Straight_Cyclic;
import FloydCylceProblems.LinkedList_Straight_Cyclic.CyclicLinkedList;

public class SampleProgram {
public static LinkedList head;
static int  i =0;

public static void main(String[] args) {
	//CycleDetection det = new CycleDetection();
//det.FloydCycleDisplay(new CyclicLinkedList().head);
	//populatePalindrome("1233721");
	//isPalindromeLL(head);
	//displayLinkedList();
	//System.out.println("palindrome status:"+isPalindromeLL(head));
	//head = reverLinkedList_nonRec(head);
	//displayLinkedList();
	LinkedList head1 = new LinkedList();
	LinkedList head2 = new LinkedList();
	populate2IntersectingLinkedList(head1,head2);
	LinkedList.displayLinkedList(head1);
	System.out.println("**************");
	LinkedList.displayLinkedList(head2);
	//Intersecting part??
	System.out.println("node is "+findIntersectingNode(head1,head2).getData());
	/*Stack<Integer> intStack = new Stack<Integer>();
	intStack.add(1);
	intStack.add(2);
	intStack.add(3);
	
	reverseStack(intStack);
	Iterator<Integer> iter = intStack.iterator();
		while(iter.hasNext()){
	System.out.println("--"+iter.next());*/
	//reverseLinkedList_pairs(head);
	//displayLinkedList();

	//System.out.println("..");
	//reverseLinkedList(head).setNext(null);;
	//head = reverseLinkedlist_n(head,8);
//populateList();
//displayLinkedList();

//	displayLinkedList();
	//System.out.println("here it is!!!!!"+nThNodefromEnd(8).data);
	//populateCircularList();
	//displayCircularList();
	//System.out.println("--"+josephus_element(head,3).getData());
}
/**
 * Using stack to find the required element
 * @param head1
 * @param head2
 * @return
 */
public static LinkedList findIntersectingNode(LinkedList head1 , LinkedList head2){
	Stack<LinkedList> stack1 = new Stack<LinkedList>();
	Stack<LinkedList> stack2 = new Stack<LinkedList>();
	LinkedList temp;
	temp = head1;
	while(temp!=null){
		stack1.push(temp);
		temp = temp.getNext();
	}
	temp = head2;
	while(temp != null){
		stack2.push(temp);
		temp = temp.getNext();
	}
	//now start popping,you will get the intersecting one
	while(stack1.peek() == stack2.peek()){
		stack2.pop();
		temp =  stack1.pop();
	}
	return temp;
}

public static LinkedList getLastNode(LinkedList head){
LinkedList node = head;
int i=3;	
while(node.getNext()!=null && node.getNext()!=head){
	node = node.getNext();
}
return node;
}

/**
 * Populate an Intersecting LinkedList
 */
public static void populate2IntersectingLinkedList(LinkedList head1,LinkedList head2){
	LinkedList commonlist = LinkedList.populateList(new LinkedList(), 15,18);
	head1 = LinkedList.populateList(head1, 4);
	head2 = LinkedList.populateList(head2, 6,11);
	LinkedList temp;
	temp = head1;
	while(temp.getNext()!=null){
		temp = temp.getNext();
	}
	temp.setNext(commonlist);
	temp = head2;
	while(temp.getNext()!=null){
		temp = temp.getNext();
	}
	temp.setNext(commonlist);
	
	
}

/**
 * reversing of stack using recursion
 */
public static void reverseStack(Stack<Integer> st){
	if(st.isEmpty())
		return;
	int i = st.pop();
	reverseStack(st);
	System.out.println("addToBottom called for:"+i);
	addToBottom(i,st);
	
}

public static void addToBottom(Integer i, Stack<Integer> st){
	if(st.isEmpty()){
		System.out.println("stavc was empty");
		st.push(i);
		return;
	}
	Integer element = st.pop();//1
System.out.println("addToBottom called #"+element);
	addToBottom(element, st);
	System.out.println("pushed  element"+element);
	st.push(i);
	
}

/**
 * Josephus eliminator
 */
public static LinkedList josephus_element(LinkedList head, int eliminator){

LinkedList node = head;
for(int i =0;i<eliminator-1;i++){
	node = node.getNext();
	if(node==node.getNext())
		return node;
}
System.out.println("ELIMINATIBNG"+node.getNext().data);
node.setNext(node.getNext().getNext());
return josephus_element(node.getNext(), eliminator);
}


/**
 * Check if the linkedList is palindrome or not. Complexity should be O(n) and time-complexity should be O(1)
 * first get to the middle of the linkedList.Reverse the other half.
 */
public static boolean isPalindromeLL(LinkedList head){
	LinkedList fastptr=head;
	LinkedList slowptr = head;

		 while(fastptr!=null){
		for(int i = 0;i<2;i++){
		fastptr = fastptr.getNext();
		if(fastptr == null )
			break;
		}
		slowptr = slowptr.getNext();
	}
	//slowptr is in middle of linkedList.Simply reverse everything from here.
	System.out.println("slowptr.before... "+slowptr.getData());

	fastptr = head;
	slowptr = reverLinkedList_nonRec(slowptr);
	System.out.println("slowptr.... "+slowptr.getData());
	LinkedList.displayLinkedList(slowptr);
		//Now start comparing
	while(slowptr!=null){
		System.out.println("compared "+slowptr.getData() +" to "+fastptr.getData());
		if(slowptr.getData() != fastptr.getData())
			return false;
		slowptr = slowptr.getNext();
		fastptr = fastptr.getNext();
	}
	System.out.println("AP");
	return true;
}


/**
 * Reverse linkedlist in n pairs without using array
 */


/**
 * Reverse linked List in n pairs
 */
public static LinkedList reverseLinkedlist_n(LinkedList node, int n){
	
	
	if(node == null){
		return null;
	}
	LinkedList[] arr = new LinkedList[n];
	LinkedList lastnode = null;
	LinkedList temp = node;
	for(int i =0;i<n-1;i++){
		arr[i]= temp;
		//temp = new LinkedList();
		temp = arr[i].getNext();
		if(temp ==  null){
			System.out.println("ele--"+arr[0].getData());
			return arr[0];//no need to swap
		}
	}
	arr[n-1]=temp;
	int k =0;
	for(int i = n-1; i > 0; i--){
			if(k++ == 0){
				lastnode = arr[i].getNext();
			}
					arr[i].setNext(arr[i-1]);
		}
	
	
	arr[0].setNext(reverseLinkedlist_n(lastnode, n));
	
	return arr[n-1];
}

public static LinkedList reverLinkedList_nonRec(LinkedList curNode){
	LinkedList prevNode = null;
	while(curNode!=null){
		LinkedList node1 = curNode.getNext();
		if(node1 == null){
			curNode.setNext(prevNode);
			return curNode;
		}
		LinkedList node2 = node1.getNext();
		node1.setNext(curNode);
		curNode.setNext(prevNode);
		if(node2==null)
			return node1;
		curNode = node2;
		prevNode = node1;
		
	}
	return null;
}

/**
 * Reverse a LinkedList recursively
 */

public static LinkedList reverseLinkedList(LinkedList curNode){
	if(curNode == null){
		return null;
	}
	LinkedList prevNode = reverseLinkedList(curNode.getNext());
	if(prevNode == null)
		return head = curNode;
	prevNode.setNext(curNode);
	return curNode;
}

/**
 * Reverse a linked list in pairs.
 * @param n
 * @return 
 */
public static void reverseLinkedList_pairs(LinkedList node){
	
	if(node == null || node.getNext() == null)
		return;
	if(i++ == 0)head = head.next;
	LinkedList node2 = node.getNext();
	
	LinkedList temp = node2.getNext();
	
	node2.setNext(node);
	node.setNext((temp==null || temp.getNext() == null) ? temp:temp.getNext());
	reverseLinkedList_pairs(temp);
}

//find the nth node from end of List
public static LinkedList nThNodefromEnd(int n){
	LinkedList ptr = head;
	LinkedList runner = head;
//check for preconditions node length should be greater than 0
	
	int counter = n;
	//so i need to run n-1 nodes??
	while(counter-- > 1){
		runner = runner.getNext();
		System.out.println("counter is "+counter);
	}

	System.out.println("coun"+counter);
	while(runner.getNext() != null)
	{
		System.out.println("runner2w");
		runner = runner.getNext();
		counter++;
		ptr = ptr.getNext();
	}
/*	
 * optimization removed the code block from here and added in above while block 
 * while(counter-->0){
		ptr = ptr.getNext();
	}
*/	return ptr;
}

public static void populateList(){
	head = new LinkedList();
	head.setData(0);

	
	LinkedList next = head;
	for (int i = 1; i < 8; i++) {
	LinkedList newNode = new LinkedList();
	newNode.setData(i);
	next.setNext(newNode);
	next = newNode;
	//System.out.println("--"+i);
	}
}

public static void populatePalindrome(String data){
	head = new LinkedList();
	LinkedList next=null;
	for (char c : data.toCharArray()) {
		if(head.getData()==null){
			head.setData(c);
			next = head;
		}else{
			LinkedList node = new LinkedList();
			node.setData(c);
			next.setNext(node);	
			next = node;
		}
	}
}

public static void populateCircularList(){

	head = new LinkedList();
	head.setData(0);

	
	LinkedList next = head;
	for (int i = 1; i < 4; i++) {
	LinkedList newNode = new LinkedList();
	newNode.setData(i);
	next.setNext(newNode);
	next = newNode;
	//System.out.println("--"+i);
	}
	next.setNext(head);
}
public static void displayLinkedList(){
	LinkedList next = head;
	while(next != null){
		System.out.print("==>"+next.data);
		next = next.getNext();
	}
}
public static void displayCircularList(){

	LinkedList next = head;
	while(next.getNext() != head){
		System.out.print("==>"+next.data);
		next = next.getNext();
	}

}

}