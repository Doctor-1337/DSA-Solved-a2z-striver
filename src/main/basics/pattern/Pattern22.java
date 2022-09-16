package src.main.basics.pattern;


//Pattern
//444444444
//433333334
//432222234
//432111234
//432101234
//432111234
//432222234
//433333334
//444444444


public class Pattern22 {
	public static void printPattern22(int n) {
		int maxLength = 2*n;
		for(int i=0;i<=maxLength;i++) {
			for(int j=0;j<=maxLength;j++) {
				
				System.out.print(n- Math.min(Math.min(i,j),Math.min(maxLength - i,maxLength - j)));
				
					
			}
			System.out.println();
		}
	}

}
