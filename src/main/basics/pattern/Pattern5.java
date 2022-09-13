package src.main.basics.pattern;


//Pattern
//* * * * * 
//* * * * 
//* * * 
//* * 
//* 


public class Pattern5 {
	public static void printPattern5(int n) {
		for(int i=0;i<n;i++) {
			for(int j=n;j>i;j--) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}
