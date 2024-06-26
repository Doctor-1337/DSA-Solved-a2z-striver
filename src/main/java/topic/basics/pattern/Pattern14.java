package topic.basics.pattern;


//Pattern
//A
//AB
//ABC
//ABCD
//ABCDE


public class Pattern14 {
	public static void printPattern14(int n) {
		for(int i=0;i<n;i++) {
			char num= 'A';

			for(int j=0;j<=i;j++) {
					
					System.out.print(num);
					num++;
				
			}
			System.out.println();
		}
	}

}
