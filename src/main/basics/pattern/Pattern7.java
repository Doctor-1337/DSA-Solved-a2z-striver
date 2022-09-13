package src.main.basics.pattern;


//Pattern
//    *
//   ***
//  *****
// *******

public class Pattern7 {
	public static void printPattern7(int n) {
		int maxStars = 1+(n-1)*2;
		for(int i=0;i<n;i++) {
			for(int j=0;j<maxStars;j++) {
				
				if(j>=n-i-1 && j<n+i) {
					System.out.print("*");
				}else {
					System.out.print(" ");
					
					

				}
					
					
			}
			System.out.println();
		}
	}
}
