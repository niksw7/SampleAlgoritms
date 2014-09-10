package queueOperations;


import LinkedListOperations.LinkedList;
import LinkedListOperations.SampleProgram;

/**
 * Creates a dynamic circular Queue.
 * As the name suggest, a circular queue which can always accommodate a new element
 * @author acer
 * 
 */
public class DynamicCircularQueue {
static LinkedList circularList;
	public static void main(String[] args) {
		populateCircularQueue();
		insertAtEnd(5);
		LinkedList.displayLinkedList(circularList);	
	}
	protected static void insertAtEnd(Object data) {
		LinkedList newNode = new LinkedList();
		newNode.setData(data);
		newNode.setNext(circularList);
		SampleProgram.getLastNode(circularList).setNext(newNode);
	}
	
	public static LinkedList populateCircularQueue() {
		return circularList = LinkedList.populateCircularList(new LinkedList(), 1,5);
	}
}
