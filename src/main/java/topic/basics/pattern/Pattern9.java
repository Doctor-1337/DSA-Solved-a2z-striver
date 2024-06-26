package topic.basics.pattern;


//Pattern
//    *     
//   ***   
//  *****  
// ******* 
//*********
//*********
// ******* 
//  *****  
//   ***   
//    *
//    



public class Pattern9 {
	public static void printPattern9(int n) {
		
		
		
		
		int maxStars = 1+(n-1)*2;
		for(int i=0;i<n;i++) {
			for(int j=0;j<maxStars;j++) {
				
				if(j>=n-i-1 && j<n+i) {
					System.out.print("*");
				}else {
					System.out.print(" ");
					
					

				}
					
					
			}
			System.out.println();
		}
		
	for(int i=0;i<n;i++) {
		for(int j=0;j<maxStars;j++) {
			
			if(j>=i && j<maxStars-i) {
				System.out.print("*");
			}else {
				System.out.print(" ");
				
				

			}
				
				
		}
		System.out.println();
	}
}
}
