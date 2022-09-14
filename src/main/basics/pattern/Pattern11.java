package src.main.basics.pattern;


//Pattern
//1
//01
//101
//0101
//10101
public class Pattern11 {
	public static void printPattern11(int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				if( ( i+j )% 2 == 0) {
					
					System.out.print("1");
				}else {
					System.out.print("0");
				}
			}
			System.out.println();
		}
	}
}
