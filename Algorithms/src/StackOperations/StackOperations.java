package StackOperations;
/**
 * The reason to make top[] = -1 when the stack is empty is to how will you differentiate when the stack has 1 element and stack is empty??
 * @author acer
 *
 */
public class StackOperations {
static int[] array,top,base;
final static int MAX = 6;
final static int nOfStack = 3;
	public static void main(String[] args) {
	array = new int[MAX];
	top = new int[nOfStack];
	base = new int[nOfStack];
	create_n_stack(nOfStack);
push(1, 2);
push(2, 2);
//push(3, 2);
//push(4, 1);
/*push(5, 1);
*/
displayStack();
	}
	public static void displayStack(){
		int j =0;
		for (int i : array) {
		System.out.println("##display arr["+j++ +"] "+i);
		}
		for(int i =0;i<nOfStack;i++){
			System.out.println("top,base["+i+"] is "+top[i]+" .."+base[i]);
		}
	}
/**
 * Implementing n stacks using single array.
 */
public static void create_n_stack(int nOfStack){
//Divide the array into n stacks
	top[0] = -1;
	base[0]=0;
	for(int i =1;i < nOfStack; i++){
		//define the tops of each stack
		base[i] =MAX/nOfStack*i;
		top[i]= -1;
		
		System.out.println("top["+i+"] ="+top[i]+" base "+ base[i]);
	}
}
public static boolean isStackFull(int stackNo){
	if(stackNo+1 >= nOfStack){
		if(top[stackNo]+1 == MAX)
			return true;
		else 
			return false;
	}
	if((top[stackNo]+1)==base[stackNo+1]){
		return true;
	}return false;
		
}
public static boolean isStackEmpty(int stackNo){
	int topIndex = top[stackNo];
	if(topIndex==-1)
		return true;
	return false;
}
public static void push(int data,int stackNo){
	int topIndex = top[stackNo];
if(topIndex == -1){
	topIndex = top[stackNo] = base[stackNo];
	System.out.println("Stack "+stackNo +"was prev empty ");
	array[topIndex] = data;
	return;
}
if(isStackFull(stackNo)){
	//try some left shifting or right shifting	
	if(!leftShift(stackNo, data) && !rightShift(stackNo, data))
		throw new StackOverflowError();
	
}else{
	//simply add the element
	top[stackNo]++;
	array[top[stackNo]] = data;	
}
}
/**
 * Reserving 1 space compulsory for the particular stack,even if its empty
 * @param stackNo
 * @return
 */
public static boolean isStackEmptyFull(int stackNo){
	//Check if it has only 1 space
	if(!isStackEmpty(stackNo))
		return false;

	
	if(base[stackNo]+1==MAX)
		return true;
	else if(base[stackNo]+1==base[stackNo+1])
		return true;
	return false;
}
public static boolean leftShift(int stackNo,int data){
	int curStack = stackNo;
	while(--stackNo >= 0){
		if(isStackEmptyFull(stackNo)){
//Yes this stack is reserved with 1 space.
			System.out.println("skipping stackNo"+stackNo+" because its emptyFull");
			continue;
		}else if(isStackEmpty(stackNo)){
			//stack is not emptyFull
			//left shift all elements
		System.out.println("stack is empty..0...."+stackNo);
			stackNo++;
				int startIndex = base[stackNo]-1;
				int temp = startIndex;
				System.out.println("stack is empty......"+stackNo+"base[stackNo]="+base[stackNo]);

				while(startIndex<top[curStack]){
					array[startIndex] =  array[++startIndex];
				}
				while(stackNo<=curStack){
					System.out.println("...........***..........stackNo="+stackNo);
					base[stackNo]--;
					if(top[stackNo] != -1)
					top[stackNo]--;
					stackNo++;
				}
				System.out.println("top["+curStack+"] is "+top[curStack]);
				
			//}
			array[++top[curStack]] = data;
			return true;
		}
		if(top[stackNo]+1 == base[stackNo+1]){
			System.out.println("Stack"+stackNo+" is full..next stack plz");
			continue;
		}else{
			//left shift all the elements!! Yes I know how tedious it is :((

			int startIndex = top[stackNo];
			while(++startIndex<top[curStack]){
				array[startIndex] =  array[startIndex+1];
			}
			System.out.println("currently stack is shud be 0 lets c"+ ++stackNo);
			while(++stackNo<=curStack){
				System.out.println("base["+stackNo+"] is +"+base[stackNo]);
				base[stackNo]--;
				if(top[stackNo]!=-1)
				top[stackNo]--;
			}
			//now this is the r8 position to insert your element
			System.out.println("inserted  data "+data+"@ "+top[stackNo]);
			array[++top[stackNo]]=data;
			return true;
		}
	}
	return false;
}

public static boolean rightShift(int stackNo,int data){
	int curStack = stackNo;
	if(top[stackNo] + 1 == MAX){
		System.out.println("dude i m out of frame!!");
		return false;
	}
	//start shifting right all elements from this index
	int shiftElementIndex = top[stackNo]+1;
	int shiftElementEnd ;
	//Now check if you find any stack which can free you a space
	while(++stackNo < nOfStack){
		//if you find a space in this stack , then you just need to move all the elements to right from shiftElementIndex to free position
		if(isStackEmptyFull(stackNo)){
			System.out.println("sorry this stack is poor::"+stackNo);
			continue;
		}else if(isStackEmpty(stackNo)){
			//check the top is -1 here
			shiftElementEnd = base[stackNo];
			System.out.println("base changed base["+stackNo+"]to "+base[stackNo]+"shiftelementindex "+shiftElementIndex+" shiftelementend "+shiftElementEnd);
			//increment the baseIndex by1
			while(shiftElementEnd > shiftElementIndex){
				array[shiftElementEnd] = array[--shiftElementEnd];
			}
			System.out.println("stack no is "+stackNo);
			//Now its time to shift all the base, top if is already -1 so no need
			while(stackNo > curStack){
				if(top[stackNo]!=-1)
					top[stackNo]++;
				base[stackNo]++;
				stackNo--;
			}
			array[++top[curStack]] = data;
		return true;	
		}
		if(top[stackNo]+1==MAX || top[stackNo]+1 == base[stackNo+1]){
			System.out.println("Stack"+stackNo+" is full..next stack plz");
			continue;
		}else{
		//its normal
		shiftElementEnd = top[stackNo]++;
		while(shiftElementEnd > shiftElementIndex){
			array[shiftElementEnd] = array[--shiftElementEnd];
		}
		array[++top[curStack]] = data;
		return true;
	}
}

	return false;
}
}