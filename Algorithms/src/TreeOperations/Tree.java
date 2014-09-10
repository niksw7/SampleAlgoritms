package TreeOperations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree<E> {
private Object data;
private Tree left,right;
Tree(Object input){
	this.data =  input;
}
public Tree() {
	// TODO Auto-generated constructor stub
}
/*
 * Populate the tree with dummy values
 *                                 1
 *                                / \
 *                               /   \
 *                              /     \
 *                             2       3
 *                            / \      / \
 *                           4   5    6   7
 */                                        //\
                                            //8  
public static Tree populateTree(){
	Tree node2 = new Tree(2);
	node2.left=new Tree(4);
	node2.right=new Tree(5);
	
	Tree node3 = new Tree(3);
	Tree node8 = new Tree(8);
	node8.left = new Tree(9);
	node3.left = new Tree(6);	
	Tree node7 = new Tree(7);
	node7.left=node8;
	//node7.right=new Tree(5);
	
		
	node3.right=node7;

	
	Tree tree = new Tree(1);
	tree.left = node2;
	tree.right = node3;
	return tree;
}
enum Traversal{
	POSTORDER,
	INORDER,
	PREORDER
}
static int postOrderIndex =0;
public static Tree constructATree_P(int start, int end , int[] postOrder, int[] inOrder){
	if(start > end ){
		return null;
	}
	Tree node = new Tree(postOrder[postOrderIndex++]);
	if(start == end)
		return node;
	int inOrderIndex = getIndexInOrder(postOrder[postOrderIndex-1], inOrder);
	node.right =constructATree_P(inOrderIndex+1, end, postOrder, inOrder);
	 
	node.left = constructATree_P(start, inOrderIndex-1, postOrder, inOrder);
	return node;
}


/**
 * Constructing a tree from PreOrder,Inorder traversals
 */
static int preOrderIndex = 0;
public static Tree P_constructATree(int start, int end,int[] preOrder, int[] inOrder){
	if(start > end)
		return null;
	Tree node = new Tree(preOrder[preOrderIndex++]);
	if(start == end)
		return node;
	int inOrderIndex = getIndexInOrder(preOrder[preOrderIndex-1], inOrder);
	System.out.println("inOrderIndex "+ inOrderIndex);
	node.left = P_constructATree(start, inOrderIndex - 1, preOrder, inOrder);
	node.right = P_constructATree( inOrderIndex + 1,end, preOrder, inOrder);
	return node;
}
public static int getIndexInOrder(int data , int[] inOrder){
	for (int i = 0; i < inOrder.length; i++) {
		if(data == inOrder[i])
			return i;
	}
	return -1;
}
/*public static Tree constructATree(Traversal traversal,int[] arr,int[] preOrder,int[] inOrder) throws Exception{
	Tree<Integer> root = null;
	Tree node = null;
	Stack<Tree> stack = new Stack<Tree>();
	Tree array[] = new Tree[preOrder.length];
		//get the root element
		//Get the left child for every node.
		int index = 0;
		*//**
		 * Allocate memory for each of the preorder elements
		 *//*
	for (int i : preOrder) {
		array[index++] = new Tree(i);
	}
	*//**
	 * Try assigning a left element for each element in preOrder way
	 *//*
	for(int i = 0 ; i<array.length - 1 ; i++){
		if(array[i].left == null)//I think we should remove this check 
			getAleftNode(array,array[i],inOrder);
	}
	
	return null;
}

public static void getAleftNode(Tree[] array,Tree currentNode,int[] inOrder) throws Exception{
	for (Tree tree : array) {
		if(tree == currentNode || tree.left != null)
		{
			System.out.println("continue...");
			continue;
		}
		if( isLeft_InOrder((Integer) currentNode.data,(Integer) tree.data,inOrder)){
			//You also need to check if this element is before in PreOrder
			if(isLeft_InOrder((Integer)currentNode.data,(Integer)tree.data,getArray(array)))
				continue;
			currentNode.left = tree;
			break;
		}
	}	
}

public static int[] getArray(Tree[] tree){
	int arr[] = new int[tree.length];
	for (int i = 0; i<tree.length;i++) {
		arr[i] = (Integer)tree[i].data;
	}
	return arr;
}
public static boolean isLeft_InOrder(int node,int toleft,int[] inOrder) throws Exception{
	for (int i : inOrder) {
		if(i == node)
			return false;
		if(i == toleft)
			return true;
	}
	throw new Exception("ELEMENT NOT FOUND");
}
public static boolean isLeft(int num,int current, int[] arr){
	for (int i : arr) {
		if(i == current){
			break;
		}
		if(i == num)
			return true;
	}
	return false;
}
*/

public static Tree populateTree1(){
	Tree node2 = new Tree(2);
	node2.left=new Tree(4);
	node2.right=new Tree(5);
	
	Tree node3 = new Tree(3);
	node3.left=new Tree(6);
	node3.right=new Tree(7);

	Tree tree = new Tree(1);
	tree.left = node2;
	tree.right = node3;
	return tree;
}
/**
 *Post-Order Traveral of tree 
 * @throws InterruptedException 
 */
public static void main(String[] args) throws InterruptedException {
	/*postOrder_nr(populateTree());
	System.out.println("...............");
	postOrder(populateTree());*/
	//printreverseTree(populateTree());
	//deleteNode(populateTree(), 3);
	//diameter( populateTree());
	//System.out.println(diameter);
	//printAllPaths(populateTree(), new Stack());
	//System.out.println(checkPath(populateTree(), 5));
	//System.out.println(sumOfAllElements(populateTree1()));
	
	/*Tree tree1 = populateTree1();
	preOrder(tree1);
	System.out.println();
	MirrorTree(tree1);
	preOrder(tree1);*/
	//int [] preOrder = {1,2,4,5,3};
	//int [] inOrder = {4,2,5,1,3};
	/*System.out.println("-->len="+preOrder.length);
	Tree tree = P_constructATree(0, preOrder.length - 1, preOrder, inOrder);*/
	//int[] postOrder = {1,3,2,5,4};
	
/*	Tree tree = constructATree_P(0, inOrder.length-1, postOrder, inOrder);
	System.out.println("--"+tree.data);
	preOrder(tree);
*/
	printAncetors(populateTree(), new Tree(7));	
}

public static void preOrder(Tree tree){
	if(tree == null)
		return;
	System.out.print(" "+tree.data);
	preOrder(tree.left);
	preOrder(tree.right);

}

public static void preOrder_nr(Tree tree){
	Stack<Tree> stack = new Stack<Tree>();
	if(tree==null)
		return;
	stack.push(tree);
	while(true){
		tree= stack.pop();
		System.out.print(" "+tree.data);
		if(tree.right != null)
		stack.push(tree.right);
		if(tree.left !=null)
		stack.push(tree.left);		
		if(stack.isEmpty()){
			return;
		}
		
	}
}
public static void postOrder(Tree tree){
	if(tree == null)
		return;
	postOrder(tree.left);
	postOrder(tree.right);
	System.out.print(" "+tree.data);
}

/**
 * Post-Order of a tree without recursion.
 * @throws InterruptedException 
 */
	public static void postOrder_nr(Tree tree) throws InterruptedException {
		Stack<Tree> stack = new Stack<Tree>();
		Tree lastElement = new Tree(null);
		ArrayList<Tree> skipped = new ArrayList<Tree>();
		while (true) {
	//	Thread.sleep(1000);
			while (tree != null && !skipped.contains(tree)) {
			//	System.out.println("pushing "+tree.data);
				stack.push(tree);
				tree = tree.left;
			}
			
			if (stack.isEmpty())
				return;
			tree= stack.pop();
			if(tree.right == null || lastElement == tree.right){
			if(lastElement==tree.right){
				lastElement = tree;
				System.out.print(" "+tree.data);
			//	System.out.println("contiu");
			tree=null;
				continue;
			}
			lastElement = tree;
			System.out.print(" "+tree.data);
			}
			else /*if(tree.right != null)*/{
				//put back the element back into stack
				stack.push(tree);
				skipped.add(tree);
				//System.out.println("skippin"+tree.data);
			}
			tree = tree.right;
		}
	}

public static void inOrder(Tree tree){
	if(tree == null)
		return;
	inOrder(tree.left);
	System.out.print(" "+tree.data);
	inOrder(tree.right);
}


public static void inOrder_nr(Tree tree){
	Stack<Tree> stack =  new Stack();
	if(tree == null)
		return;
	while(true){
	while(tree!=null)
	{
		stack.push(tree);
		tree = tree.left;
	}
	if(stack.isEmpty())
		return;
		//tree = stack.pop();
		if(stack.peek().right == null){
			tree= stack.pop();
		System.out.print(" "+tree.data);
		 if(stack.peek().right != tree){
			System.out.println(stack.pop().data);
		}
		tree = tree.right;
		}
if(!stack.isEmpty()){
	tree= stack.peek().right;
}else tree=null;
	}
}

public  int size(){
	return size(this);
}

/**
 * Returns the size of the tree.
 * I am using the default java LinkedList, you can however use your own custom LinkedList(it would be faster):))
 * @param tree
 * @return
 */
public static int size_nr(Tree tree){
	Queue<Tree> queue = new LinkedList();
	queue.add(tree);
	int counter =1;
	while(!queue.isEmpty()){
		tree= queue.remove();
		if(tree.left!=null){
		queue.add(tree.left);
		counter++;
		}
		if(tree.right!=null){
		queue.add(tree.right);
		counter++;
		}
	}
	return counter;
}
/**
 * Calculate the size of a tree recursively
 * @param tree
 * @return
 */
	public static int size(Tree tree) {
		if (tree == null)
			return 0;

		return size(tree.left) + size(tree.right) + 1;
	}
public static int height_nr(Tree tree){
	Queue<Tree> queue = new LinkedList();
	int height = -1;
	
	queue.add(tree);
	queue.add(null);
	while(!queue.isEmpty()){
		tree = queue.remove();
		//System.out.println("-"+tree.data);
		if(tree == null){
			height++;
			
			if(queue.isEmpty())
				return height;
			queue.add(null);
			continue;
		}		
		if(tree.left!=null)
		queue.add(tree.left);
		if(tree.right!=null)
		queue.add(tree.right);
	}
	return height;
}
/**
 * height of a binary tree recursively
 */
public static int height(Tree tree){
	if(tree == null)
		return 0;
	return Math.max(height(tree.left)+1, height(tree.right)+1);
}
/*find the bloody output here.
 * public static int maxNode(Tree tree,int max){
	int leftMax,rightMax;
	if(tree == null)
		return max;
	
	leftMax = maxNode(tree.left,max);
	if(((Integer)tree.data) > max){
		max = (Integer)tree.data;
	}
	rightMax= maxNode(tree.right,max);
	if(rightMax>max)
		max = rightMax;
	return max;
		

}*/
/**
 * TC=SC:O(n)
 * @param tree
 * @return
 */
 public static int maxNode(Tree tree){
	 if(tree == null)
		 return 0;
	 int cur,left = 0,right = 0;
	 left = maxNode(tree.left);
	 right = maxNode(tree.right);
	 cur = (Integer) tree.data;
		 return max(cur,left,right);
 }
private static int max(int cur, int left2, int right2) {
	// TODO Auto-generated method stub
	return Math.max(right2, Math.max(cur, left2));
}
/**
 * Non-recursively finding the maxNode.(using level order traversal)
 * TC=SC:O(n)
 * @param tree
 * @return
 */
public static int maxNode_nr(Tree tree){
	Queue<Tree> queue = new LinkedList<Tree>();
	int max = 0;
	queue.add(tree);
	while(!queue.isEmpty()){
		tree = queue.remove();
		if((Integer)tree.data > max)
			max = (Integer) tree.data;
		if(tree.left!=null)
			queue.add(tree.left);
		if(tree.right!=null){
			queue.add(tree.right);
		}
	}
	return max;
}

/**
 * Searching an element in a binary tree.
 * Using an object of generic type ,specifically for integer, you can change according to your needs
 * S.C=T.C = O(n)
 */
public static boolean SearchElement(Tree tree, Object data){
	if(tree == null)
		return false;
	if(((Integer)tree.data).intValue() == ((Integer)data).intValue())
		return true;
	if(SearchElement(tree.left,data) ||
	SearchElement(tree.right,data))
		return true;
	else return false;
	
}
/**
 * Algorithm for printing a tree in reverse order.
 */
public static void printreverseTree(Tree tree){
	Queue<Tree> queue = new LinkedList<Tree>();
	Stack<Tree> stack = new Stack<Tree>();
	queue.add(tree);
	while(!queue.isEmpty()){
		tree = queue.remove();
		stack.push(tree);
		if(tree.right!=null)
		queue.add(tree.right);
		if(tree.left!=null)
		queue.add(tree.left);
	}
	while(!stack.isEmpty()){
		System.out.print(" "+stack.pop().data);
	}
}
/**
 * Algorithm for finding the deepest node in a tree.
 * Last element from  level order!!
 * 
 */
public static Tree deepestNode(Tree tree){

	Queue<Tree> queue = new LinkedList<Tree>();
	queue.add(tree);
	while(!queue.isEmpty()){
		tree = queue.remove();
		if(tree.left!=null)
		queue.add(tree.left);
		if(tree.right!=null)
		queue.add(tree.right);
	}
		return tree;
}

/**
 * Deleting an element from binary tree
 * Steps we would be following here is 
 * Find the node to be deleted.
 * simply replace the data of this node with the deepest node.
 */
public static void deleteNode(Tree tree,Object data){
	//Find the node which you want to delete
	Tree mainTree = tree;
	System.out.println("BEFORE_PREORDER");
	preOrder(mainTree);
	Tree delNode = searchNode(tree, data);
	if(delNode == null){
		System.out.println("No such element found.");
		return;
	}

	Tree deepestNode = deepestNode(tree);
	Object deepData = deepestNode.data;
	freeNode(mainTree, deepestNode);
	delNode.data = deepData;
	/*NOT WORKING FOR JAVA
	 * deepestNode = null;
	System.gc();*/
	System.out.println("AFTER_PREORDER");

	preOrder(mainTree);
}

public static void freeNode(Tree tree , Tree node){
	Queue<Tree> queue = new LinkedList<Tree>();
	queue.add(tree);
	while(!queue.isEmpty()){
		tree = queue.remove();
		if(tree.left!=null)
		{
			if(tree.left == node){
				System.out.println("freeing...");
				tree.left = null;
				return;
			}
		queue.add(tree.left);
		}
		if(tree.right!=null){
			if(tree.right == node){
				System.out.println("freeing");
				tree.right = null;
				return;
			}
		queue.add(tree.right);
		}
	}
	return;
}
public static Tree searchNode(Tree tree,Object data){
	Queue<Tree> queue = new LinkedList<Tree>();
	queue.add(tree);
	while(!queue.isEmpty()){
		tree = queue.remove();
		if(((Integer)tree.data).intValue() == ((Integer)data).intValue()){
			return tree;
		}
		if(tree.left!=null)
		queue.add(tree.left);
		if(tree.right!=null)
		queue.add(tree.right);
	}
	return null;
}
/**
 * finding the number of leaves in a binary tree.
 */
public static int numberOfLeaves(Tree tree){
	if(tree == null)
		return 0;
	if(tree.left== null && tree.right == null)
		return 1;
	
	return numberOfLeaves(tree.left) + numberOfLeaves(tree.right);
}
/**
 * Structurally Identical trees
 */
public static boolean isStructurallyIdentical(Tree tree1, Tree tree2){
	if((tree1 == tree2) /*|| (tree1 != null && tree2 != null)*/)
		return true;
	if(tree1 == null || tree2 == null)
		return false;
	
		return (isStructurallyIdentical(tree1.left, tree2.left) && isStructurallyIdentical(tree1.right, tree2.right) );
}
/**
 * Finding the diameter of a tree.
 * Longest nodes between 2 sub-trees.
 *T.C= O(n) S.C = O(n)
 */
static int diameter = 0;
public static int diameter(Tree tree){
	if(tree == null)
		return 0;
	int left = diameter(tree.left); 
	int right = diameter(tree.right);
	
	if(left+right > diameter)
		diameter = left + right;//update the new diameter
	return Math.max(left, right) + 1;
}
/**
 * binary tree to print all it's root to leaf paths.
 */
public static void printAllPaths(Tree tree,Stack stack){
	if(tree == null) return;
	if(tree.left == null && tree.right == null){
		stack.push(tree.data);
		printArray(stack);
		stack.pop();
		//stack = new Stack();
	}else{
		Tree cache = tree;
		stack.push(tree.data);
		printAllPaths(tree.left,stack);
		//if(cache.left != null || cache.right != null){
		while( stack.pop() != cache.data);
		stack.push(cache.data);
		//}
		printAllPaths(tree.right, stack);
	}
}

public static void printArray(Stack arr){
for (Iterator<Integer> iter = arr.iterator();iter.hasNext();) {

	System.out.print(" "+iter.next());	
}
System.out.println();
}

/**
 * Check for the existence of a given path with the given sum
 * T.C=O(n)  S.C = O(n)
 */
public static boolean checkPath(Tree tree ,int sum){
	if(sum == 0){
		return true;
	}else if(tree == null)
		return false;
	return checkPath(tree.left, sum - ((Integer)tree.data) ) || checkPath(tree.right,  sum - ((Integer)tree.data));
	
}

public static int sumOfAllElements(Tree tree){
	if(tree == null)
		return 0;
	
	return (Integer)tree.data + sumOfAllElements(tree.left) + sumOfAllElements(tree.right);
}

public static void MirrorTree(Tree tree){
	if(tree == null)
		return;
	Tree temp = tree.right;
	tree.right = tree.left;
//	tree.left = new Tree();
	tree.left = temp;
	MirrorTree(tree.left);
	MirrorTree(tree.right);
}

/**
 * Print all the ancestors of the given node
 */
public static boolean printAncetors(Tree root,Tree node){
	if(root == null)
		return false;
	if((Integer)root.data == (Integer)node.data || printAncetors(root.left, node) || printAncetors(root.right, node)){
		System.out.println("=="+root.data);
		return true;
	}
	return false;
}
/**
 * Least common ancestors between any 2 nodes.
 * Call the prinAncestors() for each node and compare them.
 * 
 *  else(Alternative method)
 *    
 */

}