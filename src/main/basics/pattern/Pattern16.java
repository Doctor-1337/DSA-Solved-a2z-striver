package src.main.basics.pattern;


//Pattern
//A
//BB
//CCC
//DDDD
//EEEEE


public class Pattern16 {
	public static void printPattern16(int n) {
		char num= 'A';

		for(int i=0;i<n;i++) {

			for(int j=0;j<=i;j++) {
					
					System.out.print(num);
				
			}
			System.out.println();
			num++;

		}
	}
}
