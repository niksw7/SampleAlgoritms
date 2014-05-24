package backtracking;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * This code is used to generate permutation of any string.
 * @courtesyAlgo:BinaryString generation
 * 
 * function binary(n){
 * //let str be the global string.
 *if(n<1)
 *print  str
 *else{
 *		str[n-1] = 0
 *		binary(n-1)
 *		str[n-1]=1
 *		binary(n-1)
 *	}
 *}
 * @author enigma
 *
 */
public class BinaryString {
	private static char[] str;
	static private String data;
	public static void main(String[] args) {
		System.out.println("enter the characters(without delimiters) whose permutaion u need");
		Scanner o = new Scanner(System.in);
		data = o.next();
		System.out.println("--data--"+data);
		str= new char[data.length()];
		binary(data.length());
		}
	public static  void binary(int n) {
		if(n<1){
			System.out.println(str);
		}else{
		/*str[n-1]='0';
		binary(n-1);
		str[n-1]='1';
		binary(n-1);
		str[n-1]='3';
		binary(n-1);*/
			for(int i =0;i<data.length();i++){
				str[n-1] = data.toCharArray()[i];
				binary(n-1);
			}
		}
	}
}
