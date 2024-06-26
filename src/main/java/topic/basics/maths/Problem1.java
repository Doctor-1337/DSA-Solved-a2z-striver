package topic.basics.maths;

public class Problem1 {
	public static void countNoOfDigs(int num) {
//		int count = 0;
//		while( num > 0) {
//			num/=10;
//			count++;
//		}
//		System.out.println(count);
		
		//alt approach O(1)
		
		System.out.println((int) Math.floor(Math.log10(num) + 1));
	}
}
