package src.main.basics.pattern;


//Pattern
//1
//23
//456
//78910
//1112131415

public class Pattern13 {
	public static void printPattern13(int n) {
		int num= 1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
					
					System.out.print(num);
					num++;
				
			}
			System.out.println();
		}
	}
}
