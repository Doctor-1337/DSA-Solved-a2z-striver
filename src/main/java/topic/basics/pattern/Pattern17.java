package topic.basics.pattern;


//Pattern
//    A    
//   ABA   
//  ABCBA  
// ABCDCBA 
//ABCDEDCBA


public class Pattern17 {
	public static void printPattern17(int n) {
		int maxStars = 1+(n-1)*2;
		for(int i=0;i<n;i++) {
			char num = '@';
			for(int j=0;j<maxStars;j++) {
				
				if(j>=n-i-1 && j<=maxStars/2) {
					num++;

					System.out.print(num);
				}else if (j>maxStars/2 && j<n+i) {
					num--;
					System.out.print(num);
				}else {
					System.out.print(" ");
				}
					
					
			}
			System.out.println();
		}
	}
}
