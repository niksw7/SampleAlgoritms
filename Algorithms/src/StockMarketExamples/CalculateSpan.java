package StockMarketExamples;

public class CalculateSpan {
	static int[] elements = {1,2,3,5,4};
	static int[] span = new int[5]; 
	
	public static void main(String[] args) {
			 //calculateSpan(elements);
}
	
	/**
	 * Recursive function to calculate the span of elements
	 * Didnt get span??
	 * S[i] is maximum of elements immediately preceding A[i] and such that A[j]<=A[j+1]
	 * @param arrayOfIntegers
	 */
 public static void calculateSpan(int[] elements){
	 for (int i=0;i<elements.length;i++) {
		span[i] = getSpan(i);
	 }
 }
 
 public static int getSpan(int i){
	 if(i == 0 || elements[i]<elements[i-1])
		 return 1;
	 else if(elements[i]>elements[i-1]){
		 return getSpan(i-span[i-1])+span[i-1];
	 }else if(elements[i] == elements[i-1]){
		return span[i-1]+1; 
	 }
	 return 0;
 }
}
