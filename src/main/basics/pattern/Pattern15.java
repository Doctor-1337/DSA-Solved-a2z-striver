package src.main.basics.pattern;


//Pattern
//ABCDE
//ABCD
//ABC
//AB
//A


public class Pattern15 {
	public static void printPattern15(int n) {
		for(int i=0;i<n;i++) {
			char num= 'A';

			for(int j=0;j<n-i;j++) {
					
					System.out.print(num);
					num++;
				
			}
			System.out.println();
		}
	}
}
