package queueOperations;

import java.util.Stack;
/**
 * Implementing a queue using 2 stacks.
 * If you want to enqueue ,Simply push into 1st stack.
 * If you want to dequeue,
 * 		check if the stack2 is empty,
 * 			if not then simply pop from stack2
 * 			if yes then 
 * 				check if stack1 is empty
 * 				if not  then simply pop all but last element from stack1 to stack2,pop the remaining 1 element from stack1.
 * @author acer
 *
 */
public class QueueWith2Stacks {
	public static void main(String[] args) throws Exception {
		Object[] array = new Object[4];
		enqueue(1);
		enqueue(2);
		System.out.println("popped"+dequeue());
		System.out.println("popped"+dequeue());
		enqueue(3);
		System.out.println("popped"+dequeue());
		enqueue(4);
		System.out.println("popped"+dequeue());
		System.out.println("popped"+dequeue());
	}
static Stack stack1,stack2;
static{
	stack1 = new Stack();
	stack2 = new Stack();
}
/**
 * if stack2 is not empty , pop the element 
 * else simply pop all elements from stack1 to stack2, and then pop 1 element from stack2
 * @param data
 * @throws Exception 
 */
public static Object dequeue() throws Exception{
	if(!stack2.isEmpty()){
		return stack2.pop();
	}else if(!stack1.isEmpty()){
		pushStack(stack1,stack2);
		return stack2.pop();
	}
	throw new Exception("Stack UnderFlow");
}

public static void  enqueue(Object data){
	stack1.push(data);
}
public static void pushStack(Stack stack1, Stack stack2){
	while(!stack1.isEmpty())
		stack2.push(stack1.pop());
	}
}

