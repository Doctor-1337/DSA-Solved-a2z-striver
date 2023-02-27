package main.basics.maths;

public class Problem2 {
	public static void revNum(int num) {
		
		int revNum = 0;
		while( num > 0) {
			revNum = revNum*10;
			revNum += num%10;
			num/=10;

		}
		
		System.out.println(revNum);
		
}
}
