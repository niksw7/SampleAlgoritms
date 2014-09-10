package FloydCylceProblems;

import LinkedListOperations.LinkedList;

public class CycleDetection {
	public static void FloydCycleDisplay(LinkedList head) {
		LinkedList fastPtr = head.getNext();
		boolean cycle =true;
		LinkedList slowPtr = head;
		outer: while (slowPtr != fastPtr || fastPtr != null) {
			slowPtr = slowPtr.getNext();
			for (int i = 0; i < 2; i++) {
				fastPtr = fastPtr.getNext();
				if (fastPtr == slowPtr) {
					break outer;
				}else if(fastPtr == null){
					cycle = false;
					break outer;
				}
			}
		}
		if(!cycle){
			System.out.println("Not a Floyd cycle");
			LinkedList.displayLinkedList(head);
			return;		
			}
		slowPtr = head;
		// get the start of the cycle
		fastPtr = fastPtr.getNext();
		while (slowPtr != fastPtr) {
			slowPtr = slowPtr.getNext();
			fastPtr = fastPtr.getNext();
		}
		//now start displaying the nodes
		slowPtr = head;
		while(slowPtr!=fastPtr){
			System.out.print("==>"+slowPtr.getData());
			slowPtr = slowPtr.getNext();
		}
		System.out.print("==>(cycle)");
		LinkedList.displayLinkedList(fastPtr);
	}
}
