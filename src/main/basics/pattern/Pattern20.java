package src.main.basics.pattern;

public class Pattern20 {
	
//Pattern
	
//	*        *
//	**      **
//	***    ***
//	****  ****
//	**********
//	****  ****
//	***    ***
//	**      **
//	*        *

	public static void printPattern20(int n) {
		
		int rows = n + n-1;
		int maxStars = n*2;

	for(int i=0,stars =1;i<rows;i++) {
		for(int j=0;j<maxStars;j++) {
			
			if(j<stars|| j >=maxStars-stars) {
				System.out.print("*");
			}else {
				System.out.print(" ");

			}
		}
		if(i >= n-1) {
			stars--;
		}else {
			stars++;
		}
		System.out.println();
	

	}
	
	}
}
