package topic.basics.pattern;


//Pattern
//E
//DE
//CDE
//BCDE
//ABCDE

public class Pattern18 {
	public static void printPattern18(int n) {
		char ch = (char) ('A' + n-1);

		for(int i=0;i<n;i++) {
			char ch2 = ch;
			for(int j=0;j<=i;j++) {
				
					
					System.out.print(ch2);
					ch2++;
				
			}
			System.out.println();
			ch--;
		}
	}
}
