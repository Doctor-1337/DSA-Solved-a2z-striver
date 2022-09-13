package src.main.basics.pattern;

public class Pattern10 {
	
	
//Pattern
//	*    
//	**   
//	***  
//	**** 
//	*****
//	**** 
//	***  
//	**   
//	*    

public static void printPattern10(int n) {
		
		
		
		
		int maxStars = 1+(n-1)*2;
		for(int i=0;i<n-1;i++) {
			for(int j=n-1;j<maxStars;j++) {
				
				if(j<n+i) {
					System.out.print("*");
				}else {
					System.out.print(" ");
					
					

				}
					
					
			}
			System.out.println();
		}
		
	for(int i=0;i<n;i++) {
		for(int j=n-1;j<maxStars;j++) {
			
			if(j<maxStars-i) {
				System.out.print("*");
			}else {
				System.out.print(" ");
				
				

			}
				
				
		}
		System.out.println();
	}
}
}
