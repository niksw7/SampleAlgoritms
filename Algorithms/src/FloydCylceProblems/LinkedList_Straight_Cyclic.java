package FloydCylceProblems;

import java.util.Collections;

import LinkedListOperations.LinkedList;

public class LinkedList_Straight_Cyclic {
public static class StraightLinkedList{
	public static LinkedList head;
	public StraightLinkedList() {
		head = new LinkedList();
		head = LinkedList.populateList(head,8);
	}
}
public static class CircularLinkedList{
	public static LinkedList head;
	public CircularLinkedList() {
		head = new LinkedList();
		head = LinkedList.populateCircularList(head, 9, 14);
	}
}

public static class CyclicLinkedList{
	public static LinkedList head;
	public CyclicLinkedList(){
		head = new LinkedList();
		head = LinkedList.populateList(head,2);
		LinkedList nxtNode = head;
		while(nxtNode.getNext() != null){
			nxtNode = nxtNode.getNext();
		}
		//Attach circularLinkedList at the end of Straight LinkedList
		nxtNode.setNext(new CircularLinkedList().head);
		//LinkedList.displayLinkedList(head);
	}
}
}
