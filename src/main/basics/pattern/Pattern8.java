package src.main.basics.pattern;


//Pattern
//*************
//*********** 
// *********  
//  *******   
//   *****    
//    ***     
//     *   
public class Pattern8 {
	public static void printPattern8(int n) {
		int maxStars = 1+(n-1)*2;
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
