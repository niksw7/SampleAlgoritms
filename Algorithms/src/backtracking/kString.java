package backtracking;

/**
 * This code is used to generate string of length n drawn from 0....k-1.
 * @courtesyAlgo:BinaryString generation
 * @input: length of string n,fromnumbers k
 * @output:k^n
 * @author enigma
 *
 */
public class kString {
	final static int k =4;
	final static int n =5;
	private static char[] str = new char[n];
public static void main(String[] args) {
	kString(n);
}
public static  void kString(int n) {
	if(n<1){
		System.out.println(str);
	}else{
		for(int i =0;i<k;i++){
			str[n-1] = (char) (i + 48);
			kString(n-1);
		}
	}
}
}
