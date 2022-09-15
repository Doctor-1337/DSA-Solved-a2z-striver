package src.main.basics.pattern;

public class Pattern21 {
	public static void printPattern21(int length,int width) {

		for(int i=0;i<length;i++) {
			for(int j=0;j<width;j++) {
				
				
					if(j == 0 || j == width-1) {
						System.out.print("*");

					}else if(i == 0 || i == length-1) {
						System.out.print("*");
					}else {
						System.out.print(" ");

					}
					
			}
			System.out.println();
		}
	}
}
