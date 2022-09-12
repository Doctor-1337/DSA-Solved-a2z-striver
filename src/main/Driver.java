package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import main.basics.pattern.Pattern1;
import main.basics.pattern.Pattern2;
import main.basics.pattern.Pattern3;
import main.basics.pattern.Pattern4;
import main.basics.pattern.Pattern5;
import main.basics.pattern.Pattern6;

public class Driver {

	public static void main(String[] args) {
		
		BufferedReader reader = new BufferedReader(
	            new InputStreamReader(System.in));
	 
	        // Reading data using readLine
	        String noOfLines = null;
			try {
				noOfLines = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int n = Integer.parseInt(noOfLines);
	 
			//Pattern1 
			Pattern1.printPattern1(n);
			
			//Pattern2
			Pattern2.printPattern2(n);
			
			//Pattern3
			Pattern3.printPattern3(n);
			
			//Pattern4
			Pattern4.printPattern4(n);
			
			//Pattern5
			Pattern5.printPattern5(n);
			
			//Pattern6
			Pattern6.printPattern6(n);

			
			
			
	}
	
	
	
	
	

}
