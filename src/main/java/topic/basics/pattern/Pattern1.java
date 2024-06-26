package topic.basics.pattern;


//Pattern
//* * * * * 
//* * * * * 
//* * * * * 
//* * * * * 
//* * * * * 


public class Pattern1 {

	public static void printPattern1(int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}
