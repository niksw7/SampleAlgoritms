package polishNotationExamples;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class PolishNotation {
public static void main(String[] args) throws IOException {
	//evaluatePostfix(getInput());
	System.out.println("--"+evaluateInfix(getInput()));
}
/**
 * Evaluate a postfix expression.
 * The evaluation supports 0-9,+,-,*,/
 * @param input
 */
public static int  evaluatePostfix(String input){
	Stack stack = new Stack<Integer>();
	int retVal;
	for (char c : input.toCharArray()) {
	if(Character.isDigit(c)){	
		stack.push(c-48); //c-'0'
	}

	else{
		int[] operands = {(Integer) stack.pop(),(Integer) stack.pop()};
		swap(operands);
		stack.push(getResult(operands, c));
		/*switch (c) {
		case '+':
			stack.push((Integer)stack.pop()+(Integer)stack.pop());
			break;
		case '-':
			stack.push(-((Integer)stack.pop()-(Integer)stack.pop()));
			break;
		case '*':
			stack.push((Integer)stack.pop()*(Integer)stack.pop());
			break;
		case '/':
			stack.push((Integer)stack.pop()/(Integer)stack.pop());
			break;
		default:
			break;
		}*/
	}
	}
	retVal = (Integer) stack.pop();
	System.out.println("output:"+retVal);
	return retVal;
}

public static void swap(int[] operands){
	operands[0] = operands[0]+operands[1];
	operands[1] = operands[0]-operands[1];
	operands[0] = operands[0]-operands[1];
}

public static int getPrecedence(char ch){
	switch(ch){
	case '+':
	case '-':
		return 0;
	case '*':
	case '/':
		return 1;	
	default:
		return -1;
	}
}

/**
 * 
 * @param input
 * @return
 */
public static int evaluateInfix(String input){
	Stack operand,operator;
	operand = new Stack<Integer>();
	operator = new Stack<Character>();
	for (Character c : input.toCharArray()) {
		if(Character.isDigit(c)){
			operand.push(c-'0');
		}else{
				if(operator.isEmpty() || getPrecedence(c) > getPrecedence((Character) operator.peek()) ){
					operator.push(c);
					}else{
						//remove 2 operands and perform the operation till you dont get the operand smaller than the current operand
						while(getPrecedence((Character) operator.peek()) >= getPrecedence(c)){
						int[] operands = {(Integer) operand.pop(),(Integer) operand.pop()};
						swap(operands);
						operand.push(getResult(operands, (Character) operator.pop()));
						if(operator.isEmpty())break;
						}
						operator.push(c);
				
			}
		}
	}
while(!operator.isEmpty()){
	int[] operands = {(Integer) operand.pop(),(Integer) operand.pop()};
	swap(operands);
	operand.push(getResult(operands, (Character) operator.pop()));	
}

return (Integer) operand.pop();
}

public static int getResult(int[] operands,char operator){
	switch (operator) {
	case '+':
		return operands[0]+operands[1];
	case '-':
		return operands[0]-operands[1];
	case '*':
		return operands[0]*operands[1];
	case '/':
		return operands[0]/operands[1];
	default:
		return 0;
	}
}
	public static String getInput() throws IOException{
		System.out.println("Please enter the expression(Postfix/Infix/Prefix)");
		Scanner sc = new Scanner(System.in);
		String data = sc.next(); 
		System.out.println(data);
		return data;
		}
}
