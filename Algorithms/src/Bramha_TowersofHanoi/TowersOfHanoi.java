package Bramha_TowersofHanoi;

public class TowersOfHanoi {
public static void main(String[] args) {
	move1(3,'1','3','2');
System.out.println("look at him");	
	move(3,1,3);

}
	public static void move1(int n ,char from,char to,char aux){
	if(n == 0)
		return;
	move1(n-1,from, aux,to);
	System.out.println("Moving "+ n +" from Tower :"+from +" to "+to );
	move1(n-1, aux,to,from);
	//System.out.println("Moving "+ n +" from Tower :"+from +" to "+to + " using "+aux);

}
	public static void move(int n, int startPole, int endPole) {
	    if (n== 0){
	      return; 
	    }
	    int intermediatePole = 6 - startPole - endPole;
	    move(n-1, startPole, intermediatePole);
	    System.out.println("Move " +n + " from " + startPole + " to " +endPole);
	    move(n-1, intermediatePole, endPole);
	  }
	  
}
