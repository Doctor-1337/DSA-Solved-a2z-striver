package src.main.basics.pattern;

public class Pattern19 {
	
	
//Pattern
//	**********
//	****  ****
//	***    ***
//	**      **
//	*        *
//	*        *
//	**      **
//	***    ***
//	****  ****
//	**********

	public static void printPattern19(int n) {
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n*2;j++) {
				if(j>=n-i && j<n+i) {
					System.out.print(" ");
				}else {
					System.out.print("*");
				}
			}
			System.out.println();
		}

		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n*2;j++) {
				if(j<=i || j>=2*n-i-1) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
