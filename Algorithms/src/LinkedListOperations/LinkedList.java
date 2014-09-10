package LinkedListOperations;

public class LinkedList {
Object data;
LinkedList next;


public Object getData() {
	return data;
}

public void setData(Object data) {
	this.data = data;
}

public LinkedList getNext() {
	return next;
}

public void setNext(LinkedList next) {
	this.next = next;
}


public static LinkedList populateList(LinkedList head,int count){
	return populateList(head, 0, count-1);
}


public static LinkedList populateList(LinkedList head,int start,int end){
	if(head == null)
	head = new LinkedList();
	head.setData(start);
	LinkedList next = head;
	for (int i = start+1; i <= end; i++) {
	LinkedList newNode = new LinkedList();
	newNode.setData(i);
	next.setNext(newNode);
	next = newNode;
	}
	return head;
}

public void displayLinkedList(){
	displayLinkedList(this);
}
/**
 * 
 * @param head
 */
public static void displayLinkedList(LinkedList head){
	LinkedList next = head;
	while(next != null && next.getNext() != head){
		System.out.print("==>"+next.data);
		next = next.getNext();
	}
}


public static LinkedList populateCircularList(LinkedList head,int count){

return populateCircularList(head, 0, count-1);

}
public static LinkedList populateCircularList(LinkedList head,int start,int end){
	if(head == null)
	head = new LinkedList();
	head.setData(start);	
	LinkedList next = head;
	for (int i = start+1; i <= end; i++) {
	LinkedList newNode = new LinkedList();
	newNode.setData(i);
	next.setNext(newNode);
	next = newNode;
	//System.out.println("--"+i);
	}
	next.setNext(head);
	return head;
}
}
