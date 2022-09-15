package src.main.basics.pattern;

public class Pattern22 {
	public static void printPattern22(int n) {
		
		for(int i=0;i<2*n-1;i++) {
			int temp = n;
			for(int j=0;j<2*n-1;j++) {
				
				System.out.print(temp);
				
				if(j <= n) {
				if(temp > n-i)
					 temp--;
				}
				if(j>n) {
				if(temp < n-i)
					temp++;
				}
					
					
			}
			System.out.println();
		}
	}

}
