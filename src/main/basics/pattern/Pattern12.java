package src.main.basics.pattern;


//Pattern
//1        1
//12      21
//123    321
//1234  4321
//1234554321

public class Pattern12 {
	public static void printPattern12(int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n*2;j++) {
				if(j<=i) {	
					System.out.print(j+1);
				}else if(j>=2*n-i-1) {
					System.out.print(2*n-j);
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
